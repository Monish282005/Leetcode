with temp as(
     select
     a.player_id as id ,
     min(event_date) as 'date'
     from Activity a
     group by a.player_id
)

select
round(count(*)
/
 (select 
 (count(distinct player_id))
  from Activity), 2) as fraction
from temp t
join Activity a
on t.id = a.player_id
and date_add(t.date, Interval 1 day) = a.event_date