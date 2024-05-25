package Contraloria.MsDespacho.dto.DatosProductos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Contraloria.MsDespacho.model.Proveedor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateDatosProductosRequest {
   
    @JsonIgnore
    private Proveedor proveedor;

    @NotNull(message = "El idProveedor no puede ser nulo")
    int idProveedor;

    String codigo;

    int tipoServicio;

    int tipoAcceso;

    int tipoEntrega;

    int estadoEntrega;

    int plazoEntrega;

    int plazoRetorno;
    
    int pais;

    @Pattern(regexp = "^\\d{6}$", message = "El ubigeo debe contener exactamente 6 dígitos")
    String ubigeo;
}
