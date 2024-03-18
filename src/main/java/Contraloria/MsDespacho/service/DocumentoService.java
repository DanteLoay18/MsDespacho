package Contraloria.MsDespacho.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import Contraloria.MsDespacho.exception.NotFoundException;
import Contraloria.MsDespacho.model.Documento;

public interface DocumentoService {
    public List<Documento> findAll();
    public Page<Documento> findAll(PageRequest pageRequest);
    public Documento findById(int id) throws NotFoundException;
}
