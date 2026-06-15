with temp as (
select u.name as name, count(*) as tot from 
movieRating mr
join Users u
on mr.user_id = u.user_id
group by mr.user_id, u.name 
order by tot desc, name ASC
limit 1 
),
temp1 as(
    select avg(rating) as avgRating, m.title as title
    from MovieRating mr
    join Movies m
    on mr.movie_id = m.movie_id
    where mr.created_at between '2020-02-01' and '2020-02-29'
    group by mr.movie_id, m.title
    order by avgRating desc, title ASC
    limit 1
)

select name as results from Users where name = (select name from temp)
union all
select title from temp1;