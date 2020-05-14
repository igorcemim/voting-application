package br.com.igorc.voting.client;

import br.com.igorc.voting.client.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class UserInfoClient {

    private RestTemplate restTemplate;

    private final String SERVICE_URL = "https://user-info.herokuapp.com";

    public ResponseEntity<UserResponse> getUser(String cpf) {
        return restTemplate.getForEntity(SERVICE_URL.concat("/users/{cpf}"), UserResponse.class, cpf);
    }

}
