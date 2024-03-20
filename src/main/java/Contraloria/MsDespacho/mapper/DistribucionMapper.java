package Contraloria.MsDespacho.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import Contraloria.MsDespacho.dto.Distribucion.CargoAdicionalDto;
import Contraloria.MsDespacho.dto.Distribucion.CargoDistribucionDto;
import Contraloria.MsDespacho.dto.Distribucion.CreateDistribucionRequest;
import Contraloria.MsDespacho.dto.Paginator.PaginatorResponse;
import Contraloria.MsDespacho.model.Cargo;
import Contraloria.MsDespacho.model.CargoAdicional;
import Contraloria.MsDespacho.model.CargoDistribucion;
import Contraloria.MsDespacho.model.DetalleCargoDistribucion;

@Mapper(componentModel = "spring",uses = CargoMapper.class)
public interface DistribucionMapper {
    
    @Mapping(source = "content", target = "items")
    @Mapping(source = "number", target = "page")
    @Mapping(source = "size", target = "rows")
    @Mapping(source = "totalElements", target = "total")
    PaginatorResponse<CargoDistribucionDto> toPaginationDto(Page<CargoDistribucion> docargocumento);

    CargoAdicionalDto toDto(CargoAdicional cargoAdicional);

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
        @Mapping(target = "cargos", ignore = true),
        @Mapping(target = "cargosAdicionales", ignore = true),
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
