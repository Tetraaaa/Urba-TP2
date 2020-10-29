package org.cnam.sample.domain;

import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.AccountToCreate;
import org.cnam.sample.domain.entity.User;
import org.cnam.sample.domain.entity.UserToCreate;
import org.cnam.sample.repository.AccountRepository;
import org.cnam.sample.repository.UserRepository;
import org.cnam.sample.repository.model.AccountModel;
import org.cnam.sample.repository.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getById(Long id) {
        UserModel userModelFound = userRepository.getOne(id);

        return new User(userModelFound.getId(), userModelFound.getFirstname(), userModelFound.getLastname());
    }

    public User create(UserToCreate userToCreate) {
        UserModel userModelToCreate = new UserModel(userToCreate.firstname, userToCreate.lastname);

        UserModel userModelCreated = userRepository.save(userModelToCreate);

        return new User(userModelCreated.getId(), userModelCreated.getFirstname(), userModelCreated.getLastname());
    }

    public User update(User userToUpdate, String firstname, String lastname) {
        UserModel userModelToUpdate = new UserModel(userToUpdate.id, firstname, lastname);

        UserModel userModelUpdated = userRepository.save(userModelToUpdate);

        return new User(userModelUpdated.getId(), userModelUpdated.getFirstname(), userModelUpdated.getLastname());
    }

    public void delete(User userToDelete) {
        UserModel userModel = new UserModel(userToDelete);

        userRepository.delete(userModel);
    }
}
