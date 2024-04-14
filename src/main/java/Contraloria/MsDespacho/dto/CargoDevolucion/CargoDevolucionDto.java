package Contraloria.MsDespacho.dto.CargoDevolucion;

import java.sql.Date;

import Contraloria.MsDespacho.dto.Distribucion.CargoDistribucionDto;
import lombok.Data;

@Data
public class CargoDevolucionDto {

    int id;

    private CargoDistribucionDto cargoDistribucion;

    int idSedeDestino;

    int idUsuarioRecibe;

    public Date fechaDevolucion;

    

}
