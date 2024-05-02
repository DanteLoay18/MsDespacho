package Contraloria.MsDespacho.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import Contraloria.MsDespacho.model.Enumerado;


@DataJpaTest
public class EnumeradoRepositoryTest {

    @Autowired
    EnumeradoRepository enumeradoRepository;

    @Autowired
    TestEntityManager testEntityManager;

    //Se ejecuta antes de las pruebas unitarias
    @BeforeEach
    void setUp(){
        Enumerado enumerado =  new Enumerado(null, 1, "Tipo de Documentos", null, null, 1);

        enumerado.setFechaCreacion(new Date());
        enumerado.setUsuarioCreacion("User");
        
        testEntityManager.persistAndFlush(enumerado);       

        
        Enumerado enumerado1 = new Enumerado(enumerado, 1, "Documento Nacional de Identidad", "Dni", null, 1);
        enumerado1.setFechaCreacion(new Date());
        enumerado1.setUsuarioCreacion("User");

        testEntityManager.persistAndFlush(enumerado1);   
    }


    @Test
    public void findAllHijosFound(){
        List<Enumerado> enumerados = enumeradoRepository.findAllHijos(1);
        
        assertEquals(enumerados.size(), 1);

        System.out.println("pruebas  ----- "+enumerados.get(0));
    }


}
