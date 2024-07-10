DELIMITER $ 
CREATE PROCEDURE `sp_listar_categorias` (
 	var_log int)
 begin
     if (var_log is null) then
 		select * from categorias;
 	else
         select * from categorias where categoriaID = var_log;
 	end if;
 END $ 