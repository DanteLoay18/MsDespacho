package Contraloria.MsDespacho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.CargoDistribucion;

@Repository
public interface CargoDistribucionRepository extends JpaRepository<CargoDistribucion, Integer>{
    
}
