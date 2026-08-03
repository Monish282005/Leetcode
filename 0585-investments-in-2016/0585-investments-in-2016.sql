WITH temp AS (
    SELECT 
        CONCAT(lat, ' ', lon) AS place 
    FROM Insurance
)
SELECT 
    ROUND(
        SUM(
            CASE 
                WHEN (
                    SELECT SUM(CASE WHEN i2.tiv_2015 = i1.tiv_2015 THEN 1 ELSE 0 END) 
                    FROM Insurance i2
                ) >= 2 
                AND (
                    SELECT SUM(CASE WHEN CONCAT(lat, ' ', lon) = place THEN 1 ELSE 0 END) 
                    FROM temp
                ) = 1 
                THEN tiv_2016 
                ELSE 0 
            END
        ), 
        2
    ) AS tiv_2016 
FROM Insurance i1;