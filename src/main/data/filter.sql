select product.id, product.name, type_id, expired_date, price, amount
from product join type t on t.id = product.type_id
where t.name like 'СЫР';

select product.id, product.name, type_id, expired_date, price, amount
from product join type t on t.id = product.type_id
where t.name like '%мороженное%';

select * from product
where expired_date <= current_date + interval '1 month'; 

select product.name
from product join type t on t.id = product.type_id
order by price desc
    limit 1;

select type_id, count(id)
from product
group by type_id;

select product.id, product.name, type_id, expired_date, price, amount
from product join type t on t.id = product.type_id
where t.name like 'СЫР' or t.name like 'МОЛОКО';

select t.name, count(product.id)
from product join type t on product.type_id = t.id
group by type_id
having count(product.id) < 10;

select product.id, product.name, product.type_id, product.expired_date, product.price, product.amount, t.name
from product join type t on t.id = product.type_id;