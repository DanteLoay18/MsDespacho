package Contraloria.MsDespacho.dto.Catalogo;

import lombok.Data;

@Data
public class CatalogoDto {

    private Integer id;

    private Integer codigo;

    private String descripcion;

    private String valor;
    
    private Integer orden;
}
