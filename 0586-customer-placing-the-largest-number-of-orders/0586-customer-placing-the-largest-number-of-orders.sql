-- Write your PostgreSQL query statement below

select customer_number 
from Orders 
group by customer_number 
having count(*) = 
(select max(total)
from (select count(*) as total from Orders group by customer_number)
);