package com.lucianorib.workshopmongo.services;

import com.lucianorib.workshopmongo.domain.User;
import com.lucianorib.workshopmongo.dto.UserDTO;
import com.lucianorib.workshopmongo.repository.UserRepository;
import com.lucianorib.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public void update(User user) {
        Optional<User> newUser = userRepository.findById(user.getId());
        newUser.ifPresent(u -> {
            updateData(u, user);
            userRepository.save(u);
        });
    }

    private void updateData(User newUser, User user){
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
