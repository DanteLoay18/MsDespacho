package Contraloria.MsDespacho.dto.DatosFinancieros;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Contraloria.MsDespacho.model.Proveedor;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateDatosFinancierosRequest {

    @JsonIgnore
    private Proveedor proveedor;

    @NotNull(message = "El idProveedor no puede ser nulo")
    int idProveedor;

    int tipoContrato;

    int nroContrato;

    String archivoContrato;

    Date fechaInicio;

    Date fechaFin;

    Date fechaConsulta;
    
    int estado;

    int tipoServicio;

    @DecimalMin(value = "0.0", inclusive = false, message = "El montoContrato debe ser un número positivo")
    double montoContrato;

    @DecimalMin(value = "0.0", inclusive = false, message = "El saldoContrato debe ser un número positivo")
    double saldoContrato;

    Integer usuarioCreacion;

    @AssertTrue(message = "La fecha de retorno debe ser posterior a la fecha de recepción.")
    public boolean isFechaRetornoValid() {
        return fechaFin != null && fechaInicio != null && !fechaFin.before(fechaInicio);
    }
}
