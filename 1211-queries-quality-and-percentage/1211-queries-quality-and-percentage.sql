
select q1.query_name, 
round(
    (select avg(
        case when q2.query_name = q1.query_name
        then q2.rating/q2.position
        end
    ) from queries q2)
, 2) as quality,
round(((
        select sum(
        case when q2.query_name = q1.query_name and q2.rating < 3 then 1
        else 0
        end
    ) from queries q2)
    /
    ((select sum(case when q2.query_name = q1.query_name then 1 else 0 end) from queries q2)))*100
, 2) as poor_query_percentage 
from queries q1
group by q1.query_name;