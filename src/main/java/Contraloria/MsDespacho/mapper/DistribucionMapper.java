package Contraloria.MsDespacho.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import Contraloria.MsDespacho.dto.Distribucion.CreateDistribucionRequest;
import Contraloria.MsDespacho.model.Cargo;
import Contraloria.MsDespacho.model.CargoAdicional;
import Contraloria.MsDespacho.model.CargoDistribucion;
import Contraloria.MsDespacho.model.DetalleCargoDistribucion;

@Mapper(componentModel = "spring")
public interface DistribucionMapper {
    
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "esEliminado", constant = "false"),
        @Mapping(target = "fechaCreacion", expression = "java(new java.util.Date())"),
        @Mapping(target = "usuarioCreacion", expression = "java(obtenerUsuarioActual())"),
        @Mapping(target = "fechaModificacion", ignore = true),
        @Mapping(target = "usuarioModificacion", ignore = true),
        @Mapping(target = "usuarioEliminacion", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true),
        @Mapping(target = "fechaCargo", ignore = true),
        @Mapping(target = "numeroCargo", ignore = true),
    })
    CargoDistribucion createRequestToDistribucionEntity(CreateDistribucionRequest createDistribucionRequest);


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
    DetalleCargoDistribucion createRequestToDetalleCargoDistribucionEntity(Cargo cargo,  CargoDistribucion cargoDistribucion);

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
    CargoAdicional createRequestToCargoAdicionalEntity(String numeroDocumento,  CargoDistribucion cargoDistribucion);

    default String obtenerUsuarioActual() {
        return "UsuarioActual";
    }
}
