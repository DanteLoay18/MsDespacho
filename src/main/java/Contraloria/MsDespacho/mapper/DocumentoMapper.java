package Contraloria.MsDespacho.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import Contraloria.MsDespacho.dto.Documento.CreateDocumentoRequest;
import Contraloria.MsDespacho.dto.Documento.DocumentoDto;
import Contraloria.MsDespacho.dto.Paginator.PaginatorResponse;
import Contraloria.MsDespacho.model.Documento;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {
    DocumentoDto toDto(Documento usuario);

    @Mapping(source = "content", target = "items")
    @Mapping(source = "number", target = "page")
    @Mapping(source = "size", target = "rows")
    @Mapping(source = "totalElements", target = "total")
    PaginatorResponse<DocumentoDto> toPaginationDto(Page<Documento> documento);

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
    Documento createRequestToEntity(CreateDocumentoRequest createDocumentoRequest);

    default String obtenerUsuarioActual() {
        return "UsuarioActual";
    }
}
