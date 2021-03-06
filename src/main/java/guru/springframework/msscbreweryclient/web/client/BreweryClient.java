package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.config.MsscBreweryConfig;
import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;


//@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder, MsscBreweryConfig msscBreweryConfig) {
        this.restTemplate = restTemplateBuilder.build();
        apihost = msscBreweryConfig.getApihost();
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID id, BeerDto beerDto){
        restTemplate.put(apihost + BEER_PATH_V1 + id.toString(), beerDto);
    }

    public void deleteBeer(UUID id){
        restTemplate.delete(apihost + BEER_PATH_V1 + id);
    }


}
