package Contraloria.MsDespacho.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;



import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.CargoDistribucion;
import Contraloria.MsDespacho.repository.CargoDistribucionRepository;
import Contraloria.MsDespacho.service.CargoDistribucionService;
@Service
public class CargoDistribucionServiceImp implements CargoDistribucionService{
    @Autowired
    private CargoDistribucionRepository cargoDistribucionRepository;

    @Override
    public CargoDistribucion add(CargoDistribucion cargoDistribucion) {
        long millis=System.currentTimeMillis(); 

        cargoDistribucion.setFechaCargo(new java.sql.Date(millis));
        cargoDistribucion.setNumeroCargo(cargoDistribucionRepository.findMaxNumeroCargo()+1);
        return cargoDistribucionRepository.save(cargoDistribucion);
    }

    @Override
    public CargoDistribucion update(CargoDistribucion cargoDistribucion){
        return cargoDistribucionRepository.save(cargoDistribucion);
    }

    @Override
    public boolean delete(CargoDistribucion cargoDistribucion){

        cargoDistribucion.setFechaEliminacion(new Date());
        cargoDistribucion.setUsuarioEliminacion("UsuarioEliminacion");
        
        cargoDistribucionRepository.save(cargoDistribucion);

        cargoDistribucionRepository.deleteById(cargoDistribucion.getId());
        return true;
    }

    @Override
    public List<CargoDistribucion> findAll(){
        return(List<CargoDistribucion>) cargoDistribucionRepository.findAll();
    }

    @Override
    public Page<CargoDistribucion> findAll(PageRequest pageRequest){
        return cargoDistribucionRepository.findAll(pageRequest);
    }

    @Override
    public CargoDistribucion findById(int id) throws NotFoundException{
        Optional<CargoDistribucion> model = cargoDistribucionRepository.findById(id);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el cargoDistribucion");
        }
       
        return model.get();
    }

    
    @Override
    public List<CargoDistribucion> findAllConParametros(Optional<Integer> idSedeDestino, Optional<Integer> numeroCargo, Optional<String> fieldName,Optional<Boolean> ascending) {
        if(fieldName.isPresent()){
            Sort sort = ascending.get() ? Sort.by(fieldName.get()).ascending() : Sort.by(fieldName.get()).descending();

            return cargoDistribucionRepository.findAllByParameters(idSedeDestino,numeroCargo, sort);
        }
        
        Sort sort =  Sort.by("fechaCreacion").descending();

        return cargoDistribucionRepository.findAllByParameters(idSedeDestino,numeroCargo, sort);
    }

    @Override
    public Page<CargoDistribucion> findAllConParametrosPaginado(Optional<Integer> idSedeDestino, Optional<Integer> numeroCargo,PageRequest pageRequest, Optional<String> fieldName,Optional<Boolean> ascending){

        if(fieldName.isPresent()){
            Sort sort = ascending.get() ? Sort.by(fieldName.get()).ascending() : Sort.by(fieldName.get()).descending();

            Pageable pageable = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), sort);
            return cargoDistribucionRepository.findAllByParametersPaginated(idSedeDestino,numeroCargo, pageable);
        }

        Sort sort =  Sort.by("fechaCreacion").descending();
        Pageable pageable = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), sort);
        return cargoDistribucionRepository.findAllByParametersPaginated(idSedeDestino, numeroCargo, pageable);
    }
}