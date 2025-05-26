use bd_restaurante;

-- Primary Keys
alter table categoria
add constraint pk_categoria primary key (codigo);
alter table producto
add constraint pk_producto primary key (codigo);
alter table documento
add constraint pk_documento primary key (codigo);
alter table detalle_documento
add constraint pk_detalle_documento primary key (id_documento, id_producto);
alter table forma_pago
add constraint pk_forma_pago primary key (codigo);
alter table mesa
add constraint pk_mesa primary key (numero);
alter table boleta
add constraint pk_boleta primary key (id_documento);
alter table factura
add constraint pk_factura primary key (id_documento);

-- Foreign Keys
alter table producto
add constraint fk_producto_categoria foreign key (id_categoria) references categoria (codigo);
alter table documento
add constraint fk_documento_forma_pago foreign key (id_forma_pago) references forma_pago (codigo);
alter table documento
add constraint fk_documento_mesa foreign key (num_mesa) references mesa (numero);
alter table detalle_documento
add constraint fk_detalle_documento_documento foreign key (id_documento) references documento (codigo);
alter table detalle_documento
add constraint fk_detalle_documento_producto foreign key (id_producto) references producto (codigo);
alter table boleta
add constraint fk_boleta_documento foreign key (id_documento) references documento (codigo);
alter table factura
add constraint fk_factura_documento foreign key (id_documento) references documento (codigo);
