package Contraloria.MsDespacho.dto.Distribucion;


import java.util.ArrayList;

import lombok.Data;

@Data
public class CreateDistribucionRequest {
    
    ArrayList<Integer> cargos;

    ArrayList<String> cargosAdicionales;

    int idSedeDestino;

    Integer usuarioCreacion;

}

