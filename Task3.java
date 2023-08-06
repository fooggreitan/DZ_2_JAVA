
/* 
Задача 3:
    Напишите программу, которая запрашивает у пользователя три числа и выполняет следующие проверки:
    Если первое число больше 100, выбросить исключение NumberOutOfRangeException с сообщением "Первое число вне допустимого диапазона".
    Если второе число меньше 0, выбросить исключение NumberOutOfRangeException с сообщением "Второе число вне допустимого диапазона".
    Если сумма первого и второго чисел меньше 10, выбросить исключение NumberSumException с сообщением "Сумма первого и второго чисел слишком мала".
    Если третье число равно 0, выбросить исключение DivisionByZeroException с сообщением "Деление на ноль недопустимо".
    
    В противном случае, программа должна выводить сообщение "Проверка пройдена успешно".
    - необходимо создать 3 класса собвстенных исключений 
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    /**
     * Метод для запуска приложения
     * @param args
     * @throws NumberOutOfRangeException
     * @throws NumberSumException
     * @throws DivisionByZeroException
     */
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            float num1 = scanner.nextFloat();  
            InputOne(num1);
            
            System.out.print("Введите второе число: ");
            float num2 = scanner.nextFloat();  
            InputTwo(num1, num2);
            
            System.out.print("Введите третье число: ");
            float num3 = scanner.nextFloat();  
            InputThree(num3);
            
            System.out.print("Проверка пройдена успешно");
        }
        catch (InputMismatchException e) {
            throw new NotFormatFiteException("Неверный ввод. Попробуйте еще раз.");
        } catch (NumberOutOfRangeException e) {
            e.printStackTrace();
        } catch (NumberSumException e) {
            e.printStackTrace();
        } catch (DivisionByZeroException e) {
            e.printStackTrace();
        }
    }

    public static float InputOne(float num1) throws NumberOutOfRangeException {
        if(num1 > 100) throw new NumberOutOfRangeException("Первое число вне допустимого диапазона"); 
        return num1;
    }
    public static float InputTwo(float num1, float num2) throws NumberOutOfRangeException, NumberSumException {
        if(num2 < 0) throw new NumberOutOfRangeException("Второе число вне допустимого диапазона"); 
        else if (num1 + num2 < 10) throw new NumberSumException("Сумма первого и второго чисел слишком мала");
        return num2;
    }
    public static float InputThree(float num3) throws NumberOutOfRangeException, DivisionByZeroException {
        if(num3 == 0) throw new DivisionByZeroException("Деление на ноль недопустимо"); 
        return num3;
    }

}

class NumberOutOfRangeException extends Exception {
    /**
     * Исключение для проверки диапозона числа
     * @param message
     */
    public NumberOutOfRangeException(String message) {
        super(message);
    }
}

class NumberSumException extends Exception {
    /**
     * Исключение для проверки суммы первого и второго чисела
     * @param message
     */
    public NumberSumException(String message) {
        super(message);
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