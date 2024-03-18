package Contraloria.MsDespacho.dto.Usuario;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateUsuarioRequest {

    @Min(value = 1, message = "El id debe ser un entero positivo")
    private int id;
    
    @NotBlank(message = "Por favor agregue el username")
    @Length(min = 4, max = 10, message = "El username debe tener entre 4 y 10")
    private String username;

    @NotBlank(message = "Por favor agregue el password")
    private String password;

    @NotBlank(message = "Por favor agregue el apellido Paterno")
    private String apellidoPaterno;

    @NotBlank(message = "Por favor agregue el apellido Materno")
    private String apellidoMaterno;
    
    @NotBlank(message = "Por favor agregue el nombre")
    private String nombres;
    
    
    private String pais;
    
    
    private String departamento;
    
    
    private String provincia;
    
    
    private String distrito;
    
    @NotBlank(message = "Por favor agregue el tipo documento")
    private String tipoDocumento;
    
    @NotBlank(message = "Por favor agregue el numero documento")
    private String numeroDocumento;
    
    
    private String razonSocial;
    
    @NotBlank(message = "Por favor agregue el telefono")
    private String telefono;
    
    @NotBlank(message = "Por favor agregue el celular")
    private String celular;
    
    @NotBlank(message = "Por favor agregue el correo")
    private String correo;
    
    @NotBlank(message = "Por favor agregue la fechaInicio")
    private String fechaInicio;

    @NotBlank(message = "Por favor agregue el rol")
    private String rol;

    private boolean esActivo;
}
