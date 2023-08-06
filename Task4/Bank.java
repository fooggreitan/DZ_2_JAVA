package Task4;

import java.text.DecimalFormat;
import java.util.Random;

class Bank implements Runnable {

    private int accountId;
    private float balance;
    private Random rnd = new Random();

    /**
     * Метод для сохранения индетификатора
     * @param accountId
     * @param maxBalance
     */
    public Bank(int accountId) {
        this.accountId = accountId;
    }

    /**
     * Метод для осуществления начисления денег
     * @param amount
     * @throws MaxBalanceExceededException
     */
    public synchronized void deposit(float amount) throws MaxBalanceExceededException {
        DecimalFormat df = new DecimalFormat("0.00");
        if (balance + amount > 20000) {
            throw new MaxBalanceExceededException("Сумма депозита превышает максимальный баланс");
        }
        balance += amount;
        System.out.printf("Депозит %s успешно. Новый баланс для счета %d: %s руб\n", df.format(amount), accountId, df.format(balance));
    }

    /**
     * Метод для осуществления перевода денег
     * @param amount
     * @throws InsufficientFundsException
     */
    public synchronized void withdraw(float amount) throws InsufficientFundsException {
        DecimalFormat df = new DecimalFormat("0.00");
        if (balance < amount) {
            throw new InsufficientFundsException("Сумма вывода превышает доступный баланс");
        }
        balance -= amount;
        System.out.printf("Вывод %s выполнен успешно. Новый баланс для аккаунта %d: %s руб\n", df.format(amount), accountId, df.format(balance));
    }

    public void run() {
        int accountId = rnd.nextInt(100);
        float maxBalance = rnd.nextInt(20000);
        BankAccount.addAccount(accountId, maxBalance);
        try {
            BankAccount.deposit(accountId, rnd.nextFloat(40000));
            BankAccount.withdraw(accountId, rnd.nextFloat(5000));
        } catch (InsufficientFundsException | MaxBalanceExceededException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

// import java.util.Scanner;

// public class Bank {
//     private BankAccount[] accounts;

//     public Bank() {
//         accounts = new BankAccount[5]; // Assuming we have 5 accounts
//     }

//     public void createAccount() {
//         for (int i = 0; i < accounts.length; i++) {
//             if (accounts[i] == null) {
//                 accounts[i] = new BankAccount();
//                 System.out.println("Создан новый счет с номером: " + i);
//                 return;
//             }
//         }
//         System.out.println("Невозможно создать новый счет. Достигнуто максимальное количество счетов.");
//     }

//     public void showAccounts() {
//         for (int i = 0; i < accounts.length; i++) {
//             if (accounts[i] != null) {
//                 System.out.println("Счет " + i + ": Баланс - " + accounts[i].getBalance()  + " РУБ");
//             }
//         }
//     }

//     public void send() throws MaxBalanceExceededException {
//         System.out.print("Введите номер счета: ");
//         Scanner scanner = new Scanner(System.in);
//         int accountNumber = scanner.nextInt();

//         if (accountNumber < 0 || accountNumber >= accounts.length || accounts[accountNumber] == null) {
//             System.out.println("Неверный номер счета.");
//             return;
//         }

//         System.out.print("Введите сумму отправки: ");
//         int amount = scanner.nextInt();

//         accounts[accountNumber].deposit(amount);
//         System.out.println("Транзакция завершена. Баланс счета " + accountNumber + ": " + accounts[accountNumber].getBalance() + " РУБ");
//     }

//     public void unsend() throws InsufficientFundsException {
//         System.out.print("Введите номер счета: ");
//         Scanner scanner = new Scanner(System.in);
//         int accountNumber = scanner.nextInt();

//         if (accountNumber < 0 || accountNumber >= accounts.length || accounts[accountNumber] == null) {
//             System.out.println("Неверный номер счета.");
//             return;
//         }

//         System.out.print("Введите сумму списания: ");
//         int amount = scanner.nextInt();

//         accounts[accountNumber].withdraw(amount);
//         System.out.println("Транзакция завершена. Баланс счета " + accountNumber + ": " + accounts[accountNumber].getBalance()  + " РУБ");
//     }

//     public void showBalance() {
//         System.out.print("Введите номер счета: ");
//         Scanner scanner = new Scanner(System.in);
//         int accountNumber = scanner.nextInt();

//         if (accountNumber < 0 || accountNumber >= accounts.length || accounts[accountNumber] == null) {
//             System.out.println("Неверный номер счета.");
//             return;
//         }

//         System.out.println("Баланс счета " + accountNumber + ": " + accounts[accountNumber].getBalance()  + " РУБ");
//     }
// }
