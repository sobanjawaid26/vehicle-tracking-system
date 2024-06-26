package com.sobanscode.auth.data.dal;


import com.sobanscode.auth.data.entity.AuthTable;
import com.sobanscode.auth.data.entity.User;
import com.sobanscode.auth.data.enums.Roles;
import com.sobanscode.auth.data.repository.IUserAuthRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AuthServiceHelper {
    private final IUserAuthRepository userAuthRepository;

    public AuthServiceHelper(IUserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    public AuthTable findByUsernameAndPassword(String username, String password) {
        return userAuthRepository.findByUsernameAndPassword(username, password);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public AuthTable save(String username, String password, User user, Roles role) {
        AuthTable authTable = AuthTable.
                builder().
                username(username).
                password(password).
                user(user).
                role(role).
                build();

        return userAuthRepository.save(authTable);
    }
}
