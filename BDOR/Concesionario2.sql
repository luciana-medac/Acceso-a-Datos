DROP TYPE VehiculoType FORCE;
DROP TYPE MarcaType FORCE;
DROP TYPE CocheType FORCE;

DROP TABLE Marca CASCADE CONSTRAINTS;
DROP TABLE Vehiculo CASCADE CONSTRAINTS;
DROP TABLE Coche CASCADE CONSTRAINTS;

-- Crear un tipo de objeto llamado VehiculoType
CREATE OR REPLACE TYPE VehiculoType AS OBJECT(

    IdVehiculo NUMBER,
    nombre VARCHAR2(30)

) NOT FINAL; -- Permite que más objetos hereden de vehiculo

CREATE OR REPLACE TYPE MarcaType AS OBJECT(
    
    IdMarca NUMBER,
    nombre VARCHAR2(30)
    
);

-- Creamos el VARRAY
CREATE OR REPLACE TYPE ColoresType AS VARRAY(3) OF VARCHAR2(20);

-- Tabla anidada
CREATE OR REPLACE TYPE ReparacionesType as TABLE OF VARCHAR(50);

CREATE OR REPLACE TYPE CocheType UNDER VehiculoType(
    
    precio NUMBER,
    marca REF MarcaType,
    colores ColoresType, -- Implementamos el varray
    reparaciones ReparacionesType

);

CREATE TABLE Marca OF MarcaType(
    IdMarca primary key
);

CREATE TABLE Coche OF CocheType(
    IdVehiculo primary key,
    SCOPE FOR(marca) IS Marca -- le dice a Oracle que todas las referencias marca apunten a filas de la tabla Marca
)
NESTED TABLE reparaciones STORE AS Reparaciones_Store; -- Hace referencia a la tabla de reparaciones (tabla anidada)

-- AÑADIR DATOS

INSERT INTO Marca VALUES (MarcaType(1,'Luciana_Seat'));
INSERT INTO Marca VALUES (MarcaType(2,'Luciana_Toyota'));
INSERT INTO Marca VALUES (MarcaType(3,'Luciana_Renault'));
INSERT INTO Marca VALUES (MarcaType(4,'Luciana_Cupra'));
INSERT INTO Marca VALUES (MarcaType(5,'Luciana_Citroen'));

INSERT INTO Coche 
    SELECT CocheType(
        1,
        'Ibiza',
        15000,
        REF(m),
        ColoresType('Rojo', 'Blanco'),
        ReparacionesType('Cambio aceite', 'Pastillas freno')
    ) FROM Marca m WHERE m.idmarca = 1;

INSERT INTO Coche
    SELECT CocheType(
        2,
        'Yaris',
        20000,
        REF(m),
        ColoresType('Negro', 'Rojo'),
        ReparacionesType('Cambio de aceite', 'Cambio ruedas')
    ) FROM Marca m WHERE m.idmarca = 2;

INSERT INTO Coche
    SELECT CocheType(
        3,
        'Clio',
        10000,
        REF(m),
        ColoresType('Naranja'),
        ReparacionesType('Cambio filtro', 'Revision general')
    ) FROM Marca m WHERE m.idmarca = 3;
    
INSERT INTO Coche
    SELECT CocheType(
        4,
        'Ateca',
        30000,
        REF(m),
        ColoresType('Rojo Cereza'),
        ReparacionesType('Revision general')
    ) FROM Marca m WHERE m.idmarca = 4;

INSERT INTO Coche
    SELECT CocheType(
        5,
        'C3',
        12000,
        REF(m),
        ColoresType('Azul'),
        ReparacionesType('Limpialunas nuevo')
    ) FROM Marca m WHERE m.idmarca = 5;


-- Ver todas las marcas
SELECT * FROM Marca;

-- Ver todos los coches
SELECT * FROM Coche;

-- Ver coches con nombre de a marca (usando DEREF)
SELECT 
    c.idvehiculo,
    c.nombre,
    c.precio,
    DEREF(c.marca).idMarca AS idMarca,
    DEREF(c.marca).nombre AS NombreMarca
