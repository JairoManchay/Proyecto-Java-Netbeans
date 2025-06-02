delimiter $$

create procedure sp_modificar_producto
(
	in p_codigo char(6),
	in p_descripcion varchar(50),
	in p_precio numeric(5,2),
	in p_categoria varchar(30)
)

begin
	update producto
    set
		descripcion = p_descripcion,
        precio = p_precio,
        categoria = p_categoria
	where
		codigo = p_codigo;
end$$

delimiter ;
