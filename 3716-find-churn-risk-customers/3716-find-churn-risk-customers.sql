WITH temp AS (
    SELECT
        se.user_id AS id,
        max(event_id) as cur_id,
        MAX(se.event_date) AS cur,

        (
            SELECT plan_name
            FROM subscription_events se1
            WHERE se1.user_id = se.user_id
              AND event_id = (select max(event_id) from subscription_events se1 where se1.user_id = se.user_id) 
        ) AS cur_plan

    FROM subscription_events se
    GROUP BY se.user_id
)

SELECT
    se.user_id,

    (
        SELECT cur_plan
        FROM temp t
        WHERE t.id = se.user_id
    ) AS current_plan,

    (
        SELECT monthly_amount
        FROM subscription_events se1
        WHERE se1.user_id = se.user_id
          AND se1.event_id = (select cur_id from temp t where t.id = se.user_id)
    ) AS current_monthly_amount,

    MAX(monthly_amount) AS max_historical_amount,

    DATEDIFF(
        MAX(event_date),
        MIN(event_date)
    ) AS days_as_subscriber

FROM subscription_events se

GROUP BY se.user_id

HAVING
    SUM(event_type = 'downgrade') >= 1

    AND DATEDIFF(
            MAX(event_date),
            MIN(event_date)
        ) >= 60

    AND (
            SELECT current_plan
            FROM temp t
            WHERE t.id = se.user_id
        ) IS NOT NULL

    AND (
            MAX(monthly_amount) * 50 / 100
        ) > (
            SELECT monthly_amount
            FROM subscription_events se1
            WHERE se1.user_id = se.user_id
              AND se1.event_id = (select cur_id from temp t where t.id = se.user_id)   
        )

ORDER BY
    days_as_subscriber DESC,
    se.user_id;