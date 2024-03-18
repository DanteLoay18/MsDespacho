package Contraloria.MsDespacho.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.CargoDistribucion;

public interface CargoDistribucionService {
    public CargoDistribucion add (CargoDistribucion cargo);
    public CargoDistribucion update (CargoDistribucion cargo);
    public boolean delete (CargoDistribucion cargo);
    public List<CargoDistribucion> findAll();
    public Page<CargoDistribucion> findAll(PageRequest pageRequest);
    public CargoDistribucion findById(int id) throws NotFoundException;
}
