DROP DATABASE tienda_db;
CREATE DATABASE tienda_db;
USE tienda_db;

-- Creamos las tablas
CREATE TABLE cliente(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    edad INT,
    ciudad VARCHAR(255)
);

CREATE TABLE pedido(
	id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    id_cliente INT NOT NULL,
    foreign key (id_cliente) references cliente(id)
);

CREATE TABLE producto(
	id INT auto_increment PRIMARY KEY,
    precio DECIMAL(10,2),
    nombre VARCHAR(50),
    stock INT
);

CREATE TABLE pedido_producto(
	id_pedido INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT,
    primary key (id_pedido, id_producto),
    foreign key (id_pedido) references pedido(id),
    foreign key (id_producto) references producto(id)
);

-- Manipulacion de los datos (DML, insert, update, delete, select)

insert into cliente (nombre, edad, ciudad) values
('Ana López', 30, 'Madrid'),
('Carlos Ruiz', 45, 'Sevilla'),
('Lucía Gómez', 22, 'Granada');

insert into producto(nombre, precio, stock) values
('Portatil', 800.00, 2),
('Ratón', 10, 50),
('Teclado', 20, 50);

insert into pedido(fecha, id_cliente) values
('2024-01-10', 1),
('2024-01-11', 2),
('2025-01-12', 3),
('2025-05-05', 1);

insert into pedido_producto(id_pedido, id_producto, cantidad) values
(1, 1, 1), -- Ana compra 1 portatil
(1, 2, 2), -- Ana compra 2 ratones
(3, 1, 1), -- Carlos compra 2 teclados
(4, 3, 5); -- Ana compra 5 teclados

-- Cambiar el stock de los portatiles
update producto set stock=10 where id=1;

SELECT nombre, ciudad FROM cliente WHERE edad > 26;

-- Clientes cuyo nombre empieza por 'L'
SELECT nombre FROM cliente where nombre like 'L%';

-- Clientes entre 25 y 45 ordenados alfabeticamente
select * FROM cliente WHERE edad between 25 AND 5 order by nombre;

-- Productos con precio menor a 50€ con precio descendiente
select nombre from producto order by precio desc;

-- Mostrar datos de los pedidos con el nombre y ciudad de los clientes
SELECT p.id, cli.nombre, cli.ciudad FROM pedido as p
INNER JOIN cliente as cli ON p.id_cliente = cli.id;

-- total gastado por cada cliente
SELECT cli.nombre, sum(pp.cantidad*pr.precio) total FROM cliente as cli
INNER JOIN pedido as p ON p.id_cliente = cli.id 
INNER JOIN pedido_producto as pp ON pp.id_pedido = p.id
INNER JOIN producto as pr ON pp.id_producto = pr.id
GROUP BY cli.nombre having total > 100;









