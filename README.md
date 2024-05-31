## OOPS Concepts

1. **Abstraction -** 
- **Concept** : Data abstraction involves hiding the implementation details and showing only the essential features of an object. It focuses on what an object does rather than how it does it.
- **Usage** : In my experience, I have utilized many predefined classes provided by Java (from Oracle/Sun). While I may not know the internal workings of these classes, I have effectively used their functionalities in my projects.
- **Implementation** : Abstraction in Java can be achieved using interfaces and abstract classes. By defining methods in an interface, we can specify what actions an object can perform, without dictating how these actions are implemented.
- **Example :**
    - Interfaces: The `Animal` interface defines abstract methods `makeSound()` and `move()`. Concrete classes `Dog` and `Cat` implement these methods, providing specific behaviors for each animal type.

    - Abstract Classes: The abstract class `Vehicle` defines abstract methods `start()` and `stop()`, along with a concrete method `fuel()`. Subclasses `Car` and `Bike` provide specific implementations for the abstract methods, while inheriting the concrete method.

2. **Encapsulation -** 
- **Concept** : Encapsulation is the process of bundling data (fields) and methods (functions) that operate on the data into a single unit, usually a class. It helps in protecting the data from unauthorized access and modification.
- **Usage** : In my projects, all classes demonstrate encapsulation by bundling data and the methods that manipulate that data together.
- **Example** : Consider a User class. The class has private data members, and for these data members, it provides public methods (getters and setters) to allow controlled manipulation and access.

3. **Modularity -** 
- **Concept** : Modularity involves dividing a project into separate, self-contained modules. This approach improves code readability and maintainability by organizing related functionality into distinct units.
- **Implementation** : The concept of packages in Java helps achieve modularity. By grouping related classes and interfaces into packages, we create well-defined modules within the project.
- **Usage** : In my projects, I have implemented modularity by creating different modules such as User, Pizza, Order, and Address. Each module encapsulates its respective functionality, making the codebase more organized and easier to manage.

4. **Hierarchy**
- **Concept** : Hierarchy in OOP is the ranking or ordering of abstractions. It allows for code reusability by defining relationships between classes and objects.
- **Types of Hierarchies** : There are two main types of hierarchies in OOP:
	1. **“IS–A” hierarchy : Inheritance** : This type of hierarchy allows a subclass to inherit properties and methods from a superclass, promoting code reuse and logical structuring.
		- `Rose` "is-a" `flower`
		- `Employee` "is-a" `person`
		- `Student` "is-a" `person`
		- `Rectangle` "is-a" `Shape`
	2. **“PART–OF” hierarchy : Association** : This type of hierarchy defines how objects are associated with each other. Aggregation represents a weak association where the lifetime of the part is independent of the whole, while composition represents a strong association where the part's lifetime is dependent on the whole.
		- There are two types of **Association**
			- **Aggregation (Loose coupling)**
				- `Wallet` has `Money` but `money` doesn’t need to have `Wallet` necessarily
				- `peron` has `address`
				- `Pizza` has `order(s)`
				- `Mobile` has `backcover`

			- **Composition (Tight coupling)**
				- `Human` has `Heart`
				- `Car` has `engine`
				- `Room` has `wall`
				- `bird` has `wings`
				- `Order` has `pizza(s)`
	
## Polymorphism.
- **Definition** : Polymorphism, refers to the ability of different objects to be treated as instances of a common superclass. This enables a single interface to represent various underlying data types and behaviors.

- **Concept** : At its core, polymorphism allows for flexibility and extensibility in software design by promoting code reuse and abstraction. The concept revolves around the idea of having multiple classes that share a common interface (via inheritance) but provide different implementations of methods. This allows developers to write code that can work with objects of multiple types, without needing to know the specific details of each type.

### Compile-time polymorphism (Static Binding):
This form of polymorphism, resolved during compilation, allows multiple methods with the same name but different parameters to coexist within the same class. The compiler determines which method to call based on the method signature and the context of the call. Method overloading exemplifies this static polymorphism, facilitating code clarity and efficiency.

```JAVA
public class Math {
 
    public static int add(int a, int b)
    {
        return a + b;
    }
 
    public static double add(
        double a, double b)
    {
        return a + b;
    }

    public static void main(String args[])
    {
        System.out.println(add(2, 3));
        System.out.println(add(2.0, 3.0));
    }
}
```
### Runtime polymorphism (Dynamic Binding):
Unlike its compile-time counterpart, runtime polymorphism is resolved during program execution. It enables a subclass to provide a specific implementation of a method that is already defined in its superclass. Method overriding illustrates dynamic polymorphism, as the JVM dynamically selects the appropriate method implementation based on the actual object type rather than the reference type. This flexibility empowers developers to create more adaptable and extensible code structures.
```JAVA
class Bike{  
	void run() {
		System.out.println("Running");
	}  
}

class Bmw extends Bike{  
  	void run() {
		  System.out.println("Running safely with 120km/hr");
	}  
}

class Main{    
  public static void main(String args[]){  
    Bike b = new Bmw();//upcasting  
    b.run();  
  }  
} 
```
## What is REST API? [Representational state transfer] not a protocal is a archi. pattern
- Before we jump right into it, let’s first understand what REST is. 
- Contrary to the belief of many, REST is not a protocol, a tool or library, but rather an architectural style of web service that provides a channel of communication between systems or computers on the internet.
- It is a standard that is utilized as an architectural means of designing a Network-based software system.
- Therefore a REST API is an application program interface that is backed by the architectural style of REST.
- It refers to tools, service or software that is based on the REST architectural principle.
- Although REST can be used on nearly any protocol, they take advantage of HTTP when used for web APIs.
- The primary advantage of REST APIs is that they offer more flexibility. 
- In REST APIs, data is not constrained to resources or methods. 
- Therefore, it can make multiple types of calls, return various data formats, and even change structurally with the appropriate implementation of hypermedia.

## What is Web API?
- Web API is basically an open-source framework that is used to write HTTP APIs.
- It refers to an API over the web which can be accessed using the HTTP protocol.
- It is important to note that it is a concept and not a technology. 
- Developers can build Web API using a vast array of technologies such as .NET, and Java, among others. 
- Web API can be RESTful or not.
- Web API implements protocol specification and thus it incorporates concepts like caching, URIs, versioning, request/response headers and various content formats in it.

