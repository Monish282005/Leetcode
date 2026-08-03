WITH temp AS (
    SELECT DISTINCT visited_on AS visited 
    FROM Customer c1 
    WHERE EXISTS (
        SELECT 1 
        FROM Customer c2 
        WHERE c2.visited_on = DATE_ADD(c1.visited_on, INTERVAL 6 DAY)
    )
) 
SELECT 
    DATE_ADD(t1.visited, INTERVAL 6 DAY) AS visited_on, 
    (
        SELECT SUM(amount) 
        FROM Customer c1 
        WHERE c1.visited_on >= t1.visited 
          AND c1.visited_on <= DATE_ADD(t1.visited, INTERVAL 6 DAY)
    ) AS amount, 
    ROUND(
        (
            SELECT SUM(amount) 
            FROM Customer c1 
            WHERE c1.visited_on >= t1.visited 
              AND c1.visited_on <= DATE_ADD(t1.visited, INTERVAL 6 DAY)
        ) / 7.0, 
        2
    ) AS average_amount 
FROM temp t1;