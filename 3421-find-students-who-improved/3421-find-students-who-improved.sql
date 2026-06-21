# Write your MySQL query statement below
select * from (
select s.student_id,
s.subject,
(select s1.score from Scores s1 where s1.student_id = s.student_id and s1.subject = s.subject and s1.exam_date = 
(select min(exam_date) from Scores s1 where s1.student_id = s.student_id and s1.subject = s.subject)) as first_score,
(select s1.score from Scores s1 where s1.student_id = s.student_id and s1.subject = s.subject and s1.exam_date = 
(select max(exam_date) from Scores s1 where s1.student_id = s.student_id and s1.subject = s.subject)) as latest_score
from Scores s
group by s.student_id, s.subject
having count(distinct exam_date) >= 2
order by s.student_id, s.subject
) temp where temp.first_score < temp.latest_score