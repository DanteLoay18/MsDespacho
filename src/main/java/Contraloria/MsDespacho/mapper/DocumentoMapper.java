package Contraloria.MsDespacho.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

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
}