## Differences between REST and SOAP APIs

|	   **REST API**				|			**SOAP API**                |
|-------------------------------|---------------------------------------|
|Representational state transfer |Simple Object Access Protocol	|
|It has no official standard since it is primarily an architectural style	|	It is an official standard because it is a protocol |
|Can use several standards like HTTP, URL, JSON, and XML | Based largely on HTTP and XML |


### Dependency Injection
- Dependency Injection is a fundamental aspect of the Spring framework, through which the Spring container “injects” objects into other objects or “dependencies”. Simply put, this allows for loose coupling of components and moves the responsibility of managing components onto the container.
- Dependency injection is a pattern we can use to implement IoC, where the control being inverted is setting an object's dependencies.Connecting objects with other objects, or “injecting” objects into other objects, is done by an assembler rather than by the objects themselves.

```java
// Tight coupling
// Here's how we would create an object dependency in traditional programming:
public class Store {
    private Item item;
 
    public Store() {
        item = new ItemImpl1();    
    }
}

// loose coupling
// By using DI, we can rewrite the example without specifying the implementation of the Item that we want:
public class Store {
    private Item item;
    public Store(Item item) {
        this.item = item;
    }
}

// Constructor-Based Dependency Injection in Spring f/w
@Configuration
@ComponentScan("com.app.constructordi")
public class Config {

    @Bean
    public Engine engine() {
        return new Engine("v8", 5);
    }

    @Bean
    public Transmission transmission() {
        return new Transmission("sliding");
    }
}

@Component
public class Car {

    @Autowired
    public Car(Engine engine, Transmission transmission) {
        this.engine = engine;
        this.transmission = transmission;
    }
}

```
# Collection in java

- **Collection**
	- **List**
		- ArrayList [c]
		- LinkedList [c]
		- Vector [c]
			- Stack [c]
	- **Set**
		- HashSet [c]
			- LinkedHashSet [c]
		- SortedSet
			- NavigableSet
				- TreeSet [c]
	- **Queue**
		- PriorityQueue [c]
		- BlockingQueue [c]
			- PriorityBlockingQueue [c]
			- LinkedBlockingQueue [c]
		- Deque
			- ArrayDeque [c]
			- AbstractCollection [c]
					
- **Map<K,V>**
	- HashMap [c]
		- LinkedHashMap [c]
	- IdentityHashMap [c]
	- WeakHashMap [c]
	- SortedMap
		- NavigableMap
			- TreeMap [c]
	- HashTable [c] extends Dictionary [AC]
# List
## ArrayList
- **Resizable Array** : ArrayList in Java is essentially a resizable-array implementation of the List interface. It can dynamically grow and shrink in size as elements are added or removed.
- **Supports All Elements** : ArrayList permits the inclusion of all elements, including null values.
- **Default Capacity** : Initially, an ArrayList has a default capacity of 10 elements. However, in newer versions of Java, this default capacity is represented by the object Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};.
- **Capacity Growth** : When the capacity of an ArrayList needs to be increased, it typically grows by 50% to accommodate more elements efficiently.
- **Not Synchronized** : It's essential to note that ArrayList is not synchronized. This means that it is not inherently thread-safe, and concurrent modifications or accesses from multiple threads can lead to unexpected behavior.
- **Concurrent Modification** : Multiple threads can concurrently modify or access an ArrayList, but caution must be exercised to ensure proper synchronization mechanisms are in place to avoid data corruption or inconsistencies.
- **Performance Compared to Vector** : In comparison to the Vector class, ArrayList is generally faster due to its non-synchronized nature, making it more suitable for scenarios where high-performance is a priority.

## LinkedList
- **Doubly-linked List**: LinkedList in Java is implemented as a doubly-linked list, meaning each element is connected to its previous and next elements.
- **Supports All Elements** : Similar to ArrayList, LinkedList permits the inclusion of all elements, including null values.
- **Not Synchronized** : It's important to note that LinkedList is not synchronized, which means it's not inherently thread-safe. Concurrent modifications or accesses from multiple threads can lead to unexpected behavior.
- **Concurrent Modification** : Multiple threads can concurrently modify or access a LinkedList. However, it's crucial to implement proper synchronization mechanisms to avoid data corruption or inconsistencies.
Fast Add Operation: One of the advantages of LinkedList is its fast add operation, especially when adding elements to the beginning or middle of the list. This is because it doesn't require resizing or shifting of elements like ArrayList does.

## Vector
- **Growable Array** : The Vector class in Java implements a growable array of objects, similar to ArrayList. However, it predates ArrayList and is considered legacy.
- **Capacity Growth** : When the capacity of a Vector needs to be increased, it typically grows by doubling its size (increased by 100%).
- **Synchronized** : Unlike ArrayList, Vector is synchronized, meaning it ensures thread-safety by allowing only one thread to modify it at a time.
- **Recommendation** : If a thread-safe implementation is not required, it's recommended to use ArrayList instead of Vector due to its better performance.
- **Comparative Performance** : Vector is generally slower compared to ArrayList due to its synchronized nature, which introduces overhead for thread safety.

# Set
- **Null Value Allowed** : HashSet permits the inclusion of null values.
- **No Duplicates** : Duplicate elements are not allowed in a HashSet. Each element is unique.
- **No Order Maintenance** : Unlike some other collection types, HashSet does not maintain the insertion order of elements.
- **Constant Time Performance**: Basic operations like add, remove, contains, and size have constant time performance, making HashSet efficient for these operations.
- **Not Synchronized** : It's essential to note that HashSet's implementation is not synchronized, meaning it is not inherently thread-safe.
- **Concurrent Modification** : While multiple threads can concurrently modify or access a HashSet, it's important to ensure proper synchronization mechanisms are in place to avoid thread interference and data inconsistencies.

