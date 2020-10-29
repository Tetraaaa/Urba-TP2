package org.cnam.sample.controller;

import org.cnam.sample.controller.dto.DepositResponse;
import org.cnam.sample.controller.dto.DepositToCreateRequest;
import org.cnam.sample.controller.dto.WithdrawalResponse;
import org.cnam.sample.controller.dto.WithdrawalToCreateRequest;
import org.cnam.sample.domain.AccountService;
import org.cnam.sample.domain.DepositService;
import org.cnam.sample.domain.UserService;
import org.cnam.sample.domain.WithdrawalService;
import org.cnam.sample.domain.entity.Deposit;
import org.cnam.sample.domain.entity.DepositToCreate;
import org.cnam.sample.domain.entity.Withdrawal;
import org.cnam.sample.domain.entity.WithdrawalToCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/withdrawal")
public class WithdrawalController {

    @Autowired
    WithdrawalService withdrawalService;

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<WithdrawalResponse> getWithdrawal(@PathVariable("id") Long id) {
        Withdrawal withdrawalFound = withdrawalService.getById(id);

        WithdrawalResponse withdrawalResponse = new WithdrawalResponse(withdrawalFound.id, withdrawalFound.amount, withdrawalFound.beneficiaire, withdrawalFound.account);

        return new ResponseEntity<>(withdrawalResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<WithdrawalResponse> createWithdrawal(@RequestBody WithdrawalToCreateRequest withdrawalToCreateRequest) {
        WithdrawalToCreate withdrawalToCreate = new WithdrawalToCreate(withdrawalToCreateRequest.amount, withdrawalToCreateRequest.beneficiaire, withdrawalToCreateRequest.account);

        Withdrawal withdrawalCreated = withdrawalService.create(withdrawalToCreate);

        WithdrawalResponse withdrawalResponse = new WithdrawalResponse(withdrawalCreated.id, withdrawalCreated.amount, withdrawalCreated.beneficiaire, withdrawalCreated.account);

        return new ResponseEntity<>(withdrawalResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<WithdrawalResponse> updateWithdrawal(@PathVariable("id") Long id, @PathParam("amount") Long amount, @PathParam("beneficiaireId") Long beneficiaireId, @PathParam("accountId") Long accountId) {
        Withdrawal withdrawalFound = withdrawalService.getById(id);

        Withdrawal withdrawalUpdated = withdrawalService.update(withdrawalFound, amount, userService.getById(beneficiaireId), accountService.getById(accountId));

        WithdrawalResponse withdrawalResponse = new WithdrawalResponse(withdrawalUpdated.id, withdrawalUpdated.amount, withdrawalUpdated.beneficiaire, withdrawalUpdated.account);

        return new ResponseEntity<>(withdrawalResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity deleteWithdrawal(@PathVariable("id") Long id) {
        Withdrawal withdrawalFound = withdrawalService.getById(id);

        withdrawalService.delete(withdrawalFound);

        return ResponseEntity.ok().build();
    }
}
