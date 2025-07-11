delimiter $$

create procedure sp_generar_codigo_producto(out p_codigo char(6))

begin
	declare numero int;
    select 
		ifnull(max(cast(substring(codigo, 3) as unsigned)), 0) + 1 into numero
    from 
		producto;

	set p_codigo = concat('PD', lpad(numero, 4, '0'));
end$$

delimiter ;

delimiter $$

create procedure sp_registrar_producto
(
	in p_descripcion varchar(50),
	in p_precio numeric(5,2),
	in p_categoria varchar(30),
        in p_stock int
)

begin
	declare p_codigo char(6);
    
    call sp_generar_codigo_producto(p_codigo);
    
    insert into producto (codigo, descripcion, precio, categoria, stock) 
    values (p_codigo, p_descripcion, p_precio, p_categoria, p_stock);
end$$

delimiter ;