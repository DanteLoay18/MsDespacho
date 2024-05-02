package Contraloria.MsDespacho.service;

import java.util.List;
import java.util.Optional;

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
    public List<CargoDistribucion> findAllConParametros(Optional<Integer> idSedeDestino, Optional<Integer> numeroCargo, Optional<String> fieldName,Optional<Boolean> ascending);
    public Page<CargoDistribucion> findAllConParametrosPaginado(Optional<Integer> idSedeDestino, Optional<Integer> numeroCargo,PageRequest pageRequest, Optional<String> fieldName,Optional<Boolean> ascending);
}
