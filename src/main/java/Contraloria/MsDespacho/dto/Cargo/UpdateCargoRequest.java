package Contraloria.MsDespacho.dto.Cargo;

import java.util.Date;
import java.util.Optional;

import lombok.Data;

@Data
public class UpdateCargoRequest {

    Integer id;
    
    Optional<Integer> idSedeDestino;

    Optional<Date> fechaRecepcion;

    Optional<Date> fechaRetorno;
    
    Optional<Integer> intento;

    Optional<Integer> enuMotivoDevolucion;

    Optional<String> descMotivoDevolucion;

    Optional<String> notas;
    
    Optional<String> codigoBarra;

    Integer usuarioModificacion;

}
