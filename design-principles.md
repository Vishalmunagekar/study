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

**Aspect-Oriented Programming (AOP)** is a programming paradigm that allows you to modularize cross-cutting concerns in your application. In simpler terms, AOP is a way to inject additional behavior into existing code without modifying it directly, which makes your codebase cleaner, more readable, and easier to maintain.

### Key Concepts of AOP:

1. **Aspect**: A module that encapsulates a cross-cutting concern, such as logging, security, or transaction management. In Spring, an aspect is typically a class annotated with `@Aspect`.

2. **Join Point**: A point in the execution of the program, such as a method call or an exception being thrown. In Spring, join points are usually method executions.

3. **Advice**: The action taken by an aspect at a particular join point. For example, advice can run before, after, or around a method execution. There are several types of advice in Spring:
   - **Before Advice**: Runs before the method execution.
   - **After Advice**: Runs after the method execution, regardless of its outcome.
   - **After Returning Advice**: Runs after a method execution only if it completes successfully.
   - **After Throwing Advice**: Runs if a method throws an exception.
   - **Around Advice**: Surrounds a method call, allowing you to perform actions before and after the method execution.

4. **Pointcut**: A set of one or more join points where an advice should be executed. Pointcuts are expressions that match join points. In Spring, you define pointcuts using AspectJ expressions.

5. **Weaving**: The process of linking aspects with other application types or objects to create an advised object. Weaving can occur at compile time, load time, or runtime. Spring AOP performs weaving at runtime using proxies.

### How AOP is Implemented in Spring:

Spring AOP is implemented using **dynamic proxies** or **AspectJ**. Here's how it works:

1. **Dynamic Proxies**:
   - Spring uses JDK dynamic proxies or CGLIB proxies to implement aspects. 
   - If the target object implements at least one interface, a JDK dynamic proxy is created. Otherwise, a CGLIB proxy is created.
   - Proxies wrap the target object and intercept method calls to add additional behavior before or after the method execution.

2. **AspectJ**:
   - Spring also supports integration with AspectJ, a more powerful and flexible AOP framework that provides compile-time and load-time weaving.
   - AspectJ allows for more complex aspects and offers a richer set of join points (not limited to method execution).
   - To use AspectJ in Spring, you need to add the AspectJ libraries and configure Spring to use AspectJ's `@Aspect` annotations.

### Example of Implementing AOP in Spring:

Here's an example of how to implement logging with AOP in a Spring application:

1. **Add Dependencies**: Include the Spring AOP dependency in your `pom.xml` (for Maven):

   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-aop</artifactId>
   </dependency>
   ```

2. **Define an Aspect**:

   ```java
   import org.aspectj.lang.annotation.Aspect;
   import org.aspectj.lang.annotation.Before;
   import org.springframework.stereotype.Component;

   @Aspect
   @Component
   public class LoggingAspect {
       @Before("execution(* com.example.service.*.*(..))")
       public void logBeforeMethod() {
           System.out.println("A method in the service package is about to be executed.");
       }
   }
   ```

   - `@Aspect`: Marks the class as an aspect.
   - `@Before`: An advice type that runs before the matched method execution.
   - `execution(* com.example.service.*.*(..))`: A pointcut expression that matches any method execution within the `com.example.service` package.

3. **Enable AOP in Spring Configuration**:

   Ensure that AOP support is enabled in your Spring application by adding `@EnableAspectJAutoProxy` in your configuration class:

   ```java
   import org.springframework.context.annotation.Configuration;
   import org.springframework.context.annotation.EnableAspectJAutoProxy;

   @Configuration
   @EnableAspectJAutoProxy
   public class AppConfig {
   }
   ```

### Benefits of AOP in Spring:

- **Separation of Concerns**: AOP separates cross-cutting concerns (like logging, security) from the core business logic.
- **Code Reusability**: Reduces code duplication by allowing the reuse of aspects across multiple modules.
- **Modularity**: Makes code modular, cleaner, and easier to maintain.

### Conclusion:

AOP in Spring is a powerful mechanism to handle cross-cutting concerns, making the codebase more modular and easier to maintain. It provides a flexible way to apply aspects using Spring's proxy-based mechanism or AspectJ integration.

For more detailed information, check out the [Spring AOP documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop).