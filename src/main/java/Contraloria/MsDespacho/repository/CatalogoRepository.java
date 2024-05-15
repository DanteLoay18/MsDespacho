package Contraloria.MsDespacho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Contraloria.MsDespacho.model.Catalogo;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Integer>{
    @Query("SELECT u FROM Catalogo u WHERE u.padre.id = :id")
    List<Catalogo> findAllHijos(@Param("id") int id);
}
