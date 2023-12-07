package org.example;

import org.example.enums.AccountType;
import org.example.model.BankAccount;
import org.example.repository.AccountRepositoryImpl;
import org.example.util.JsonSerializer;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();
        AccountRepositoryImpl accountRepository = AccountRepositoryImpl.getInstance();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                accountRepository.populateData();
            }).start();
        }
        System.out.print("Tape a character : ");
        System.in.read();



        List<BankAccount> bankAccounts = accountRepository
                .searchAccounts(account -> account.getType().equals(AccountType.CURRENT_ACCOUNT));
        bankAccounts.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);
        System.out.println("====================");

    }
}