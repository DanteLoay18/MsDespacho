package Contraloria.MsDespacho.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean delete(Proveedor proveedor){

        proveedor.setFechaEliminacion(new Date());
        proveedor.setUsuarioEliminacion("UsuarioEliminacion");
        
        proveedorRepository.save(proveedor);

        proveedorRepository.deleteById(proveedor.getId());
        return true;
    }

    @Override
    public List<Proveedor> findAll(){
        return(List<Proveedor>) proveedorRepository.findAll();
    }

    
    @Override
    public Proveedor findById(int id) throws NotFoundException{
        Optional<Proveedor> model = proveedorRepository.findById(id);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el proveedor");
        }
       
        return model.get();
    }

}
