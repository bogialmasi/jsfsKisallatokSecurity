package hu.kisallatokSecurity.services.OService;

import hu.kisallatokSecurity.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OService {

    @Autowired
    private RestTemplate restTemplate;

    private final String REST_URL= "http://localhost:8080/owners";

    public int newOwner(String name, String address) {
        String url = REST_URL;
        Owner o = new Owner(name, address);
        HttpEntity<Owner> resuestEntity = new HttpEntity<>(o);
        ResponseEntity<Owner> responseEntity = restTemplate.exchange(url, HttpMethod.POST, resuestEntity, Owner.class);
        return responseEntity.getStatusCodeValue();
    }
}
