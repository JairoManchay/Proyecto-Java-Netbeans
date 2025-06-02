delimiter $$

create procedure sp_generar_codigo_documento(
	in p_tipo varchar(20),
    out p_codigo char(12)
)

begin
	declare iniciales char(2); 
    declare numero int;
    
    set iniciales = if(lower(p_tipo) = 'factura', 'FC', 'BV');
    
    select 
		ifnull(max(cast(substring(codigo, 3) as unsigned)), 0) + 1 into numero
    from 
		documento
	where
		codigo like concat(iniciales, '%');

	set p_codigo = concat(iniciales, lpad(numero, 10, '0'));
end$$

delimiter ;

delimiter $$

create procedure sp_registrar_documento
(
	in p_fecha datetime,
    in p_tipo varchar(20),
    in p_num_cliente varchar(11),
    in p_nombre_cliente varchar(60),
    in p_forma_pago varchar(20),
    in p_num_mesa tinyint
)

begin
	declare p_codigo char(12);
    
    call sp_generar_codigo_documento(p_tipo, p_codigo);
    
    insert into documento (codigo, fecha, tipo, num_cliente, nombre_cliente, forma_pago, num_mesa) 
    values (p_codigo, p_fecha, p_tipo, p_num_cliente, p_nombre_cliente, p_forma_pago, p_num_mesa);
end$$

delimiter ;