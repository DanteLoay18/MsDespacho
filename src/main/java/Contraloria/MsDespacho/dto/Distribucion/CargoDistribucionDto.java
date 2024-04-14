package Contraloria.MsDespacho.dto.Distribucion;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CargoDistribucionDto {

    int id;

    public int numeroCargo;

    public Date fechaCargo;
    
    public int idSedeDestino;

    private List<DetalleCargoDistribucionDto> cargos = new ArrayList<>();

    private List<CargoAdicionalDto> cargosAdicionales = new ArrayList<>();
}
