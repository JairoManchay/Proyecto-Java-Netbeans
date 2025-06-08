delimiter $$

create procedure sp_registrar_mesa
(
	in p_asientos tinyint
)

begin
    insert into mesa (asientos) values (p_asientos);
end$$

delimiter ;