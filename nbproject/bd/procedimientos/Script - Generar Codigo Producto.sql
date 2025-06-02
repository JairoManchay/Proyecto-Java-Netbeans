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
