package Contraloria.MsDespacho.dto.DatosProductos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Contraloria.MsDespacho.model.Proveedor;
import jakarta.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateDatosProductosRequest {
   
    @JsonIgnore
    private Proveedor proveedor;

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
