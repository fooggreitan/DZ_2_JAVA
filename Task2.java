
/* 
Задача 2:
Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление. Если второе число равно нулю, программа 
должна выбрасывать исключение DivisionByZeroException с сообщением "Деление на ноль недопустимо". В противном случае, программа должна выводить результат деления.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    /**
     * Метод для запуска приложения
     * @param args
     * @throws DivisionByZeroException
     */
    public static void main(String[] args) throws DivisionByZeroException {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();

            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();

            if (num2 == 0) throw new DivisionByZeroException("Деление на ноль недопустимо");

            System.out.print("Результат: " + num1/num2);
        } catch (InputMismatchException e) {
            throw new NotFormatFiteException("Неверный ввод. Попробуйте еще раз.");
        }
    }
}

class DivisionByZeroException extends Exception {
    /**
     * Исключение для проверки деления на ноль
     * @param message
     */
    public DivisionByZeroException(String message) {
        super(message);
    }
}

class NotFormatFiteException extends InputMismatchException {
   /**
    * Исключение для проверки написанного значения
     * @param message
     */
     public NotFormatFiteException(String message) {
        super(message);
    }
}