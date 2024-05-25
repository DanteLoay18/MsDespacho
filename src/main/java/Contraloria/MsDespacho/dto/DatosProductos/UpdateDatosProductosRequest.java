package Contraloria.MsDespacho.dto.DatosProductos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Contraloria.MsDespacho.model.Proveedor;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class UpdateDatosProductosRequest {
    
    int id;

    String codigo;

    int tipoServicio;

    int tipoAcceso;

    int tipoEntrega;

    int estadoEntrega;

    int plazoEntrega;

    int plazoRetorno;

    int pais;

    String ubigeo;

    Integer usuarioModificacion;

}
