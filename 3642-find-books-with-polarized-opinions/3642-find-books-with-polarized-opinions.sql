# Write your MySQL query statement below
select book_id, title, author, genre, pages, rating_spread, polarization_score from (
select r.book_id,
b.title,
b.author,
b.genre,
b.pages,
max(session_rating) - min(session_rating) as rating_spread,
round(sum(case when session_rating <= 2 or session_rating >= 4 then 1 else 0 end)/(count(*)), 2) as polarization_score
from books b
join reading_sessions r
on b.book_id = r.book_id
group by r.book_id, b.title, b.author, b.pages
having(count(*)) >= 5 and 
sum(case when r.session_rating >= 4 then 1 else 0 end) >= 1 and
sum(case when r.session_rating <= 2 then 1 else 0 end) >= 1
order by polarization_score desc, b.title desc
) as temp where polarization_score >= 0.6;