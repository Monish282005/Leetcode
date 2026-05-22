# Write your MySQL query statement below

select concat(year(trans_date), '-', case when month(trans_date) < 10 then concat('0',month(trans_date)) else month(trans_date) end) as month,
 country, 
 count(*) as trans_count, 
 count(case when state = 'approved' then 1 end) as approved_count, sum(amount) as trans_total_amount,
 sum(case when state = 'approved' then amount else 0 end) as approved_total_amount
 from Transactions
 group by country, month(trans_date), year(trans_date);