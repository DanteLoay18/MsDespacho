package Contraloria.MsDespacho.dto.Catalogo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Contraloria.MsDespacho.model.Catalogo;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCatalogoRequest {

    private int idPadre;

    private int codigo;

    @NotBlank(message = "Por favor agregue el nombre")
    private String nombre;

    private String descripcion;

    private String valor;

    private int orden;

    @JsonIgnore
    private Catalogo padre;
}
