package Contraloria.MsDespacho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.Proveedor;

public interface ProveedorService {
    public Proveedor add (Proveedor proveedor);
    public Proveedor update (Proveedor proveedor);
    public boolean delete (Proveedor proveedor);
    public List<Proveedor> findAll(Optional<Integer> tipoDocumento, Optional<String> numeroDocumento,Optional<String> nombres,Optional<Integer> estado,Optional<Integer> anyo,Optional<String> fieldName,Optional<Boolean> ascending);
    public Proveedor findById(int id) throws NotFoundException;
    public Page<Proveedor> findAllConParametrosPaginated(Optional<Integer> tipoDocumento, Optional<String> numeroDocumento,Optional<String> nombres,Optional<Integer> estado,Optional<Integer> anyo, Optional<String> fieldName,Optional<Boolean> ascending, PageRequest pageRequest);

}
