package Contraloria.MsDespacho.dto.Proveedor;

import java.util.Optional;

import lombok.Data;

@Data
public class UpdateProveedorRequest {

    Integer id;

    Optional<Integer> tipoProveedor;
    
    Optional<Integer> tipoDocumento;

    Optional<String> numeroDocumento;
    
    Optional<String> apellidoPaterno;
    
    Optional<String> apellidoMaterno;

    Optional<String> nombres;
 
    Optional<String> telefono;
    
    Optional<String> celular;

    Optional<String> correo;

    Optional<Integer> estado;

    Optional<Integer> pais;
    
    Optional<String> ubigeo;

    Optional<String> direccionRENIEC;

    Optional<String> direccion;
    
    Optional<String> representanteLegal;

    Optional<String> paginaWeb;

    Optional<Integer> tipoDeServicio;

    Integer usuarioModificacion;
}
