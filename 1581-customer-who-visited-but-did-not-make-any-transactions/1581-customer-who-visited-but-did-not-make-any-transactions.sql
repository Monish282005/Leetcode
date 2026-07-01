# Write your MySQL query statement below

with temp as(
    select
    customer_id,
    visit_id
    from visits v1 where v1.visit_id not in (
    select 
    distinct visit_id
    from Transactions
    )
)

select 
    customer_id ,
    count(*) as count_no_trans
    from temp
    group by customer_id

