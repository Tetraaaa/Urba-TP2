package org.cnam.sample.domain;

import org.cnam.sample.domain.entity.*;
import org.cnam.sample.repository.AccountRepository;
import org.cnam.sample.repository.DepositRepository;
import org.cnam.sample.repository.UserRepository;
import org.cnam.sample.repository.WithdrawalRepository;
import org.cnam.sample.repository.model.AccountModel;
import org.cnam.sample.repository.model.DepositModel;
import org.cnam.sample.repository.model.UserModel;
import org.cnam.sample.repository.model.WithdrawalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class WithdrawalService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    public Withdrawal getById(Long id)
    {
        WithdrawalModel withdrawalModelFound = withdrawalRepository.getOne(id);
        User beneficiaire = userService.getById(withdrawalModelFound.getBeneficiaire().getId());
        Account account = accountService.getById(withdrawalModelFound.getAccount().getId());
        return new Withdrawal(withdrawalModelFound.getId(), withdrawalModelFound.getAmount(), beneficiaire, account);
    }

    public WithdrawalModel create(WithdrawalToCreate withdrawalToCreate)
    {
        UserModel beneficiaire = new UserModel(withdrawalToCreate.beneficiaire.id, withdrawalToCreate.beneficiaire.firstname, withdrawalToCreate.beneficiaire.lastname);
        AccountModel account = new AccountModel(withdrawalToCreate.account.id, withdrawalToCreate.account.money, new UserModel(withdrawalToCreate.account.user.id, withdrawalToCreate.account.user.firstname, withdrawalToCreate.account.user.lastname));

        WithdrawalModel withdrawalCreated =  withdrawalRepository.save(new WithdrawalModel(withdrawalToCreate.amount, beneficiaire, account));
        return withdrawalCreated;
    }

    public WithdrawalModel update(Withdrawal withdrawalToUpdate, Long amount, User beneficiaire, Account account)
    {
        UserModel beneficiaireModel = new UserModel(beneficiaire.id, beneficiaire.firstname, beneficiaire.lastname);
        AccountModel accountModel = new AccountModel(account.id, account.money, new UserModel(withdrawalToUpdate.account.user.id, withdrawalToUpdate.account.user.firstname, withdrawalToUpdate.account.user.lastname));
        WithdrawalModel withdrawalModelToUpdate = new WithdrawalModel(withdrawalToUpdate.id, amount, beneficiaireModel, accountModel);
        WithdrawalModel withdrawalModelUpdated = withdrawalRepository.save(withdrawalModelToUpdate);
        return withdrawalModelUpdated;
    }

    public void delete(Withdrawal withdrawalToDelete)
    {
        UserModel beneficiaire = new UserModel(withdrawalToDelete.beneficiaire.id, withdrawalToDelete.beneficiaire.firstname, withdrawalToDelete.beneficiaire.lastname);
        AccountModel account = new AccountModel(withdrawalToDelete.account.id, withdrawalToDelete.account.money, new UserModel(withdrawalToDelete.account.user.id, withdrawalToDelete.account.user.firstname, withdrawalToDelete.account.user.lastname));
        WithdrawalModel withdrawalModel = new WithdrawalModel(withdrawalToDelete.id, withdrawalToDelete.amount, beneficiaire, account);
        withdrawalRepository.delete(withdrawalModel);
    }
}
