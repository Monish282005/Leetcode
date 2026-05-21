# Write your MySQL query statement below

select u.user_id as buyer_id, u.join_date, sum(case when o.order_date between '2019-01-01' and '2019-12-31'
then 1
else 0
End ) as orders_in_2019
from Users u
left join 
Orders o
on u.user_id = o.buyer_id
group by u.user_id

-- select 
--     u.user_id as buyer_id, 
--     u.join_date, 
--     sum(case when o.order_date between '2019-01-01' and '2019-12-31' then 1 else 0 end) as orders_in_2019
-- from Users u
-- left join Orders o
-- on u.user_id = o.buyer_id
-- group by u.user_id;