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
	FechaNac TIMESTAMP NOT NULL,
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

ALTER TABLE Empresa.Proveedor ADD CONSTRAINT CH_Email CHECK(
	Email LIKE '%_@__%.__%'
);

--Tabla Producto--
CREATE TABLE Inventario.Producto(
	IdProducto BIGSERIAL NOT NULL,
	Nombre VARCHAR(200) NOT NULL,
	Existencia INT NOT NULL, --Aqu� est� bien este tipo de dato?--
	CostoProveedor FLOAT8 NOT NULL,
	CostoVenta FLOAT8 NOT NULL,
	CONSTRAINT PK_PRODUCTO PRIMARY KEY(IdProducto)
)

ALTER TABLE Inventario.Producto ADD CONSTRAINT CH_Existencias CHECK(
	Existencia >= 0 AND Existencia <=100
	);
	

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

ALTER TABLE Transaccion.DetalleVenta ADD CONSTRAINT CH_CantidadDetalleVenta CHECK(
	Cantidad >= 1 AND Cantidad <= 100
);

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
	Entregada BOOLEAN NOT NULL, --Para cuando ya se entregue la devolución al proveedor no vuelva a ser entregada--
	CONSTRAINT PK_DEVOLUCION PRIMARY KEY(IdDevolucion),
	CONSTRAINT FK_EMPLEADO3 FOREIGN KEY(IdEmpleado) REFERENCES Empresa.Empleado(IdEmpleado),
	CONSTRAINT FK_VENTA3 FOREIGN KEY(IdVenta) REFERENCES Transaccion.Venta(IdVenta)
)

