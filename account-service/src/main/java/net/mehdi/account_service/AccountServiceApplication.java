package net.mehdi.account_service;

import net.mehdi.account_service.clients.CustomerRestClient;
import net.mehdi.account_service.entities.BankAccount;
import net.mehdi.account_service.enums.AccountType;
import net.mehdi.account_service.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository accountRepository, CustomerRestClient customerRestClient){
		return args -> {
			customerRestClient.allCustomers().forEach(c->{
				BankAccount bankAccount1 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(19800)
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(c.getId())
						.build();
				BankAccount bankaccount2 = BankAccount.builder().accountId(UUID.randomUUID().toString())
						.currency("USD")
						.balance(8200)
						.type(AccountType.SAVING_ACCOUNT)
						.customerId(c.getId())
						.build();
				accountRepository.save(bankAccount1);
				accountRepository.save(bankaccount2);
			});
		};
		}
	}

