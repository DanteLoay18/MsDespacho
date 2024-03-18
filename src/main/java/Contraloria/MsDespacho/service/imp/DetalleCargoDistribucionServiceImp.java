package Contraloria.MsDespacho.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.DetalleCargoDistribucion;
import Contraloria.MsDespacho.repository.DetalleCargoDistribucionRepository;
import Contraloria.MsDespacho.service.DetalleCargoDistribucionService;

@Service
public class DetalleCargoDistribucionServiceImp implements DetalleCargoDistribucionService{
    @Autowired
    private DetalleCargoDistribucionRepository detalleCargoDistribucionRepository;

    @Override
    public DetalleCargoDistribucion add(DetalleCargoDistribucion detalleCargoDistribucion) {
        return detalleCargoDistribucionRepository.save(detalleCargoDistribucion);
    }

    @Override
    public DetalleCargoDistribucion update(DetalleCargoDistribucion detalleCargoDistribucion){
        return detalleCargoDistribucionRepository.save(detalleCargoDistribucion);
    }

    @Override
    public boolean delete(DetalleCargoDistribucion detalleCargoDistribucion){

        detalleCargoDistribucion.setFechaEliminacion(new Date());
        detalleCargoDistribucion.setUsuarioEliminacion("UsuarioEliminacion");
        
        detalleCargoDistribucionRepository.save(detalleCargoDistribucion);

        detalleCargoDistribucionRepository.deleteById(detalleCargoDistribucion.getId());
        return true;
    }

    @Override
    public List<DetalleCargoDistribucion> findAll(){
        return(List<DetalleCargoDistribucion>) detalleCargoDistribucionRepository.findAll();
    }

    @Override
    public Page<DetalleCargoDistribucion> findAll(PageRequest pageRequest){
        return detalleCargoDistribucionRepository.findAll(pageRequest);
    }

    @Override
    public DetalleCargoDistribucion findById(int id) throws NotFoundException{
        Optional<DetalleCargoDistribucion> model = detalleCargoDistribucionRepository.findById(id);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el detalleCargoDistribucion");
        }
       
        return model.get();
    }
}
