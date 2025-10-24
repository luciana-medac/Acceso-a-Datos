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









