SELECT 
    book_id, 
    title, 
    author, 
    genre, 
    pages, 
    rating_spread, 
    polarization_score 
FROM (
    SELECT 
        r.book_id,
        b.title,
        b.author,
        b.genre,
        b.pages,
        MAX(session_rating) - MIN(session_rating) AS rating_spread,
        ROUND(SUM(CASE WHEN session_rating <= 2 OR session_rating >= 4 THEN 1 ELSE 0 END) / COUNT(*), 2) AS polarization_score
    FROM books b
    JOIN reading_sessions r ON b.book_id = r.book_id
    GROUP BY r.book_id, b.title, b.author, b.genre, b.pages
    HAVING COUNT(*) >= 5 
       AND SUM(CASE WHEN r.session_rating >= 4 THEN 1 ELSE 0 END) >= 1 
       AND SUM(CASE WHEN r.session_rating <= 2 THEN 1 ELSE 0 END) >= 1
) AS temp 
WHERE polarization_score >= 0.6
ORDER BY 
    polarization_score DESC, 
    title DESC;