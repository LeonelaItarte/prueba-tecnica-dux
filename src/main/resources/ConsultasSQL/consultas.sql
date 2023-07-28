-- 1
select p.* from producto p
where p.id_rubro = (select r.id_rubro from rubro r where r.rubro = 'libreria') and p.fecha_creacion = CURDATE();

-- 2
select sum(v.precio_unitario) as total, CONCAT(c.nombre, ' ', c.apellido) as cliente from venta v
join cliente c on c.id_cliente = v.id_cliente
group by c.id_cliente;

-- 3
select coalesce(sum(v.cantidad), 0) as cantidad, p.nombre  from venta v
right join producto p on p.codigo = v.codigo_producto
group by p.codigo;

-- 4
select CONCAT(c.nombre, ' ', c.apellido) as cliente, COUNT(distinct v.codigo_producto) as cantidad_de_productos_distintos from venta v
join cliente c on c.id_cliente = v.id_cliente
where CONCAT(DATE_FORMAT(v.fecha, '%m'), '-', DATE_FORMAT(v.fecha, '%Y')) = CONCAT(DATE_FORMAT(CURDATE(), '%m'), '-', DATE_FORMAT(CURDATE(), '%Y'))
group by c.id_cliente;


-- 5
select v.* from venta v
join producto p on p.codigo = v.codigo_producto
join rubro r on p.id_rubro = r.id_rubro
where r.rubro = 'libreria';


-- 6
select * from rubro where id_rubro not in (select p.id_rubro from producto p
				join venta v on p.codigo = v.codigo_producto
                and v.fecha >= DATE_SUB(CURDATE(), INTERVAL 2 MONTH))