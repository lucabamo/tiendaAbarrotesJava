DROP DATABASE  "TiendaAbarrotes"


CREATE DATABASE  "TiendaAbarrotes"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Spanish_Mexico.1252'
       LC_CTYPE = 'Spanish_Mexico.1252'
       CONNECTION LIMIT = -1;

CREATE SCHEMA Empresa;
CREATE SCHEMA Transaccion;
CREATE SCHEMA Inventario;

--Tabla Empleado--
CREATE TABLE Empresa.Empleado(
	IdEmpleado BIGSERIAL NOT NULL,
	Nombre VARCHAR(200) NOT NULL,
	Domicilio VARCHAR(200) NOT NULL,
	FechaNac DATE NOT NULL,
	Edad INT, --Usado en trigger calcula edad--
	Usuario VARCHAR(200) NOT NULL,
	Contrasenia VARCHAR(100) NOT NULL,
	CONSTRAINT PK_EMPLEADO PRIMARY KEY(IdEmpleado)
)

--Tabla proveedor--
CREATE TABLE Empresa.Proveedor(
	IdProveedor BIGSERIAL NOT NULL,
	Nombre VARCHAR(200) NOT NULL,
	Telefono VARCHAR(80) NOT NULL,
	Email VARCHAR(200) NOT NULL, --Para hacer UNIQUE
	RFC VARCHAR(100) NOT NULL,
	DomicilioFiscal VARCHAR(200) NOT NULL,
	CONSTRAINT PK_PROVEEDOR PRIMARY KEY(IdProveedor)
)

ALTER TABLE Empresa.Proveedor ADD CONSTRAINT UQ_EMAIL UNIQUE (Email);
ALTER TABLE Empresa.Proveedor ADD CONSTRAINT UQ_RFC UNIQUE (RFC);

--Tabla Producto--
CREATE TABLE Inventario.Producto(
	IdProducto BIGSERIAL NOT NULL,
	Nombre VARCHAR(200) NOT NULL,
	Existencia INT NOT NULL, --Aqu� est� bien este tipo de dato?--
	CostoProveedor FLOAT8 NOT NULL,
	CostoVenta FLOAT8 NOT NULL,
	CONSTRAINT PK_PRODUCTO PRIMARY KEY(IdProducto)
)


--Tabla Venta--
CREATE TABLE Transaccion.Venta(
	IdVenta BIGSERIAL NOT NULL,
	IdEmpleado BIGINT NOT NULL,
	FechaVenta TIMESTAMP NOT NULL,
	Total FLOAT8 NOT NULL,
	CONSTRAINT PK_VENTA1 PRIMARY KEY(IdVenta),
	CONSTRAINT FK_EMPLEADO1 FOREIGN KEY(IdEmpleado) REFERENCES Empresa.Empleado(IdEmpleado)
)


CREATE TABLE Transaccion.Promocion(
	IdPromocion BIGSERIAL NOT NULL,
	IdProducto BIGINT NOT NULL,
	FechaInicio TIMESTAMP NOT NULL,
	FechaFinal TIMESTAMP NOT NULL,
	Descuento REAL NOT NULL, --Preguntar a la maestra--
	CONSTRAINT PK_PROMOCION PRIMARY KEY(IdPromocion),
	CONSTRAINT FK_PRODUCTO2 FOREIGN KEY(IdProducto) REFERENCES Inventario.Producto(IdProducto)
)

--Tabla detalle venta--
CREATE TABLE Transaccion.DetalleVenta(
	IdDetalleVenta BIGSERIAL NOT NULL,
	IdVenta BIGINT NOT NULL,
	IdPromocion BIGINT NOT NULL,
	IdProducto BIGINT NOT NULL,
	Cantidad INT NOT NULL,
	Subtotal FLOAT8, --Usado para calcular subtotal--
	CONSTRAINT PK_DETALLEVENTA PRIMARY KEY (IdDetalleVenta),
	CONSTRAINT FK_VENTA2 FOREIGN KEY(IdVenta) REFERENCES Transaccion.Venta(IdVenta),
	CONSTRAINT FK_PROMOCION FOREIGN KEY(IdPromocion) REFERENCES Transaccion.Promocion(IdPromocion),
	CONSTRAINT FK_PRODUCTO1 FOREIGN KEY(IdProducto) REFERENCES Inventario.Producto(IdProducto)
)

