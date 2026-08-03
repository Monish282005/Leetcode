with temp as(
    select person_name,
    (select sum(weight) from queue q2 where q2.turn <= q1.turn) as weight,
    turn
    from queue q1
    order by turn
)


select person_name from (
    select turn , person_name from temp where weight <= 1000
order by turn desc limit 1
) t;