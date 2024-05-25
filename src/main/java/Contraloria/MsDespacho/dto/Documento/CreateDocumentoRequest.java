package Contraloria.MsDespacho.dto.Documento;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateDocumentoRequest {
    
    @NotBlank(message = "El número de documento no puede estar vacío.")
    int tipoDocumento;

    @NotBlank(message = "El número de documento no puede estar vacío.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El número de documento solo puede contener letras y números.")
    String numeroDocumento;

    @NotNull(message = "La fecha del documento no puede estar vacía.")
    Date fechaDocumento;

    int movimiento;

    @NotNull(message = "La fecha de ingreso no puede estar vacía.")
    Date fechaIngreso;

    int clase;

    @NotNull(message = "La fecha de envío no puede estar vacía.")
    Date fechaEnvio;

    @NotNull(message = "La fecha de revisión no puede estar vacía.")
    Date fechaRevision;

    String flujo;

    String ddjj;

    String notas;
}