DROP TABLE Transaccion.DetalleVenta

CREATE TABLE Transaccion.Compra(
	IdCompra BIGSERIAL NOT NULL,
	IdProveedor BIGINT NOT NULL,
	IdEmpleado BIGINT NOT NULL,
	Fecha TIMESTAMP NOT NULL,
	Total FLOAT8 NOT NULL,
	CONSTRAINT PK_COMPRA PRIMARY KEY(IdCompra),
	CONSTRAINT FK_PROVEEDOR1 FOREIGN KEY(IdProveedor) REFERENCES Empresa.Proveedor(IdProveedor),
	CONSTRAINT FK_EMPLEADO2 FOREIGN KEY(IdEmpleado) REFERENCES Empresa.Empleado(IdEmpleado)
)

CREATE TABLE Transaccion.DetalleCompra(
	IdDetalleCompra BIGSERIAL NOT NULL,
	IdCompra BIGINT NOT NULL,
	IdProducto BIGINT NOT NULL,
	Cantidad INT NOT NULL,
	Subtotal FLOAT8,
	CONSTRAINT PK_DETALLECOMPRA PRIMARY KEY (IdDetalleCompra),
	CONSTRAINT FK_COMPRA1 FOREIGN KEY(IdCompra) REFERENCES Transaccion.Compra(IdCompra),
	CONSTRAINT FK_PRODUCTO3 FOREIGN KEY(IdProducto) REFERENCES Inventario.Producto(IdProducto)
)

DROP TABLE Transaccion.DetalleCompra

CREATE TABLE Transaccion.Devolucion(
	IdDevolucion BIGSERIAL NOT NULL,
	IdEmpleado BIGINT NOT NULL,
	IdVenta BIGINT NOT NULL,
	Fecha TIMESTAMP NOT NULL,
	Motivo VARCHAR(300) NOT NULL,
	Monto FLOAT8 NOT NULL,
	CONSTRAINT PK_DEVOLUCION PRIMARY KEY(IdDevolucion),
	CONSTRAINT FK_EMPLEADO3 FOREIGN KEY(IdEmpleado) REFERENCES Empresa.Empleado(IdEmpleado),
	CONSTRAINT FK_VENTA3 FOREIGN KEY(IdVenta) REFERENCES Transaccion.Venta(IdVenta)
)

CREATE TABLE Transaccion.DetalleDevolucion(
	IdDevolucion BIGINT NOT NULL,
	IdProducto BIGINT NOT NULL,
	Cantidad INT NOT NULL,
	CONSTRAINT FK_DEVOLUCION1 FOREIGN KEY(IdDevolucion) REFERENCES Transaccion.Devolucion(IdDevolucion),
	CONSTRAINT FK_PRODUCTO4 FOREIGN KEY(IdProducto) REFERENCES Inventario.Producto(IdProducto)
)

CREATE TABLE Transaccion.Entrega(
	IdEntrega BIGSERIAL NOT NULL,
	IdProveedor BIGINT NOT NULL,
	IdEmpleado BIGINT NOT NULL,
	IdDevolucion BIGINT NOT NULL,
	FechaEntrega TIMESTAMP NOT NULL,
	CONSTRAINT PK_ENTREGA PRIMARY KEY(IdEntrega),
	CONSTRAINT FK_PROVEEDOR2 FOREIGN KEY(IdProveedor) REFERENCES Empresa.Proveedor(IdProveedor),
	CONSTRAINT FK_EMPLEADO4 FOREIGN KEY(IdEmpleado) REFERENCES Empresa.Empleado(IdEmpleado),
	CONSTRAINT FK_DEVOLUCION2 FOREIGN KEY(IdDevolucion) REFERENCES Transaccion.Devolucion(IdDevolucion)
)


