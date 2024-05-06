package Contraloria.MsDespacho.dto.DatosProductos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Contraloria.MsDespacho.model.Proveedor;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class UpdateDatosProductosRequest {
    
    int id;

    @JsonIgnore
    private Proveedor proveedor;

    @Min(value = 1, message = "El tipo proveedor debe ser un entero positivo")
    int idProveedor;

    String codigo;

    int tipoServicio;

    int tipoAcceso;

    int tipoEntrega;

    int estadoEntrega;

    int plazoEntrega;

    int plazoRetorno;

    int pais;

    String ubigeo;
}
