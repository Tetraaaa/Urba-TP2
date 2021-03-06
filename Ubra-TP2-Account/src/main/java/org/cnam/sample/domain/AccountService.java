package org.cnam.sample.domain;

import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.AccountResult;
import org.cnam.sample.domain.entity.AccountToCreate;
import org.cnam.sample.repository.AccountRepository;
import org.cnam.sample.repository.model.AccountModel;
import org.cnam.sample.repository.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserService userService;

    public Account getById(Long id) {
        Optional<AccountModel> accountModelFound = accountRepository.findById(id);
        if(!accountModelFound.isPresent()) return null;

        AccountModel modelFound = accountModelFound.get();
        return new Account(modelFound.getId(), modelFound.getMoney(), userService.getById(modelFound.getUser().getId()));
    }

    public AccountResult create(AccountToCreate accountToCreate) {
        if(accountToCreate.user != null && accountToCreate.money != null)
        {
            UserModel userModel = new UserModel(accountToCreate.user);
            AccountModel accountModelToCreate = new AccountModel(accountToCreate.money, userModel);

            AccountModel accountModelCreated = accountRepository.save(accountModelToCreate);

            return new AccountResult(true, accountModelCreated.getId(), accountModelCreated.getMoney(), userService.getById(userModel.getId()));
        }
        else
        {
            return new AccountResult(false, null, accountToCreate.money, accountToCreate.user);
        }


    }

    public Account update(Account accountToUpdate, Long money, Long userId) {
        AccountModel accountModelToUpdate = new AccountModel(accountToUpdate.id, money, new UserModel(userService.getById(userId)));

        AccountModel accountModelUpdated = accountRepository.save(accountModelToUpdate);

        return new Account(accountModelUpdated.getId(), accountModelUpdated.getMoney(), userService.getById(accountModelUpdated.getUser().getId()));
    }

    public void delete(Account accountToDelete) {
        UserModel userModel = new UserModel(accountToDelete.user);

        AccountModel accountModelToDelete = new AccountModel(accountToDelete.id, accountToDelete.money, userModel);

        accountRepository.delete(accountModelToDelete);
    }

    public AccountResult ouvrirCompte(Long userId) {
        User user = userService.getById(userId);
        if(userService.userExists(user)) {
            UserModel userModel = new UserModel(user);
            AccountModel accountModelToCreate = new AccountModel(0L, userModel);

            AccountModel accountModelCreated = accountRepository.save(accountModelToCreate);
            return new AccountResult(true, accountModelCreated.getId(), accountModelCreated.getMoney(), userService.getById(accountModelCreated.getUser().getId()));
        } else {
            return new AccountResult(false, null, 0L, user);
        }
    }

    public boolean accountExists(Account account)
    {
        return account != null;
    }

    public void crediterCompte(Long amount, Account account)
    {
        account.money += amount;
    }
}
