package Contraloria.MsDespacho.model.Sunat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@AllArgsConstructor
public class SunatResponse<T> {
    @Getter
    private final boolean respuesta;
    
    @Getter
    private final List<T> listaRetorno;
    
    @Getter
    private final String valorRetorno;

    @Getter
    private final String mensaje;
}