CREATE TABLE Transaccion.DetalleDevolucion(
	IdDetalleDevolucion BIGSERIAL NOT NULL,
	IdDevolucion BIGINT NOT NULL,
	IdProducto BIGINT NOT NULL,
	Cantidad INT NOT NULL,
	CONSTRAINT PK_DETALLEDEVOLUCION PRIMARY KEY(IdDetalleDevolucion),
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

--TRIGGERS--

--Trigger para calcular la edad de un empleado--
CREATE OR REPLACE FUNCTION EDAD_EMPLEADO() RETURNS TRIGGER AS $body$
BEGIN
  NEW.Edad := date_part('year', AGE(New.fechanac));
  RETURN NEW; -- or the insert or update would fail
END; 
$body$ LANGUAGE plpgsql;


CREATE TRIGGER CALCULA_EDAD
BEFORE INSERT OR UPDATE ON Empresa.Empleado
FOR EACH ROW
EXECUTE PROCEDURE EDAD_EMPLEADO();

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

--Trigger para actualizar el total de la devolución después de un detalle devolución--
CREATE FUNCTION ActualizaTotalDevolucion() RETURNS TRIGGER
AS $$
DECLARE 
	CostoProducto FLOAT8;
BEGIN
	SELECT Producto.CostoVenta INTO CostoProducto FROM Inventario.Producto WHERE IdProducto = NEW.IdProducto;
	UPDATE Transaccion.Devolucion SET 
	monto = monto + (NEW.Cantidad * CostoProducto)
	WHERE IdDevolucion = NEW.IdDevolucion;
	RETURN NEW;
END;
$$
Language plpgsql;

CREATE TRIGGER ActualizaTotalDevolucionTrigg AFTER INSERT 
ON Transaccion.DetalleDevolucion FOR EACH ROW
EXECUTE PROCEDURE ActualizaTotalDevolucion();

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

--Actulizar el total de la venta después de eliminar un detalle de venta
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

--Trigger para actualizar el inventario después de una entrega
CREATE FUNCTION EntregaDevolcion() RETURNS TRIGGER
AS $$
DECLARE 
	idEntrega BIGINT;
	idDevolucionE BIGINT;
BEGIN
	idDevolucionE = NEW.idDevolucion;
	UPDATE Transaccion.Devolucion SET Entregada = TRUE
	WHERE idDevolucion = idDevolucionE;
	RETURN NEW;
END;
$$
Language plpgsql;

CREATE TRIGGER ActualizaEstadoDevolucion BEFORE INSERT
ON Transaccion.Entrega FOR EACH ROW
EXECUTE PROCEDURE EntregaDevolcion();
	
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

--Trigger para ingresar una promocion default despues de la insercion de un producto
CREATE FUNCTION insertaPromocionDefault() RETURNS TRIGGER
AS $$
DECLARE BEGIN
	
	INSERT INTO Transaccion.Promocion(IdProducto, FechaInicio, FechaFinal,Descuento) VALUES (NEW.IdProducto, CURRENT_DATE,CURRENT_DATE,0);
	RETURN NEW;

END;
$$
Language plpgsql;	


CREATE TRIGGER agregaPromocionDefault AFTER INSERT
ON Inventario.Producto FOR EACH ROW
EXECUTE PROCEDURE insertaPromocionDefault();



--Usuarios--
CREATE ROLE ADMINISTRADOR WITH LOGIN ENCRYPTED PASSWORD 'password';
CREATE ROLE EMPLEADO WITH LOGIN ENCRYPTED PASSWORD 'password';
CREATE ROLE CLIENTE WITH LOGIN ENCRYPTED PASSWORD 'password';

--Permisos--

--ADMINISTRADOR--
GRANT CONNECT ON DATABASE "TiendaAbarrotes" TO ADMINISTRADOR;

GRANT USAGE ON SCHEMA empresa,inventario,transaccion TO ADMINISTRADOR

GRANT ALL PRIVILEGES ON DATABASE "TiendaAbarrotes" to ADMINISTRADOR;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA "empresa" TO ADMINISTRADOR;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA "inventario" TO ADMINISTRADOR;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA "transaccion" TO ADMINISTRADOR;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA "public" TO ADMINISTRADOR;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA "empresa" TO ADMINISTRADOR;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA "inventario" TO ADMINISTRADOR;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA "transaccion" TO ADMINISTRADOR;


--EMPLEADO--
GRANT CONNECT ON DATABASE "TiendaAbarrotes" TO EMPLEADO;
GRANT USAGE ON SCHEMA inventario,transaccion TO EMPLEADO;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA "inventario" TO EMPLEADO;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA "inventario" TO EMPLEADO;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA "transaccion" TO EMPLEADO;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA "transaccion" TO EMPLEADO;

--CLIENTE--
GRANT CONNECT ON DATABASE "TiendaAbarrotes" TO CLIENTE;
REVOKE INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA "inventario" FROM CLIENTE;
GRANT SELECT ON ALL TABLES IN SCHEMA "inventario" TO CLIENTE;
REVOKE INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA "transaccion" FROM CLIENTE;
GRANT SELECT ON ALL TABLES IN SCHEMA "transaccion" TO CLIENTE;

SELECT * FROM Empresa.Proveedor
SELECT * FROM Empresa.Empleado
SELECT Nombre, idEmpleado FROM Empresa.Empleado
SELECT * FROM Transaccion.Venta
SELECT * FROM Transaccion.Devolucion
SELECT * FROM Transaccion.Entrega
SELECT * FROM Transaccion.DetalleDevolucion
SELECT * FROM Inventario.Producto

SELECT * FROM Transaccion.Devolucion
SELECT * FROM Transaccion.DetalleDevolucion

SELECT producto.IdProducto, producto.Existencia, detalle.Cantidad, entrega.IdEntrega, entrega.IdDevolucion FROM Inventario.Producto AS producto 
INNER JOIN Transaccion.DetalleDevolucion AS detalle ON detalle.IdProducto = producto.IdProducto
INNER JOIN Transaccion.Entrega AS entrega ON entrega.IdDevolucion = detalle.IdDevolucion 
AND entrega.IdEntrega = 10