FROM Coche c;
    
-- Ver coches con nombre de marca ordenados por el nombre de la marca
SELECT 
    c.idvehiculo,
    c.nombre,
    c.precio,
    DEREF(c.marca).nombre AS NombreMarca
FROM Coche c
ORDER BY NombreMarca;

-- Ver colores de cada coche
SELECT 
    c.idvehiculo,
    c.nombre,
    c.precio,
    col.COLUMN_VALUE AS COLOR
FROM Coche c,
    TABLE(c.colores) col;
    
-- Ver reparaciones de cada coche
SELECT 
    c.idvehiculo,
    c.nombre,
    c.precio,
    rep.COLUMN_VALUE AS REPARACIONES
FROM Coche c,
    TABLE(c.reparaciones) rep;
    
-- Número de coches por marca
SELECT 
    DEREF(c.marca).nombre AS NombreMarca,
    COUNT(*) AS NUM_COCHES
FROM Coche c
GROUP BY DEREF(c.marca).nombre;

-- Diferentes marcas que existen (dice las marcas que hay sin que se dupliquen)
SELECT DISTINCT(DEREF (c.marca).nombre) FROM Coche c;
    
-- Coches de una marca concreta(por nombre)
SELECT 
    c.idvehiculo,
    c.nombre,
    c.precio,
    DEREF(c.marca).nombre AS NombreMarca
FROM Coche c
WHERE DEREF(c.marca).IdMarca = 1;


-- Colores del coche
SELECT 
    c.nombre,
    col.COLUMN_VALUE AS COLOR
FROM Coche c,
    TABLE(c.colores) col
    WHERE idvehiculo = 2;


-- Reparaciones del coche 1
SELECT
    c.idvehiculo,
    c.nombre,
    rep.COLUMN_VALUE AS REPARACIONES
FROM Coche c,
    TABLE (c.reparaciones) rep
    WHERE idvehiculo = 1;
    
-- Mostrar todos los colores de un coche concreto
SELECT 
    col.COLUMN_VALUE AS COLOR
FROM Coche c,
    TABLE(c.colores) col
    WHERE idvehiculo = 1;
    
--  Mostrar todas las reparaciones de un coche concreto
SELECT
    rep.COLUMN_VALUE AS REPARACIONES
FROM Coche c,
    TABLE (c.reparaciones) rep
    WHERE idvehiculo = 1;
    
--  Listar coches ordenados por precio
SELECT 
    c.idvehiculo,
    c.nombre,
    c.precio,
    DEREF(c.marca).nombre AS NombreMarca
FROM Coche c
ORDER BY c.precio;

-- Contar reparaciones por coche
SELECT
    c.idvehiculo,
    c.nombre,
    COUNT(rep.COLUMN_VALUE) AS NUM_REP
FROM Coche c,
    TABLE (c.reparaciones) rep
    GROUP BY c.idvehiculo, c.nombre;
    
-- Número de coches por marca
SELECT 
    DEREF(c.marca).nombre AS NombreMarca,
    COUNT(*) AS NUM_COCHES
FROM Coche c
GROUP BY DEREF(c.marca).nombre;

-- Prueba de un coche sin reparaciones

INSERT INTO Coche
    SELECT CocheType(
        6,
        'Formentor',
        50000,
        REF(m),
        ColoresType('Morado'),
        ReparacionesType('')
    ) FROM Marca m WHERE m.idmarca = 4;

-- Mostrar coches sin reparaciones
SELECT
    c.idvehiculo,
    c.nombre,
    c.precio,
    DEREF(c.marca).nombre AS NombreMarca
FROM Coche c
LEFT JOIN TABLE(c.reparaciones) rep
    ON c.idvehiculo = c.idvehiculo -- comparo el mismo ID porque la tabla anidada no tiene el idvehiculo 
WHERE rep.COLUMN_VALUE IS NULL;



