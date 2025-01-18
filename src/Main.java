import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ////// Выбор короче
        System.out.println("Оберіть номер завдання (1-12):");
        int taskNumber = scanner.nextInt();

        switch (taskNumber) {
            case 1:
                task1(scanner);
                break;
            case 2:
                task2(scanner);
                break;
            case 3:
                task3(scanner);
                break;
            case 4:
                task4(scanner);
                break;
            case 5:
                task5();
                break;
            case 6:
                task6(scanner);
                break;
            case 7:
                task7();
                break;
            case 8:
                task8(scanner);
                break;
            case 9:
                task9(scanner);
                break;
            case 10:
                task10();
                break;
            case 11:
                task11(scanner);
                break;
            case 12:
                task12();
                break;
            default:
                System.out.println("Неправильний номер завдання!");
        }
    }

    ////  1
    private static void task1(Scanner scanner) {
        System.out.println("Введіть перше число:");
        int num1 = scanner.nextInt();

        System.out.println("Введіть друге число:");
        int num2 = scanner.nextInt();

        System.out.println("Введіть третє число:");
        int num3 = scanner.nextInt();

        String resultStr = Integer.toString(num1) + Integer.toString(num2) + Integer.toString(num3);
        int result = Integer.parseInt(resultStr);

        System.out.println("Об'єднане число: " + result);
    }

    ///// 2
    private static void task2(Scanner scanner) {
        System.out.println("Введіть значення:");
        double value = scanner.nextDouble();

        System.out.println("Введіть відсоток, який потрібно обчислити:");
        double percent = scanner.nextDouble();

        double result = (value * percent) / 100;

        System.out.println(percent + "% від " + value + " = " + result);
    }

    ///// 3
    private static void task3(Scanner scanner) {
        System.out.println("Введіть шестизначне число:");
        String input = scanner.next();

        if (input.length() != 6 || !input.matches("\\d+")) {
            System.out.println("Помилка: введіть коректне шестизначне число!");
            return;
        }

        char[] digits = input.toCharArray();
        swap(digits, 0, 5);
        swap(digits, 1, 4);

        String result = new String(digits);
        System.out.println("Результат: " + result);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /// 4
    private static void task4(Scanner scanner) {
        System.out.println("Введіть номер місяця (1-12):");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Помилка: місяць має бути в діапазоні 1..12!");
            return;
        }

        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("Winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Autumn");
                break;
        }
    }

    //// 5
    private static void task5() {
        int[] arr = {2, 5, 1, 9, 3, 0, 10, 7};
        int minIndex = 0, maxIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) minIndex = i;
            if (arr[i] > arr[maxIndex]) maxIndex = i;
        }

        int start = Math.min(minIndex, maxIndex);
        int end = Math.max(minIndex, maxIndex);

        for (int i = start + 1; i < end; i++) {
            arr[i] *= 2;
        }

        System.out.println("Масив після обробки: " + Arrays.toString(arr));
    }

    ///// 6
    private static void task6(Scanner scanner) {
        System.out.println("Введіть перше число діапазону:");
        int start = scanner.nextInt();

        System.out.println("Введіть друге число діапазону:");
        int end = scanner.nextInt();

        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        System.out.println("Непарні числа в діапазоні:");
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
    }

    //////// 7
    private static void task7() {
        int[] arr = new Random().ints(20, -10, 11).toArray();
        int negative = 0, positive = 0, zeros = 0;

        for (int num : arr) {
            if (num < 0) negative++;
            else if (num > 0) positive++;
            else zeros++;
        }

        System.out.println("Масив: " + Arrays.toString(arr));
        System.out.println("Від’ємних: " + negative + ", Додатних: " + positive + ", Нулів: " + zeros);
    }

    //// 8
    private static void task8(Scanner scanner) {
        System.out.println("Чи є нова компанія? (y/n)");
        if (!scanner.next().equalsIgnoreCase("y")) {
            System.out.println("Програма завершена.");
            return;
        }

        System.out.println("На скількох осіб замовлення?");
        int peopleCount = scanner.nextInt();
        double totalOrderPrice = 0;

        String[] menuItems = {"Кава - 40 грн", "Чай - 25 грн", "Печиво - 30 грн", "Тістечко - 50 грн"};
        int[] prices = {40, 25, 30, 50};

        for (int person = 1; person <= peopleCount; person++) {
            System.out.println("Замовлення для людини №" + person);
            double personOrderSum = 0;

            while (true) {
                for (int i = 0; i < menuItems.length; i++) {
                    System.out.println((i + 1) + ". " + menuItems[i]);
                }
                System.out.println("0 - Завершити замовлення");
                int choice = scanner.nextInt();

                if (choice == 0) break;
                if (choice > 0 && choice <= menuItems.length) {
                    personOrderSum += prices[choice - 1];
                } else {
                    System.out.println("Неправильний вибір!");
                }
            }

            totalOrderPrice += personOrderSum;
        }

        System.out.println("Загальна сума: " + totalOrderPrice + " грн");
    }

    ///// 9
    private static void task9(Scanner scanner) {
        System.out.println("Оберіть спосіб заповнення масиву (1 - випадковий, 2 - вручну):");
        int choice = scanner.nextInt();

        int[][] array;
        if (choice == 1) {
            System.out.println("Введіть кількість рядків і стовпців:");
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            array = new int[rows][cols];
            Random random = new Random();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    array[i][j] = random.nextInt(21) - 10;
                }
            }
        } else {
            System.out.println("Введіть кількість рядків:");
            int rows = scanner.nextInt();
            array = new int[rows][];

            for (int i = 0; i < rows; i++) {
                System.out.println("Введіть рядок чисел через кому:");
                String[] parts = scanner.next().split(",");
                array[i] = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
            }
        }

        double[] ratios = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            int zeros = 0, nonZeros = 0;
            for (int num : array[i]) {
                if (num == 0) zeros++;
                else nonZeros++;
            }
            ratios[i] = (double) zeros / (nonZeros == 0 ? 1 : nonZeros);
        }

        System.out.println("Результат: " + Arrays.toString(ratios));
    }

    ///// 10
    private static void task10() {
        int[] arr = new Random().ints(20, -10, 11).toArray();
        System.out.println("Вихідний масив: " + Arrays.toString(arr));

        int[][] result = new int[4][];
        result[0] = Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
        result[1] = Arrays.stream(arr).filter(x -> x % 2 != 0).toArray();
        result[2] = Arrays.stream(arr).filter(x -> x < 0).toArray();
        result[3] = Arrays.stream(arr).filter(x -> x > 0).toArray();

        for (int i = 0; i < result.length; i++) {
            System.out.println("Рядок " + (i + 1) + ": " + Arrays.toString(result[i]));
        }
    }

    ///// 11
    private static void task11(Scanner scanner) {
        System.out.println("Введіть початок діапазону:");
        int start = scanner.nextInt();
        System.out.println("Введіть кінець діапазону:");
        int end = scanner.nextInt();

        long sum = 0;
        for (int i = Math.min(start, end); i <= Math.max(start, end); i++) {
            sum += i;
        }

        System.out.println("Сума чисел у діапазоні: " + sum);
    }

    ////// 12
    private static void task12() {
        double[] arr = {1.2, 0.5, 7.0, 2.6, 5.0};
        System.out.println("Початковий масив: " + Arrays.toString(arr));

        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) maxIndex = i;
        }

        double[] left = Arrays.copyOfRange(arr, 0, maxIndex);
        double[] right = Arrays.copyOfRange(arr, maxIndex + 1, arr.length);

        Arrays.sort(left);
        Arrays.sort(right);
        for (int i = 0; i < right.length / 2; i++) {
            double temp = right[i];
            right[i] = right[right.length - 1 - i];
            right[right.length - 1 - i] = temp;
        }

        double[] result = new double[arr.length];
        System.arraycopy(left, 0, result, 0, left.length);
        result[left.length] = arr[maxIndex];
        System.arraycopy(right, 0, result, left.length + 1, right.length);

        System.out.println("Результат: " + Arrays.toString(result));
    }
}
