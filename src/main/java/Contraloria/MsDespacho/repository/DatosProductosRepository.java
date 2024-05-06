package Contraloria.MsDespacho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.DatosProductos;

@Repository
public interface DatosProductosRepository extends JpaRepository<DatosProductos, Integer>{
    
}
