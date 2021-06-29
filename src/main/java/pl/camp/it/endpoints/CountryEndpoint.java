package pl.camp.it.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.camp.it.countries.Country;
import pl.camp.it.countries.Currency;
import pl.camp.it.countries.GetCountryRequest;
import pl.camp.it.countries.GetCountryResponse;

import java.util.HashMap;
import java.util.Map;

@Endpoint
public class CountryEndpoint {

    @PayloadRoot(namespace = "http://it.camp.pl/countries/", localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountryResponse(@RequestPayload GetCountryRequest getCountryRequest) {
        Map<String, Country> countryMap = generateCountriesMap();

        Country c = countryMap.get(getCountryRequest.getName());

        GetCountryResponse getCountryResponse = new GetCountryResponse();
        getCountryResponse.setCountry(c);

        return getCountryResponse;
    }

    private Map<String, Country> generateCountriesMap() {
        Map<String, Country> countryMap = new HashMap<>();

        Country country1 = new Country();
        country1.setName("Polska");
        country1.setCapital("Warszawa");
        country1.setPopulation(38000000);
        country1.setCurrency(Currency.PLN);

        countryMap.put("Polska", country1);

        Country country2 = new Country();
        country2.setName("Hiszpania");
        country2.setCapital("Mardyt");
        country2.setPopulation(50000000);
        country2.setCurrency(Currency.EUR);

        countryMap.put("Hiszpania", country2);

        Country country3 = new Country();
        country3.setName("Wielka Brytania");
        country3.setCapital("Londyn");
        country3.setPopulation(60000000);
        country3.setCurrency(Currency.GBP);

        countryMap.put("Wielka Brytania", country3);

        return countryMap;
    }
}
