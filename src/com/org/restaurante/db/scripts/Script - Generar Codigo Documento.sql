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
