package geekbrains.lesson_3.guess_number;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ваша задача - угадать число");


        int[] levels = new int[]{ 3, 4, 5 };

        for (int level = 0; level < levels.length; level++) {
            guess(scanner, levels[level]);
        }

        scanner.close();
    }

    public static void guess(Scanner scanner,  int range) {
        System.out.println("Угадайте число от 0 до " + range);

        int number = (int)(Math.random() * range);

        while (true) {
            int input = scanner.nextInt();

            if (input == number) {
                System.out.println("Вы угадали");
                break;
            }

            else if (input <= number) System.out.println("Введеное число меньше загаданного.");

            else System.out.println("Введеное число больше загаданного.");
        }
    }
}
