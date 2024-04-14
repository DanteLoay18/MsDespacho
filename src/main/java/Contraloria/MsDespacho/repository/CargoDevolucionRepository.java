package Contraloria.MsDespacho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.CargoDevolucion;

@Repository
public interface CargoDevolucionRepository extends JpaRepository<CargoDevolucion, Integer>{
    
}
