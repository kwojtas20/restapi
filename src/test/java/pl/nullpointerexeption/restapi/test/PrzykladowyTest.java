package pl.nullpointerexeption.restapi.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
class PrzykladowyTest {

    @Test
    void test1() {
        log.info("Test 1");
        PrzykladowaKlasa1 obiekt1 = new PrzykladowaKlasa1("Jakiś durny napis");
        PrzykladowaKlasa1 obiekt2 = new PrzykladowaKlasa1(
                'a',
                "Jakiś durny napis",
                2123,
                2344L,
                23.435f,
                123.3453,
                new Integer(11378),
                Integer.parseInt("34563"),
                new Long(2234L),
                Long.parseLong("123"),
                new Float(765.89f),
                Float.parseFloat("534.12"),
                new Double(123.4234),
                Double.parseDouble("5235.23423"),
                "finalnyStringZainicjalizowanyPrzezKonstruktor");

        log.info(obiekt1.napisPubliczny);
        log.info(obiekt1.getNapisPubliczny());

//        log.info(obiekt1.napisPrywatny); // Nie działa bo pole jest prywatne. Można czytac tylko przez getter
        log.info(obiekt1.getNapisPrywatny());

        log.info(PrzykladowaKlasa1.getPoleFinalne2());
        log.info(PrzykladowaKlasa1.POLE_FINALNE_2); // Nie trzeba tworzyć obiektu klasy żeby użyć pola statycznego z tej klasy
        // Metody i pola statyczne można używać bez tworzenia obiektu klasy.

        obiekt2.metodaCoNicNieZwraca();
        obiekt2.metodaCoNicNieZwracaZParametrami("dupa", 534);
        obiekt2.metodaCoCosZwraca();
        obiekt2.metodaCoCosZwracaZParametrami(4834, new PrzykladowaKlasa2());

        PrzykladowaKlasa1.metodaStatycznaCoNicNieZwraca();
        PrzykladowaKlasa1.metodaStatycznaCoNicNieZwracaZParametrami("dupaStatyczna", 54534);
        PrzykladowaKlasa1.metodaStatycznaCoCosZwraca();
        PrzykladowaKlasa1.metodaStatycznaCoCosZwracaZParametrami(9789, new PrzykladowaKlasa2());

        Assertions.assertTrue(true);
    }

    @Test
    void test2() {
        // sposób 1
        int[] array1 = new int[]{1, 2, 3, 4};

        //Wyświetl wszystkie liczby z tablicy
        for (int liczba : array1) {
            log.info(String.valueOf(liczba));
        }
    }

    @Test
    void test3() {
        // sposób 2
        int[] array2 = new int[4];
        array2[0] = 1;
        array2[1] = 2;
        array2[2] = 3;
        array2[3] = 4;

        //Wyświetl wszystkie liczby z tablicy
        for (int liczba : array2) {
            log.info(String.valueOf(liczba));
        }
    }

    @Test
    void test4() {
        String[] strings = new String[]{"a", "b", "c"};

        for (String ssss : strings) {
            log.info(ssss);
        }
    }

    @Test
    void test5() {
        float[] floats = new float[]{1.1f, 1.2f, 1.3f};

        // for ( typ i ELEMENT TABLICY: jakas tablica)
        // Wykonuje pętlę dla wszystkich elementow tablicy floats
        for (float liczba : floats) {
            log.info(String.valueOf(liczba));
        }
    }

    @Test
    void test6() {
        char[] chars = new char[]{'a', 'b', 'c'};

        for (char znak : chars) {
            log.info(String.valueOf(znak));
        }
    }

    @Test
    void test7() {
        log.info(String.valueOf(sum(7, 8))); //Wyświetlenie dodawania x i y
    }

    @Test
    void test8() {
        log.info(String.valueOf(substract(6, 2))); //Wyświetlenie odejmowania x i y
    }

    private static int sum(int x, int y) {
        // return zwraca wartość, która jest wynikiem dodawania - operator "+"
        return x + y;
    }

    private static int substract(int x, int y) {
        // return zwraca wartość, która jest wynikiem odejmowania - operator "-"
        return x - y;
    }

