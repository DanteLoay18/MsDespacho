package Contraloria.MsDespacho.service;

import java.util.List;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.Enumerado;

public interface EnumeradoService {
    public Enumerado add (Enumerado enumerado);
    public Enumerado update (Enumerado enumerado);
    public boolean delete (Enumerado enumerado);
    public List<Enumerado> findAll();
    public Enumerado findById(int id) throws NotFoundException;
    public List<Enumerado> findEnumeradosHijos(int idPadre) throws NotFoundException;
}
