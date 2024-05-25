package Contraloria.MsDespacho.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.CargoAdicional;

public interface CargoAdicionalService {
    public CargoAdicional add (CargoAdicional cargo);
    public CargoAdicional update (CargoAdicional cargo);
    public boolean delete (CargoAdicional cargo,Integer usuarioEliminacion);
    public List<CargoAdicional> findAll();
    public Page<CargoAdicional> findAll(PageRequest pageRequest);
    public CargoAdicional findById(int id) throws NotFoundException;
}