### Implementation :
```java
Set<String> hashset = new HashSet<String>();
		hashset.add("one");
		hashset.add("one");
		hashset.add("two");
		hashset.add("three");
		hashset.add("four");
		hashset.add(null);
		hashset.add("five");
		hashset.add(null);
		
		for(String val : hashset)
		{
			System.out.println(val);
		}

OutPut :
null
four
one
two
three
five
```
## LinkedHashSet
- **Null Value Allowed** : LinkedHashSet allows the inclusion of null values.
- **No Duplicates** : Duplicate elements are not allowed in a LinkedHashSet. Each element is unique.
- **Maintains Insertion Order** : Unlike HashSet, LinkedHashSet maintains the insertion order of elements, which means elements are stored in the order they were added.
- **Constant Time Performance** : Basic operations like add, remove, and contains have constant time performance, making LinkedHashSet efficient for these operations.
- **Not Synchronized** : It's important to note that LinkedHashSet's implementation is not synchronized, meaning it is not inherently thread-safe.
- **Concurrent Modification** : While multiple threads can concurrently modify or access a LinkedHashSet, it's crucial to implement proper synchronization mechanisms to prevent thread interference and ensure data consistency.

### Implementation :
```java
		Set<String> linkedhashset = new LinkedHashSet<>();
		linkedhashset.add("one");
		linkedhashset.add("one");
		linkedhashset.add("two");
		linkedhashset.add("three");
		linkedhashset.add("four");
		linkedhashset.add("five");
		linkedhashset.add(null);
		
		for(String val : linkedhashset)
		{
			System.out.println(val);
		}

output :
one
two
three
four
five
null
```
## TreeSet implements NavigableSet
- **Null Value Not Allowed** : TreeSet does not permit the inclusion of null values.
- **No Duplicates**: Duplicate elements are not allowed in a TreeSet. Each element is unique.
- **Does Not Maintain Insertion Order** : Unlike some other collection types, TreeSet does not maintain the insertion order of elements. Instead, it stores elements in sorted order based on their natural ordering or a custom comparator.
- **Guaranteed Log(n) Time Cost** : TreeSet provides a guaranteed log(n) time cost for basic operations like add, remove, and contains due to its underlying balanced tree data structure.
- **Not Synchronized** : TreeSet's implementation is not synchronized, meaning it is not inherently thread-safe.
- **Concurrent Modification** : While multiple threads can concurrently modify or access a TreeSet, it's essential to implement proper synchronization mechanisms to prevent thread interference and ensure data consistency.

### Implementation :
```java
		Set<String> treeset = new TreeSet<>();
		treeset.add("one");
		treeset.add("one");
		treeset.add("two");
		treeset.add("three");
		treeset.add("four");
		treeset.add("five");
		//treeset.add(null); //null not allowed : NullPointerException
		
		for(String val : treeset)
		{
			System.out.println(val);
		}
Output : //here null not allowed
five
four
one
three
two
```
---
# Map<K, V>
## HashMap<k, v>
- **Permits Null Values and Null Key** : HashMap allows both null values and a null key.
- **Permits Nulls** : It permits the inclusion of null elements.
- **Order Not Guaranteed** : HashMap does not guarantee that the order of elements will remain constant over time. Iterating over the elements may not yield them in the order they were added.
- **Constant-Time Performance** : Basic operations like get and put have constant-time performance, making HashMap efficient for these operations in most scenarios.
- **Performance Parameters** : An instance of HashMap has two parameters affecting its performance: initial capacity and load factor. These parameters can be adjusted to optimize HashMap's performance for specific use cases.
- **Not Synchronized** : HashMap's implementation is not synchronized, meaning it is not inherently thread-safe.
- **Concurrent Modification** : While multiple threads can concurrently modify or access a HashMap, it's crucial to implement proper synchronization mechanisms to prevent thread interference and ensure data consistency.
	
### Implementation :
```java
HashMap<Integer, String> hashmap = new HashMap<>();		
		hashmap.put(101, "CaptainAmerica");
		hashmap.put(101, "IronMan");
		hashmap.put(104, "Loki");
		hashmap.put(102, "Thor");
		hashmap.put(105, "NickFury");
		hashmap.put(103, "BlackWidow");
		hashmap.put(106, null);
		hashmap.put(null, null);
		
		for(Map.Entry<Integer, String> m : hashmap.entrySet())
		{
			System.out.println(m.getKey() + " : "+ m.getValue());
		}

// OutPut : order will not remain constant over time

null : null
101 : IronMan
102 : Thor
103 : BlackWidow
104 : Loki
105 : NickFury
106 : null
```

## Hashtable<k, v> :
- **Non-null Keys and Values** : Hashtable permits any non-null object to be used as a key or value. Null values are not allowed.
- **No Order Maintenance** : Elements in a Hashtable are not maintained in any specific order; they are stored in a seemingly random order.
- **Hashcode and Equals** : To successfully store and retrieve objects from a Hashtable, it's essential to implement the hashCode method and the equals method in the objects used as keys.
- **Default Load Factor** : Hashtable has a default load factor of 0.75, which affects its resizing behavior as it approaches capacity.
- **Synchronized (Thread-safe)** : Hashtable is synchronized, meaning it ensures thread safety by allowing only one thread to access it at a time. This makes it suitable for concurrent access from multiple threads.
- **Recommendation** : If a thread-safe implementation is not required, it's recommended to use HashMap instead of Hashtable due to better performance.
- **LinkedHashMap** : Use LinkedHashMap when you want to preserve the insertion order of elements.
- **TreeMap**: Utilize TreeMap when you want to sort the key-value pairs based on the natural ordering of keys.
	
