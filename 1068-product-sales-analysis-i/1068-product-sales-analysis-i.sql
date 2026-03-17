-- Write your PostgreSQL query statement below

select p.product_name, year, price 
from Sales s
join product p
on p.product_id = s.product_id;