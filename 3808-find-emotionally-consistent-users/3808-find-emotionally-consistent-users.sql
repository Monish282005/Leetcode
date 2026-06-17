# Write your MySQL query statement below
select * from (
select r.user_id,
(
    select reaction from (
    select r1.reaction as reaction, count(*) as totReaction from reactions r1
    where r1.user_id = r.user_id
    group by r1.reaction
    order by totReaction desc
    limit 1) as temp
) as dominant_reaction ,
round( sum(reaction = (select reaction from (
    select r1.reaction as reaction, count(*) as totReaction from reactions r1
    where r1.user_id = r.user_id
    group by r1.reaction
    order by totReaction desc
    limit 1) as temp))/(count(distinct content_id)), 2) as reaction_ratio
from reactions r
group by r.user_id
having count(distinct content_id) >= 5
order by reaction_ratio desc,r.user_id
) as f where f.reaction_ratio >= 0.60