package Contraloria.MsDespacho.service;

import Contraloria.MsDespacho.model.Sunat.SunatResponse;

public interface SunatService {
    
    public SunatResponse<String> buscarRazonSocial();
    public SunatResponse<String> buscarRazonSocialNew();
    public SunatResponse<String> buscarRepLegales();
    public SunatResponse<String> buscarRuc();
    public SunatResponse<String> buscarRucNew();


}
