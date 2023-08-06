package Task4;

import java.util.HashMap;

public class BankAccount {

    /**
     * Коллекция для хранения индитификаторов
     */
    private static HashMap<Integer, Bank> accounts = new HashMap<>();

    /**
     * Метод для создания аккаунта
     * @param accountId
     * @param maxBalance
     */
    public synchronized static void addAccount(int accountId, float maxBalance) {
        Bank account = new Bank(accountId);
        accounts.put(accountId, account);
        System.out.printf("Создана новая учетная запись с идентификатором %d и балансом 0\n", accountId);
    }

    /**
     * Метод для зачисления средств на индитификатор
     * @param accountId
     * @param amount
     * @throws MaxBalanceExceededException
     */
    public synchronized static void deposit(int accountId, float amount) throws MaxBalanceExceededException {
        Bank account = accounts.get(accountId);
        account.deposit(amount);
    }

    /**
     * Метод для перевода средств из индитификатора
     * @param accountId
     * @param amount
     * @throws InsufficientFundsException
     */
    public synchronized static void withdraw(int accountId, float amount) throws InsufficientFundsException {
        Bank account = accounts.get(accountId);
        account.withdraw(amount);
    }
}
