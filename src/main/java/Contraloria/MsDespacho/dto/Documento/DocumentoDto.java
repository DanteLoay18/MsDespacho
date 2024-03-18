package Contraloria.MsDespacho.dto.Documento;

import java.sql.Date;

import lombok.Data;

@Data
public class DocumentoDto {
    public Integer id;

    int tipoDocumento;

    String numeroDocumento;

    Date fechaDocumento;

    int movimiento;

    Date fechaIngreso;

    int clase;

    Date fechaEnvio;

    Date fechaRevision;

    String flujo;

    String ddjj;

    String notas;
}
