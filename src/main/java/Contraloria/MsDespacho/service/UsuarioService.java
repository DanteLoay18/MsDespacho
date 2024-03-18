package Contraloria.MsDespacho.service;

import java.util.List;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.Usuario;

public interface UsuarioService {

    public Usuario add (Usuario usuarioModel);
    public Usuario update (Usuario usuarioModel);
    public boolean delete (Usuario usuario);
    public List<Usuario> findAll();
    public Usuario findById(int id) throws NotFoundException;
}
