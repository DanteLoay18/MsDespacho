package Contraloria.MsDespacho.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.Proveedor;

@Repository
public interface ProveedorRepository  extends JpaRepository<Proveedor, Integer>{
    
    @Query("SELECT p FROM Proveedor p WHERE " +
            "(:tipoDocumento IS NULL OR p.tipoDocumento = :tipoDocumento) AND "+
            "(:numeroDocumento IS NULL OR p.numeroDocumento = :numeroDocumento) AND "+
            "(:nombres IS NULL OR p.nombres LIKE %:nombres%) AND "+
            "(:estado IS NULL OR p.estado = :estado) AND"+
            "(:anyo IS NULL OR YEAR(p.fechaCreacion) = :anyo)")
    List<Proveedor> findAllByParameters(Optional<Integer> tipoDocumento, Optional<String> numeroDocumento,Optional<String> nombres,Optional<Integer> estado,Optional<Integer> anyo, Sort sort);

 
    @Query("SELECT p FROM Proveedor p WHERE " +
            "(:tipoDocumento IS NULL OR p.tipoDocumento = :tipoDocumento) AND "+
            "(:numeroDocumento IS NULL OR p.numeroDocumento = :numeroDocumento) AND "+
            "(:nombres IS NULL OR p.nombres LIKE %:nombres%) AND "+
            "(:estado IS NULL OR p.estado = :estado) AND "+
            "(:anyo IS NULL OR YEAR(p.fechaCreacion) = :anyo)")
    Page<Proveedor> findAllByParametersPaginated(Optional<Integer> tipoDocumento, Optional<String> numeroDocumento, Optional<String> nombres, Optional<Integer> estado, Optional<Integer> anyo, Pageable pageable);

}