### Implementation :
```java
Hashtable<Integer, String> hashtable = new Hashtable<>();
		
		hashtable.put(101, "CaptainAmerica");
		hashtable.put(101, "IronMan");
		hashtable.put(104, "Loki");
		hashtable.put(102, "Thor");
		hashtable.put(105, "NickFury");
		hashtable.put(103, "BlackWidow");
		hashtable.put(107, "BlackWidow");
	  //hashtable.put(106, null);    	// null value not allowed : NullPointerException
	  //hashtable.put(null, "Vishal");  // null key not allowed : NullPointerException
		
		for(Map.Entry<Integer, String> m : hashtable.entrySet())
			System.out.println(m.getKey() +" : "+ m.getValue());
			
//OutPut : does not maintain order of elements (in random order)

107 : BlackWidow
105 : NickFury
104 : Loki
103 : BlackWidow
102 : Thor
101 : IronMan
```
### LinkedHashMap Implementation: maintain insertion order
```java
	LinkedHashMap<Integer, String> linkedhashmap = new LinkedHashMap<>();

		linkedhashmap.put(101, "CaptainAmerica");
		linkedhashmap.put(101, "IronMan");
		linkedhashmap.put(104, "Loki");
		linkedhashmap.put(102, "Thor");
		linkedhashmap.put(105, "NickFury");
		linkedhashmap.put(103, "BlackWidow");
		linkedhashmap.put(107, "BlackWidow");
		linkedhashmap.put(106, null);   
		linkedhashmap.put(null, "Vishal");

		for(Map.Entry<Integer, String> m : linkedhashmap.entrySet())
			System.out.println(m.getKey() +" : "+ m.getValue());
//Output :

101 : IronMan
104 : Loki
102 : Thor
105 : NickFury
103 : BlackWidow
107 : BlackWidow
106 : null
null : Vishal
```
### TreeMap Implementation : Sorted
```java
TreeMap<Integer, String> treemap = new TreeMap<>();

		treemap.put(101, "CaptainAmerica");
		treemap.put(101, "IronMan");
		treemap.put(104, "Loki");
		treemap.put(102, "Thor");
		treemap.put(105, "NickFury");
		treemap.put(103, "BlackWidow");
		treemap.put(107, "BlackWidow");
		treemap.put(106, null);   
		//treemap.put(null, "Vishal"); //null key not allowed

		for(Map.Entry<Integer, String> m : treemap.entrySet())
			System.out.println(m.getKey() +" : "+ m.getValue());

Output :
101 : IronMan
102 : Thor
103 : BlackWidow
104 : Loki
105 : NickFury
106 : null
107 : BlackWidow
```
## Default Methods In Java 8
- Before Java 8, interfaces could have only abstract methods. The implementation of these methods has to be provided in a separate class.
- So, if a new method is to be added in an interface, then its implementation code has to be provided in the class implementing the same interface.
- To overcome this issue, Java 8 has introduced the concept of default methods which allow the interfaces to have methods with implementation without affecting the classes that implement the interface.
	
## What is Interface in java ?
- The interface in Java is a mechanism to achieve abstraction.
- There can be only abstract methods in the Java interface, not method body (Concreate methods).
- It is used to achieve abstraction and multiple inheritance in Java.
	
## why we can't create object of interface in java?
- Interface is basically a complete abstract class.
- So if we don't have any implementation of a method then that means if we create object of that interface and call that method it compile nothing as there is no code to compile.

## Multithreading in Java
1. Multithreading in Java is a process of executing multiple threads simultaneously.
2. A thread is a lightweight sub-process, the smallest unit of processing
3. Java provides Thread class to achieve thread programming.
4. Thread class implements Runnable interface.
	
## Life cycle of a Thread:
1. Newborn : Thread t1 = new Thread(object)
2. Runnable : start();
3. Running : run();
4. Dead : stop();
5. Blocked : sleep(), wait()
6. Runnable : notify(), notifyAll();

## Mutex :
- The Mutex is a locking mechanism that makes sure only one thread can acquire the Mutex at a time and enter the critical section.
- This thread only releases the Mutex when it exits the critical section.
		 
## Semaphore :
- A semaphore is a signalling mechanism and a thread that is waiting on a semaphore can be signaled by another thread.
- This is different than a mutex as the mutex can be signaled only by the thread that called the wait function.

## Runnable And Callable in Java
- *Runnable* is the core interface provided for representing multithreaded tasks, and *Java 1.5* provided *Callable* as an improved version of *Runnable*.

### Runnable: 
- The *Runnable* interface is a *functional interface* and has a single run() method that doesn't accept any parameters or return any values.
```java
public interface Runnable {
    public void run();
}

public class EventLoggingTask implements  Runnable{
    private Logger logger
      = LoggerFactory.getLogger(EventLoggingTask.class);

    @Override
    public void run() {
        logger.info("Message");
    }
}

public void executeTask() {
    executorService = Executors.newSingleThreadExecutor();
    Future future = executorService.submit(new EventLoggingTask());
    executorService.shutdown();
}
```

### Callable:
- The Callable interface is a *generic functional interface* containing a single call() method that returns a generic value V:
```java
public interface Callable<V> {
    V call() throws Exception;
}

public class FactorialTask implements Callable<Integer> {
    int number;

    // standard constructors

    public Integer call() throws InvalidParamaterException {
        int fact = 1;
        // ...
        for(int count = number; count > 1; count--) {
            fact = fact * count;
        }

        return fact;
    }
}

@Test
public void whenTaskSubmitted_ThenFutureResultObtained(){
    FactorialTask task = new FactorialTask(5);
    Future<Integer> future = executorService.submit(task);
 
    assertEquals(120, future.get().intValue());
}
```
## Difference Between Runnable interface and Callable interface
|		**Runnable interface ** |			**Callable interface**			|
|-------------------------------|-------------------------------------------|
|It is a part of java.lang package since Java 1.0|It is a part of the java.util.concurrent package since Java 1.5.|
|It cannot return the return of computation.|It can return the result of the parallel processing of a task.|
|It cannot throw a checked Exception.|It can throw a checked Exception.|
|In a runnable interface, one needs to override the run() method in Java.|In order to use Callable, you need to override the call()|

## Difference Between Iterator and Enumeration
|		**Iterator** 		|			**Enumeration**			|
|---------------------------|-----------------------------------|
|Universal cursor as it is applicable for all the collection classes|Not a universal cursor as it applies only to legacy classes.|
|Using Iterator you can read and remove the elements in the collection|Using Enumeration you can only read the elements in the collection|
|public boolean hasnext(); public objects next(); public void remove();|public boolean hasMoreElements(); public object nextElement();|
|Can not add any new element in the collection|It has only read-only access to the elements in a collection.|
|To overcome the limitations of Iterator you must opt for ListIterator.|To overcome the limitations of Enumeration you must opt for Iterator|
|java.util.iterator|java.util.enumeration|
|Since: 1.2| Since: 1.0 |

```java
Iterator itr = Collc.iterator();

public boolean hasnext();
public Object next();
public void remove();
```

```java
Enumeration er = Vect.elements();

public boolean hasMoreElements();
public nextElement();
```

## **Legacy Class in Java**
1. Dictionary
2. Vector
3. HashTable
4. Stack
5. Properties

