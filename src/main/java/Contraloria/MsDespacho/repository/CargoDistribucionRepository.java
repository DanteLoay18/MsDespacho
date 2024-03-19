package Contraloria.MsDespacho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.CargoDistribucion;

@Repository
public interface CargoDistribucionRepository extends JpaRepository<CargoDistribucion, Integer>{
    @Query("SELECT COALESCE(MAX(c.numeroCargo), 0) FROM CargoDistribucion c")
    int findMaxNumeroCargo();
}
