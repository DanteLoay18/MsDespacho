package Contraloria.MsDespacho.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.Usuario;
import Contraloria.MsDespacho.repository.UsuarioRepository;
import Contraloria.MsDespacho.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario add(Usuario usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    @Override
    public Usuario update(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean delete(Usuario usuario){
        
        usuario.setFechaEliminacion(new Date());
        usuario.setUsuarioEliminacion("UsuarioEliminacion");
        
        usuarioRepository.save(usuario);
        
        usuarioRepository.deleteById(usuario.getId());
        return true;
    }

    @Override
    public List<Usuario> findAll(){
        return(List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(int id) throws NotFoundException{
        Optional<Usuario> model = usuarioRepository.findById(id);

        if(model.isEmpty() || model.get().isEsEliminado()){
            throw new NotFoundException("No se encontro el usuario");
        }
       
        return model.get();
    }
}