## Difference Between iterable and iterator
### **Iterable**
- If any class implements iterable iterface, It gain ability to iterate over an object of that class using iterator.
- It represents collection which can be traversed.
- When we implement iterable interface it allows an object to make use of for-each loop.
- iterable does call internally iterator() method
- java.lang.Iterable
- Since: 1.5
- **Methods**
	- Iterator<T> iterator()
	- default void forEach(Consumer<? super T> action)
	- default Spliterator<T> spliterator()


### **Iterator**
- Iterator is an interface which belongs to collection framework
- It allows us to traverse the collection, access the data element and remove the data elements of the collection.
- Since: 1.2
- **Methods**
	- public boolean hasnext();
	- public objects next();
	- public void remove();
```java
ArrayList<String> list = new ArrayList<String>(); 
        list.add("A"); 
        list.add("B"); 
        list.add("C"); 
        list.add("D"); 
        list.add("E"); 

        Iterator iterator = list.iterator();  
        while (iterator.hasNext()) 
            System.out.print(iterator.next() + " ");
```



## Diff b/w comparable and comparator
### **Comparable :**
0. Functional interface contains only one abstract method
1. Compare an object with other objects of the same type
2. java.lang package
3. It contains only one method compareTo() which is responsible for sorting.

* int compareTo() : 
	1. returns an int value, value can be either positive, negative, or zero
```java
@Override
public int compareTo(Student per) {
	if(this.age == per.age)
		return 0;
	else
		return this.age > per.age ? 1 : -1;
}
```
### **Comparator :**
0. This interface contains two methods
..1. int compare(Object obj1,Object obj2);
..2. boolean equals(Object element);
1. java.util package
2. Compare an object with other objects of the same type

```java
public int compare(School sch1, School sch2) {
	if(sch1.getNumOfStudents()== sch2.getNumOfStudents())
		return 0;
	else
		return sch1.getNumOfStudents() > sch2.getNumOfStudents() ? 1 : -1;
}
```

### UpCasting :
```java
Person p = new Employee( );
```
### DownCasting :
```java
Person p = new Employee();
Employee emp = ( Employee) p;
```

## What variable type can I use to hold huge numbers (30+ digits) in java?
```java
BigInteger bi1 = new BigInteger("637824629384623845238423545642384"); 
BigInteger bi2 = new BigInteger("3039768898793547264523745379249934"); 

BigInteger bigSum = bi1.add(bi2);
BigInteger bigProduct = bi1.multiply(bi2);

System.out.println("Sum     : " + bigSum);
System.out.println("Product : " + bigProduct);
```
## String : 
- **Immutability** : Strings in Java are immutable, meaning their values cannot be changed once they are created. This immutability facilitates easy sharing of strings across different threads or functions without the risk of unintended modification.
- **String Pool** : All string literals in Java are stored in a special memory area called the String pool. This facilitates memory optimization by avoiding duplicate string objects with the same value.
- **Concatenation Behavior** : When concatenating strings using the '+' operator, a new string object is created, and the original strings are left unchanged. This behavior minimizes the risk of unintentional modifications and facilitates memory management.
- **Overloaded '+' Operator**: The '+' operator is overloaded for strings in Java. Internally, it uses a StringBuffer and its append() method to perform concatenation efficiently.
- **String Manipulation Overhead** : Due to immutability and the creation of new string objects during concatenation, string manipulation operations can be heavy on memory usage and can generate a significant amount of garbage in the heap.

```java
public final class String 
	extends Object 
	implements Serializable, Comparable<String>, CharSequence {

}

// Example 1- 
		String s1 = "HELLO"; // immutable - gose to string pool
        s1 = "WORLD"; // new instance - gose to string pool

		String s3 = "HELLO"; // same instance as s1, not new
		String s4 = new String("HELLO"); // out of string pool

```
	
## StringBuffer : 
1. Is Mutable.
2. Thread safe and Synchronized
3. All methods are Synchronized so performance is slower
4. since java 1.0
	
## StringBuilder :
1. Is mutable 
2. Not Thread safe and Not Synchronized
3. High performance (faster)
4. since java 1.5
	
## Exception Hierachy:
- **Object**
    - **Throwable -**
        - **Exception**
            - RuntimeException [UnChecked]
                - ArithmeticException
                - NUllPointerException
                - ClassCastException
                - IndexOutOfBoundException
                - ArrayIndexOutOfBoundException
                - StringIndexOutOfBoundException
				- ArrayStoreException
            - IOException [Checked]
                - EOFException
                - FileNotFoundException
                - InterruptedIOException
            - SQLException [Checked]
            - AWTException [Checked]
            - InterruptedException [Checked]
        - **Error - [UnChecked]**
            - VirtualMachinError
                - StackOverFlowError
                - OutOfMemoryError
            - AssertionError
            - IOError
            - AWTError

## The Spring *@Controller* and *@RestController* Annotations
- We can use the *@Controller* annotation for traditional Spring controllers, and it has been part of the framework for a very long time. *Spring 4.0* introduced the *@RestController* annotation in order to simplify the creation of RESTful web services. It's a convenient annotation that combines *@Controller* and *@ResponseBody*, which eliminates the need to annotate every request handling method of the controller class with the *@ResponseBody* annotation.

### @Controller: 
- We can annotate classic controllers with the *@Controller* annotation. This is simply a specialization of the *@Component* class, which allows us to auto-detect implementation classes through the classpath scanning. We typically use @Controller in combination with a @RequestMapping annotation for request handling methods.
- We annotated the request handling method with *@ResponseBody*. This annotation enables automatic serialization of the return object into the HttpResponse.
```java
@Controller
@RequestMapping("books")
public class SimpleBookController {

    @GetMapping("/{id}", produces = "application/json")
    public @ResponseBody Book getBook(@PathVariable int id) {
        return findBookById(id);
    }

    private Book findBookById(int id) {
        // ...
    }
}
```

### @RestController:
- *@RestController* is a specialized version of the controller. It includes the *@Controller* and *@ResponseBody* annotations, and as a result, simplifies the controller implementation.
- The controller is annotated with the *@RestController* annotation; therefore, the *@ResponseBody* isn't required. Every request handling method of the controller class automatically serializes return objects into HttpResponse.
```JAVA
@RestController
@RequestMapping("books-rest")
public class SimpleBookRestController {
    
    @GetMapping("/{id}", produces = "application/json")
    public Book getBook(@PathVariable int id) {
        return findBookById(id);
    }

    private Book findBookById(int id) {
        // ...
    }
}
```

