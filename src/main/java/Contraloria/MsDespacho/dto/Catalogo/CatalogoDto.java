package Contraloria.MsDespacho.dto.Catalogo;

import lombok.Data;

@Data
public class CatalogoDto {

    private Integer id;

    private int codigo;

    private String nombre;

    private String descripcion;

    private String valor;
    
    private int orden;
}
