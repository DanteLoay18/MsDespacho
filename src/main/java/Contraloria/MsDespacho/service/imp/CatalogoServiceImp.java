package Contraloria.MsDespacho.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.Catalogo;
import Contraloria.MsDespacho.repository.CatalogoRepository;
import Contraloria.MsDespacho.service.CatalogoService;

@Service
public class CatalogoServiceImp implements CatalogoService{
    @Autowired
    private CatalogoRepository catalogoRepository;

    @Override
    public Catalogo add(Catalogo catalogo) {
        return catalogoRepository.save(catalogo);
    }

    @Override
    public Catalogo update(Catalogo catalogo){
        return catalogoRepository.save(catalogo);
    }

    @Override
    public boolean delete(Catalogo catalogo){

        catalogo.setFechaEliminacion(new Date());
        catalogo.setUsuarioEliminacion("UsuarioEliminacion");
        
        catalogoRepository.save(catalogo);

        catalogoRepository.deleteById(catalogo.getId());
        return true;
    }

    @Override
    public List<Catalogo> findAll(){
        return(List<Catalogo>) catalogoRepository.findAll();
    }

    
    @Override
    public Catalogo findById(int id) throws NotFoundException{
        Optional<Catalogo> model = catalogoRepository.findById(id);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el catalogo");
        }
       
        return model.get();
    }

    @Override
    public List<Catalogo> findCatalogosHijos(int idPadre) throws NotFoundException{

        Optional<Catalogo> model = catalogoRepository.findById(idPadre);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el catalogo");
        }

        return(List<Catalogo>) catalogoRepository.findAllHijos(idPadre);
    }
}
