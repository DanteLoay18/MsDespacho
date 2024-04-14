package Contraloria.MsDespacho.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.CargoDevolucion;
import Contraloria.MsDespacho.repository.CargoDevolucionRepository;
import Contraloria.MsDespacho.service.CargoDevolucionService;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class CargoDevolucionServiceImp implements CargoDevolucionService {
    
    @Autowired
    private CargoDevolucionRepository cargoDevolucionRepository;

    @Override
    public CargoDevolucion add(CargoDevolucion cargoAdicional) {
        return cargoDevolucionRepository.save(cargoAdicional);
    }

    @Override
    public CargoDevolucion update(CargoDevolucion cargoAdicional){
        return cargoDevolucionRepository.save(cargoAdicional);
    }

    @Override
    public boolean delete(CargoDevolucion cargoAdicional){

        cargoAdicional.setFechaEliminacion(new Date());
        cargoAdicional.setUsuarioEliminacion("UsuarioEliminacion");
        
        cargoDevolucionRepository.save(cargoAdicional);

        cargoDevolucionRepository.deleteById(cargoAdicional.getId());
        return true;
    }

    @Override
    public List<CargoDevolucion> findAll(){
        return(List<CargoDevolucion>) cargoDevolucionRepository.findAll();
    }

    @Override
    public Page<CargoDevolucion> findAll(PageRequest pageRequest){
        return cargoDevolucionRepository.findAll(pageRequest);
    }

    @Override
    public CargoDevolucion findById(int id) throws NotFoundException{
        Optional<CargoDevolucion> model = cargoDevolucionRepository.findById(id);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el cargoAdicional");
        }
       
        return model.get();
    }
}
