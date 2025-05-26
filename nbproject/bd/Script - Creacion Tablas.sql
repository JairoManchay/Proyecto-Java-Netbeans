use bd_restaurante;

create table categoria (
	codigo char(4) not null,
    nombre varchar(30) not null
);

create table producto (
	codigo char(6) not null,
    descripcion varchar(50) not null,
    precio numeric(5,2) not null,
    id_categoria char(4) not null
);

create table detalle_documento (
	id_documento char(12) not null,
    id_producto char(6) not null,
    cantidad tinyint not null,
    precio numeric(5,2) not null
);

create table documento (
	codigo char(12) not null,
    fecha datetime not null,
    id_forma_pago char(3) not null,
    num_mesa tinyint
);

create table forma_pago (
	codigo char(3) not null,
    nombre varchar(20) not null
);

create table mesa (
	numero tinyint not null,
    asientos tinyint,
    disponible bit not null default 1
);

create table boleta (
	id_documento char(12) not null,
    dni char(8) not null,
    nombres varchar(60) not null
);

create table factura (
	id_documento char(12) not null,
    ruc char(11) not null,
    razon_social varchar(60) not null
);
