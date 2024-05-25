package Contraloria.MsDespacho.dto.Catalogo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Contraloria.MsDespacho.model.Catalogo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCatalogoRequest {

    private static final String REGEX_SOLO_LETRAS = "^[a-zA-Z ]+$";

    private Integer idPadre;

    private Integer codigo;

    @Schema(description = "Nombre catalogo", example = "Tipo Documento")
    @NotBlank(message = "Por favor agregue la descripcion")
    @Pattern(regexp = REGEX_SOLO_LETRAS, message = "La descripcion debe contener solo letras")
    private String descripcion;
    
    @Schema(description = "Valor", example = "0")
    @Pattern(regexp = "\\d+", message = "El valor debe contener solo números")
    private String valor;

    private Integer orden;

    @JsonIgnore
    private Catalogo padre;

    Integer usuarioCreacion;


}