## Difference between *@RequestMapping* and *@GetMapping*
- *@RequestMapping* is used at the **class** level while *@GetMapping* is used to connect the **methods**.

```JAVA
@RestController
@RequestMapping("/home")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    String get() {
        return "Hello from get";
    }
    @RequestMapping(method = RequestMethod.DELETE)
    String delete() {
        return "Hello from delete";
    }
    @RequestMapping(method = RequestMethod.POST)
    String post() {
        return "Hello from post";
    }
    @RequestMapping(method = RequestMethod.PUT)
    String put() {
        return "Hello from put";
    }
```

### @RequestMapping Shortcuts:
- *Spring 4.3* introduced method-level variants, also known as composed annotations of *@RequestMapping*. The composed annotations better express the semantics of the annotated methods. They act as wrapper to *@RequestMapping* and have become the standard ways of defining the endpoints.

```JAVA
@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/person")
    public @ResponseBody ResponseEntity<String> getPerson() {
        return new ResponseEntity<String>("Response from GET", HttpStatus.OK);
    }
    @GetMapping("/person/{id}")
    public @ResponseBody ResponseEntity<String> getPersonById(@PathVariable String id) {
        return new ResponseEntity<String>("Response from GET with id " + id, HttpStatus.OK);
    }
    @PostMapping("/person")
    public @ResponseBody ResponseEntity<String> postPerson( @RequestBody Person person) {
        return new ResponseEntity<String>("Response from POST method", HttpStatus.OK);
    }
    @PutMapping("/person")
    public @ResponseBody ResponseEntity<String> putPerson() {
        return new ResponseEntity<String>("Response from PUT method", HttpStatus.OK);
    }
    @DeleteMapping("/person")
    public @ResponseBody ResponseEntity<String> deletePerson() {
        return new ResponseEntity<String>("Response from DELETE method", HttpStatus.OK);
    }
    @PatchMapping("/person")
    public @ResponseBody ResponseEntity<String> patchPerson() {
        return new ResponseEntity<String>("Response from PATCH method", HttpStatus.OK);
    }
}
```

## Singleton class

### 1. Lazy Instatiation
```java
public class Singleton {
	public Singleton() { 	}
	
	private static Singleton instance;

	public static Singleton getInstance() {
		if(Singleton.instance == null)
		{
			Singleton.instance = new Singleton();
		}
		return Singleton.instance;
	}		
}
```
### 2. Eager initialization
```java
class EagerInitializedSingleton {
    
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    
    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}
```

### 3. Static initialization block
```java
class StaticBlockSingleton {

    private static StaticBlockSingleton instance;
    
    private StaticBlockSingleton(){}
    
    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
```
### 4. Thread Safe Singleton
```java
class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton(){}
    
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
```

### 5. Bill Pugh Singleton Implementation
```java
public class BillPughSingleton { //main class

    private BillPughSingleton(){} // ctor of main class
    
    private static class SingletonHelper{ // inner singleton_helper class
   	 	// instantiation of main class in inner class which is final
        private static final BillPughSingleton INSTANCE = new BillPughSingleton(); 
    }
    
    public static BillPughSingleton getInstance(){ //method of main class which return object
        return SingletonHelper.INSTANCE;
    }
}
```

## How Do We Create an Immutable Class
1. Make your **class final**, so that no other classes can extend it.
2. Make all your **fields final**, so that they’re initialized only once inside the constructor and never modified afterward.
3. Don’t define/provide setter methods.
- **Example :**
```java
package com.app;

public final class ImmutableStudent {
    private final int id;
    private final String name;
	//ctor
    public ImmutableStudent(int id, String name) {
        this.name = name;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
```
## Life Cycle Of MVC
- Thin client send a request.
- It will first reaches to **web.xml** file where we did servlet mapping.
- Then this request routed by the **servlet Container** to **DispatcherServlet** Which is act like **front Controller** provided by Spring Container
- DispatcherServlet take help of **Handler Mapping** to select Apropriate Controller.
- Handler Mapping chooes a controller based on Request **URl**
- Request thus reaches to Specific Controller, Then Controller use service , DAO layer and execute BL.
- result of BL is now return back to DispatcherServlet as a **ModelAndView** Object
- Then This Object send to **ViewResolver** to get the **view page ( JSP )**
- Then Page  will rendered to user

## SOLID Principles
- The SOLID design principles were promoted by Robert C. Martin and are some of the best-known design principles in object-oriented software development. 
### 1. Single Responsibility Principle
- _"One class should have one and only one responsibility"_

- In given example, we have two classes Person and Account. Both have single responsibility to store their specific information. If we want to change state of Person then we do not need to modify the class Account and vice-versa.
- I have created **Three-Tier Architecture** application as my project so in that front end, back end and database it all have its own responsibilities.
- **Example :**
```java
public class Person 
{
    private Long personId;
    private String firstName;
    private String lastName;
    private String age;
    private List<Account> accounts;
}

public class Account 
{
    private Long guid;
    private String accountNumber;
    private String accountName;
    private String status;
    private String type;
}
```
### 2. Open Closed Principle
- _“Software components should be open for extension, but closed for modification”_

- For example, spring framework has class DispatcherServlet.
- This class acts as front controller for String based web applications.
- To use this class, we are not required to modify this class.
- All we need is to pass initialization parameters and we can extend it’s functionality the way we want.


### 3. Liskov’s Substitution Principle
- _“Derived (child) types must be completely exchangeable for their base (Parent) types”_
	
- Substitutability is a principle in object-oriented programming stating that
- if child is a subtype of parent, then objects of type parent may be replaced with objects of type child without altering any of the desirable properties of the program.
- Ostrich is a bird, But it can't fly, Ostrich class is a subtype of class Bird, But it can't use the fly method, that means that we are breaking LSP principle.

### 4. Interface Segregation Principle
- _“Clients should not be forced to implement unnecessary methods which they will not use”_

- Developer vishal created an interface Reportable and added two methods generateExcel() and generatedPdf().
- Now client wants to use this interface but he want to use reports only in PDF format and not in excel.
- He will have to implement both the methods, out of which one is extra burden put on him by designer of software.
- This is not a good design.
- Solution is to create two interfaces by breaking the existing one.
- They should be like PdfReportable and ExcelReportable. This will give the flexibility to user to use only required functionality only.

