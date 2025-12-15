package com.accounts.controller;

import com.accounts.constants.AccountsConstants;
import com.accounts.dto.CustomerDto;
import com.accounts.dto.ResponseDto;
import com.accounts.service.AccountsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountsController {

    private AccountsService accountsService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        accountsService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseDto.builder()
                        .statusCode(AccountsConstants.STATUS_201)
                        .statusMsg("Account created successfully")
                        .build());
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountsService.updateAccount(customerDto);
        if (!isUpdated) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseDto.builder()
                            .statusCode(AccountsConstants.STATUS_417)
                            .statusMsg("Account update failed")
                            .build());
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ResponseDto.builder()
                            .statusCode(AccountsConstants.STATUS_200)
                            .statusMsg("Account updated successfully")
                            .build());
        }
    }

    @DeleteMapping("/delete/{mobileNumber}")
    public ResponseEntity<ResponseDto> deleteAccount(@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
                                                     String mobileNumber) {
        boolean isDeleted=accountsService.deleteAccount(mobileNumber);
        if (isDeleted){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ResponseDto.builder()
                            .statusCode(AccountsConstants.STATUS_200)
                            .statusMsg("Account deleted successfully")
                            .build());

        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseDto.builder()
                            .statusCode(AccountsConstants.STATUS_417)
                            .statusMsg("Account deletion failed")
                            .build());
        }
        }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<CustomerDto>> fetchAccount() {
        List<CustomerDto> list = accountsService.fetchAllAccounts();
        return ResponseEntity.status(HttpStatus.OK)
                .body(list);
    }

    @GetMapping("/fetch/{mobileNumber}")
    public ResponseEntity<CustomerDto> fetchAccount(@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
                                                    String mobileNumber) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountsService.fetchAccount(mobileNumber));
    }
}
