import java.util.InputMismatchException;
import java.util.Scanner;

/* Задача 1:
Напишите программу, которая запрашивает у пользователя число и проверяет, является ли оно 
положительным. Если число отрицательное или равно нулю, программа должна выбрасывать 
исключение InvalidNumberException с сообщением "Некорректное число". В противном случае, программа должна выводить сообщение "Число корректно". */  

public class Task1 {
    /**
     * Метод для запуска приложения
     * @param arg
     * @throws InvalidNumberException
     */
    public static void main(String arg[]) throws InvalidNumberException {
        System.out.print("Введите число: ");
        try {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            if(number <= 0 ) throw new InvalidNumberException("Некорректное число");
            else System.out.print("Число корректно");
        }
        catch (InputMismatchException e) {
            throw new NotFormatFiteException("Неверный ввод. Попробуйте еще раз.");
        }
    }
}

class InvalidNumberException extends Exception{
    /**
     * Исключение для проверки корректности числа
     * @param message
     */
    public InvalidNumberException(String message) {
        super(message);
    }
}


