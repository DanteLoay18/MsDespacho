package Contraloria.MsDespacho.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.DatosFinancieros;
import Contraloria.MsDespacho.repository.DatosFinancierosRepository;
import Contraloria.MsDespacho.service.DatosFinancierosService;


@Service
public class DatosFinancierosServiceImp implements DatosFinancierosService{

    @Autowired
    private DatosFinancierosRepository datosFinancierosRepository;
    
    @Override
    public DatosFinancieros add(DatosFinancieros datosFinancieros) {
        return datosFinancierosRepository.save(datosFinancieros);
    }

    @Override
    public DatosFinancieros update(DatosFinancieros datosFinancieros) {
        return datosFinancierosRepository.save(datosFinancieros);
    }

    @Override
    public boolean delete(DatosFinancieros datosFinancieros,Integer usuarioEliminacion) {
        datosFinancieros.setFechaEliminacion(new Date());
        datosFinancieros.setUsuarioEliminacion(usuarioEliminacion);
        
        datosFinancierosRepository.save(datosFinancieros);

        datosFinancierosRepository.deleteById(datosFinancieros.getId());
        return true;
    }

    @Override
    public List<DatosFinancieros> findAll() {
        return(List<DatosFinancieros>) datosFinancierosRepository.findAll();
    }

    @Override
    public DatosFinancieros findById(int id) throws NotFoundException {
        Optional<DatosFinancieros> model = datosFinancierosRepository.findById(id);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el dato financiero");
        }
       
        return model.get();
    }
    
}
