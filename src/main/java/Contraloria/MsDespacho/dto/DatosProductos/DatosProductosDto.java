package Contraloria.MsDespacho.dto.DatosProductos;

import Contraloria.MsDespacho.model.Proveedor;

import lombok.Data;

@Data
public class DatosProductosDto {
   
    int id;

    Proveedor proveedor;

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
