package Contraloria.MsDespacho.repository;

import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.Cargo;


@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer>{
    @Query("SELECT u FROM Cargo u WHERE u.codigoBarra = :codigoBarra")
    Optional<Cargo> findByCodigoDeBarra(@Param("codigoBarra") String codigoBarra);

    @Query("SELECT c.idSedeDestino as idSedeDestino, COUNT(c) as cantidad FROM Cargo c GROUP BY c.idSedeDestino")
    List<Object[]> obtenerCantidadPorSedeDestino();

    @Query("SELECT u FROM Cargo u WHERE u.idSedeDestino = :idSedeDestino")
    List<Cargo> listarCargosPorUO(@Param("idSedeDestino") int idSedeDestino);

    @Query("SELECT c FROM Cargo c WHERE " +
            "(:idSedeDestino IS NULL OR c.idSedeDestino = :idSedeDestino) AND " +
            "(:numeroDocumento IS NULL OR c.documento.numeroDocumento = :numeroDocumento)")
    List<Cargo> findAllByParameters(Optional<Integer> idSedeDestino, Optional<String> numeroDocumento);

    
}
