package Contraloria.MsDespacho.dto.Documento;

import java.sql.Date;

public class CreateDocumentoRequest {
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
