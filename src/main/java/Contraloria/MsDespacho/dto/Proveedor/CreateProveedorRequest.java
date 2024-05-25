package Contraloria.MsDespacho.dto.Proveedor;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateProveedorRequest {
    
    @NotBlank(message = "Por favor agregue el numero de documento")
    private int tipoProveedor;
    
    @NotBlank(message = "Por favor agregue el numero de documento")
    private int tipoDocumento;

    @NotBlank(message = "Por favor agregue el numero de documento")
    @Length(min=1 ,max = 15, message = "El numero de documento debe tener maximo 15 caracteres")
    String numeroDocumento;
    
    @NotBlank(message = "Por favor agregue el apellido paterno")
    @Length(min=1 ,max = 50, message = "El apellido paterno debe tener maximo 50 caracteres")
    String apellidoPaterno;
    
    @NotBlank(message = "Por favor agregue el apellido materno")
    @Length(min=1 ,max = 50, message = "El apellido materno debe tener maximo 50 caracteres")
    String apellidoMaterno;
    
    @NotBlank(message = "Por favor agregue el nombre")
    @Length(min=1 ,max = 100, message = "El nombre debe tener maximo 100 caracteres")
    String nombres;

    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{7,15}$", message = "El teléfono debe ser válido y contener entre 7 y 15 dígitos")
    String telefono;
    
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{7,15}$", message = "El celular debe ser válido y contener entre 7 y 15 dígitos")
    String celular;

    @Email(message = "El correo debe ser un email válido")
    String correo;

    int estado;

    int pais;
    
    @Pattern(regexp = "^\\d{6}$", message = "El ubigeo debe contener exactamente 6 dígitos")
    String ubigeo;

    String direccionRENIEC;

    String direccion;
    
    String representanteLegal;

    @URL(message = "La página web debe ser una URL válida")
    String paginaWeb;

    int tipoDeServicio;
}
