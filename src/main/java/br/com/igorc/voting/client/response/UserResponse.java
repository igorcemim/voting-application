package br.com.igorc.voting.client.response;

import br.com.igorc.voting.enumeration.UserStatusEnumeration;
import lombok.Data;

@Data
public class UserResponse {

    private UserStatusEnumeration status;

}
