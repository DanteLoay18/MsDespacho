package Contraloria.MsDespacho.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.CargoAdicional;
import Contraloria.MsDespacho.repository.CargoAdicionalRepository;
import Contraloria.MsDespacho.service.CargoAdicionalService;

@Service
public class CargoAdicionalServiceImp implements CargoAdicionalService{

    @Autowired
    private CargoAdicionalRepository cargoAdicionalRepository;

    @Override
    public CargoAdicional add(CargoAdicional cargoAdicional) {
        return cargoAdicionalRepository.save(cargoAdicional);
    }

    @Override
    public CargoAdicional update(CargoAdicional cargoAdicional){
        return cargoAdicionalRepository.save(cargoAdicional);
    }

    @Override
    public boolean delete(CargoAdicional cargoAdicional, Integer usuarioEliminacion){

        cargoAdicional.setFechaEliminacion(new Date());
        cargoAdicional.setUsuarioEliminacion(usuarioEliminacion);
        
        cargoAdicionalRepository.save(cargoAdicional);

        cargoAdicionalRepository.deleteById(cargoAdicional.getId());
        return true;
    }

    @Override
    public List<CargoAdicional> findAll(){
        return(List<CargoAdicional>) cargoAdicionalRepository.findAll();
    }

    @Override
    public Page<CargoAdicional> findAll(PageRequest pageRequest){
        return cargoAdicionalRepository.findAll(pageRequest);
    }

    @Override
    public CargoAdicional findById(int id) throws NotFoundException{
        Optional<CargoAdicional> model = cargoAdicionalRepository.findById(id);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el cargoAdicional");
        }
       
        return model.get();
    }
}
