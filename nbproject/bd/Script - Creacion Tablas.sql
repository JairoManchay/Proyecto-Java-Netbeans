use bd_restaurante;

create table producto (
	codigo char(6) not null,
    descripcion varchar(50) not null,
    precio numeric(5,2) not null,
    categoria varchar(30) not null
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
    tipo varchar(20) not null,
    num_cliente varchar(11) null,
    nombre_cliente varchar(60) null,
    forma_pago varchar(20) not null,
    num_mesa tinyint
);

create table mesa (
	numero tinyint not null auto_increment unique,
    asientos tinyint,
    disponible bool not null default 1
);