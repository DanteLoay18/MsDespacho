package Contraloria.MsDespacho.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.CargoDistribucion;

@Repository
public interface CargoDistribucionRepository extends JpaRepository<CargoDistribucion, Integer>{
    @Query("SELECT COALESCE(MAX(c.numeroCargo), 0) FROM CargoDistribucion c")
    int findMaxNumeroCargo();

    @Query("SELECT c FROM CargoDistribucion c WHERE " +
            "(:idSedeDestino IS NULL OR c.idSedeDestino = :idSedeDestino) AND " +
            "(:numeroCargo IS NULL OR c.numeroCargo = :numeroCargo) " +
            "ORDER BY c.fechaCreacion DESC")
    List<CargoDistribucion> findAllByParameters(Optional<Integer> idSedeDestino, Optional<Integer> numeroCargo);

    @Query("SELECT c FROM CargoDistribucion c WHERE " +
            "(:idSedeDestino IS NULL OR c.idSedeDestino = :idSedeDestino) AND " +
            "(:numeroCargo IS NULL OR c.numeroCargo = :numeroCargo) " +
            "ORDER BY c.fechaCreacion DESC")
    Page<CargoDistribucion> findAllByParameters(Optional<Integer> idSedeDestino, Optional<Integer> numeroCargo, Pageable pageable );
}
