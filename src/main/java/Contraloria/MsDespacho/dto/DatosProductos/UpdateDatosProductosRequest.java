package Contraloria.MsDespacho.dto.DatosProductos;
import java.util.Optional;

import lombok.Data;

@Data
public class UpdateDatosProductosRequest {
    
    Integer id;

    Optional<String> codigo;

    Optional<Integer> tipoServicio;

    Optional<Integer> tipoAcceso;

    Optional<Integer> tipoEntrega;

    Optional<Integer> estadoEntrega;

    Optional<Integer> plazoEntrega;

    Optional<Integer> plazoRetorno;

    Optional<Integer> pais;

    Optional<String> ubigeo;

    Integer usuarioModificacion;

}
