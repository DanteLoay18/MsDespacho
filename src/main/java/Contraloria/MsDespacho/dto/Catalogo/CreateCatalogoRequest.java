package Contraloria.MsDespacho.dto.Catalogo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Contraloria.MsDespacho.model.Catalogo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCatalogoRequest {

    private static final String REGEX_SOLO_LETRAS = "^[a-zA-Z]+$";

    private int idPadre;

    private int codigo;

    @Pattern(regexp = REGEX_SOLO_LETRAS, message = "El nombre debe contener solo letras")
    @NotBlank(message = "Por favor agregue el nombre")
    private String nombre;

    @Pattern(regexp = REGEX_SOLO_LETRAS, message = "La descripcion debe contener solo letras")
    private String descripcion;

    @Pattern(regexp = "\\d+", message = "El valor debe contener solo números")
    private String valor;

    private int orden;

    @JsonIgnore
    private Catalogo padre;
}
