package org.cnam.sample.domain;

import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.Deposit;
import org.cnam.sample.domain.entity.DepositToCreate;
import org.cnam.sample.domain.entity.User;
import org.cnam.sample.repository.AccountRepository;
import org.cnam.sample.repository.DepositRepository;
import org.cnam.sample.repository.UserRepository;
import org.cnam.sample.repository.model.AccountModel;
import org.cnam.sample.repository.model.DepositModel;
import org.cnam.sample.repository.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DepositService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    public Deposit getById(Long id)
    {
        DepositModel depositModelFound = depositRepository.getOne(id);
        User depositaire = userService.getById(depositModelFound.getDepositaire().getId());
        Account account = accountService.getById(depositModelFound.getAccount().getId());
        return new Deposit(depositModelFound.getId(), depositModelFound.getAmount(), depositaire, account);
    }

    public DepositModel create(DepositToCreate depositToCreate)
    {
        UserModel depositaire = new UserModel(depositToCreate.depositaire.id, depositToCreate.depositaire.firstname, depositToCreate.depositaire.lastname);
        AccountModel account = new AccountModel(depositToCreate.account.id, depositToCreate.account.money, new UserModel(depositToCreate.account.user.id, depositToCreate.account.user.firstname, depositToCreate.account.user.lastname));

        DepositModel depositCreated =  depositRepository.save(new DepositModel(depositToCreate.amount, depositaire, account));
        return depositCreated;
    }

    public DepositModel update(Deposit depositToUpdate, Long amount, User depositaire, Account account)
    {
        UserModel depositaireModel = new UserModel(depositaire.id, depositaire.firstname, depositaire.lastname);
        AccountModel accountModel = new AccountModel(account.id, account.money, new UserModel(depositToUpdate.account.user.id, depositToUpdate.account.user.firstname, depositToUpdate.account.user.lastname));
        DepositModel depositModelToUpdate = new DepositModel(depositToUpdate.id, amount, depositaireModel, accountModel);
        DepositModel depositModelUpdated = depositRepository.save(depositModelToUpdate);
        return depositModelUpdated;
    }

    public void delete(Deposit depositToDelete)
    {
        UserModel depositaire = new UserModel(depositToDelete.depositaire.id, depositToDelete.depositaire.firstname, depositToDelete.depositaire.lastname);
        AccountModel account = new AccountModel(depositToDelete.account.id, depositToDelete.account.money, new UserModel(depositToDelete.account.user.id, depositToDelete.account.user.firstname, depositToDelete.account.user.lastname));
        DepositModel depositModel = new DepositModel(depositToDelete.id, depositToDelete.amount, depositaire, account);
        depositRepository.delete(depositModel);
    }
}
