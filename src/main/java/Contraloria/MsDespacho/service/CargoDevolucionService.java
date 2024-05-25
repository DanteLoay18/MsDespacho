package Contraloria.MsDespacho.service;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.CargoDevolucion;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface CargoDevolucionService {
    public CargoDevolucion add (CargoDevolucion cargo);
    public CargoDevolucion update (CargoDevolucion cargo);
    public boolean delete (CargoDevolucion cargo,Integer usuarioEliminacion);
    public List<CargoDevolucion> findAll();
    public Page<CargoDevolucion> findAll(PageRequest pageRequest);
    public CargoDevolucion findById(int id) throws NotFoundException;
}
