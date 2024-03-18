package Contraloria.MsDespacho.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.Enumerado;
import Contraloria.MsDespacho.repository.EnumeradoRepository;
import Contraloria.MsDespacho.service.EnumeradoService;

@Service
public class EnumeradoServiceImp implements EnumeradoService{
    @Autowired
    private EnumeradoRepository enumeradoRepository;

    @Override
    public Enumerado add(Enumerado enumerado) {
        return enumeradoRepository.save(enumerado);
    }

    @Override
    public Enumerado update(Enumerado enumerado){
        return enumeradoRepository.save(enumerado);
    }

    @Override
    public boolean delete(Enumerado enumerado){

        enumerado.setFechaEliminacion(new Date());
        enumerado.setUsuarioEliminacion("UsuarioEliminacion");
        
        enumeradoRepository.save(enumerado);

        enumeradoRepository.deleteById(enumerado.getId());
        return true;
    }

    @Override
    public List<Enumerado> findAll(){
        return(List<Enumerado>) enumeradoRepository.findAll();
    }

    
    @Override
    public Enumerado findById(int id) throws NotFoundException{
        Optional<Enumerado> model = enumeradoRepository.findById(id);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el enumerado");
        }
       
        return model.get();
    }

    @Override
    public List<Enumerado> findEnumeradosHijos(int idPadre) throws NotFoundException{

        Optional<Enumerado> model = enumeradoRepository.findById(idPadre);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el enumerado");
        }

        return(List<Enumerado>) enumeradoRepository.findAllHijos(idPadre);
    }
}
