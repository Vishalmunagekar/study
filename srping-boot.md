## Spring boot annotations : 
Annotations in Spring Boot are a form of metadata that provide information about the code and are used to influence the behavior of the application. They are a core part of the Spring Framework and play a crucial role in configuring Spring applications. Here are some key annotations in Spring Boot and their purposes:

### Core Annotations
- `@SpringBootApplication` : This is a convenience annotation that combines three annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan. It enables auto-configuration, component scanning, and allows defining extra configuration on a Spring Boot application.
```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
- `@Configuration` : Indicates that the class can be used by the Spring IoC container as a source of bean definitions.
```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```
- `@ComponentScan` : Configures component scanning directives for use with @Configuration classes. It tells Spring where to look for annotated components.
```java
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
}
```
- `@Bean` : Indicates that a method produces a bean to be managed by the Spring container.
```java
@Bean
public MyService myService() {
    return new MyServiceImpl();
}
```
### Stereotype Annotations
- `@Component` : Indicates that an annotated class is a "component". Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.
```java
@Component
public class MyComponent {
}
```
- `@Service` : Indicates that an annotated class is a "service". This annotation serves as a specialization of @Component
```java
@Service
public class MyService {
}
```
- `@Repository` : Indicates that an annotated class is a "repository". It is a specialization of @Component and used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
```java
@Repository
public class MyRepository {
}
```
- `@Controller` : Indicates that an annotated class is a "controller" (a Spring MVC controller). It is a specialization of @Component and used to define web controllers.
```java
@Controller
public class MyController {
}
```
- `@RestController` : Combines @Controller and @ResponseBody, indicating that the class serves RESTful web services.
```java
@RestController
public class MyRestController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
```
### Dependency Injection Annotations
- `@Autowired` : Marks a constructor, field, setter method, or config method to be autowired by Spring’s dependency injection facilities.
```java
@Service
public class MyService {
    @Autowired
    private MyRepository myRepository;
}
```
- `@Qualifier` : Used along with @Autowired to specify which bean should be injected when there are multiple beans of the same type.
```java
@Service
public class MyService {
    @Autowired
    @Qualifier("mySpecialRepository")
    private MyRepository myRepository;
}
```
- `@Value` : Used for expression-driven dependency injection. It can be used to inject values from properties files.
```java
@Service
@Value("${my.property}")
private String myProperty;
```
### Spring MVC Annotations
- `@RequestMapping` : Used to map web requests to specific handler classes and/or handler methods.
```java
@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
```
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`: Specialized variants of `@RequestMapping` for specific HTTP methods.
```java
@RestController
public class MyRestController {
    @GetMapping("/items")
    public List<Item> getItems() {
        return itemService.getAllItems();
    }

    @PostMapping("/items")
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }
}
```

### Configuration and Profiles
- `@Profile` Specifies that a component is eligible for registration when one or more specified profiles are active.
```java
@Service
@Profile("development")
public class DevelopmentService {
    // Development-specific code
}
```
### Scheduling
`@Scheduled` Marks a method to be scheduled at a fixed rate or with a `CRON` expression.
```java
@Component
public class ScheduledTasks {
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("The time is now " + new Date());
    }
}
```
## `@PostConstruct` and `@PreDestroy`
- Spring allows us to attach custom actions to bean **creation** and **destruction**

### `@PostConstruct`
- Spring calls the methods annotated with `@PostConstruct` only once, just after the initialization of bean properties. Keep in mind that these methods will run even if there’s nothing to initialize.
- The method annotated with `@PostConstruct` can have any access level, but it **can’t be static**.
- One possible use of `@PostConstruct` is populating a database. For instance, during development, we might want to create some default users:

```java
@Component
public class DbInit {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void postConstruct() {
        User admin = new User("admin", "admin password");
        User normalUser = new User("user", "user password");
        userRepository.save(admin, normalUser);
    }
}
```
### `@PreDestroy`
- A method annotated with `@PreDestroy` runs only once, just before Spring removes our bean from the application context.
- Same as with `@PostConstruct`, the methods annotated with `@PreDestroy` can have any access level, but **can’t be static**.
- The purpose of this method should be to release resources or perform other cleanup tasks, such as closing a database connection, before the bean gets destroyed.
```java
@Component
public class UserRepository {

    private DbConnection dbConnection;
    @PreDestroy
    public void preDestroy() {
        dbConnection.close();
    }
}
```

## Bean scopes in Spring framework
In the context of Spring Framework, bean scopes define the lifecycle and visibility of the beans within the Spring IoC (Inversion of Control) container. Understanding these scopes is crucial for managing the behavior and dependencies of beans in a Spring application
1. **Singleton (default)** : 
    - **Description** : Only one instance of the bean is created per Spring IoC container.
    - **Use Case** : Shared, stateless beans like services or DAOs.
    - **Lifecycle** : The single instance is created at container startup (eager initialization) or on first use (lazy initialization).
