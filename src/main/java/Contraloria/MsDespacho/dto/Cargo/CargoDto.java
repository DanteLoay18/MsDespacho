package Contraloria.MsDespacho.dto.Cargo;

import java.sql.Date;

import Contraloria.MsDespacho.dto.Documento.DocumentoDto;
import lombok.Data;

@Data
public class CargoDto {
    int id;

    int idSedeDestino;

    Date fechaRecepcion;

    Date fechaRetorno;
    
    int intento;

    int enuMotivoDevolucion;

    String descMotivoDevolucion;

    String notas;

    private DocumentoDto documento;
}
