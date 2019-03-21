package bohdan.papizhanskiy.laptops.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UserRequest {

    @Email
    private String login;

    @NotNull
    @NotEmpty
    @Min(6)
    @Max(16)
    private String password;
}
