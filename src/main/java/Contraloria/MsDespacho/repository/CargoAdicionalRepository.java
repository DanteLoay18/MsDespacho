package Contraloria.MsDespacho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.CargoAdicional;

@Repository
public interface CargoAdicionalRepository extends JpaRepository<CargoAdicional, Integer>{
    
}
