# Write your MySQL query statement below

with temp as(
    select distinct score from Scores
)

select s.score, (
   case when 
   (select sum(case when s.score < t.score then 1 else 0 end) from temp t) = 0 then 1 
   else 
   (select sum(case when s.score < t.score then 1 else 0 end) from temp t) + 1
   end
) as 'rank'
from Scores s
order by s.score desc