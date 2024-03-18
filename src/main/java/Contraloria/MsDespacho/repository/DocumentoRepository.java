package Contraloria.MsDespacho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer>{
    
}
