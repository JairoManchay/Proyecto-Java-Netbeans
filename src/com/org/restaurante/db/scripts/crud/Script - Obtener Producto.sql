delimiter $$

create procedure sp_obtener_producto(in p_codigo char(6))

begin
	select
		*
    from
		producto
	where
		codigo = p_codigo;
end$$

delimiter ;