package com.sobanscode.user.data.dal;

import com.sobanscode.user.data.entity.User;
import com.sobanscode.user.data.repository.IUserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class UserServiceHelper {

    private final IUserRepository userRepository;

    public UserServiceHelper(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserId(long id) {
        return userRepository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public User save(User user){
        return userRepository.save(user);
    }
}
