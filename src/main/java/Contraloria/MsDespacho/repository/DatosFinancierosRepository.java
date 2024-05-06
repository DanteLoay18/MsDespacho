package Contraloria.MsDespacho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.DatosFinancieros;

@Repository
public interface DatosFinancierosRepository extends JpaRepository<DatosFinancieros, Integer>{
    
}
