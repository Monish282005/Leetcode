with temp as(
    select d.driver_id as id,
    avg(
        case 
        when month(trip_date) between '01' and '06' 
        then (distance_km / fuel_consumed)
        end
        ) as first_half,
    avg(
        case 
        when month(trip_date) between '07' and '12'
        then (distance_km / fuel_consumed)
        end
    ) as second_half
    from trips d
    group by d.driver_id
)
-- select * from (
-- select 
--     t.driver_id,
--     d.driver_name,
--     round((select 
--     first_half
--     from temp
--     where id = t.driver_id ), 2) as first_half_avg,
--     round((select 
--     second_half
--     from temp
--     where id = t.driver_id), 2) as second_half_avg,
--     round((select 
--     second_half
--     from temp
--     where id = t.driver_id) - (select 
--     first_half
--     from temp
--     where id = t.driver_id), 2) as efficiency_improvement 
-- from Drivers d
-- join trips t
-- on d.driver_id = t.driver_id
-- group by t.driver_id
-- having (
--     ((select 
--     first_half 
--     from temp
--      where id = t.driver_id) is not null)
--     and
--     (
--         (select 
--         second_half
--         from temp
--         where id = t.driver_id) is not null
--     )
-- )
-- order by efficiency_improvement desc,
-- d.driver_name
-- ) as f where efficiency_improvement > 0


select 
d.driver_id,
driver_name,
round(first_half ,2) as first_half_avg,
round(second_half, 2) as second_half_avg,
round(second_half - first_half ,2) as efficiency_improvement 
from drivers d
join temp te
on d.driver_id = te.id
where 
second_half is not null
and first_half is not null
and second_half - first_half > 0
order by efficiency_improvement desc, driver_name;