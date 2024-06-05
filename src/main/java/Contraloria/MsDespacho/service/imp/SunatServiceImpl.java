package Contraloria.MsDespacho.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Contraloria.MsDespacho.model.Sunat.SunatResponse;
import Contraloria.MsDespacho.service.SunatService;

@Service
public class SunatServiceImpl implements SunatService{

    @Autowired
    private RestTemplate restTemplate;

    private String servicio= "http://11.162.108.89:8021/srvSunat/RucES.svc?WSDL";

    @Override
    public SunatResponse<String> buscarRazonSocial() {
        
        ResponseEntity<SunatResponse<String>> response = restTemplate.exchange(
            servicio,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<SunatResponse<String>>() {}
        );

        return response.getBody();
    }

    @Override
    public SunatResponse<String> buscarRazonSocialNew() {

        ResponseEntity<SunatResponse<String>> response = restTemplate.exchange(
            servicio,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<SunatResponse<String>>() {}
        );
        
        return response.getBody();
    }

    @Override
    public SunatResponse<String> buscarRepLegales() {
        ResponseEntity<SunatResponse<String>> response = restTemplate.exchange(
            servicio,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<SunatResponse<String>>() {}
        );
        
        return response.getBody();
    }

    @Override
    public SunatResponse<String> buscarRuc() {

        ResponseEntity<SunatResponse<String>> response = restTemplate.exchange(
            servicio,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<SunatResponse<String>>() {}
        );
        
        return response.getBody();
    }

    @Override
    public SunatResponse<String> buscarRucNew() {
        ResponseEntity<SunatResponse<String>> response = restTemplate.exchange(
            servicio,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<SunatResponse<String>>() {}
        );
        
        return response.getBody();
    }
    
}
