# Write your MySQL query statement below

select e.reports_to as employee_id, 
(select name from Employees e1 where e.reports_to = e1.employee_id) as name,
count(*) as reports_count, 
round(avg(age)) as average_age
from Employees e
where e.reports_to is not null
group by e.reports_to
order by employee_id;