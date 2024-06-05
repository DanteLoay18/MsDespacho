package Contraloria.MsDespacho.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import Contraloria.MsDespacho.dto.CargoDevolucion.CargoDevolucionDto;
import Contraloria.MsDespacho.dto.CargoDevolucion.CreateCargoDevolucion;
import Contraloria.MsDespacho.dto.CargoDevolucion.UpdateCargoDevolucion;
import Contraloria.MsDespacho.dto.Paginator.PaginatorResponse;
import Contraloria.MsDespacho.model.CargoDevolucion;

@Mapper(componentModel = "spring")
public interface CargoDevolucionMapper {

    CargoDevolucionMapper INSTANCE = Mappers.getMapper(CargoDevolucionMapper.class);

    CargoDevolucionDto toDto(CargoDevolucion cargoDevolucion);

    @Mapping(source = "content", target = "items")
    @Mapping(source = "number", target = "page")
    @Mapping(source = "size", target = "rows")
    @Mapping(source = "totalElements", target = "total")
    PaginatorResponse<CargoDevolucionDto> toPaginationDto(Page<CargoDevolucion> cargoDevolucion);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "esEliminado", constant = "false"),
        @Mapping(target = "fechaCreacion", expression = "java(new java.util.Date())"),
        @Mapping(target = "fechaModificacion", ignore = true),
        @Mapping(target = "usuarioModificacion", ignore = true),
        @Mapping(target = "usuarioEliminacion", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true),
    })
    CargoDevolucion createRequestToEntity(CreateCargoDevolucion createCargoRequest);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "esEliminado", ignore = true),
        @Mapping(target = "usuarioCreacion", ignore = true),
        @Mapping(target = "fechaCreacion", ignore = true),
        @Mapping(target = "fechaModificacion", expression = "java(new java.util.Date())"),
        @Mapping(target = "usuarioEliminacion", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true),
        @Mapping(target = "cargoDistribucion", ignore = true),
        @Mapping(target = "idSedeDestino", expression = "java(unwrap(updateCargoDevolucion.getIdSedeDestino(), entity.getIdSedeDestino()))"),
        @Mapping(target = "idUsuarioRecibe", expression = "java(unwrap(updateCargoDevolucion.getIdUsuarioRecibe(), entity.getIdUsuarioRecibe()))")
    })
    void updateRequestToEntity(@MappingTarget CargoDevolucion entity,UpdateCargoDevolucion updateCargoDevolucion);

    default <T> T unwrap(Optional<T> optional, T currentValue) {
        return (optional != null && optional.isPresent()) ? optional.get() : currentValue;
    }
    
}
