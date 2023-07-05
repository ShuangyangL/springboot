package ITSalaryDemo.Entity;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class HttpClient {

    public String getResponse(String url, HttpMethod method, String json_input){
        // create a http client and get response
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = null;

        // set the header
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("keyzcpXsupauEJBhZ");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        if (method.matches("GET"))
        {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    requestEntity,
                    String.class);
        }
        else if(method.matches("POST"))
        {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestEntity,
                    String.class,
                    json_input);
        }

        return response.getBody();
    }
}