### 5. Dependency Inversion Principle
- _“Depend on abstractions, not on concretions”_

- Based on this idea, Robert C. Martin’s definition of the Dependency Inversion Principle consists of two parts:
	1. - High-level modules should not depend on low-level modules. Both should depend on abstractions.
	2. - Abstractions should not depend on details. Details should depend on abstractions.
- In spring framework, all modules are provided as separate components which can work together by simply injected dependencies in other module. This dependency is managed externally in XML files.

## Difference between Mysql and Nosql .
|    **MySQL**						           |                    **NoSQL**                      |
|----------------------------------------------|---------------------------------------------------|
|Relational database Management system (RDBMS) |	Non-relational or distributed database system. |
|These databases have fixed or static or predefined schema |	They have have dynamic schema      |
|Verticlly Scalable			                    | Horizontally scalable|
|stores data in a table where the data is neatly separated into rows and columns. | store data in JSON in a very flexible way |
|SQL is a better fit for complex query environment	| NoSQL databases isn’t a good fit for complex queries |
|Structured Query language	| Unstructured Query language |

## ACID properties:

### Atomicity:
- All the operations inside transaction take place or Not or rolled back.

### Consistency: 
- In the middle of transaction if there is an error in transaction then all the changes that already made will be rolled back automaticlly.

### Isolation: 
- Every transaction is individual and one transaction can't acces the result of other until the transaction completed.
- that's mean at a time only one transaction can happen.

### Durability:
- once the transaction completed, then the changes it has made to the database will be permanent even if there is a system failuer or any abnormal changes.

## Types of index in SQL
### 1. Clusterd Index
- It store recored physiclly in Acending order by Primary key.
- Your table has primary key as ID, when you insert data into table in any order it will maintain recored in acending order.
- This type of index is only one per table

### 2. Non-Clusterd Index
- In database storage this type of index is stored at one place and table is stored in another place.
- we can create multiple index per table.
- **Example :**
	- 1. textBook
	- 2. Apartment flat no list at entry gate

## Stored Procedure
```sql
DELIMITER $$
CREATE PROCEDURE sp_insert_book
(
IN pBookId INT,
IN pSubjectName VARCHAR(256),
IN pBookName VARCHAR(256),
IN pAuthorName VARCHAR(256),
IN pPrice FLOAT
)
BEGIN
INSERT INTO BookTable
VALUES (pBookId, pSubjectName, pBookName, pAuthorName, pPrice);
END $$
DELIMITER ;
```
```sql
DROP PROCEDURE procedureName;
DELIMITER $$
CREATE PROCEDURE procedureName(para1 varchar(12))
BEGIN
    SELECT * FROM EMP WHERE job=para1;
END $$
DELIMITER ;
```
```sql
DELIMITER $$
CREATE PROCEDURE sp_select_book( )
BEGIN
SELECT * FROM BookTable;
END $$
DELIMITER ;
```
## Functions In SQL

```SQL
DROP FUNCTION IF EXISTS F1;
DELIMITER $$
CREATE FUNCTION F1() RETURNS varchar(100)
BEGIN
    DECLARE x varchar(100) default 'Hello World';
    SELECT "Hello World";
     call p1(x);
     return x;
END $$
DELIMITER ;
```
```sql
DROP FUNCTION functionName;
DELIMITER $$
CREATE FUNCTION functionName() RETURNS int
BEGIN
    DECLARE x int;
    SET x = 1001;
    RETURN (x);
END $$
DELIMITER ;
```
```SQl
DROP FUNCTION IF EXISTS functionName;
DELIMITER $$
CREATE FUNCTION functionName(no int) RETURNS varchar(20)
BEGIN
   DECLARE x varchar(20);
   SELECT DISTINCT 'Number present' INTO x FROM t1 WHERE c1 = no;
  IF x IS NOT NULL THEN
	RETURN(x);
  ELSE
	RETURN (no);
  END IF;
END $$
DELIMITER ;
```

## What are Views SQL??
- A view is nothing more than a SQL statement that is stored in the database with an associated name.
- A view is actually a composition of a table in the form of a predefined SQL query.
	
```sql
CREATE VIEW CUSTOMERS_VIEW AS
SELECT name, age
FROM  CUSTOMERS;
```
## Triggers In SQl
```SQl
DROP TRIGGER IF EXISTS triggerName;
DELIMITER $$
CREATE TRIGGER triggerName AFTER INSERT ON dept for each ROW
BEGIN
	INSERT INTO d1 VALUES (new.deptno, new.dname, new.loc, new.pwd);
END $$
DELIMITER ;
```
```SQl
DROP TRIGGER IF EXISTS triggerName;
DELIMITER $$
CREATE TRIGGER triggerName AFTER UPDATE ON dept for each ROW
BEGIN
	INSERT INTO d1 VALUES (old.dname, new.dname);
END $
DELIMITER ;
```
```SQl
DROP TRIGGER IF EXISTS triggerName;
DELIMITER $$
CREAsTE trigger triggerName AFTER DELETE ON dept for each ROW
BEGIN
	INSERT INTO d1 VALUES (old.deptno, old.dname, old.loc, old.pwd, NOW(), user());
END $
DELIMITER ;
```
### Transaction in SQL
- A transaction is an atomic unit of database operations against the data in one or more databases. The effects of all the SQL statements in a transaction can be either all committed to the database or all rolled back.
```sql
SET autocommit = 0 / 1;
-- or
SET autocommit = OFF / ON;

-- Example
	
-- 1. start a new transaction
START TRANSACTION;
 
-- 2. insert a new order for customer 145
INSERT INTO orders(orderNumber,orderDate, requiredDate, shippedDate, status, customerNumber)
VALUES( 1, '2005-05-31', '2005-06-10','2005-06-11','In Process', 145);
        
-- 3. Insert order line items
INSERT INTO orderdetails(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber)
VALUES( 1,'S18_1749', 30, '136', 1), ( 1,'S18_2248', 50, '55.09', 2);
      
-- 4. commit / rollback changes    
COMMIT / ROLLBACK;
```
## What is mysql database engine?
- Storage engines are MySQL components that handle the SQL operations for different table types.
- InnoDB is the default and most general-purpose storage engine, and Oracle	recommends using it for tables except for specialized use cases.

