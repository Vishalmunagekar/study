**IoC (Inversion of Control)** is a design principle in software development where the control of objects or portions of a program is transferred to a container or framework. It is a key concept in frameworks like Spring, where the creation and management of objects (such as dependencies) are handled by the framework instead of the developer.

### What IoC Means

1. **Traditional Control Flow**:
   - In traditional programming, the developer is responsible for creating objects and managing their dependencies. For example, you would manually create instances of classes and handle their lifecycles.

2. **Inversion of Control**:
   - With IoC, the framework or container takes over the responsibility of creating and managing objects. Instead of objects being created and managed by the application code, they are created, configured, and managed by the IoC container.

### Key Benefits of IoC

1. **Decoupling**: 
   - IoC helps decouple the application components. Classes do not need to know about the dependencies they require; they only need to specify what they need, and the IoC container provides them.
   
2. **Testability**: 
   - By using IoC, you can easily replace dependencies with mock or stub implementations, which is highly beneficial for unit testing.

3. **Flexibility and Configurability**:
   - The behavior of your application can be easily changed by reconfiguring the dependencies in the IoC container, without needing to change the application's code.

4. **Simplified Code**:
   - Reduces the need for boilerplate code to manage object lifecycles, dependency lookups, and other concerns, making the code cleaner and easier to maintain.

### Types of IoC

There are different types of IoC, typically implemented via a design pattern:

1. **Dependency Injection (DI)**:
   - The most common type of IoC. Dependencies are provided (injected) into a class, typically via constructors, setters, or method parameters.
   
2. **Service Locator**:
   - A less commonly recommended type of IoC where objects ask a service locator for dependencies. While it is technically an IoC pattern, it often leads to more tightly coupled code than Dependency Injection.

### Example of IoC Using Dependency Injection

Consider a simple example of IoC using Spring:

#### Without IoC

```java
public class Car {
    private Engine engine;

    public Car() {
        this.engine = new Engine(); // Car is tightly coupled with Engine
    }
}
```

#### With IoC (Using Spring)

```java
public class Car {
    private Engine engine;

    @Autowired // Dependency Injection via constructor
    public Car(Engine engine) {
        this.engine = engine;
    }
}
```

In this example, the `Engine` dependency is injected into the `Car` class, which means the `Car` class does not create the `Engine` object itself. Instead, a framework like Spring creates and manages the `Engine` object and injects it into `Car` when needed.

### In Summary

**IoC (Inversion of Control)** is a design principle that delegates control of object creation and management to a container or framework, such as Spring, to achieve loose coupling, better testability, and easier maintainability of code. The most common way to implement IoC is through Dependency Injection.

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

## Singleton class

### 1. Lazy Instatiation
```java
public class Singleton {
	private Singleton() { 	}
	
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