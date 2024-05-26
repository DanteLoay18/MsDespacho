package Contraloria.MsDespacho.dto.CargoDevolucion;

import java.sql.Date;
import java.util.Optional;

import lombok.Data;

@Data
public class UpdateCargoDevolucion {
    
    Integer id;

    Optional<Integer> idSedeDestino;

    Optional<Integer> idUsuarioRecibe;

    public Date fechaDevolucion;

    Integer usuarioModificacion;

}
