package Contraloria.MsDespacho.dto.Proveedor;

import lombok.Data;

@Data
public class ProveedorDto {
    int id;
    
    int tipoProveedor;

    //TODO : POR CADA tipoProveedor que es considerado en catalogo se le agrega un descripcion

    String tipoProveedorDescripcion;
    
    int tipoDocumento;
    
    String tipoDocumentoDescripcion;
    
    String numeroDocumento;

    String apellidoPaterno;

    String apellidoMaterno;

    String nombres;

    String telefono;

    String celular;

    String correo;

    int estado;

    int pais;
    
    char ubigeo;

    String direccionRENIEC;

    String direccion;

    String representanteLegal;

    String paginaWeb;

    int tipoDeServicio;

    String tipoDeServicioDescripcion;
}
