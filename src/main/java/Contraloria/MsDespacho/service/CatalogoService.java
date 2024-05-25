package Contraloria.MsDespacho.service;

import java.util.List;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.Catalogo;

public interface CatalogoService {
    public Catalogo add (Catalogo enumerado);
    public Catalogo update (Catalogo enumerado);
    public boolean delete (Catalogo enumerado,Integer usuarioEliminacion);
    public List<Catalogo> findAll();
    public Catalogo findById(int id) throws NotFoundException;
    public List<Catalogo> findCatalogosHijos(int idPadre) throws NotFoundException;
}
