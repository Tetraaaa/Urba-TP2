package org.cnam.sample.controller;

import org.cnam.sample.controller.dto.AccountToCreateRequest;
import org.cnam.sample.controller.dto.AccountResponse;
import org.cnam.sample.domain.AccountService;
import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.AccountToCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AccountResponse> getAccount(@PathVariable("id") Long id) {
        Account accountFound = accountService.getById(id);

        AccountResponse accountResponse = new AccountResponse(accountFound.id, accountFound.money);

        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountToCreateRequest accountToCreateRequest) {
        AccountToCreate accountToCreate = new AccountToCreate(accountToCreateRequest.money);

        Account accountCreated = accountService.create(accountToCreate);

        AccountResponse accountResponse = new AccountResponse(accountCreated.id, accountCreated.money);

        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

}
