
select p.product_id, p.product_name
from Product p
join Sales s
on p.product_id = s.product_id
group by s.product_id
having sum(sale_date between '2019-01-01' and '2019-03-31') = count(*)
