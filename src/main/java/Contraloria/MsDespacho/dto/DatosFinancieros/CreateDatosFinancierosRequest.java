package Contraloria.MsDespacho.dto.DatosFinancieros;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Contraloria.MsDespacho.model.Proveedor;
import jakarta.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateDatosFinancierosRequest {

    @JsonIgnore
    private Proveedor proveedor;

    @Min(value = 1, message = "El tipo proveedor debe ser un entero positivo")
    int idProveedor;

    int tipoContrato;

    int nroContrato;

    String archivoContrato;

    Date fechaInicio;

    Date fechaFin;

    Date fechaConsulta;
    
    int estado;

    int tipoServicio;

    double montoContrato;

    double saldoContrato;
}
