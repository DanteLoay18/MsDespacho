package Contraloria.MsDespacho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.DetalleCargoDistribucion;

@Repository
public interface DetalleCargoDistribucionRepository extends JpaRepository<DetalleCargoDistribucion, Integer>{
    
}