--Trigger para actualizar existencias de un producto despues de realizar una compra al proveedor
CREATE FUNCTION ActualizarInventario() RETURNS TRIGGER 
AS $$
DECLARE BEGIN
	UPDATE Inventario.Producto SET
	Existencia = Existencia + NEW.Cantidad
	WHERE Producto.IdProducto = NEW.IdProducto;
	return NEW;
END;
$$
Language plpgsql;

CREATE TRIGGER ActualizarExistenciasCompra AFTER INSERT
ON Transaccion.DetalleCompra FOR EACH ROW
EXECUTE PROCEDURE ActualizarInventario();

--Trigger para actualizar existencias de un producto despues de realizar una venta
CREATE FUNCTION ActualizarExistencias() RETURNS TRIGGER 
AS $$
DECLARE BEGIN
	UPDATE Inventario.Producto SET
	Existencia = Existencia - NEW.Cantidad
	WHERE Producto.IdProducto = NEW.IdProducto;
	return NEW;
END;
$$
Language plpgsql;

CREATE TRIGGER ActualizarExistenciasVenta AFTER INSERT
ON Transaccion.DetalleVenta FOR EACH ROW
EXECUTE PROCEDURE ActualizarExistencias();

Select * from Transaccion.Venta

--Trigger para actualizar total de la venta
CREATE FUNCTION ActualizarTotalVenta() RETURNS TRIGGER
AS $$
DECLARE BEGIN
	UPDATE Transaccion.Venta SET 
	Total = Total + NEW.Subtotal 
	WHERE Venta.IdVenta = NEW.IdVenta;
	RETURN NEW;
END;
$$
Language plpgsql;

CREATE TRIGGER ActualizarTotalVenta AFTER INSERT
ON Transaccion.DetalleVenta FOR EACH ROW
EXECUTE PROCEDURE ActualizarTotalVenta();

CREATE FUNCTION ActualizarTotalVentaDel() RETURNS TRIGGER
AS $$
DECLARE BEGIN
	UPDATE Transaccion.Venta SET 
	Total = Total - OLD.Subtotal 
	WHERE Venta.IdVenta = OLD.IdVenta;
	RETURN OLD;
END;
$$
Language plpgsql;

CREATE TRIGGER ActualizarTotalVentaDelete AFTER DELETE
ON Transaccion.DetalleVenta FOR EACH ROW
EXECUTE PROCEDURE ActualizarTotalVentaDel();

--Actualizar total compra
CREATE FUNCTION ActualizarTotalCompra() RETURNS TRIGGER
AS $$
DECLARE BEGIN
	UPDATE Transaccion.Compra SET 
	Total = Total + NEW.Subtotal 
	WHERE Compra.IdCompra = NEW.IdCompra;
	RETURN NEW;
END;
$$
Language plpgsql;

CREATE TRIGGER ActualizarTotalCompra AFTER INSERT
ON Transaccion.DetalleCompra FOR EACH ROW
EXECUTE PROCEDURE ActualizarTotalCompra();

CREATE FUNCTION ActualizarTotalCompraDel() RETURNS TRIGGER
AS $$
DECLARE BEGIN
	UPDATE Transaccion.Compra SET 
	Total = Total - OLD.Subtotal 
	WHERE Compra.IdCompra = OLD.IdCompra;
	RETURN OLD;
END;
$$
Language plpgsql;

CREATE TRIGGER ActualizarTotalCompraDelete AFTER DELETE
ON Transaccion.DetalleCompra FOR EACH ROW
EXECUTE PROCEDURE ActualizarTotalCompraDel();

--Trigger para calcular el subtotal de la venta tomando en consideracion el descuento
CREATE FUNCTION CalcularSubtotalVenta() RETURNS TRIGGER
AS $$
DECLARE 
	id_Producto BIGINT;
	id_Promocion BIGINT;
	cantidad INT;
	costoVenta FLOAT8;
	descuento_Promo REAL;
	fecha_inicio TIMESTAMP;
	fecha_final TIMESTAMP;

