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
    AccountService sampleService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AccountResponse> getSample(@PathVariable("id") long id) {
        Account accountFound = sampleService.getById(id);

        AccountResponse accountResponse = new AccountResponse(accountFound.id, accountFound.data);

        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<AccountResponse> createSample(@RequestBody AccountToCreateRequest accountToCreateRequest) {
        AccountToCreate accountToCreate = new AccountToCreate(accountToCreateRequest.data);

        Account accountCreated = sampleService.create(accountToCreate);

        AccountResponse accountResponse = new AccountResponse(accountCreated.id, accountCreated.data);

        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

}
