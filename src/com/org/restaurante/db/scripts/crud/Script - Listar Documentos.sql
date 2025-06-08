delimiter $$

create procedure sp_listar_documentos()

begin
	select
		*
    from
		documentos;
end$$

delimiter ;