package Contraloria.MsDespacho.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import Contraloria.MsDespacho.dto.Catalogo.CreateCatalogoRequest;
import Contraloria.MsDespacho.dto.Catalogo.CatalogoDto;
import Contraloria.MsDespacho.dto.Catalogo.UpdateCatalogoRequest;
import Contraloria.MsDespacho.model.Catalogo;

@Mapper(componentModel = "spring")
public interface CatalogoMapper {
    
    CatalogoDto toDto(Catalogo enumerado);


    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "esEliminado", constant = "false"),
        @Mapping(target = "fechaCreacion", expression = "java(new java.util.Date())"),
        @Mapping(target = "fechaModificacion", ignore = true),
        @Mapping(target = "usuarioModificacion", ignore = true),
        @Mapping(target = "usuarioEliminacion", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true),
    })
    Catalogo createRequestToEntity(CreateCatalogoRequest createCatalogoRequest);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "esEliminado", ignore = true),
        @Mapping(target = "fechaCreacion", ignore = true),
        @Mapping(target = "usuarioCreacion", ignore = true),
        @Mapping(target = "fechaModificacion", expression = "java(new java.util.Date())"),
        @Mapping(target = "usuarioEliminacion", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true),
        @Mapping(target = "padre", ignore = true),
        @Mapping(target = "codigo", expression = "java(unwrap(updateCatalogoRequest.getCodigo(), entity.getCodigo()))"),
        @Mapping(target = "descripcion", expression = "java(unwrap(updateCatalogoRequest.getDescripcion(), entity.getDescripcion()))"),
        @Mapping(target = "valor", expression = "java(unwrap(updateCatalogoRequest.getValor(), entity.getValor()))"),
        @Mapping(target = "orden", expression = "java(unwrap(updateCatalogoRequest.getOrden(), entity.getOrden()))")
    })
    void updateRequestToEntity(@MappingTarget Catalogo entity,UpdateCatalogoRequest updateCatalogoRequest);

    default <T> T unwrap(Optional<T> optional, T currentValue) {
            return (optional != null && optional.isPresent()) ? optional.get() : currentValue;
    }
}
