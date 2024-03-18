package Contraloria.MsDespacho.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.Documento;
import Contraloria.MsDespacho.repository.DocumentoRepository;
import Contraloria.MsDespacho.service.DocumentoService;

@Service
public class DocumentoServiceImp implements DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Override
    public List<Documento> findAll(){
        return(List<Documento>) documentoRepository.findAll();
    }

    @Override
    public Page<Documento> findAll(PageRequest pageRequest){
        return documentoRepository.findAll(pageRequest);
    }

    @Override
    public Documento findById(int id) throws NotFoundException{
        Optional<Documento> model = documentoRepository.findById(id);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el documento");
        }
       
        return model.get();
    }

}
