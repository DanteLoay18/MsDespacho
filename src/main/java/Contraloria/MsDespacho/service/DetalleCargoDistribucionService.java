package Contraloria.MsDespacho.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.DetalleCargoDistribucion;

public interface DetalleCargoDistribucionService {
    public DetalleCargoDistribucion add (DetalleCargoDistribucion cargo);
    public DetalleCargoDistribucion update (DetalleCargoDistribucion cargo);
    public boolean delete (DetalleCargoDistribucion cargo);
    public List<DetalleCargoDistribucion> findAll();
    public Page<DetalleCargoDistribucion> findAll(PageRequest pageRequest);
    public DetalleCargoDistribucion findById(int id) throws NotFoundException;
}
