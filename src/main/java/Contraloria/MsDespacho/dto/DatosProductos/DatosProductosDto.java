package Contraloria.MsDespacho.dto.DatosProductos;

import Contraloria.MsDespacho.model.Proveedor;

import lombok.Data;

@Data
public class DatosProductosDto {
   
    int id;

    Proveedor proveedor;

    String codigo;

    int tipoServicio;

    String tipoServicioDescripcion;

    int tipoAcceso;

    String tipoAccesoDescripcion;

    int tipoEntrega;

    String tipoEntregaDescripcion;
    
    int estadoEntrega;

    int plazoEntrega;

    int plazoRetorno;

    int pais;

    String ubigeo;
}
