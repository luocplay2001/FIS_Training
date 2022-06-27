package fis.training.criminalsystemmanagement.config.payload;

import fis.training.criminalsystemmanagement.model.enums.Rank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {

    private String username;
    private String password;

    private Rank rank;
}
