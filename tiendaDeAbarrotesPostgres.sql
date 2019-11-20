CREATE DATABASE "tiendaDeAbarratos"
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
	IdVenta BIGINT NOT NULL,
	IdPromocion BIGINT NOT NULL,
	IdProducto BIGINT NOT NULL,
	Cantidad INT NOT NULL,
	Subtotal FLOAT8, --Usado para calcular subtotal--
	CONSTRAINT FK_VENTA2 FOREIGN KEY(IdVenta) REFERENCES Transaccion.Venta(IdVenta),
	CONSTRAINT FK_PROMOCION FOREIGN KEY(IdPromocion) REFERENCES Transaccion.Promocion(IdPromocion),
	CONSTRAINT FK_PRODUCTO1 FOREIGN KEY(IdProducto) REFERENCES Inventario.Producto(IdProducto)
)

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
	IdCompra BIGINT NOT NULL,
	IdProducto BIGINT NOT NULL,
	Cantidad INT NOT NULL,
	Subtotal FLOAT8,
	CONSTRAINT FK_COMPRA1 FOREIGN KEY(IdCompra) REFERENCES Transaccion.Compra(IdCompra),
	CONSTRAINT FK_PRODUCTO3 FOREIGN KEY(IdProducto) REFERENCES Inventario.Producto(IdProducto)
)

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
