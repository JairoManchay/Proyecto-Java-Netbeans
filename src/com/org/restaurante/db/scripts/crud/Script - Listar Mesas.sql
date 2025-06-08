delimiter $$

create procedure sp_listar_mesas()

begin
	select
		*
    from
		mesa;
end$$

delimiter ;