## OOPS Concepts :
Object-Oriented Programming (OOP) is a programming paradigm that uses "objects" to design software. It is built around the concept of objects, which can be instances of classes, and provides a way to structure programs so that properties and behaviors are bundled together. Here are the key principles and features of OOP:

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
    b.run();  // Running safely with 120km/hr
  }  
} 
```
## Method Overloading with `null`
In Java, method overloading allows multiple methods with the same name but different parameter types. When calling an overloaded method, the Java compiler determines which method to invoke based on the argument types provided.

When `null` is passed as an argument, it can match any reference type. In the context of method overloading, the compiler must decide which overloaded method to call based on the available options and the specificity of the parameter types.

The Java compiler uses a concept called **"most specific method"** to determine which method to call.

```java
public class OverloadExample {
    public static void method(Object s) {
        System.out.println("Object");
    }

    public static void method(String s) {
        System.out.println("String");
    }

    public static void main(String[] args) {
        method(null);  // This will call method(String s)
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

### Differences between the **`List`** and **`Set`** interfaces
The List and Set interfaces in Java are part of the Java Collections Framework and provide different ways of storing and managing groups of objects. Here are the key differences between the **`List`** and **`Set`** interfaces:
- **List Interface**
    - **Order** : Lists maintain the order of insertion. The elements are stored in a sequence, and the order in which elements are added is preserved.
    - **Duplicates** : Lists allow duplicate elements. Multiple elements with the same value can be added.
    - **Access** : Lists provide positional access and allow for elements to be retrieved, inserted, or modified by their index.
    - **Implementation Classes** : Common implementations include `ArrayList`, `LinkedList`, `Vector`, and `Stack`.
- **Set Interface**
    - **Order** : Sets do not guarantee the order of elements. Some implementations like LinkedHashSet maintain insertion order, while others like HashSet do not.
    - **Duplicates** : Sets do not allow duplicate elements. Each element must be unique.
    - **Access** : Sets do not provide positional access. Elements cannot be accessed by an index, and operations are based on the elements themselves.
    - **Implementation Classes** : Common implementations include `HashSet`, `LinkedHashSet`, and `TreeSet`.

#### **Practical Usage Scenarios**
- **`List`** : Use when you need an ordered collection that allows duplicates and where elements can be accessed by their index.
    - **Example** : Maintaining a list of tasks in the order they were added, including possible duplicate tasks.
    
- **`Set`**: Use when you need a collection of unique elements, and the order of elements is not critical (or where you need a specific order with LinkedHashSet or sorting with TreeSet).
    - **Example** : Storing a collection of unique user IDs.

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
## when to use Abstract class and Interface in java ?
In Java, both abstract classes and interfaces are used to achieve abstraction, but they have different use cases and characteristics. Here’s a comparison to help determine when to use each:

### Abstract Class
An abstract class is a class that cannot be instantiated on its own and is meant to be subclassed. It can have both abstract methods (without a body) and concrete methods (with a body).

#### Use an abstract class when:
1. **Shared State or Implementation** : You want to share code among several closely related classes. Abstract classes allow you to define methods that can be shared among subclasses.
2. **Partial Implementation** : You have a base class that provides some default behavior, and subclasses will provide the rest.
3. **Common Base Class** : You have classes that should be treated as the same type, and you want to use polymorphism.
4. **Non-Abstract Methods** : You want to provide some common non-abstract methods to subclasses.
5. **State Representation** : You need to maintain a state (fields) that can be inherited by subclasses.

```java
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method
    public abstract void makeSound();

    // Non-abstract method
    public void sleep() {
        System.out.println("Sleeping...");
    }
}

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
```

### Interface
An interface is a reference type in Java, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types. Interfaces cannot contain instance fields.

#### Use an interface when:
1. **Multiple Inheritance** : You need to implement multiple inheritance. A class can implement multiple interfaces, which is not possible with abstract classes.
2. **Unrelated Classes** : You want to define a contract that can be implemented by any class, from any inheritance tree. Interfaces are a good way to ensure that different classes follow a certain protocol.
3. **API Design** : You want to define the capabilities that a class must provide without dictating how they should be implemented.
4. **Non-Abstract Methods** : You want to provide some common non-abstract methods to subclasses.
5. **Functional Programming** : You need to use functional interfaces, especially for lambda expressions (e.g., Runnable, Callable, or custom functional interfaces).

```java
public interface Animal {
    void makeSound();
    void sleep();
}

public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    @Override
    public void sleep() {
        System.out.println("Sleeping...");
    }
}
```

#### Summary
- **Abstract Class** : Use when you have a clear hierarchy, need to share code among closely related classes, and need to maintain a state.
- **Interface** : Use when you need to define a contract for classes to follow, especially when multiple inheritance or unrelated classes are involved.

## why we can't create object of interface in java?
- Interface is basically a complete abstract class.
- So if we don't have any implementation of a method then that means if we create object of that interface and call that method it compile nothing as there is no code to compile.

## Default Methods In Java 8
- Before Java 8, interfaces could have only abstract methods. The implementation of these methods has to be provided in a separate class.
- So, if a new method is to be added in an interface, then its implementation code has to be provided in the class implementing the same interface.
- To overcome this issue, Java 8 has introduced the concept of default methods which allow the interfaces to have methods with implementation without affecting the classes that implement the interface.

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
    1. int compare(Object obj1,Object obj2);
    2. boolean equals(Object element);
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

### Finally block
In Java, the `finally` block is used to execute important code such as resource cleanup that must run regardless of whether an exception is thrown or not. It is typically used in association with `try` and `catch` blocks.

The finally block follows the try and catch blocks. It will always execute, even if an exception is not thrown or if an exception is caught and handled.

The code within the finally block is guaranteed to run even if a return statement is encountered in the try or catch blocks, or if an exception is thrown but not caught.

The primary use case for the finally block is resource management, such as closing files, releasing database connections, or cleaning up other resources.

Example :
```java
public class FinallyExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // This will throw an ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught an arithmetic exception: " + e.getMessage());
        } finally {
            System.out.println("This block is always executed.");
        }
    }
}
```
Output :
```csharp
Caught an arithmetic exception: / by zero
This block is always executed.
```
### Behavior with Return Statements:
Even if you have a return statement in the try or catch block, the finally block will still execute.
```java
public class FinallyExample {
    public static void main(String[] args) {
        System.out.println(testMethod());
    }

    public static String testMethod() {
        try {
            return "Try block";
        } catch (Exception e) {
            return "Catch block";
        } finally {
            System.out.println("Finally block");
        }
    }
}

```
Output :
```csharp
Finally block
Try block
```
##  Final keyword
In Java, the `final` keyword is used to apply restrictions on classes, methods, and variables. Its purpose is to prevent further modification and to enhance the safety and predictability of your code. Here’s how it is used:
#### Final Variables
- When a variable is declared with the `final` keyword, its value cannot be modified after it is initialized. This makes the variable a constant.
- For instance variables and local variables, the `final` keyword ensures that the variable is assigned only once. For object references, the reference cannot be changed, but the object itself can still be modified.
#### Final Methods
- When a method is declared as `final`, it cannot be overridden by subclasses. This is useful to prevent altering the intended behavior of the method in subclasses.
#### Final Classes
- When a class is declared as `final`, it cannot be subclassed. This is useful to prevent inheritance and to ensure that the class's behavior remains unchanged.
#### Final Parameters
- Method parameters can also be declared as `final`. This means the parameter cannot be modified within the method.

### Summary of Uses
1. Final Variable: A constant whose value cannot be changed once assigned.
2. Final Method: A method that cannot be overridden by subclasses.
3. Final Class: A class that cannot be subclassed.
4. Final Parameter: A parameter whose value cannot be modified within the method.
- Using the `final` keyword appropriately can help in writing more *robust*, *secure*, and *maintainable* code by explicitly preventing unintended modifications.


## static
The **static** keyword in Java is used to declare a member variable or method that belongs to the class itself, rather than to an instance of the class. This means that static members can be accessed without creating an instance of the class.

1. Static variables are shared by all instances of the class.
2. Static methods can be called without creating an instance of the class.
3. Static members can be accessed using the class name, rather than an instance variable.
4. Static members are initialized before any instance of the class is created.
5. Static members can only access other static members.

## marker interfaces
A marker interface in Java is an interface that does not contain any methods or constants. It is used to indicate that a class implementing the interface has some special property or behavior. Marker interfaces are used to provide additional information about an object to the compiler and JVM. This information can be used to perform certain actions or optimizations.

#### Key Characteristics of Marker Interfaces
- **No Methods** : Marker interfaces do not declare any methods. Their sole purpose is to mark or tag a class.
- **Semantic Role** : They provide metadata about a class to the Java runtime or other tools and frameworks.
- **Design Choice** : They serve as a design pattern to signal or flag certain behavior to the JVM or to the developers using the classes.

#### Common Examples of Marker Interfaces
1. **Serializable** : The `Serializable` interface is used to indicate that a class can be serialized, which means converting an object into a byte stream so that it can be easily saved to a file or transferred over a network.
2. **Cloneable** : The `Cloneable` interface indicates that a class allows for field-for-field copying through the Object.clone() method. If a class does not implement Cloneable and its clone method is called, a `CloneNotSupportedException` is thrown.
3. **Remote** : The `Remote` interface is used in RMI (Remote Method Invocation) to indicate that a class can be invoked remotely.

## Functional Interfaces :
Functional interfaces in Java are interfaces that have exactly one abstract method. These interfaces are intended to represent single abstract functionality that can be implemented using lambda expressions or method references. The concept of functional interfaces was introduced in Java 8 to support the functional programming paradigm and make the language more expressive and concise.

### Key Features of Functional Interfaces
- **Single Abstract Method** : A functional interface has only one abstract method. This method defines the contract that the lambda expression or method reference implements.
- **@FunctionalInterface Annotation** : While optional, this annotation can be used to indicate that an interface is intended to be a functional interface. The compiler will enforce this by generating an error if the interface doesn't conform to the rules of a functional interface.
- **Default and Static Methods** : A functional interface can have any number of default or static methods without affecting its status as a functional interface because these are not abstract methods.


- **Summary** : Functional interfaces in Java are a powerful feature that facilitates the use of lambda expressions and method references, enabling a more functional programming style. They provide a way to pass behavior as a parameter and make the code more readable and concise. The @FunctionalInterface annotation ensures that an interface meets the requirements of a functional interface, providing compile-time checking. Built-in functional interfaces like Function, Consumer, Supplier, Predicate, and BinaryOperator cover a wide range of common use cases, and custom functional interfaces can be easily created as needed.

1. **Consumer & BiConsumer**
```java
import java.util.*;
import java.util.function.Consumer;
import java.util.function.BiConsumer;

public class ConsumerExample {
    public static void main(String[] args) {
        // Example 1: Simple Consumer to print a string
        Consumer<String> printConsumer = s -> System.out.println(s);
        printConsumer.accept("We are using Consumer<T> interface..."); // The accept method consumes the input string

        // Example 2: Using Consumer with a list
        List<Integer> numberList = new ArrayList<>(Arrays.asList(10, 20, 30, 40));

        // Consumer to print each element in the list
        Consumer<Integer> printNumber = n -> System.out.println(n);
        numberList.forEach(printNumber); // forEach method uses the Consumer to process each element

        // Example 3: BiConsumer to combine two different types of input
        BiConsumer<Integer, String> printNumberWithText = (a, b) -> System.out.println(a + " " + b);
        printNumberWithText.accept(10, " <- Ten"); // Directly calling BiConsumer with two arguments

        // Example 4: Using BiConsumer with a Map
        Map<Integer, String> numberMap = new HashMap<>();
        numberMap.put(1, "One");
        numberMap.put(2, "Two");
        numberMap.put(3, "Three");
        numberMap.put(4, "Four");

        // BiConsumer to print each key-value pair in the map
        BiConsumer<Integer, String> printMapEntry = (number, value) -> System.out.println(number + " -> " + value);
        numberMap.forEach(printMapEntry); // forEach method uses the BiConsumer to process each entry in the map

        // Example 5: Chaining Consumers
        Consumer<Integer> multiplyByTwo = n -> System.out.println(n * 2);
        Consumer<Integer> squareNumber = n -> System.out.println(n * n);

        // Combining two Consumers: first multiply by two, then print the square
        Consumer<Integer> combinedConsumer = multiplyByTwo.andThen(squareNumber);

        System.out.println("Chained Consumer example:");
        numberList.forEach(combinedConsumer);
    }
}
```
2. **Supplier**
```java
import java.util.*;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        // Example 1: Simple Supplier that returns a fixed value
        Supplier<String> stringSupplier = () -> "Hello from Supplier!";
        System.out.println(stringSupplier.get()); // Calling get() to retrieve the value from the Supplier

        // Example 2: Supplier that generates a random number
        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100); // Generates a random number between 0 and 99
        System.out.println("Random Number: " + randomNumberSupplier.get());

        // Example 3: Supplier that returns the current date and time
        Supplier<Date> dateSupplier = () -> new Date();
        System.out.println("Current Date and Time: " + dateSupplier.get());

        // Example 4: Supplier with complex object creation
        Supplier<List<String>> listSupplier = () -> Arrays.asList("Apple", "Banana", "Cherry");
        List<String> fruitList = listSupplier.get();
        System.out.println("Fruit List: " + fruitList);

        // Example 5: Supplier with a factory method pattern
        Supplier<UUID> uuidSupplier = UUID::randomUUID; // Method reference to generate UUID
        System.out.println("Generated UUID: " + uuidSupplier.get());
    }
}
```
3. **Function & BiFunction**
```java
import java.util.*;
import java.util.function.Function;
import java.util.function.BiFunction;

public class FunctionExample {
    public static void main(String[] args) {
        // Example 1: Simple Function to convert Integer to String
        Function<Integer, String> intToStringFunction = i -> "Number: " + i;
        System.out.println(intToStringFunction.apply(5)); // Outputs "Number: 5"

        // Example 2: Function to calculate the square of a number
        Function<Integer, Integer> squareFunction = n -> n * n;
        System.out.println("Square of 4: " + squareFunction.apply(4)); // Outputs 16

        // Example 3: Function chaining using andThen
        Function<Integer, Integer> multiplyByTwo = n -> n * 2;
        Function<Integer, Integer> squareAndMultiply = squareFunction.andThen(multiplyByTwo);

        System.out.println("Square and then multiply by two of 3: " + squareAndMultiply.apply(3)); // Outputs 18

        // Example 4: BiFunction to concatenate two strings
        BiFunction<String, String, String> concatenateStrings = (s1, s2) -> s1 + " " + s2;
        System.out.println(concatenateStrings.apply("Hello", "World")); // Outputs "Hello World"

        // Example 5: BiFunction to add two numbers
        BiFunction<Integer, Integer, Integer> addNumbers = (a, b) -> a + b;
        System.out.println("Sum of 5 and 10: " + addNumbers.apply(5, 10)); // Outputs 15

        // Example 6: Using BiFunction with andThen
        BiFunction<Integer, Integer, Integer> multiplyNumbers = (a, b) -> a * b;
        Function<Integer, String> intToString = n -> "Result: " + n;

        // Multiply two numbers and then convert the result to a string
        String result = multiplyNumbers.andThen(intToString).apply(5, 4);
        System.out.println(result); // Outputs "Result: 20"
    }
}
```
4. **Predicate & BiPredicate**
```java
import java.util.*;
import java.util.function.Predicate;
import java.util.function.BiPredicate;

public class PredicateExample {
    public static void main(String[] args) {
        // Example 1: Simple Predicate to check if a number is even
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4)); // Outputs true
        System.out.println("Is 7 even? " + isEven.test(7)); // Outputs false

        // Example 2: Predicate to check if a string is empty
        Predicate<String> isEmpty = s -> s.isEmpty();
        System.out.println("Is the string empty? " + isEmpty.test("")); // Outputs true
        System.out.println("Is the string empty? " + isEmpty.test("Hello")); // Outputs false

        // Example 3: Combining Predicates using and(), or(), and negate()
        Predicate<String> isShortString = s -> s.length() <= 5;
        Predicate<String> startsWithH = s -> s.startsWith("H");

        Predicate<String> combinedPredicate = isShortString.and(startsWithH);
        System.out.println("Is 'Hello' a short string and starts with 'H'? " + combinedPredicate.test("Hello")); // Outputs true

        Predicate<String> complexPredicate = isShortString.or(startsWithH).negate();
        System.out.println("Is 'HelloWorld' neither a short string nor starts with 'H'? " + complexPredicate.test("HelloWorld")); // Outputs true

        // Example 4: BiPredicate to check if one string contains another
        BiPredicate<String, String> contains = (str, substr) -> str.contains(substr);
        System.out.println("Does 'HelloWorld' contain 'World'? " + contains.test("HelloWorld", "World")); // Outputs true
        System.out.println("Does 'HelloWorld' contain 'Java'? " + contains.test("HelloWorld", "Java")); // Outputs false

        // Example 5: BiPredicate to check if the sum of two numbers is greater than a threshold
        BiPredicate<Integer, Integer> sumGreaterThan = (a, b) -> (a + b) > 10;
        System.out.println("Is the sum of 5 and 7 greater than 10? " + sumGreaterThan.test(5, 7)); // Outputs true
        System.out.println("Is the sum of 3 and 4 greater than 10? " + sumGreaterThan.test(3, 4)); // Outputs false

        // Example 6: Using BiPredicate with and()
        BiPredicate<Integer, Integer> bothEven = (a, b) -> a % 2 == 0 && b % 2 == 0;
        BiPredicate<Integer, Integer> bothPositive = (a, b) -> a > 0 && b > 0;

        BiPredicate<Integer, Integer> combinedBiPredicate = bothEven.and(bothPositive);
        System.out.println("Are both 4 and 8 even and positive? " + combinedBiPredicate.test(4, 8)); // Outputs true
        System.out.println("Are both -2 and 8 even and positive? " + combinedBiPredicate.test(-2, 8)); // Outputs false
    }
}
```
## How Do We Create an Immutable Class
1. Make your **class final**, so that no other classes can extend it.
2. Make all your **fields final**, so that they’re initialized only once inside the constructor and never modified afterward.
3. Don’t define/provide setter methods.

### Built-in Immutable Classes:
 - **Wrapper classes** : `Integer`, `Long`, `Float`, `Double`, `Boolean`, `Character`, `Byte`, `Short`.
- **String class**: `String`.

**Example :**
```java
import java.util.Collections;
import java.util.List;

public final class MyImmutable {
    private final int id;
    private final String name;
    private final List<String> list;

    // Constructor
    public MyImmutable(int id, String name, List<String> list) {
        this.id = id;
        this.name = name;
        // Defensive copy to prevent external modification
        this.list = list == null ? Collections.emptyList() : List.copyOf(list);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        // Return an unmodifiable copy of the list
        return list;
    }
}
```

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
|		**Runnable interface** |			**Callable interface**			|
|-------------------------------|-------------------------------------------|
|It is a part of java.lang package since Java 1.0|It is a part of the java.util.concurrent package since Java 1.5.|
|It cannot return the return of computation.|It can return the result of the parallel processing of a task.|
|It cannot throw a checked Exception.|It can throw a checked Exception.|
|In a runnable interface, one needs to override the run() method in Java.|In order to use Callable, you need to override the call()|

## `hashCode` and `equals` methods
- In Java, the `hashCode` and `equals` methods are crucial for ensuring the correct behavior of objects, especially when using collections like `HashMap`, `HashSet`, and other data structures that rely on hashing. Here's why these methods are important:

### 1. **Purpose of `hashCode` Method:**

- The `hashCode` method returns an integer representation of the object’s memory address (or a computed value based on the object’s fields) that is used for hashing purposes in hash-based collections.
- It is used to quickly narrow down the potential matches in a hash table by calculating the bucket index.
- If two objects are equal according to the `equals` method, then they must have the same `hashCode` value.
  
### 2. **Purpose of `equals` Method:**

- The `equals` method checks whether two objects are logically equivalent, meaning it compares the content or state of the objects.
- By default, the `equals` method compares object references (i.e., whether they point to the same memory location), but it is often overridden to compare object contents (e.g., fields).
  
### **Why Both Methods Are Needed Together:**

- In hash-based collections (like `HashSet` or `HashMap`), the `hashCode` method is used first to find the correct bucket location, and then `equals` is used to check if the object already exists in the bucket.
- If only `hashCode` is used, it could incorrectly identify two different objects as the same because different objects can have the same hash code (hash collision).
- If only `equals` is used without `hashCode`, the performance of hash-based collections would degrade to O(n) since every object would have to be compared using `equals`.

### **Contract Between `hashCode` and `equals`:**

- **Consistent Behavior:** If the `equals` method considers two objects as equal, then `hashCode` must return the same integer result for these objects.
- **Not Required to Be Unique:** If two objects are not equal according to the `equals` method, their `hashCode` values do not have to be different (though it’s better if they are to minimize collisions).
  
### **Practical Example:**

Consider using a `HashSet` to store custom objects. If `hashCode` and `equals` are not properly implemented:

- Two logically equal objects could be stored in the set, violating the set’s uniqueness constraint.
- A `contains` check might fail because the `hashCode` points to a different bucket or `equals` isn't defined to check content correctly.

### **Example of Overriding `hashCode` and `equals`:**

Here’s a basic example of how to correctly override these methods in a Java class:

```java
import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```

### Summary:

- **`equals`**: Determines logical equality between objects.
- **`hashCode`**: Provides an integer value for hashing that allows objects to be stored/retrieved quickly in hash-based collections.
- Together, they ensure correct and efficient behavior in collections that rely on hashing, preventing data inconsistencies and performance issues.

The **Java Security Manager** is a security mechanism in the Java programming language that allows developers to enforce a set of access controls on Java applications. It provides a way to define a security policy that governs which resources (such as files, network connections, or system properties) a Java application can access or modify.

### Key Features of the Java Security Manager:

1. **Access Control**:
   The Security Manager controls access to system resources such as files, network sockets, and system properties. For example, it can prevent untrusted code from reading or writing to a file system or opening network connections.

2. **Policy-Based Permissions**:
   The Security Manager works in conjunction with a policy file that specifies what permissions are granted to various classes or code sources. This policy file can be customized by the developer or system administrator to enforce different levels of security depending on the needs of the application.

3. **Sandboxing**:
   The Java Security Manager is commonly used in sandbox environments, where untrusted or partially trusted code is executed. It restricts the code to only perform actions that are deemed safe and allowed by the policy.

4. **Protection Against Malicious Code**:
   It helps protect against malicious code that might attempt to perform harmful operations, such as deleting files, accessing sensitive information, or connecting to unauthorized network addresses.

5. **Runtime Enforcement**:
   The Security Manager operates at runtime, meaning it continuously monitors and enforces the security policy while the Java application is running.

### Usage of the Java Security Manager:

- **Enabling the Security Manager**: You can enable the Java Security Manager by specifying the `-Djava.security.manager` JVM option when starting a Java application, optionally providing a custom policy file using the `-Djava.security.policy` option.

```sh
java -Djava.security.manager -Djava.security.policy=myPolicy.policy MyApp
```

- **Custom Policies**: You can create a policy file (`.policy`) to define what permissions your Java application or code source has, such as file read/write permissions, network permissions, or access to system properties.

### Deprecation Notice:

As of Java 17, the Security Manager is deprecated and is planned for removal in future releases. This decision was made because the Security Manager has seen less usage in modern applications, and its capabilities have been replaced by more robust security practices and sandboxing mechanisms outside of the JVM itself【82†source】.

### Conclusion:

The Java Security Manager is a powerful feature for defining and enforcing security policies within Java applications. However, developers are encouraged to explore alternative security measures due to its planned deprecation.

For more details, you can refer to the [official Oracle documentation on Java Security Manager](https://docs.oracle.com/javase/8/docs/technotes/guides/security/PolicyFiles.html).