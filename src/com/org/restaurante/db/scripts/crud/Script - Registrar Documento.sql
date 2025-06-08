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