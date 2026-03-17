# Write your MySQL query statement below
select d.name as Department, e.name as Employee, t.Salary
from Employee e
join Department d
on e.departmentId = d.id
join (
    select departmentId, max(salary) as Salary
    from Employee
    group by departmentId
) t
on e.departmentId = t.departmentId
and 
e.salary = t.salary