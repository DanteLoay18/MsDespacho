package Contraloria.MsDespacho.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.Cargo;
import Contraloria.MsDespacho.repository.CargoRepository;
import Contraloria.MsDespacho.service.CargoService;

@Service
public class CargoServiceImp implements CargoService{
    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public Cargo add(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public Cargo update(Cargo cargo){
        return cargoRepository.save(cargo);
    }

    @Override
    public boolean delete(Cargo cargo){

        cargo.setFechaEliminacion(new Date());
        cargo.setUsuarioEliminacion("UsuarioEliminacion");
        
        cargoRepository.save(cargo);

        cargoRepository.deleteById(cargo.getId());
        return true;
    }

    @Override
    public List<Cargo> findAll(){
        return(List<Cargo>) cargoRepository.findAll();
    }

    @Override
    public Page<Cargo> findAll(PageRequest pageRequest){
        return cargoRepository.findAll(pageRequest);
    }
    
    @Override
    public Cargo findById(int id) throws NotFoundException{
        Optional<Cargo> model = cargoRepository.findById(id);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el cargo");
        }
       
        return model.get();
    }

}