## what is ECMAScript? 
- ECMA means European Computer Manufacturer’s Association
- ECMAScript is a standard. JavaScript and ActionScript are well-known implementations of the ECMAScript standard.
- JavaScript is a subset of ECMAScript. 
- JavaScript is basically ECMAScript at its core but builds upon it. 
- Languages such as ActionScript, JavaScript, JScript all use ECMAScript as its core. 
- As a comparison, AS/JS/JScript are 3 different cars, but they all use the same engine. Each of their exteriors is different though, and there have been several modifications done to each to make it unique.
- The history is, Brendan Eich created Mocha which became LiveScript, and later JavaScript.
- Netscape presented JavaScript to Ecma International, which develops standards and it was renamed to ECMA-262 aka ECMAScript.
- It's important to note that Brendan Eich's "JavaScript" is not the same JavaScript that is a dialect of ECMAScript.
- He built the core language which was renamed to ECMAScript, which differs from the JavaScript which browser-vendors implement nowadays.
	
## Point wise ES:

1. ECMAScript is a Standard for a scripting languages.
2. Languages like Javascript & ActionScript are based on the ECMAScript standard.
3. ECMA Standard is based on several originating technologies, the most well known being JavaScript (Netscape) and JScript (Microsoft).
4. ECMA means European Computer Manufacturer’s Association

## Why Anguler ???
1. The main goal was to separate the DOM manipulation from application logic.
2. The second main important goal was to separate the client-side from the server-side.
3. Write less code due to CLI will provide ready made basic code
4. Unit testing ready
5. DOM Manipulation is so much easy - ngIf ngFor directive


## How to take data from .ts file to html file in angular??

* by using interpolation {{veriable or property name}}


### 1. Two-Tier Architecture:
- The two-tier is based on Client Server architecture.
- The two-tier architecture is like client server application.
- The direct communication takes place between client and server.
- There is no intermediate between client and server. 
- Because of tight coupling a 2 tiered application will run faster.

* Client Application (Client Tier)
* Database (Data Tier)

### 2. Three-Tier Architecture : 
- Three-tier architecture typically comprise a presentation tier, a business or data access tier, and a data tier. 
- Three layers in the three tier architecture are as follows:
* Client layer
* Business layer
* Data layer


## Types of joins : 
* Inner join
* Left outer join
* Right outer join
* Cross join
	
	
## The following table lists the important built-in AngularJS directives.
* ng-app
* ng-init
* ng-model
* ng-controller
* ng-show
* ng-readonly
* ng-disabled
* ng-if
* ng-repeat
* ng-click
* router-outlet


## AngularJS Routing with Parameters: Single Page Application Example
### What is Single Page Applications?
- Single page applications or (SPAs) are web applications that load a single HTML page and dynamically update the page based on the user interaction with the web application.

## What is Routing in AngularJS?
- In AngularJS, routing is what allows you to create Single Page Applications.
- AngularJS routes enable you to create different URLs for different content in your application.
- AngularJS routes allow one to show multiple contents depending on which route is chosen.

- Router-outlet in Angular works as a placeholder which is used to load the different components dynamically based on the activated component or current route state. 
- Navigation can be done using router-outlet directive and the activated component will take place inside the router-outlet to load its content.

```HTML
<router-outlet></router-outlet>  <!-- add this tag into html page -->
```
```TypeScript
import { Routes, RouterModule } from '@angular/router'; 

const appRoutes: Routes = [  
    { path: '', redirectTo: 'dashboard', pathMatch: 'full' },    
    { path: 'dashboard', component: DashboardComponent },    
    { path: 'about', component: AboutComponent },    
    { path: 'contact', component: ContactComponent },   
]; 
```
---

```TypeScript
import { Component, OnInit } from "@angular/core";

@Component({
  templateUrl:"button.html" //this is the component which has the above button html
})

export class App implements OnInit{
  constructor(){}

  ngOnInit(){

  }

  myFunc(){
    console.log("function called");
  }
}
```
---

```HTML
<button (click)="myFunc()"></button>
```
---

## 1. One-way Data Binding :
- One-way data binding will bind the data from the component to the view (DOM) or from view to the component.
- One-way data binding is unidirectional.
- You can only bind the data from component to the view or from view to the component.
	
* 1. Interpolation Binding: Interpolation refers to binding expressions into marked up language.
```HTML
		<strong>{{lastName}}</strong>
```
```TypeScript
firstName: string = "Vishal";
```
* 2. Property Binding: Property binding is used to set a property of a view element.
The binding sets the property to the value of a template expression.
```HTML
	<button (click)="myFunction()">Show alert</button>
```
```TypeScript
		myFunction(): void { 
       			alert('Show alert!'); 
   				} 
```

* 3. Attribute Binding: Attribute binding is used to set a attribute property of a view element.
```HTML
	<span [innerHTML]='firstName'></span>
```		

* 4. Class Binding: Class binding is used to set a class property of a view element.
	
* 5. Style Binding: Style binding is used to set a style of a view element.
```HTML
		<h1 [style.color]="blue">This is a Blue Heading</h1>
```

## 2. Two-way Data Binding in Angular
- Two-way data binding in Angular will help users to exchange data from the component to view and from view to the component.

```html
	<input type="text" [(ngModel)] = 'val' />
```	
Before using ngModel to achieve two-way data binding, it’s very important to import the FormsModule from @angular/forms in app.module.ts file as shown below. FormsModule will contain the ngModule directive.

```TypeScript
	import { NgModule } from '@angular/core'; 
	import { FormsModule } from "@angular/forms";
```

## Have you used onclick function in angular ? Write syntax for that.

```html
<button (click)=”handleClick($event)” type=”button”>Button</button>
```
## Write syntax for ngModel directive.

```HTML
<input [(ngModel)]="name" #it="ngModel" required>
<p>Value: {{ name }}</p>
<p>Valid: {{ it.valid }}</p>
<button (click)="setValue()">Set value</button>
``` 

## Waterfall Methodology of Software Devolopment life cycle (SDLC).
1. **Requirements**
2. **Design**
3. **Implementation**
4. **Varification**
5. **Maintainance**

## AGILE Methodology of SDLC
1. **Requirements**
2. **Design**
3. **Development**
4. **Testing**
5. **Deployment**
6. **Review/Feedback**