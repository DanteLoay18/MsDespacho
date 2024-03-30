package Contraloria.MsDespacho.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import Contraloria.MsDespacho.dto.Cargo.CargoDto;
import Contraloria.MsDespacho.dto.Cargo.CreateCargoRequest;
import Contraloria.MsDespacho.dto.Cargo.UpdateCargoRequest;
import Contraloria.MsDespacho.dto.Paginator.PaginatorResponse;
import Contraloria.MsDespacho.model.Cargo;

@Mapper(componentModel = "spring")
public interface CargoMapper {

    
    CargoMapper INSTANCE = Mappers.getMapper(CargoMapper.class);

    CargoDto toDto(Cargo cargo);

    @Mapping(source = "content", target = "items")
    @Mapping(source = "number", target = "page")
    @Mapping(source = "size", target = "rows")
    @Mapping(source = "totalElements", target = "total")
    PaginatorResponse<CargoDto> toPaginationDto(Page<Cargo> docargocumento);

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
    Cargo createRequestToEntity(CreateCargoRequest createCargoRequest);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "esEliminado", ignore = true),
        @Mapping(target = "usuarioCreacion", ignore = true),
        @Mapping(target = "fechaCreacion", ignore = true),
        @Mapping(target = "fechaModificacion", expression = "java(new java.util.Date())"),
        @Mapping(target = "usuarioModificacion", expression = "java(obtenerUsuarioActual())"),
        @Mapping(target = "usuarioEliminacion", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true),
    })
    void updateRequestToEntity(@MappingTarget Cargo entity,UpdateCargoRequest updateCargoRequest);


    default String obtenerUsuarioActual() {
        return "UsuarioActual";
    }
}
