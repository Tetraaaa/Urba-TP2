package org.cnam.sample.domain;

import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.AccountToCreate;
import org.cnam.sample.domain.entity.User;
import org.cnam.sample.repository.AccountRepository;
import org.cnam.sample.repository.UserRepository;
import org.cnam.sample.repository.model.AccountModel;
import org.cnam.sample.repository.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    public Account getById(Long id) {
        AccountModel accountModelFound = accountRepository.getOne(id);

        UserModel userModelFound = userRepository.getOne(accountModelFound.getUser().getId());
        User user = new User(userModelFound.getId(), userModelFound.getFirstname(), userModelFound.getLastname());

        return new Account(accountModelFound.getId(), accountModelFound.getMoney(), user);
    }

    public Account create(AccountToCreate accountToCreate) {
        UserModel userModel = userRepository.getOne(accountToCreate.user.id);
        AccountModel accountModelToCreate = new AccountModel(accountToCreate.money, userModel);

        AccountModel accountModelCreated = accountRepository.save(accountModelToCreate);

        User user = new User(userModel.getId(), userModel.getFirstname(), userModel.getLastname());

        return new Account(accountModelCreated.getId(), accountModelCreated.getMoney(), user);
    }

}
