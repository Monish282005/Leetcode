# Write your MySQL query statement below

select distinct l1.num as consecutiveNums
from Logs l1
join Logs l2 on l1.num = l2.num and l1.id+1 = l2.id
JOIN Logs l3 ON l1.id + 2 = l3.id AND l1.num = l3.num;