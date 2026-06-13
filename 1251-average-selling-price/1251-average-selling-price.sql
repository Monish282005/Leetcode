
select p.product_id,(case when (round(sum(p.price * u.units)/sum(u.units), 2)) != 0 then round(sum(p.price * u.units)/sum(u.units), 2) else 0 end) as average_price
from Prices p
left join UnitsSold u
on u.purchase_date between p.start_date and p.end_date and p.product_id = u.product_id
group by p.product_id