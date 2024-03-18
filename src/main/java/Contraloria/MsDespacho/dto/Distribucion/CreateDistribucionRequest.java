package Contraloria.MsDespacho.dto.Distribucion;


import java.util.ArrayList;

import lombok.Data;

@Data
public class CreateDistribucionRequest {
    
    ArrayList<Integer> cargos;

    ArrayList<Integer> cargosAdicionales;
}

