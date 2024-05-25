package Contraloria.MsDespacho.dto.Cargo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Contraloria.MsDespacho.model.Documento;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateCargoRequest {

    int idDocumento;

    @NotNull(message = "La fecha de retorno no puede estar vacía.")
    int idSedeDestino;

    @NotNull(message = "La fecha de recepción no puede estar vacía.")
    Date fechaRecepcion;

    @NotNull(message = "La fecha de retorno no puede estar vacía.")
    Date fechaRetorno;
    
    @NotNull(message = "La fecha de retorno no puede estar vacía.")
    int intento;

    int enuMotivoDevolucion;

    @Pattern(regexp = "^(?!\\s)(.*\\S)?$", message = "La descripción del motivo de devolución no debe comenzar ni terminar con espacios.")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "La descripción del motivo de devolución solo puede contener letras y espacios, sin números ni caracteres especiales.")
    String descMotivoDevolucion;

    @Pattern(regexp = "^(?!\\s)(.*\\S)?$", message = "La descripción del motivo de devolución no debe comenzar ni terminar con espacios.")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "La descripción del motivo de devolución solo puede contener letras y espacios, sin números ni caracteres especiales.")
    String notas;

    @Pattern(regexp = "^(?!\\s)(.*\\S)?$", message = "La descripción del motivo de devolución no debe comenzar ni terminar con espacios.")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "La descripción del motivo de devolución solo puede contener letras y espacios, sin números ni caracteres especiales.")
    String codigoBarra;

    @JsonIgnore
    private Documento documento;

    @AssertTrue(message = "La fecha de retorno debe ser posterior a la fecha de recepción.")
    public boolean isFechaRetornoValid() {
        return fechaRetorno != null && fechaRecepcion != null && !fechaRetorno.before(fechaRecepcion);
    }

    Integer usuarioCreacion;

}
