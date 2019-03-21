package bohdan.papizhanskiy.laptops.service;

import bohdan.papizhanskiy.laptops.dto.request.UserRequest;
import bohdan.papizhanskiy.laptops.entity.Role;
import bohdan.papizhanskiy.laptops.entity.User;
import bohdan.papizhanskiy.laptops.exception.WrongInputDataException;
import bohdan.papizhanskiy.laptops.repository.UserRepository;
import bohdan.papizhanskiy.laptops.security.tokenUtils.TokenTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenTool tokenTool;


    public String save(UserRequest request) throws Exception {
        if (userRepository.findByLoginEquals(request.getLogin()).isPresent()) {
            throw new Exception("Credentials are busy. Please, try one more time " +
                    "with other logib");
        }
        User user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        user = userRepository.saveAndFlush(user);

        return tokenTool.createToken(user.getLogin(), user.getRole().name());
    }


    public String findOneByRequest(UserRequest userRequest) throws WrongInputDataException {
        User user = userRepository.findByLoginEquals(userRequest.getLogin()).orElseThrow(() -> new WrongInputDataException("User with login " + userRequest.getLogin() + " not exists"));

        if (passwordEncoder.matches(userRequest.getPassword(), user.getPassword())) {
            return tokenTool.createToken(user.getLogin(), user.getRole().name());
        }

        throw new IllegalArgumentException("Wrong login or password");
    }
}
