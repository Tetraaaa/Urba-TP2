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
    private UserService userService;

    public Account getById(Long id) {
        AccountModel accountModelFound = accountRepository.getOne(id);

        return new Account(accountModelFound.getId(), accountModelFound.getMoney(), userService.getById(accountModelFound.getUser().getId()));
    }

    public Account create(AccountToCreate accountToCreate) {
        UserModel userModel = new UserModel(accountToCreate.user);
        AccountModel accountModelToCreate = new AccountModel(accountToCreate.money, userModel);

        AccountModel accountModelCreated = accountRepository.save(accountModelToCreate);

        return new Account(accountModelCreated.getId(), accountModelCreated.getMoney(), userService.getById(userModel.getId()));
    }

    public Account update(Account accountToUpdate, Long money, Long userId) {
        AccountModel accountModelToUpdate = new AccountModel(accountToUpdate.id, money, new UserModel(userService.getById(userId)));

        AccountModel accountModelUpdated = accountRepository.save(accountModelToUpdate);

        return new Account(accountModelUpdated.getId(), accountModelUpdated.getMoney(), userService.getById(accountModelUpdated.getUser().getId()));
    }

}
