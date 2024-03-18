package Contraloria.MsDespacho.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.Cargo;


@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer>{
    @Query("SELECT u FROM Cargo u WHERE u.codigoBarra = :codigoBarra")
    Optional<Cargo> findByCodigoDeBarra(@Param("codigoBarra") String codigoBarra);
}
