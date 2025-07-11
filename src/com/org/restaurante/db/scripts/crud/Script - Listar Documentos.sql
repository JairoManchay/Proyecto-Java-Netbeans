delimiter $$

create procedure sp_listar_documentos()

begin
	select
		*
    from
		documento;
end$$

delimiter ;