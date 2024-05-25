package Contraloria.MsDespacho.dto.Cargo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Contraloria.MsDespacho.model.Documento;
import lombok.Data;

@Data
public class UpdateCargoRequest {

    int id;
    
    int idDocumento;

    int idSedeDestino;

    Date fechaRecepcion;

    Date fechaRetorno;
    
    int intento;

    int enuMotivoDevolucion;

    String descMotivoDevolucion;

    String notas;
    
    String codigoBarra;

    @JsonIgnore
    private Documento documento;

    @JsonIgnore
    private Date fechaCreacion;

    @JsonIgnore
    private String usuarioCreacion;

    Integer usuarioModificacion;

}
