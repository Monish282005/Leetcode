with temp as(
    select e.departmentId as id, (select min(salary) from (
        select distinct salary from Employee e1 where e1.departmentId = e.departmentId
        order by salary desc
        limit 3 ) as t1) as salary
     from Employee e
    group by e.departmentId
)

select d.name as Department, e.name as Employee, e.salary
from Employee e
join Department d
on e.departmentId = d.id
where e.salary >= (select salary from temp t where t.id = e.departmentId )
order by e.name, e.salary desc