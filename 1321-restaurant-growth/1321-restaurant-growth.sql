with temp as(
    select distinct visited_on as visited
    from Customer c1
    where exists(
        select 1 
        from Customer c2
        where c2.visited_on = date_add(c1.visited_on, interval 6 day)
    )
)

select 
    date_add(t1.visited, interval 6 day) as visited_on,
    (
        select sum(amount)
        from customer c1
        where c1.visited_on >= t1.visited
        and c1.visited_on <= date_add(t1.visited, interval 6 day)
    ) as amount,
    round((select sum(amount)
        from customer c1
        where c1.visited_on >= t1.visited
        and c1.visited_on <= date_add(t1.visited, interval 6 day))/7, 2) as average_amount
 from temp t1;