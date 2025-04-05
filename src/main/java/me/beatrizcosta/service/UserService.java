package me.beatrizcosta.service;

import me.beatrizcosta.domain.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);

    List<User> findAll();

    User update(Long id, User userToUpdate);

    void delete(Long id);
}
