package Contraloria.MsDespacho.dto.Enumerado;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Contraloria.MsDespacho.model.Enumerado;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateEnumeradoRequest {

    private int idPadre;

    private int codigo;

    @NotBlank(message = "Por favor agregue el nombre")
    private String nombre;

    private String abreviatura;

    private String valor;

    private int orden;

    @JsonIgnore
    private Enumerado padre;
}
