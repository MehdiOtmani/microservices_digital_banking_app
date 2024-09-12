package net.mehdi.account_service.entities;

import jakarta.persistence.*;
import lombok.*;
import net.mehdi.account_service.enums.AccountType;
import net.mehdi.account_service.model.Customer;

import java.time.LocalDate;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;

}
