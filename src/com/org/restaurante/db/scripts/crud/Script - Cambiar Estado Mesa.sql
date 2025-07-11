delimiter $$

create procedure sp_cambiar_estado_mesa
(
	in p_numero tinyint
)

begin
    update mesa
    set
		disponible = not disponible
	where
		numero = p_numero;
end$$

delimiter ;