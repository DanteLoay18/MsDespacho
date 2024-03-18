package Contraloria.MsDespacho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.Cargo;


@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer>{
    
}
