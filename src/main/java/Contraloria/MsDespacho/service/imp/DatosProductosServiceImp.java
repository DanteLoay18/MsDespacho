package Contraloria.MsDespacho.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.DatosProductos;
import Contraloria.MsDespacho.repository.DatosProductosRepository;
import Contraloria.MsDespacho.service.DatosProductosService;

@Service
public class DatosProductosServiceImp implements DatosProductosService{
 
    @Autowired
    private DatosProductosRepository datosProductosRepository;
    
    @Override
    public DatosProductos add(DatosProductos datosProductos) {
        return datosProductosRepository.save(datosProductos);
    }

    @Override
    public DatosProductos update(DatosProductos datosProductos) {
        return datosProductosRepository.save(datosProductos);
    }

    @Override
    public boolean delete(DatosProductos datosProductos) {
        datosProductos.setFechaEliminacion(new Date());
        datosProductos.setUsuarioEliminacion("UsuarioEliminacion");
        
        datosProductosRepository.save(datosProductos);

        datosProductosRepository.deleteById(datosProductos.getId());
        return true;
    }

    @Override
    public List<DatosProductos> findAll() {
        return(List<DatosProductos>) datosProductosRepository.findAll();
    }

    @Override
    public DatosProductos findById(int id) throws NotFoundException {
        Optional<DatosProductos> model = datosProductosRepository.findById(id);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el proveedor");
        }
       
        return model.get();
    }
}
