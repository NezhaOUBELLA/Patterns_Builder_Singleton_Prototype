package org.example;

import org.example.enums.AccountType;
import org.example.model.BankAccount;
import org.example.repository.AccountRepositoryImpl;
import org.example.util.JsonSerializer;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();
        AccountRepositoryImpl accountRepository = AccountRepositoryImpl.getInstance();
        //accountRepository.populateData();
        List<BankAccount> bankAccounts = accountRepository
                .searchAccounts(account -> account.getType().equals(AccountType.CURRENT_ACCOUNT));
        bankAccounts.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);
        System.out.println("====================");
        BankAccount account = accountRepository.findById(1L).orElse(null);
        if(account!=null){
            System.out.println(bankAccountJsonSerializer.toJson(account));
        }
    }
}