    @Test
        //wyświtlenie 4 tablic przy użyciu pętli for
    void test9() {
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            log.info(Arrays.toString(array));
        }
    }

    @Test
        //Pętla for
    void test10() {
        int[] array = new int[]{1, 2, 3};
        for (int i = 0; i < array.length; i = i + 2) {
            log.info(String.valueOf(array[i]));
        }
    }

    @Test
        //Pętla for zwraca liczy od o do 99
    void test11() {
        for (int licznik = 0; licznik < 100; licznik++) {
            System.out.println(licznik);
        }
    }

    @Test
        //Petla while wyświetla sie tylko gdy warunek jest spełniony
    void test12() {
        int i = 11;
        while (i < 10) {
            System.out.println(i);
            i++;
        }
    }

    @Test
        //Petla do while - wyświetla sie zawsze minimum raz
    void test13() {
        int i = 11;
        do {
            System.out.println(i);
            i++;
        }
        while (i < 10);
    }

    @Test
    void test14() {
        List<String> list = Arrays.asList("a", "aa", "b", "c", "cc", "dd", "v", "xx", "pp", "z", "e");

        List<String> collected = list.stream()
                .filter(stringZListy -> stringZListy.length() == 1)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collected);
    }

    @Test
    void test15() {
        List<String> list = Arrays.asList("a", "aa", "b", "c", "cc", "dd", "v", "xx", "pp", "z", "e");

        String collectedString = list.stream()
                .filter(stringZListy -> stringZListy.length() == 1)
                .sorted()
                .findFirst()
                .orElseThrow(RuntimeException::new);
        System.out.println(collectedString);
    }

    @Test
    void test16() {
        List<String> list = Arrays.asList("a", "aa", "b", "c", "cc", "dd", "v", "xx", "pp", "z", "e");

        String collectedNull = list.stream()
                .filter(stringZListy -> stringZListy.length() == 3)
                .sorted()
                .findFirst()
                .orElseThrow(RuntimeException::new);
        System.out.println(collectedNull);
    }

    @Test
        // użycie stream.Map - kolekcja z kolorami aut
    void test17() {
        List<Car> cars = Arrays.asList(
                new Car("Ford", "Black"),
                new Car("Toyota", "Red"),
                new Car("Nissan", "Green")
        );

        List<String> colorList = cars.stream()
//                .map(car -> car.getColor())
                .map(Car::getColor)
                .collect(Collectors.toList());
        System.out.println(colorList);
    }

    @Test
        // użycie stream.flatMap - łaczenie kilku strumieni
    void test18() {
        List<Person> personList = Arrays.asList(
                new Person("Jhon", Arrays.asList(
                        new Car("Ford", "Black"), new Car("Toyota", "Red"))
                ),
                new Person("Paul", Arrays.asList(
                        new Car("Kia", "Red"), new Car("Seat", "Yellow"))
                ),
                new Person("Sam", Arrays.asList(
                        new Car("Ford", "Black"))
                )
        );
        List<String> brandList = personList.stream()
                .flatMap(person -> person.getCars().stream())
                .map(Car::getBrand)
                .distinct() // zapewnia unikalność
                .collect(Collectors.toList());

        System.out.println(brandList);
    }

    @Test
        // użycie stream.sort oraz limit - sortuje od końca oraz pokaże jeden znak
    void test19() {
        List<String> list = Arrays.asList("a", "aa", "b", "c", "cc", "dd", "e");
        List<String> collect = list.stream()
                .sorted(Comparator.reverseOrder()) //sortowanie od końcaa
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
        // użycie stream.min oraz ship - sortuje licznby rosnąco oraz pokaże jeden licznę najmniejszą
    void test20() {
        List<Integer> list = Arrays.asList(0, 21, 2, 1, 4, 4, 5);
        Optional<Integer> collect = list.stream()
                .skip(1)
                .min(Comparator.naturalOrder());
        System.out.println(collect.get());
    }

    @Test
        // użycie stream.findFirst oraz filter - wyświetli liczby wieksze od 10 oraz pokaże pierwszą liczbę
    void test21() {
        List<Integer> list = Arrays.asList(0, 9, 2, 1, 20, 4, 5);
        Optional<Integer> collect = list.stream()
                .filter(integer -> integer > 10)
                .findFirst();
        collect.ifPresent(System.out::println);
//        if (collect.isPresent()) {
//            System.out.println(collect.get());
//        }
    }

    @Test
        // użycie stream.anyMatch - sprwdza czy spełnia warunek w tym przypadku intiger wiekszy równy od 0 i jest prawdą
        // (jeśli jeden element strumienia pasuje do predykatu)
        // .noneMatch - sprawdza czy żaden z elementów nie pasuje do predykatu, jeśli tak to tru jeśli nie to false
        //.allMatch - sprawdza czy wszysykie elementy strumienia pasują do predykatu
    void test22() {
        List<Integer> list = Arrays.asList(0, 9, 2, 1, 20, 4, 5);
        boolean collect = list.stream()
                .anyMatch(integer -> integer >= 0);
        System.out.println(collect);
    }

    @Test
        // użycie stream.reduce - zmiana liter z małych na duże (redukcja elementów)
    void test23() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        String result = list.stream()
                .reduce("", (part, element) -> part + element.toUpperCase());
        System.out.println(result);
    }

    @Test
        //zwraca elementy streamu, dopóki jest spełniony predykat, który przyjmuje jako parametr
    void test24() {
        Stream.of(1, 2, 3, 4, 5, 6)
                .takeWhile(i -> i < 4)
                .forEach(System.out::println);
    }

    @Test
        //zwraca elementy streamu, od kiedy jest spełniony predykat, który przyjmuje jako parametr
    void test25() {
        Stream.of(1, 2, 3, 4, 5, 6)
                .dropWhile(i -> i < 4)
                .forEach(i -> log.info(String.valueOf(i)));
    }

    @Test
        //robi mniej więcej to samo co pętla for, jako parametry przyjmuje wartość początkową,
        //funkcję ograniczającą i funkcję tworzącą kolejny element
    void test26() {
        IntStream.iterate(2, x -> x < 20, x -> x * x)
                .forEach(System.out::println);
    }
}
