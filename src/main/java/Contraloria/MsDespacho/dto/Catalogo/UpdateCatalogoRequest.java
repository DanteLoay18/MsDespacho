package Contraloria.MsDespacho.dto.Catalogo;

import java.util.Optional;

import lombok.Data;

@Data
public class UpdateCatalogoRequest {
    Integer id;

    Optional<Integer> codigo;

    Optional<String> descripcion;

    Optional<String> valor;

    Optional<Integer> orden;

    Integer usuarioModificacion;

}
