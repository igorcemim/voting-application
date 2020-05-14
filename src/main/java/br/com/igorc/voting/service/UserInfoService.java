package br.com.igorc.voting.service;

import br.com.igorc.voting.client.UserInfoClient;
import br.com.igorc.voting.client.response.UserResponse;
import br.com.igorc.voting.enumeration.UserStatusEnumeration;
import br.com.igorc.voting.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserInfoService {

    private UserInfoClient userInfoClient;

    public Boolean isAbleToVote(String cpf) {
        ResponseEntity<UserResponse> userResponse = userInfoClient.getUser(cpf);

        if (HttpStatus.NOT_FOUND.equals(userResponse.getStatusCode())) {
            throw new BusinessException("CPF não encontrado na lista de associados votantes.");
        }

        if (userResponse.getStatusCode().isError()) {
            throw new BusinessException("Falha ao consultar lista de associados votantes.");
        }

        return UserStatusEnumeration.ABLE_TO_VOTE.equals(userResponse.getBody().getStatus());
    }

}
