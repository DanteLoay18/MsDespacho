package Contraloria.MsDespacho.routes;

public class ApiRoutes {
    public static final String ENDPOINT_USUARIO = "/api/v1/usuario";
    public static final String CREAR_USUARIO = "/crear";
    public static final String ACTUALIZAR_USUARIO = "/actualizar";
    public static final String ELIMINAR_USUARIO = "/eliminar/{id}";
    public static final String BUSCAR_USUARIO_POR_ID = "/buscarPorId/{id}";
    public static final String LISTAR_USUARIOS = "/listar-usuarios";

    public static final String ENDPOINT_ENUMERADO = "/api/v1/catalogo";
    public static final String LISTAR_ENUMERADOS = "/listar-catalogos";
    public static final String CREAR_ENUMERADO = "/crear";
    public static final String BUSCAR_ENUMERADO_POR_ID = "/buscarPorId/{id}";
    public static final String LISTAR_ENUMERADOS_POR_PADRE = "/listar-catalogos-padre/{id}";
    public static final String ACTUALIZAR_ENUMERADO = "/actualizar";
    public static final String ELIMINAR_ENUMERADO = "/eliminar/{id}";
    
    public static final String ENDPOINT_DOCUMENTO = "/api/v1/documento";
    public static final String LISTAR_DOCUMENTOS = "/listar-documentos";
    public static final String BUSCAR_DOCUMENTO_POR_ID = "/buscarPorId/{id}";
    public static final String BUSCAR_DOCUMENTO_POR_CODIGOBARRA = "/buscarPorCodigoDeBarra";
    public static final String LISTAR_DOCUMENTOS_PAGINADO = "/listar-documentos-paginado";

    public static final String ENDPOINT_CARGO = "/api/v1/cargo";
    public static final String LISTAR_CARGOS = "/listar-cargos";
    public static final String BUSCAR_CARGO_POR_ID = "/buscarPorId/{id}";
    public static final String LISTAR_CARGOS_PAGINADO = "/listar-cargos-paginado";
    public static final String LISTAR_RESUMEN_CARGOS_POR_UO = "/listar-resumen-cargos-por-uo";
    public static final String LISTAR_CARGOS_POR_UO = "/listar-cargos-por-uo/{idSedeDestino}";
    public static final String CREAR_CARGO = "/crear";
    public static final String ACTUALIZAR_CARGO = "/actualizar";
    public static final String ELIMINAR_CARGO = "/eliminar/{id}";

    public static final String ENDPOINT_DISTRIBUCION= "/api/v1/distribucion";
    public static final String LISTAR_DISTRIBUCION = "/listar-distribucion";
    public static final String LISTAR_DISTRIBUCION_PAGINADO = "/listar-distribucion-paginado";
    public static final String CREAR_DISTRIBUCION = "/crear-distribucion";

    public static final String ENDPOINT_CARGODEVOLUCION= "/api/v1/cargo-devolucion";
    public static final String LISTAR_CARGOSDEVOLUCION = "/listar-cargos-devolucion";
    public static final String BUSCAR_CARGOSDEVOLUCION_POR_ID = "/buscarPorId/{id}";
    public static final String LISTAR_CARGOSDEVOLUCION_PAGINADO = "/listar-cargos-devolucion-paginado";
    public static final String CREAR_CARGODISTRIBUCION = "/crear";
    public static final String ACTUALIZAR_CARGODISTRIBUCION = "/actualizar";
    public static final String ELIMINAR_CARGODISTRIBUCION = "/eliminar/{id}";


    public static final String ENDPOINT_PROVEEDOR = "/api/v1/proveedor";
    public static final String LISTAR_PROVEEDORS = "/listar-proveedores";
    public static final String CREAR_PROVEEDOR = "/crear";
    public static final String BUSCAR_PROVEEDOR_POR_ID = "/buscarPorId/{id}";
    public static final String ACTUALIZAR_PROVEEDOR = "/actualizar";
    public static final String ELIMINAR_PROVEEDOR = "/eliminar/{id}";
    public static final String LISTAR_PROVEEDOR_PAGINADO = "/listar-proveedor-paginado";


    public static final String ENDPOINT_DATOSFINANCIEROS = "/api/v1/datosFinancieros";
    public static final String LISTAR_DATOSFINANCIEROS = "/listar-datosFinancieros";
    public static final String CREAR_DATOSFINANCIEROS = "/crear";
    public static final String BUSCAR_DATOSFINANCIEROS_POR_ID = "/buscarPorId/{id}";
    public static final String ACTUALIZAR_DATOSFINANCIEROS = "/actualizar";
    public static final String ELIMINAR_DATOSFINANCIEROS = "/eliminar/{id}";

    public static final String ENDPOINT_DATOSPRODUCTOS = "/api/v1/datosProductos";
    public static final String LISTAR_DATOSPRODUCTOS = "/listar-datosProductos";
    public static final String CREAR_DATOSPRODUCTOS = "/crear";
    public static final String BUSCAR_DATOSPRODUCTOS_POR_ID = "/buscarPorId/{id}";
    public static final String ACTUALIZAR_DATOSPRODUCTOS = "/actualizar";
    public static final String ELIMINAR_DATOSPRODUCTOS = "/eliminar/{id}";
}
