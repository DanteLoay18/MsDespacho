package Contraloria.MsDespacho.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.Proveedor;
import Contraloria.MsDespacho.repository.ProveedorRepository;
import Contraloria.MsDespacho.service.ProveedorService;

@Service
public class ProveedorServiceImp implements ProveedorService{

    @Autowired
    private ProveedorRepository proveedorRepository;
    
 @Override
    public Proveedor add(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor update(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    @Override
    public boolean delete(Proveedor proveedor,Integer usuarioEliminacion){

        proveedor.setFechaEliminacion(new Date());
        proveedor.setUsuarioEliminacion(usuarioEliminacion);
        
        proveedorRepository.save(proveedor);

        proveedorRepository.deleteById(proveedor.getId());
        return true;
    }

    @Override
    public List<Proveedor> findAll(Optional<Integer> tipoDocumento, Optional<String> numeroDocumento,Optional<String> nombres,Optional<Integer> estado,Optional<Integer> anyo,Optional<String> fieldName,Optional<Boolean> ascending){
       
        if(fieldName.isPresent()){
            Sort sort = ascending.get() ? Sort.by(fieldName.get()).ascending() : Sort.by(fieldName.get()).descending();

            return proveedorRepository.findAllByParameters(tipoDocumento, numeroDocumento, nombres, estado, anyo, sort);
        }
       
        return proveedorRepository.findAllByParameters(tipoDocumento, numeroDocumento, nombres, estado, anyo, null);

    }

    
    @Override
    public Proveedor findById(int id) throws NotFoundException{
        Optional<Proveedor> model = proveedorRepository.findById(id);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el proveedor");
        }
       
        return model.get();
    }

    @Override
    public Page<Proveedor> findAllConParametrosPaginated(Optional<Integer> tipoDocumento, Optional<String> numeroDocumento,Optional<String> nombres,Optional<Integer> estado,Optional<Integer> anyo,Optional<String> fieldName, Optional<Boolean> ascending, PageRequest pageRequest) {
       
        if(fieldName.isPresent()){
            Sort sort = ascending.get() ? Sort.by(fieldName.get()).ascending() : Sort.by(fieldName.get()).descending();
            
            Pageable pageable = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), sort);

            return proveedorRepository.findAllByParametersPaginated(tipoDocumento, numeroDocumento, nombres, estado, anyo, pageable);
        }
       
        return proveedorRepository.findAllByParametersPaginated(tipoDocumento, numeroDocumento, nombres, estado, anyo, pageRequest);
    }

}
