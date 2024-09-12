package net.mehdi.account_service.web;

import net.mehdi.account_service.clients.CustomerRestClient;
import net.mehdi.account_service.entities.BankAccount;
import net.mehdi.account_service.model.Customer;
import net.mehdi.account_service.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepository accountRepository;
    private CustomerRestClient customerRestClient;
    public   AccountRestController(BankAccountRepository accountRepository,CustomerRestClient customerRestClient){
        this.accountRepository=accountRepository;
        this.customerRestClient=customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        List<BankAccount> accountList=accountRepository.findAll();
        accountList.forEach(acc->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });

        return accountList ;

    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount account=accountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return account;
    }
}