BEGIN
	cantidad = NEW.Cantidad;
	id_Producto = NEW.IdProducto;
	id_Promocion = NEW.IdPromocion;
	SELECT Producto.CostoVenta INTO costoVenta FROM Inventario.Producto WHERE Producto.IdProducto = id_Producto;
	SELECT Promocion.Descuento INTO descuento_Promo FROM Transaccion.Promocion WHERE Promocion.IdPromocion = id_Promocion;
	SELECT Promocion.FechaInicio INTO fecha_inicio FROM Transaccion.Promocion WHERE Promocion.IdPromocion = id_Promocion;
	SELECT Promocion.FechaFinal INTO fecha_final FROM Transaccion.Promocion WHERE Promocion.IdPromocion = id_Promocion;
	IF CURRENT_DATE NOT BETWEEN fecha_inicio AND fecha_final THEN
		descuento_Promo = 0;
	 END IF;
	NEW.Subtotal := (cantidad * costoVenta - (descuento_Promo * costoVenta * cantidad)); 
	RETURN NEW;

END;
$$
Language plpgsql;	

CREATE TRIGGER ActualizarSubtotalDetalleVenta BEFORE INSERT
ON Transaccion.DetalleVenta FOR EACH ROW
EXECUTE PROCEDURE CalcularSubtotalVenta();

--Trigger para calcular el subtotal de la compra

CREATE FUNCTION CalcularSubtotalCompra() RETURNS TRIGGER
AS $$
DECLARE 
	id_Producto BIGINT;
	cantidad INT;
	costo_proveedor FLOAT8;
BEGIN
	cantidad = NEW.Cantidad;
	id_Producto = NEW.IdProducto;
	SELECT Producto.CostoProveedor INTO costo_proveedor FROM Inventario.Producto WHERE Producto.IdProducto = id_Producto;
	NEW.Subtotal := (cantidad * costo_proveedor); 
	RETURN NEW;

END;
$$
Language plpgsql;	

CREATE TRIGGER ActualizarSubtotalDetalleCompra BEFORE INSERT
ON Transaccion.DetalleCompra FOR EACH ROW
EXECUTE PROCEDURE CalcularSubtotalCompra();


DROP TRIGGER ActualizarSubtotalDetalleVenta ON Transaccion.DetalleVenta
DROP FUNCTION CalcularSubtotalVenta()

SELECT * FROM Transaccion.Venta

SELECT * FROM Transaccion.DetalleVenta

INSERT INTO Transaccion.DetalleVenta (IdVenta, IdPromocion, IdProducto,Cantidad) VALUES (4,1,1,10)

SELECT * FROM Transaccion.Promocion

INSERT INTO Transaccion.DetalleVenta (IdVenta, IdPromocion, IdProducto,Cantidad) VALUES (4,3,1,1)

SELECT * FROM Empresa.Empleado
INSERT INTO Empresa.Empleado(Nombre,Domicilio,FechaNac,Usuario,Contrasenia) VALUES ('Jung Hoseok','Seoul','1994-02-18', 'j-hope', '12345')

SELECT * FROM Empresa.Proveedor
SELECT * FROM  Transaccion.DetalleCompra
SELECT * FROM Transaccion.Compra
INSERT INTO Transaccion.Compra (IdProveedor,IdEmpleado,Fecha,Total) VALUES (1,1, '2019-11-20',0)
INSERT INTO Transaccion.DetalleCompra(IdCompra, IdProducto,Cantidad) VALUES (1,1,1)
INSERT INTO Inventario.Producto(Nombre,Existencia,CostoProveedor,CostoVenta) VALUES ('Jugo', 10, 2, 3)
SELECT * FROM Inventario.Producto

TRUNCATE TABLE Transaccion.DetalleVenta
