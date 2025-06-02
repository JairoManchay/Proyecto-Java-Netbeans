delimiter $$

create procedure sp_listar_productos()

begin
	select
		*
    from
		producto;
end$$

delimiter ;
