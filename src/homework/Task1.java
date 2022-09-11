package homework;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Task1 {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private final static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static Map<String, Integer> sort() {
        Map<String, Integer> rsl = new TreeMap<>();
        int numberRepetitions = 1;
        for (int i = 0; i < RAW_DATA.length - 1; i++) {
            if (!RAW_DATA[i].equals(RAW_DATA[i + 1]) && RAW_DATA[i].getName().equals(RAW_DATA[i + 1].getName())) {
                rsl.computeIfPresent(RAW_DATA[i].getName(), (key, value) -> value + 1);
                rsl.putIfAbsent(RAW_DATA[i].getName(), numberRepetitions);
                numberRepetitions++;
            } else {
                numberRepetitions = 1;
                rsl.putIfAbsent(RAW_DATA[i].getName(), numberRepetitions);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();
        Map<String, Integer> rsl = sort();

        rsl.forEach((key, value) -> System.out.println("Key:" + key + System.lineSeparator() + "Value:" + value));
    }
}
