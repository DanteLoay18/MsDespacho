package Contraloria.MsDespacho.dto.Proveedor;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateProveedorRequest {
    
    @Min(value = 1, message = "El tipo proveedor debe ser un entero positivo")
    private int tipoProveedor;
    @Min(value = 1, message = "El tipo documento debe ser un entero positivo")
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
}