2. **Prototype**
    - **Description** : A new instance is created each time the bean is requested.
    - **Use Case** : Stateful beans or those that maintain user-specific data.
    - **Lifecycle** : Instances are created and configured every time they are requested from the container.
3. **Request (Web-aware)**
    - **Description** : A single instance is created for each HTTP request. Applicable only in a web-aware Spring application context.
    - **Use Case** : Beans that need to be request-scoped, such as HTTP  request-specific attributes or information.
    - **Lifecycle** : The instance is created and disposed of for each HTTP request.
5. **Global Session (Portlets only)**
    - **Description** : A single instance is created for the global HTTP session. Applicable only in a Portlet context.
    - **Use Case** : Beans that need to be scoped to the global session in Portlet applications.
    - **Lifecycle** : Similar to the session scope but specific to portlets.
6. **Application**
    - **Description** : A single instance is created for the lifecycle of a ServletContext.
    - **Use Case** : Beans that need to be shared across multiple servlet-based applications running in the same ServletContext.
    - **Lifecycle** : The instance is created when the ServletContext is initialized and disposed of when the ServletContext is destroyed.
```java
@Bean
@Scope("prototype")
@Scope("request")
@Scope("globalSession")
@Scope("application")
public MyService myService() {
    return new MyServiceImpl();
}
```
- **Points to Note**
    - **Custom Scopes** : Spring also allows defining custom scopes for more specific use cases.
    - **Proxy Modes** : For scopes other than singleton and prototype, Spring uses proxies to manage the bean instances. Understanding proxy modes is also important.

```java
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS) or 
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
```

- **Interview Tips**
    - **Concept Understanding**: Explain each scope clearly with examples and typical use cases.
    - **Differences**: Highlight the differences between each scope, especially singleton and prototype.
    - **Web-aware Scopes** : Be ready to discuss scenarios involving web applications and how different scopes like request and session are managed.
    - **Annotations** : Be familiar with using the @Scope annotation and its attributes.
    - **Lifecycle Management** : Discuss how the lifecycle of beans is managed in different scopes and how it affects application design.

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

## The Spring *@Controller* and *@RestController* Annotations
- We can use the `@Controller` annotation for traditional Spring controllers, and it has been part of the framework for a very long time. *Spring 4.0* introduced the *@RestController* annotation in order to simplify the creation of RESTful web services. It's a convenient annotation that combines `@Controller` and `@ResponseBody`, which eliminates the need to annotate every request handling method of the controller class with the `@ResponseBody` annotation.

### @Controller: 
- We can annotate classic controllers with the `@Controller` annotation. This is simply a specialization of the `@Component` class, which allows us to auto-detect implementation classes through the classpath scanning. We typically use `@Controller` in combination with a `@RequestMapping` annotation for request handling methods.
- We annotated the request handling method with `@ResponseBody`. This annotation enables automatic serialization of the return object into the HttpResponse.
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
- `@RestController` is a specialized version of the controller. It includes the *@Controller* and `@ResponseBody` annotations, and as a result, simplifies the controller implementation.
- The controller is annotated with the `@RestController` annotation; therefore, the `@ResponseBody` isn't required. Every request handling method of the controller class automatically serializes return objects into HttpResponse.
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
### Spring Boot Actuator
Spring Boot Actuator is a sub-project of Spring Boot that provides a suite of built-in endpoints and tools for monitoring and managing Spring Boot applications in production environments. It offers a way to gain insights into the application's health, metrics, and various runtime information.

- **Key Features** :

1. **Health Checks** : 
    - Provides health indicators to check the status of various parts of the application, such as the database, message brokers, or custom components.
    - Accessible via the `/actuator/health` endpoint.
2. **Metrics** :
    - Exposes various metrics related to the application performance, such as memory usage, CPU usage, and request statistics.
    - Metrics can be accessed via the `/actuator/metrics` endpoint.
3. **Environment Information** :
    - Displays environment properties, including system properties, configuration properties, and command-line arguments.
    - Available through the `/actuator/env` endpoint.
4. **Application Info** :
    - Provides details about the application, like build information and version.
    - This information is accessible via the /actuator/info endpoint.
5. **HTTP Trace**:
    - Records HTTP requests and responses, useful for auditing and debugging.
Can be accessed via the `/actuator/httptrace` endpoint.
6. **Thread Dump** :
    - Shows the current state of the application's threads, helpful for diagnosing performance issues.
    - Accessible via the `/actuator/threaddump` endpoint.

**Usage** :

- **Configuration** :
    - Actuator endpoints can be enabled or disabled through the `application.properties` or `application.yml` configuration files.
    - Security settings can be applied to restrict access to sensitive endpoints.
