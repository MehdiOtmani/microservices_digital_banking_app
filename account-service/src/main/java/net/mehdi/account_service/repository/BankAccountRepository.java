package net.mehdi.account_service.repository;

import net.mehdi.account_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository  extends JpaRepository<BankAccount,String>
{

}
