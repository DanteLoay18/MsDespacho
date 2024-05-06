package Contraloria.MsDespacho.dto.DatosFinancieros;

import java.sql.Date;

import Contraloria.MsDespacho.model.Proveedor;

import lombok.Data;

@Data
public class DatosFinancierosDto {
    int id;

    Proveedor proveedor;

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
