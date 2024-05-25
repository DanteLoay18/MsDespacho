package Contraloria.MsDespacho.dto.Proveedor;

import lombok.Data;

@Data
public class UpdateProveedorRequest {

    int id;

    int tipoProveedor;
    
    int tipoDocumento;

    String numeroDocumento;
    
    
    String apellidoPaterno;
    
    String apellidoMaterno;

    String nombres;

    
    String telefono;
    
    String celular;

    String correo;

    int estado;

    int pais;
    
    String ubigeo;

    String direccionRENIEC;

    String direccion;
    
    String representanteLegal;

    String paginaWeb;

    int tipoDeServicio;

    Integer usuarioModificacion;
}
