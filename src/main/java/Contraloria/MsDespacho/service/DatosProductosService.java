package Contraloria.MsDespacho.service;

import java.util.List;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.DatosProductos;

public interface DatosProductosService {
    public DatosProductos add (DatosProductos datosProductos);
    public DatosProductos update (DatosProductos datosProductos);
    public boolean delete (DatosProductos datosProductos,Integer usuarioEliminacion);
    public List<DatosProductos> findAll();
    public DatosProductos findById(int id) throws NotFoundException;
}
