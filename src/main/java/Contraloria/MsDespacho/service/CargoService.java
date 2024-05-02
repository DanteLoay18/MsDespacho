package Contraloria.MsDespacho.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.Cargo;

public interface CargoService {
    public Cargo add (Cargo cargo);
    public Cargo update (Cargo cargo);
    public boolean delete (Cargo cargo);
    public List<Cargo> findAll();
    public List<Cargo> findAllConParametros(Optional<Integer> idSedeDestino, Optional<String> numeroDocumento,Optional<Integer> tipoDocumento,Optional<Integer> anyo,Optional<Date> fechaInicio,Optional<Date> fechaFin,Optional<String> fieldName,Optional<Boolean> ascending);
    public Page<Cargo> findAll(PageRequest pageRequest);
    public Cargo findById(int id) throws NotFoundException;
    public Cargo findByCodigoBarra(String codigoBarra) throws NotFoundException;
    public List<Object> obtenerCantidadPorSedeDestino();
    public List<Cargo> listarCargosPorUO(int idSedeDestino);
    public Page<Cargo> findAllConParametrosPaginated(Optional<Integer> idSedeDestino, Optional<String> numeroDocumento,Optional<Integer> tipoDocumento,Optional<Integer> anyo,Optional<Date> fechaInicio,Optional<Date> fechaFin,PageRequest pageRequest, Optional<String> fieldName,Optional<Boolean> ascending);
}
