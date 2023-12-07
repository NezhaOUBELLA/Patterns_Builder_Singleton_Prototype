package org.example;

import org.example.enums.AccountStatus;
import org.example.enums.AccountType;
import org.example.model.BankAccount;
import org.example.model.Customer;

public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        BankAccount account1 = new BankAccount();
        account1.setAccountId(1L);
        account1.setCurrency("MAD");
        account1.setBalance(1000);
        account1.setType(AccountType.CURRENT_ACCOUNT);
        account1.setStatus(AccountStatus.ACTIVATED);
        account1.setCustomer(new Customer(1L, "Nezha"));

        BankAccount account2 = account1.clone();


        System.out.println("ACC1 = "+account1);
        System.out.println("ACC2 = "+account2);

        account1.setBalance(8888);
        System.out.println("ACC1 = "+account1.getBalance());
        System.out.println("ACC2 = "+account2.getBalance());

        System.out.println("****************");
        account1.getCustomer().setName("Niz Niz");
        System.out.println("ACC1 = "+account1);
        System.out.println("ACC2 = "+account2);
    }
}
