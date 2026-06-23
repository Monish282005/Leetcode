# Write your MySQL query statement below

select 
ro.customer_id,
(count(*)) as total_orders ,
round((sum(
    case
     when time(order_timestamp) between '11:00:00' and '14:00:00'
     or time(order_timestamp) between '18:00:00' and '21:00:00'
     then 1
     else 0
     end
)/count(*)) * 100) as peak_hour_percentage ,
round(avg(order_rating), 2) as average_rating 
from restaurant_orders ro
group by ro.customer_id
having (
count(*) >= 3
and (avg(order_rating) >= 4)
and ((sum(case when order_rating is not null then 1 else 0 end)/count(*)) * 100 >= 50)
and ((sum(case
     when time(order_timestamp) between '11:00:00' and '14:00:00'
     or time(order_timestamp) between '18:00:00' and '21:00:00'
     then 1
     else 0
     end
     )/count(*)) * 100 >= 60)
)
order by average_rating desc,
customer_id desc;
