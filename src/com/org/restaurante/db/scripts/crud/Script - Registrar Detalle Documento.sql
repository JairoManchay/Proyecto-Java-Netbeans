delimiter $$

create procedure sp_registrar_detalle_documento
(
	in p_id_documento char(12),
    in p_id_producto char(6),
    in p_cantidad tinyint,
    in p_precio numeric(5,2)
)

begin
    insert into detalle_documento (id_documento, id_producto, cantidad, precio) 
    values (p_id_documento, p_id_producto, p_cantidad, p_precio);
end$$

delimiter ;