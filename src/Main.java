import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("ДЗ 5.5");
        System.out.println("Написать генератор блатных автомобильных номеров и реализовать поиск элементов в списке прямым перебором, бинарным поиском, поиском с помощью HashSet и с помощью TreeSet. \nИзмерить и сравнить длительность 4-х видов поиска и написать результат в качестве решения домашнего задания.");

        //формат номера А111АА197
        //буквы: ABEKMHOPCTYX

        String letters= "ABCEHKMOPTXY";
        String number = "";

        ArrayList<String> list = new ArrayList<>();
        for (int firstLetterIndex = 0; firstLetterIndex < letters.length(); firstLetterIndex++){
            for (int j = 1; j <= 9; j++){
                for (int regionIndex = 1; regionIndex <= 197; regionIndex++) {
                    for (int secondLetterIndex = 0; secondLetterIndex < letters.length(); secondLetterIndex++) {
                        for (int thirdLetterIndex = 0; thirdLetterIndex < letters.length(); thirdLetterIndex++) {
                            number = letters.charAt(firstLetterIndex) + Integer.toString(j * 111) + letters.charAt(secondLetterIndex) + letters.charAt(thirdLetterIndex) + Integer.toString(regionIndex);
                            list.add(number);
                        }
                    }
                }
            }
        }

        System.out.println("Список сгенерирован");

        HashSet<String> set = new HashSet<>();
        set.addAll(list);

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.addAll(list);


        Scanner scanner = new Scanner(System.in);
        for (;;){

            System.out.println("Введите номер: ");
            String inputLine = scanner.nextLine();

            long start = System.nanoTime();
            if (list.contains(inputLine)) {
                long duration = System.nanoTime() - start;
                System.out.println("Элемент найден");
                System.out.println("Время прямого поиска: " + duration);
            } else {
                System.out.println("Элемент не найден.");
            }

            start = System.nanoTime();
            int result = Collections.binarySearch(list, inputLine);
            if (result == -1){
                System.out.println("Элемент не найден.");
            } else {
                long duration = System.nanoTime() - start;
                System.out.println("Элемент найден");
                System.out.println("Время бинарного поиска: " + duration);
            }

            start = System.nanoTime();
            if (set.contains(inputLine)){
            long duration = System.nanoTime() - start;
            System.out.println("Элемент найден");
            System.out.println("Время поиска по HashSet: " + duration);
            } else {
            System.out.println("Элемент не найден.");
            }

            start = System.nanoTime();
            if (treeSet.contains(inputLine)) {
                long duration = System.nanoTime() - start;
                System.out.println("Элемент найден");
                System.out.println("Время поиска по TreeSet: " + duration);
            } else {
                System.out.println("Элемент не найден.");
            }

        }

    }
}
