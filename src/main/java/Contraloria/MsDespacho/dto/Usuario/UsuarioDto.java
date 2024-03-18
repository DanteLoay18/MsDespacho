package Contraloria.MsDespacho.dto.Usuario;

import lombok.Data;

@Data
public class UsuarioDto {

    private Integer id;

    private String username;

    private String password;

    private String apellidoPaterno;

    private String apellidoMaterno;
    
    private String nombres;
    
    private String pais;
    
    private String departamento;
    
    private String provincia;
    
    private String distrito;
    
    private String tipoDocumento;
    
    private String numeroDocumento;
    
    private String razonSocial;
    
    private String telefono;
    
    private String celular;
    
    private String correo;
    
    private String fechaInicio;
    
    private String rol;

    private boolean esActivo;
}
