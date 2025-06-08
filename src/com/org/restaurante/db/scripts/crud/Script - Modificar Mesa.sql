delimiter $$

create procedure sp_modificar_mesa
(
	in p_numero tinyint,
    in p_asientos tinyint,
    in p_disponible bool
)

begin
    update mesa
    set
		asientos = p_asientos,
		disponible = p_disponible
	where
		numero = p_numero;
end$$

delimiter ;