package Contraloria.MsDespacho.routes;

public class ApiRoutes {
    public static final String ENDPOINT_USUARIO = "/api/v1/usuario";
    public static final String CREAR_USUARIO = "/crear";
    public static final String ACTUALIZAR_USUARIO = "/actualizar";
    public static final String ELIMINAR_USUARIO = "/eliminar/{id}";
    public static final String BUSCAR_USUARIO_POR_ID = "/buscarPorId/{id}";
    public static final String LISTAR_USUARIOS = "/listar-usuarios";

    public static final String ENDPOINT_ENUMERADO = "/api/v1/enumerado";
    public static final String LISTAR_ENUMERADOS = "/listar-enumerados";
    public static final String CREAR_ENUMERADO = "/crear";
    public static final String BUSCAR_ENUMERADO_POR_ID = "/buscarPorId/{id}";
    public static final String LISTAR_ENUMERADOS_POR_PADRE = "/listar-enumerados-padre/{id}";
    public static final String ACTUALIZAR_ENUMERADO = "/actualizar";
    public static final String ELIMINAR_ENUMERADO = "/eliminar/{id}";
    
    public static final String ENDPOINT_DOCUMENTO = "/api/v1/documento";
    public static final String LISTAR_DOCUMENTOS = "/listar-documentos";
    public static final String BUSCAR_DOCUMENTO_POR_ID = "/buscarPorId/{id}";
    public static final String LISTAR_DOCUMENTOS_PAGINADO = "/listar-documentos-paginado";

    public static final String ENDPOINT_CARGO = "/api/v1/cargo";
    public static final String LISTAR_CARGOS = "/listar-cargos";
    public static final String BUSCAR_CARGO_POR_ID = "/buscarPorId/{id}";
    public static final String LISTAR_CARGOS_PAGINADO = "/listar-cargos-paginado";
    public static final String CREAR_CARGO = "/crear";
    public static final String ACTUALIZAR_CARGO = "/actualizar";
    public static final String ELIMINAR_CARGO = "/eliminar/{id}";

    public static final String ENDPOINT_DISTRIBUCION= "/api/v1/distribucion";
    public static final String CREAR_DISTRIBUCION = "/crear-distribucion";
}
