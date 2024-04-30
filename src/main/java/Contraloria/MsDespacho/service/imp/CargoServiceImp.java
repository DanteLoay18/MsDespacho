package Contraloria.MsDespacho.service.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

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

    @Override
    public Cargo findByCodigoBarra(String codigoBarra) throws NotFoundException {
        
        Optional<Cargo> model = cargoRepository.findByCodigoDeBarra(codigoBarra);
 
        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el cargo");
        }
       
        return model.get();

    }

    @Override
    public List<Object> obtenerCantidadPorSedeDestino() {
        List<Object[]> resultados = cargoRepository.obtenerCantidadPorSedeDestino();
        
        return resultados.stream()
                .map(result -> {
                    int idSedeDestino = (int) result[0];
                    long cantidad = (long) result[1];
                    Map<String, Object> map = new HashMap<>();
                    map.put("idSedeDestino", idSedeDestino);
                    map.put("cantidad", cantidad);
                    return map;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Cargo> listarCargosPorUO(int idSedeDestino) {
        return(List<Cargo>) cargoRepository.listarCargosPorUO(idSedeDestino);
    }

    @Override
    public List<Cargo> findAllConParametros(Optional<Integer> idSedeDestino, Optional<String> numeroDocumento,Optional<Integer> tipoDocumento,Optional<Integer> anyo,Optional<Date> fechaInicio,Optional<Date> fechaFin,Optional<String> fieldName,Optional<Boolean> ascending) {
        
        if(fieldName.isPresent()){
            Sort sort = ascending.get() ? Sort.by(fieldName.get()).ascending() : Sort.by(fieldName.get()).descending();

            return cargoRepository.findAllByParameters(idSedeDestino,numeroDocumento,tipoDocumento,anyo,fechaInicio,fechaFin, sort);
        }
       

        return cargoRepository.findAllByParameters(idSedeDestino,numeroDocumento,tipoDocumento,anyo,fechaInicio,fechaFin, null);
    }


    @Override
    public Page<Cargo> findAllConParametrosPaginated(Optional<Integer> idSedeDestino, Optional<String> numeroDocumento,Optional<Integer> tipoDocumento,Optional<Integer> anyo,Optional<Date> fechaInicio,Optional<Date> fechaFin,PageRequest pageRequest, Optional<String> fieldName, Optional<Boolean> ascending) {
       
        if(fieldName.isPresent()){
            Sort sort = ascending.get() ? Sort.by(fieldName.get()).ascending() : Sort.by(fieldName.get()).descending();
            
            Pageable pageable = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), sort);

            return cargoRepository.findAllByParametersPaginated(idSedeDestino,numeroDocumento,tipoDocumento,anyo,fechaInicio,fechaFin, pageable);
        }
       
        return cargoRepository.findAllByParametersPaginated(idSedeDestino,numeroDocumento,tipoDocumento,anyo,fechaInicio,fechaFin, pageRequest);
    }
}
