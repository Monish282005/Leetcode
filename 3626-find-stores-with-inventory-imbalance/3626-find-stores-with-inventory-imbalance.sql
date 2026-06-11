# Write your MySQL query statement below

select s.store_id, s.store_name,s.location, (
   select product_name from inventory i2 where i2.store_id = s.store_id
   and i2.price = (select max(i3.price) from inventory i3 where i3.store_id = s.store_id) 
) as most_exp_product,
(select product_name from inventory i2 where i2.store_id = s.store_id
and i2.price =
 (select min(i3.price) from inventory i3 where i3.store_id = s.store_id)) as cheapest_product,
round((select sum(i2.quantity) from inventory i2 where i2.store_id = s.store_id and i2.price = (select min(i3.price) from inventory i3 where i3.store_id = s.store_id))/(select sum(i2.quantity) from inventory i2 where i2.store_id = s.store_id and i2.price = (select max(i3.price) from inventory i3 where i3.store_id = s.store_id)), 2) as imbalance_ratio
from stores s
join inventory i
on s.store_id = i.store_id
group by i.store_id, s.store_name, s.location
having count(distinct i.product_name) >= 3 
   and (select sum(i2.quantity) from inventory i2 where i2.store_id = s.store_id and i2.price = (select max(i3.price) from inventory i3 where i3.store_id = s.store_id)) < 
       (select sum(i2.quantity) from inventory i2 where i2.store_id = s.store_id and i2.price = (select min(i3.price) from inventory i3 where i3.store_id = s.store_id))
order by imbalance_ratio desc, store_name;