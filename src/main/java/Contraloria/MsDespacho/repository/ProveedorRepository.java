package Contraloria.MsDespacho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.Proveedor;

@Repository
public interface ProveedorRepository  extends JpaRepository<Proveedor, Integer>{
    
}
