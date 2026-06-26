-- with temp1 as(
--     select 
--     requester_id as r_id,
--     count(*) as r_count
--     from RequestAccepted RA
--     group by 
--     RA.requester_id
-- ),
--  temp2 as(
--     select 
--     accepter_id as a_id,
--     count(*) as a_count
--     from RequestAccepted RA
--     group by 
--     RA.accepter_id
-- )

-- select
-- t1.r_id as id,
--  max((case when t1.r_count is null then 0 else t1.r_count end) + (case when t2.a_count is null then 0 else t2.a_count end)) as num
-- from temp1 t1
-- join temp2 t2
-- on t1.r_id = t2.a_id
-- group by t1.r_id, t2.a_id
-- order by num desc
-- limit 1


with a as
(select requester_id as id from requestaccepted
union all
select accepter_id as id from requestaccepted)

select id, count(id) as num
from a
group by id
order by num desc
limit 1