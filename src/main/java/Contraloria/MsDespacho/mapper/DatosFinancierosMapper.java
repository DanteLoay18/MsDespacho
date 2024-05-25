package Contraloria.MsDespacho.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import Contraloria.MsDespacho.dto.DatosFinancieros.CreateDatosFinancierosRequest;
import Contraloria.MsDespacho.dto.DatosFinancieros.DatosFinancierosDto;
import Contraloria.MsDespacho.dto.DatosFinancieros.UpdateDatosFinancierosRequest;
import Contraloria.MsDespacho.model.DatosFinancieros;

@Mapper(componentModel = "spring")
public interface DatosFinancierosMapper {
    
    @Mappings({
        @Mapping(target = "tipoServicioDescripcion", ignore = true),
        @Mapping(target = "tipoContratoDescripcion", ignore = true),
    })
    DatosFinancierosDto toDto(DatosFinancieros datosFinancieros);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "esEliminado", constant = "false"),
        @Mapping(target = "fechaCreacion", expression = "java(new java.util.Date())"),
        @Mapping(target = "fechaModificacion", ignore = true),
        @Mapping(target = "usuarioModificacion", ignore = true),
        @Mapping(target = "usuarioEliminacion", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true),
    })
    DatosFinancieros createRequestToEntity(CreateDatosFinancierosRequest createDatosFinancierosRequest);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "esEliminado", ignore = true),
        @Mapping(target = "fechaCreacion", ignore = true),
        @Mapping(target = "usuarioCreacion", ignore = true),
        @Mapping(target = "fechaModificacion", expression = "java(new java.util.Date())"),
        @Mapping(target = "usuarioEliminacion", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true),
        @Mapping(target = "proveedor", ignore = true),
        @Mapping(target = "tipoContrato", expression = "java(unwrap(updateDatosFinancierosRequest.getTipoContrato(), entity.getTipoContrato()))"),
        @Mapping(target = "nroContrato", expression = "java(unwrap(updateDatosFinancierosRequest.getNroContrato(), entity.getNroContrato()))"),
        @Mapping(target = "archivoContrato", expression = "java(unwrap(updateDatosFinancierosRequest.getArchivoContrato(), entity.getArchivoContrato()))"),
        @Mapping(target = "fechaInicio", expression = "java(unwrap(updateDatosFinancierosRequest.getFechaInicio(), entity.getFechaInicio()))"),
        @Mapping(target = "fechaFin", expression = "java(unwrap(updateDatosFinancierosRequest.getFechaFin(), entity.getFechaFin()))"),
        @Mapping(target = "fechaConsulta", expression = "java(unwrap(updateDatosFinancierosRequest.getFechaConsulta(), entity.getFechaConsulta()))"),
        @Mapping(target = "estado", expression = "java(unwrap(updateDatosFinancierosRequest.getEstado(), entity.getEstado()))"),
        @Mapping(target = "tipoServicio", expression = "java(unwrap(updateDatosFinancierosRequest.getTipoServicio(), entity.getTipoServicio()))"),
        @Mapping(target = "montoContrato", expression = "java(unwrap(updateDatosFinancierosRequest.getMontoContrato(), entity.getMontoContrato()))"),
        @Mapping(target = "saldoContrato", expression = "java(unwrap(updateDatosFinancierosRequest.getSaldoContrato(), entity.getSaldoContrato()))")
    })
    void updateRequestToEntity(@MappingTarget DatosFinancieros entity,UpdateDatosFinancierosRequest updateDatosFinancierosRequest);

 
    default <T> T unwrap(Optional<T> optional, T currentValue) {
        return (optional != null && optional.isPresent()) ? optional.get() : currentValue;
    }


}