- **Integration** :
    - Actuator can integrate with monitoring tools like Prometheus, Grafana, and more for advanced monitoring and alerting capabilities.
- **Example Configuration** : In application.properties:
```properties
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
```
- **Security Considerations** :
    - Ensure sensitive endpoints are secured and not exposed to unauthorized users, especially in production environments.
    - Use Spring Security to restrict access based on roles or authentication.

- **Importance in Real-World Applications:**
    - Helps in proactive monitoring and management of the application.
    - Simplifies troubleshooting by providing real-time insights into the application’s state.
    - Essential for maintaining the reliability and performance of the application in production.

### what if we provide application.properties and application.yml at the same time
- Yes! We can use both at same time in same project.
- When you use both `YML` and `properties` at same time, say for example
`application.yml` and `application.properties` at same time in same
project, first `application.yml` will be loaded, later
`application.properties` will be loaded.
- Important point to be noted is that if `application.yml` and `application.properties` have same keys for example in `application.yml` has `spring.app.name = testYML` and `application.properties` has `spring.app.name = testProperties` at same time in same project, then `application.yml` value will be overwritten by `application.properties` value since it is loading at last. And the value in `spring.app.name = testProperties`.


When using Dependency Injection (DI), there are three common types to choose from: **Constructor Injection**, **Setter Injection**, and **Field Injection**. Each type has its own use cases, advantages, and drawbacks. However, **Constructor Injection** is generally considered the best practice in most scenarios. Here's a breakdown of each type and the reasons why Constructor Injection is preferred:

### Types of Dependency Injection

1. **Constructor Injection**
   - Dependencies are provided through the class constructor.
   - Example:

   ```java
   public class Car {
       private final Engine engine;

       // Constructor Injection
       public Car(Engine engine) {
           this.engine = engine;
       }
   }
   ```

2. **Setter Injection**
   - Dependencies are provided through setter methods after the object is constructed.
   - Example:

   ```java
   public class Car {
       private Engine engine;

       // Setter Injection
       public void setEngine(Engine engine) {
           this.engine = engine;
       }
   }
   ```

3. **Field Injection**
   - Dependencies are injected directly into the fields of the class, usually using annotations (like `@Autowired` in Spring).
   - Example:

   ```java
   public class Car {
       @Autowired
       private Engine engine; // Field Injection
   }
   ```

### Which Type of DI Should Be Used?

**1. Constructor Injection: Best Practice**

- **Advantages**:
  - **Immutability**: Makes it easy to create immutable objects since all dependencies are provided at construction time.
  - **Mandatory Dependencies**: Clearly indicates that the class cannot be instantiated without its required dependencies. This ensures that all required dependencies are available and avoids the risk of a partially constructed object.
  - **Testability**: Makes the class more testable by allowing the developer to inject mock dependencies directly through the constructor.
  - **Single Responsibility**: Keeps the code clean and adheres to the Single Responsibility Principle (SRP), as the class's dependencies are clearly defined.
  - **Avoids NullPointerException**: Since dependencies are required at construction time, it minimizes the risk of `NullPointerException` due to uninitialized dependencies.

- **Disadvantages**:
  - **Multiple Dependencies**: When there are many dependencies, constructors can become cumbersome with a large number of parameters.

**2. Setter Injection: Use for Optional Dependencies**

- **Advantages**:
  - **Optional Dependencies**: Useful when some dependencies are optional and may not always be needed.
  - **Flexibility**: Provides flexibility by allowing dependencies to be set or changed after object creation.

- **Disadvantages**:
  - **Mutable State**: Allows dependencies to be changed after object creation, which can make objects mutable and harder to reason about.
  - **Lack of Clarity**: Can lead to unclear object construction, as it may not be obvious what dependencies are required for the object to function properly.

**3. Field Injection: Not Recommended for General Use**

- **Advantages**:
  - **Simplicity**: It's easy to use, especially with frameworks like Spring, where it reduces boilerplate code.
  
- **Disadvantages**:
  - **Hidden Dependencies**: Makes it difficult to see what dependencies a class requires at a glance, reducing code readability and maintainability.
  - **Impedes Testability**: Harder to test because you can't easily provide mock objects via fields, leading to potential dependency on the DI framework.
  - **Violates Encapsulation**: Directly exposes dependencies as fields, potentially breaking encapsulation principles.
  - **Less Flexible**: Dependencies cannot be set or changed after object creation without reflection or other means, making it less flexible.

### Conclusion: Best Practice

- **Use Constructor Injection** for all required dependencies. It ensures immutability, clear contract for dependencies, and better testability. This is why Constructor Injection is generally considered the best practice.
- **Use Setter Injection** only for optional dependencies that are not always required for the object to function.
- **Avoid Field Injection** unless you have a specific use case where simplicity is crucial, and you're willing to trade off some testability and flexibility.

By following these guidelines, you will create more maintainable, testable, and robust code.