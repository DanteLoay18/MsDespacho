package Contraloria.MsDespacho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Contraloria.MsDespacho.mapper.DistribucionMapper;
import Contraloria.MsDespacho.routes.ApiRoutes;
import Contraloria.MsDespacho.service.CargoAdicionalService;
import Contraloria.MsDespacho.service.CargoDistribucionService;
import Contraloria.MsDespacho.service.DetalleCargoDistribucionService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(ApiRoutes.ENDPOINT_DISTRIBUCION)
@Tag(name = "Distribucion")
public class DistribucionController {

    @Autowired
    CargoAdicionalService cargoAdicionalService;

    @Autowired
    CargoDistribucionService cargoDistribucionService;

    @Autowired
    DetalleCargoDistribucionService detalleCargoDistribucionService;

    @Autowired
    DistribucionMapper distribucionMapper;

    
}
