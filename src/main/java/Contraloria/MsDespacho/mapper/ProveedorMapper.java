package Contraloria.MsDespacho.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import Contraloria.MsDespacho.dto.Paginator.PaginatorResponse;
import Contraloria.MsDespacho.dto.Proveedor.CreateProveedorRequest;
import Contraloria.MsDespacho.dto.Proveedor.ProveedorDto;
import Contraloria.MsDespacho.dto.Proveedor.UpdateProveedorRequest;
import Contraloria.MsDespacho.model.Proveedor;

@Mapper(componentModel = "spring")
public interface ProveedorMapper {

    @Mappings({
        @Mapping(target = "tipoDeServicioDescripcion", ignore = true),
        @Mapping(target = "tipoDocumentoDescripcion", ignore = true),
        @Mapping(target = "tipoProveedorDescripcion", ignore = true),
    })
    ProveedorDto toDto(Proveedor proveedor);

    @Mappings({
        @Mapping(source = "content", target = "items"),
        @Mapping(source = "number", target = "page"),
        @Mapping(source = "size", target = "rows"),
        @Mapping(source = "totalElements", target = "total")
    })
    PaginatorResponse<ProveedorDto> toPaginationDto(Page<Proveedor> pageProveedor);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "esEliminado", constant = "false"),
        @Mapping(target = "fechaCreacion", expression = "java(new java.util.Date())"),
        @Mapping(target = "fechaModificacion", ignore = true),
        @Mapping(target = "usuarioModificacion", ignore = true),
        @Mapping(target = "usuarioEliminacion", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true),
    })
    Proveedor createRequestToEntity(CreateProveedorRequest createProveedorRequest);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "esEliminado", ignore = true),
        @Mapping(target = "fechaCreacion", ignore = true),
        @Mapping(target = "usuarioCreacion", ignore = true),
        @Mapping(target = "fechaModificacion", expression = "java(new java.util.Date())"),
        @Mapping(target = "usuarioEliminacion", ignore = true),
        @Mapping(target = "fechaEliminacion", ignore = true),
        @Mapping(target = "tipoProveedor", expression = "java(unwrap(UpdateProveedorRequest.getTipoProveedor(), entity.getTipoProveedor()))"),
        @Mapping(target = "tipoDocumento", expression = "java(unwrap(UpdateProveedorRequest.getTipoDocumento(), entity.getTipoDocumento()))"),
        @Mapping(target = "numeroDocumento", expression = "java(unwrap(UpdateProveedorRequest.getNumeroDocumento(), entity.getNumeroDocumento()))"),
        @Mapping(target = "apellidoPaterno", expression = "java(unwrap(UpdateProveedorRequest.getApellidoPaterno(), entity.getApellidoPaterno()))"),
        @Mapping(target = "apellidoMaterno", expression = "java(unwrap(UpdateProveedorRequest.getApellidoMaterno(), entity.getApellidoMaterno()))"),
        @Mapping(target = "nombres", expression = "java(unwrap(UpdateProveedorRequest.getNombres(), entity.getNombres()))"),
        @Mapping(target = "telefono", expression = "java(unwrap(UpdateProveedorRequest.getTelefono(), entity.getTelefono()))"),
        @Mapping(target = "celular", expression = "java(unwrap(UpdateProveedorRequest.getCelular(), entity.getCelular()))"),
        @Mapping(target = "correo", expression = "java(unwrap(UpdateProveedorRequest.getCorreo(), entity.getCorreo()))"),
        @Mapping(target = "estado", expression = "java(unwrap(UpdateProveedorRequest.getEstado(), entity.getEstado()))"),
        @Mapping(target = "pais", expression = "java(unwrap(UpdateProveedorRequest.getPais(), entity.getPais()))"),
        @Mapping(target = "ubigeo", expression = "java(unwrap(UpdateProveedorRequest.getUbigeo(), entity.getUbigeo()))"),
        @Mapping(target = "direccionRENIEC", expression = "java(unwrap(UpdateProveedorRequest.getDireccionRENIEC(), entity.getDireccionRENIEC()))"),
        @Mapping(target = "direccion", expression = "java(unwrap(UpdateProveedorRequest.getDireccion(), entity.getDireccion()))"),
        @Mapping(target = "representanteLegal", expression = "java(unwrap(UpdateProveedorRequest.getRepresentanteLegal(), entity.getRepresentanteLegal()))"),
        @Mapping(target = "paginaWeb", expression = "java(unwrap(UpdateProveedorRequest.getPaginaWeb(), entity.getPaginaWeb()))"),
        @Mapping(target = "tipoDeServicio", expression = "java(unwrap(UpdateProveedorRequest.getTipoDeServicio(), entity.getTipoDeServicio()))")
    })
    void updateRequestToEntity(@MappingTarget Proveedor entity,UpdateProveedorRequest UpdateProveedorRequest);


    default <T> T unwrap(Optional<T> optional, T currentValue) {
        return (optional != null && optional.isPresent()) ? optional.get() : currentValue;
    }
}
