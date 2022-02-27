package by.ivankov.msvcaccounts.controller;

import by.ivankov.msvcaccounts.dto.AccountDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Collections.emptyList;

/**
 * @author al.ivankov
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {


    @GetMapping
    public List<AccountDto> getAllAccounts(){
        return emptyList();
    }

}
