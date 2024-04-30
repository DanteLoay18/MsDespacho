package Contraloria.MsDespacho.repository;

import java.util.Optional;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

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
            "(:numeroDocumento IS NULL OR c.documento.numeroDocumento LIKE %:numeroDocumento%) AND "+
            "(:tipoDocumento IS NULL OR c.documento.tipoDocumento = :tipoDocumento) AND "+
            "(:anyo IS NULL OR YEAR(c.documento.fechaDocumento) = :anyo) AND "+
            "(:fechaInicio IS NULL OR c.fechaRetorno >= :fechaInicio) AND " +
            "(:fechaFin IS NULL OR c.fechaRetorno <= :fechaFin)")
    List<Cargo> findAllByParameters(Optional<Integer> idSedeDestino, Optional<String> numeroDocumento,Optional<Integer> tipoDocumento,Optional<Integer> anyo,Optional<Date> fechaInicio,Optional<Date> fechaFin, Sort sort);

    @Query("SELECT c FROM Cargo c WHERE " +
            "(:idSedeDestino IS NULL OR c.idSedeDestino = :idSedeDestino) AND " +
            "(:numeroDocumento IS NULL OR c.documento.numeroDocumento LIKE %:numeroDocumento%) AND "+
            "(:tipoDocumento IS NULL OR c.documento.tipoDocumento = :tipoDocumento) AND "+
            "(:anyo IS NULL OR YEAR(c.documento.fechaDocumento) = :anyo) AND "+
            "(:fechaInicio IS NULL OR c.fechaRetorno >= :fechaInicio) AND " +
            "(:fechaFin IS NULL OR c.fechaRetorno <= :fechaFin)")
    Page<Cargo> findAllByParametersPaginated(Optional<Integer> idSedeDestino, Optional<String> numeroDocumento,Optional<Integer> tipoDocumento,Optional<Integer> anyo,Optional<Date> fechaInicio,Optional<Date> fechaFin, Pageable pageable);

    
}                                                      
