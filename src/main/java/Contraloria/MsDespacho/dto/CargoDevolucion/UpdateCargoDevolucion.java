package Contraloria.MsDespacho.dto.CargoDevolucion;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Contraloria.MsDespacho.model.CargoDistribucion;
import lombok.Data;

@Data
public class UpdateCargoDevolucion {
    
    int id;

    int idCargoDistribucion;

    int idSedeDestino;

    int idUsuarioRecibe;

    public Date fechaDevolucion;

    @JsonIgnore
    private CargoDistribucion cargoDistribucion;

    Integer usuarioModificacion;

}
