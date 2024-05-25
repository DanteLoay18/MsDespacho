package Contraloria.MsDespacho.service;

import java.util.List;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.DatosFinancieros;

public interface DatosFinancierosService {
    public DatosFinancieros add (DatosFinancieros datosFinancieros);
    public DatosFinancieros update (DatosFinancieros datosFinancieros);
    public boolean delete (DatosFinancieros datosFinancieros,Integer usuarioEliminacion);
    public List<DatosFinancieros> findAll();
    public DatosFinancieros findById(int id) throws NotFoundException;
}

