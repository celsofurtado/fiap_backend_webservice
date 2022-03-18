package br.com.fiap.imc.service;

import br.com.fiap.imc.model.User;
import br.com.fiap.imc.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        }

        return null;
    }

    public User getByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean delete(Long userId) {

        User user = userRepository.findById(userId).get();

        if (user != null) {
            userRepository.deleteById(userId);
            return true;
        }

        return false;

    }

    public User update(User user, Long userId) {

        User actualUser = userRepository.findById(userId).get();

        if (actualUser != null) {

            System.out.println("***********************************************");
            System.out.println(user.toString());
            System.out.println("***********************************************");

            BeanUtils.copyProperties(user, actualUser, "userId", "password");
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            System.out.print(actualUser.toString());
            userRepository.save(actualUser);
            return actualUser;
        }

        return null;

    }

}
