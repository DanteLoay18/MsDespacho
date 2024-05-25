package Contraloria.MsDespacho.dto.Catalogo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Contraloria.MsDespacho.model.Catalogo;
import lombok.Data;

@Data
public class UpdateCatalogoRequest {
    private int id;

    private int idPadre;

    private int codigo;

    private String descripcion;

    private String valor;

    private int orden;

    @JsonIgnore
    private Catalogo padre;

    Integer usuarioModificacion;

}
