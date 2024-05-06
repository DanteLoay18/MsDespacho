package Contraloria.MsDespacho.mapper;

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
    
    DatosFinancierosDto toDto(DatosFinancieros datosFinancieros);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "esEliminado", constant = "false"),
        @Mapping(target = "fechaCreacion", expression = "java(new java.util.Date())"),
        @Mapping(target = "usuarioCreacion", expression = "java(obtenerUsuarioActual())"),
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
        @Mapping(target = "usuarioModificacion", expression = "java(obtenerUsuarioActual())"),
        @Mapping(target = "usuarioEliminacion", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true),
    })
    void updateRequestToEntity(@MappingTarget DatosFinancieros entity,UpdateDatosFinancierosRequest UpdateDatosFinancierosRequest);

    default String obtenerUsuarioActual() {
        return "UsuarioActual";
    }
}
