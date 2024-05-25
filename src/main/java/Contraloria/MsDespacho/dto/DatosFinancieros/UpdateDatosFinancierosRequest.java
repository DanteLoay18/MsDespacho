package Contraloria.MsDespacho.dto.DatosFinancieros;

import java.util.Date;
import java.util.Optional;

import lombok.Data;

@Data
public class UpdateDatosFinancierosRequest 
{
    Integer id;

    Optional<Integer> tipoContrato;

    Optional<Integer> nroContrato;

    Optional<String> archivoContrato;

    Optional<Date> fechaInicio;

    Optional<Date> fechaFin;

    Optional<Date> fechaConsulta;
    
    Optional<Integer> estado;

    Optional<Integer> tipoServicio;

    Optional<Double> montoContrato;

    Optional<Double> saldoContrato;

    Integer usuarioModificacion;
}
