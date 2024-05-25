package Contraloria.MsDespacho.dto.DatosProductos;
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
