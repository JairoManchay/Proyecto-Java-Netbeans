use bd_restaurante;

-- Primary Keys
alter table producto
add constraint pk_producto primary key (codigo);
alter table documento
add constraint pk_documento primary key (codigo);
alter table detalle_documento
add constraint pk_detalle_documento primary key (id_documento, id_producto);
alter table mesa
add constraint pk_mesa primary key (numero);

-- Foreign Keys
alter table documento
add constraint fk_documento_mesa foreign key (num_mesa) references mesa (numero);
alter table detalle_documento
add constraint fk_detalle_documento_documento foreign key (id_documento) references documento (codigo);
alter table detalle_documento
add constraint fk_detalle_documento_producto foreign key (id_producto) references producto (codigo);
