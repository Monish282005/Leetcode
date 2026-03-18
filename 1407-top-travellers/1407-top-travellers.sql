# Write your MySQL query statement below


select name, travelled_distance 
from (
    select name, coalesce(sum(distance), 0) as travelled_distance
    from Users u
    left join Rides r
    on u.id = r.user_id
    group by r.user_id
) t order by travelled_distance desc, name asc;