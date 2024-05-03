package Contraloria.MsDespacho.service;

import java.util.List;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.Proveedor;

public interface ProveedorService {
    public Proveedor add (Proveedor proveedor);
    public Proveedor update (Proveedor proveedor);
    public boolean delete (Proveedor proveedor);
    public List<Proveedor> findAll();
    public Proveedor findById(int id) throws NotFoundException;
}
