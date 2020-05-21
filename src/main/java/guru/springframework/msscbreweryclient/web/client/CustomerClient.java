package guru.springframework.msscbreweryclient.web.client;


import guru.springframework.msscbreweryclient.web.config.MsscBreweryConfig;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class CustomerClient {
    private final String BASE_URL = "/api/v1/customers/";
    private String apihost;

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder, MsscBreweryConfig msscBreweryConfig) {
        this.restTemplate = restTemplateBuilder.build();
        this.apihost = msscBreweryConfig.getApihost();
    }

    CustomerDto getCustomer(UUID id) {
        return restTemplate.getForObject(apihost + BASE_URL + id, CustomerDto.class);
    }

    CustomerDto creatCustomer(CustomerDto customerDto){
        return restTemplate.postForObject(apihost + BASE_URL, customerDto, CustomerDto.class);
    }

    void updateCustomer(UUID id, CustomerDto customerDto){
        restTemplate.put(apihost + BASE_URL + id, customerDto);
    }

    void deleteCustomer(UUID id) {
        restTemplate.delete(apihost + BASE_URL + id);
    }
}
