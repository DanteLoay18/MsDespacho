package Contraloria.MsDespacho.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import Contraloria.MsDespacho.model.Catalogo;


@DataJpaTest
public class CatalogoRepositoryTest {

    @Autowired
    CatalogoRepository CatalogoRepository;

    @Autowired
    TestEntityManager testEntityManager;

    //Se ejecuta antes de las pruebas unitarias
    @BeforeEach
    void setUp(){
        // Catalogo Catalogo =  new Catalogo(null, 1, "Tipo de Documentos", null, null, 1);

        // Catalogo.setFechaCreacion(new Date());
        // Catalogo.setUsuarioCreacion("User");
        
        // testEntityManager.persistAndFlush(Catalogo);       

        
        // Catalogo Catalogo1 = new Catalogo(Catalogo, 1, "Documento Nacional de Identidad", "Dni", null, 1);
        // Catalogo1.setFechaCreacion(new Date());
        // Catalogo1.setUsuarioCreacion("User");

        // testEntityManager.persistAndFlush(Catalogo1);   
    }


    // @Test
    // public void findAllHijosFound(){
    //     List<Catalogo> Catalogos = CatalogoRepository.findAllHijos(1);
        
    //     assertEquals(Catalogos.size(), 0);

    //     System.out.println("pruebas  ----- "+Catalogos.get(0));
    // }


}
