import java.util.*;
import java.util.function.BiConsumer;

public class PrintHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> names = new HashMap<>(Map.of(
                1, "david",
                2, "simon",
                3, "mary",
                4, "john",
                5, "jane"
        ));

        System.out.println("print names HashMap from the HashMap");
        System.out.println(names);

        HashMap<Integer,String> emails = new HashMap<>(Map.of(
                1,"mary@domain.com",
                2, "john@domain.com",
                3, "jane@domain.com"
        ));

        System.out.println("print HashMap using get() method");
        for (Integer key: emails.keySet()){
            System.out.println(key +" = "+emails.get(key));
        }

        HashMap<Integer, Character> marks = new HashMap<>(Map.of(
           1,'A',
           2,'B',
           3,'C',
           4,'D'
        ));
        System.out.println("print HashMap using a Consumer");
        marks.entrySet().forEach(System.out::println);

        HashMap<Integer, String> bikes = new HashMap<>(Map.of(
                1,"hardtail",
                2,"full supension",
                3,"speciality"
        ));

        System.out.println("print HashMap using Arrays.asList()");
        System.out.println(Arrays.asList(bikes));

        HashMap<Integer, String> courses = new HashMap<>(Map.of(
                1, "how to print linked list in Java",
                2,"how to create ER diagrams",
                3,"deep dive into deadlock"
        ));

        System.out.println("print HashMap using Collections");
        List<HashMap<Integer, String>> hashMapList = Collections.singletonList(courses);
        System.out.println(hashMapList);

        HashMap<Integer,String> houses = new HashMap<>(Map.of(
                1,"bungalow",
                2,"mansion",
                3,"flat"
        ));
        System.out.println("print HashMap using getKey() and getValue()");
        for (Map.Entry<Integer,String> theHouse :houses.entrySet()){
            System.out.println(theHouse.getKey() +" = "+theHouse.getValue());
        }

        HashMap<String, String> mapNames = new HashMap<>(Map.of(
                "john","doe",
                "mary","public",
                "peter","parker",
                "donald","trump"
        ));
        System.out.println("print HashMap using a BiConsumer");
        BiConsumer<String, String> stringStringBiConsumer = (firstName, lastName) -> {
            System.out.println(firstName + " " + lastName);
        };
        mapNames.forEach(stringStringBiConsumer);

        HashMap<Integer, String> quotes = new HashMap<>(Map.of(
                1,"harry harry has no blessings",
                2,"pride comes before a fall",
                3,"Early bird catches the worm",
                4,"the higher you go the cooler it becomes"
        ));
        System.out.println("print HashMap using Iterator");
        Iterator<Map.Entry<Integer, String>> iterator = quotes.entrySet().iterator();
        iterator.forEachRemaining(System.out::println);

        System.out.println("print a HashMap using Arrays.toString()");
        Object[] objects = names.entrySet().toArray();
        System.out.println(Arrays.toString(objects));

        System.out.println("print HashMap using custom objects");
        HashMap<Integer, Student> students = new HashMap<>(Map.of(
                1,new Student("john","doe"),
                2,new Student("abdirizack","mustafa"),
                3,new Student("mary","public")
        ));

        for (Map.Entry<Integer,Student> studentEntry: students.entrySet()){
            System.out.println(studentEntry.getKey()+ " = "+ studentEntry.getValue());
        }



    }

    static class Student{
        private String firstName;
        private String lastName;

        public Student(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}
