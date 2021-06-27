### How to print HashMap elements in Java

### Table of contents
- [Print from the HashMap Reference](#print-from-the-hashmap-reference)
- [Print HashMap using get method](#print-hashmap-using-get-method)
- [Print HashMap using a Consumer](#print-hashmap-using-a-consumer)
- [Pring HashMap using Arrays to list method](#print-hashmap-using-arrays-to-list-method)
- [Print HashMap using singleton list](#print-hashmap-using-singleton-list)
- [Print HashMap using get key and get value](#print-hashmap-using-get-key-and-get-value)
- [Print HashMap using BiConsumer](#print-hashmap-using-biconsumer)
- [Print HashMap using Iterator](#print-hashmap-using-iterator)
- [Print HashMap using custom Objects](#print-hashmap-using-custom-objects)

### Print from the HashMap Reference
This is the most basic and easiest method to print out elements from a HashMap. Pass the HashMap reference to the print line method and the HashMap will output the key-value of the elements enclosed in curly brackets.

We are going to use a HashMap constructor and a pass `Map` of elements to the constructor which provides an easier way to initialize a HashMap with values using the `Map.of()` method.

A Map is an interface that forms the basis for all map implementations including a HashMap. The `Map.of()` method returns an unmodifiable map containing the number of elements that you create.

If there are any duplicate keys the method throws `IllegalArgumentException` and a `NullPointerException` if any key or value is `null`.

<pre code="java">
public static void main(String[] args) {
        HashMap<Integer, String> names = new HashMap<>(Map.of(
                1, "david",
                2, "simon",
                3, "mary",
                4, "john",
                5, "jane"
        ));
        System.out.println(names);
}
</pre>
Output:
<div class="content-box-green">
{1=david, 2=simon, 3=mary, 4=john, 5=jane}
</div>

### Print HashMap using get method
The HashMap `get(Object key)` is a method that returns the value that belongs to a particular key.

To get the key for every value in the HashMap we use a for-loop with the `keySet()` method.

The key set method returns a set of unique keys and we pass the keys to the get method to retrieve each value.

<pre code="java">
public static void main(String[] arg){
    HashMap<Integer,String> emails = new HashMap<>(Map.of(
                1,"mary@domain.com",
                2,"john@domain.com",
                3,"jane@domain.com"
        ));
        for (Integer key: emails.keySet()){
            System.out.println(key +" = "+emails.get(key));
        }
}
</pre>

Output:

<div class="content-box-green">
1 = mary@domain.com<br>
2 = john@domain.com<br>
3 = jane@domain.com
</div>

### Print HashMap using a Consumer
To use this functional interface, you have to use the `entrySet()` method which returns a `Set` containing the same type of key-value elements.

Since the set is a `Collection` class that implements `Iterable`, use the `forEach()` method to print out the elements of the HashMap.

The `forEach()` is a method from the `Iterable` class and it accepts only a Consumer as the parameter.

The for-each method iterates through the elements in the HashMap until they are exhausted as it prints them out using the print line method.

<pre code="java">
public static void main(String[] arg){
    HashMap<Integer, Character> marks = new HashMap<>(Map.of(
           1,'A',
           2,'B',
           3,'C',
           4,'D'
        ));
    marks.entrySet().forEach(System.out::println);
}
</pre>

Output:

<div class="content-box-green">
1=A<br>
2=B<br>
3=C<br>
4=D<br>
</div>

### Print HashMap using Arrays to list method
This is a Java class that enables the viewing of arrays as a List and provides methods to search and filter the elements.

When the reference of the array is is `null` it throws a `NullpointerException` except where noted.

To print out the elements of a HashMap using this class, pass the HashMap reference to the `asList()` method of the Arrays class.

This method will print out a list of elements in the HashMap as an Array.

<pre code="java">
public static void main(String[] arg){
     HashMap<Integer, String> bikes = new HashMap<>(Map.of(
                1,"hardtail",
                2,"full supension",
                3,"speciality"
        ));

    System.out.println(Arrays.asList(bikes));
}
</pre>

Output:

<div code="java">
[{1=hardtail, 2=full supension, 3=speciality}]
</div>

### Print HashMap using singleton list
The `singletonList()` is a static method from the `Collections` class hence no instantiation is required to use the method.

The singleton list returns an immutable list which is simply a list that can not be modified by either adding or removing elements from it once it has been created.

When you try to add or remove elements from the singleton list it throws an `UnsupportedOperationException` indicating that it is not supported in the list.

The singleton list method is generic meaning that it can handle any data type and in our case just pass the HashMap reference and it will automatically infer the type.



<pre code="java">
public static void main(String[] arg){
      HashMap<Integer, String> courses = new HashMap<>(Map.of(
                1,"how to print linked list in Java",
                2,"how to create ER diagrams",
                3,"deep dive into deadlock"
        ));
    System.out.println(Collections.singletonList(courses));
}
</pre>

Output:
<div class="content-box-green">
[{1=how to print linked list in Java, 2=how to create ER diagrams, 3=deep dive into deadlock}]
</div>

### Print HashMap using get key and get value
To use the `getKey()` and `getValue()` methods, we use the `entrySet()` method which returns a Set of Map entries `Map.Entry`.

The map entry contains the key-value elements in the HashMap and the elements are only available during the iteration period.

Since Set is a Collection the only way to reference the Map entry is by using an iterator inherited from the `Iterable` class.

If the Map is changed after the entry is returned by the iterator, the behavior of the entry is not clear but you can use the `setValue()` method that replaces the value similar to this with the specified value.

A for-loop will iterate through the elements in the Set of Map entries and print out the key for each value using the get key method and the value using the get value method.

<pre code="java">
public static void main(String[] arg){
        HashMap<Integer,String> houses = new HashMap<>(Map.of(
                1,"bungalow",
                2,"mansion",
                3,"flat"
        ));
        for (Map.Entry<Integer,String> theHouse :houses.entrySet()){
            System.out.println(theHouse.getKey() +" = "+theHouse.getValue());
        }
}
</pre>

Output:

<div class="content-box-green">
1 = bungalow<br>
2 = mansion<br>
3 = flat<br>
</div>

### Print HashMap using BiConsumer
[BiConsumer](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/BiConsumer.html) is a Functional Interface that represents an operation that accepts two arguments and returns no value.

The functional interface is a parameter of the `forEach()` method. The for-each method is inherited by the HashMap from the `Map` interface.

The type declared in the HashMap is the only type of value that will be accepted by the `BiConsumer`.

The functional interface will use the `accept()` method behind the scenes to receive the key and value parameters from the HashMap.

The action of our consumer will be printing out the elements in the HashMap. Note that if the action is null or an entry is removed during iteration, the for-each method will throw a `NullPointerException` and `CurrentModificationException` respectively.

<pre code="java">
public static void main(String[] arg){
    HashMap<String, String> mapNames = new HashMap<>(Map.of(
                "john","doe",
                "mary","public",
                "peter","parker",
                "donald","trump"
        ));
    BiConsumer<String, String> firstAndLastNameBiConsumer = (firstName, lastName) -> {
        System.out.println(firstName + " " + lastName);
    };
    mapNames.forEach(firstAndLastNameBiConsumer);
}
</pre>

Output:

<div class="content-box-green">
mary public<br>
john doe<br>
donald trump<br>
peter parker<br>
</div>

### Print HashMap using Iterator
We can access the `iterator()` method through the `entrySet()` method which returns a Set containing Map entries.

Since the Set class inherits from the Iterable interface we can return an [Iterator](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html) then use the `forEachRemaining()` method to iterate through the elements.

The for-each remaining is a method from the Iterator interface that we will use to print out the elements in the HashMap by passing a Consumer.

<pre code="java">
public static void main(String[] arg){
    HashMap<Integer, String> quotes = new HashMap<>(Map.of(
                    1,"harry harry has no blessings",
                    2,"pride comes before a fall",
                    3,"Early bird catches the worm",
                    4,"the higher you go the cooler it becomes"
            ));
        Iterator<Map.Entry<Integer, String>> iterator = quotes.entrySet().iterator();
        iterator.forEachRemaining(System.out::println);

}
</pre>

Output:

<div class="content-box-green">
1=harry harry has no blessings<br>
2=pride comes before a fall<br>
3=Early bird catches the worm<br>
4=the higher you go the cooler it becomes<br>
</div>

### Print HashMap using custom Objects
Whether you are creating a phone book or dictionary application, you must create custom objects for your HashMap.

We will create a HashMap that maps an id to a particular student object. The student id will be of type Integer.

Create a student class with first name and last name properties then add a constructor with the two fields and generate to string method.

<pre code="java">
 public class Student{
        private String firstName;
        private String lastName;

        public Student(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        // Generate toString() method
 }
</pre>

Create a HashMap with several objects of the student and print them out using the `getKey()` and `getValue()` methods or any other approach that we have implemented in this article.

<pre code="java">
public static void main(String[] arg){
    HashMap<Integer, Student> students = new HashMap<>(Map.of(
                1,new Student("john","doe"),
                2,new Student("abdirizack","mustafa"),
                3,new Student("mary","public")
        ));

    for (Map.Entry<Integer,Student> studentEntry: students.entrySet()){
        System.out.println(studentEntry.getKey()+ " = "+ studentEntry.getValue());
    }
}
</pre>

Output:

<div class="content-box-green">
1 = Student{firstName='john', lastName='doe'}<br>
2 = Student{firstName='abdirizack', lastName='mustafa'}<br>
3 = Student{firstName='mary', lastName='public'}<br>
</div>

### Conclution
In this article, you have learned different ways that you can use to print out the elements of a HashMap. The approaches covered include, printing directly from the HashMap reference, using the `get()` method, using a `Consumer`, using `Arrays.asList()`,
using `Collections.singletonList()`, using `getKey()` and `getValue()`, using a `BiConsumer`, using an `Iterator` and finally custom objects.  


















