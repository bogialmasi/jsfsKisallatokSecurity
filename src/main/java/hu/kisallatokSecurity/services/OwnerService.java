package hu.kisallatokSecurity.services;

import hu.kisallatokSecurity.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OwnerService {

    @Autowired
    private RestTemplate restTemplate;

    private final String REST_URL = "http://localhost:8070/owners";

    public int newOwner(String name, String address) {
        String url = REST_URL;
        Owner owner = new Owner(name, address);
        HttpEntity<Owner> requestEntity = new HttpEntity<>(owner);
        ResponseEntity<Owner> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Owner.class);
        return responseEntity.getStatusCodeValue();
    }
}
