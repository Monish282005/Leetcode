# Write your MySQL query statement below

select name from Employee
where id in (
    select managerId as id from Employee
    where managerId is not null
    group by managerId
    having(count(*)) >= 5
)