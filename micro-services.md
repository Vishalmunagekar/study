# Microserices
| Aspect                | Monolithic Architecture                               | Microservices Architecture                          |
|-----------------------|-------------------------------------------------------|-----------------------------------------------------|
| **Codebase**          | Single unified codebase                               | Multiple independent services                       |
| **Deployment**        | Entire application is deployed as one unit            | Each service is deployed independently              |
| **Scalability**       | Scale the entire application                          | Scale individual services based on demand           |
| **Development**       | Simple initially but complex as it grows              | Complex initially but more manageable as it grows   |
| **Reliability**       | Failure in one component can bring down the whole app | Failure in one service doesn't affect the whole app |
| **Technology Stack**  | Typically a single technology stack                   | Different services can use different technologies   |
| **Communication**     | Intra-process communication                           | Inter-process communication (typically over HTTP/REST, gRPC, messaging) |
| **Data Management**   | Single database                                       | Each service manages its own database               |
| **Flexibility**       | Less flexible, tightly coupled components             | Highly flexible, loosely coupled services           |
| **Maintenance**       | Harder to maintain as application grows               | Easier to maintain and update individual services   |
| **Testing**           | Easier to test the entire application in one go       | Requires more effort to test each service independently and together |
| **Deployment Time**   | Longer deployment times                               | Faster deployments due to smaller services          |
| **Fault Isolation**   | Poor fault isolation                                  | Excellent fault isolation                           |
| **Team Structure**    | Teams often work on the entire application            | Teams can be organized around individual services   |

## Design Patterns in Microservices
### API Gateway
An API Gateway is a server that acts as an API front-end, handling requests from clients and routing them to the appropriate backend services. It provides a single entry point for all client interactions with the microservices.

#### Key Functions of an API Gateway:
1. **Request Routing** : Directs client requests to the appropriate microservice based on URL paths or other request attributes.

2. **Load Balancing**: Distributes incoming requests across multiple instances of a service to ensure no single instance is overwhelmed.

3. **Security** : Handles authentication and authorization, ensuring that only authorized clients can access the services. It can also implement SSL termination.

4. **Rate Limiting and Throttling** : Controls the number of requests a client can make in a given time period to protect services from being overwhelmed.

5. **Caching** : Stores responses from services temporarily to reduce load and improve performance for repeated requests.

6. **Monitoring and Logging** : Tracks and logs request and response data for monitoring and debugging purposes.

7. **Transformation** : Converts request and response formats as needed, such as transforming XML to JSON.

8. **Aggregation** : Combines responses from multiple services into a single response for the client, reducing the number of calls a client needs to make.

#### Example Technologies:
- **Spring Cloud Gateway** : A Java-based framework providing routing and more, built on top of Spring Boot and Spring WebFlux.
- **Kong** : An open-source API Gateway built on NGINX.
- **NGINX** : A widely used web server that can also be configured as an API Gateway.
- **AWS API Gateway**: A managed service by Amazon Web Services for creating and managing APIs.

### Service Registry and Discovery
In a microservices architecture, services need to discover each other dynamically because they might scale up and down or change locations. Service Registry and Discovery mechanisms handle this dynamic nature.

#### Service Registry:

- **Central Database** : A service registry is a central database that keeps track of all the available services and their instances.
- **Registration** : Services register themselves with the service registry upon startup and deregister when they shut down.
- **Heartbeats** : Services periodically send heartbeats to the registry to confirm their availability.

#### Service Discovery:
- **Client-Side Discovery**:
    - Clients query the service registry to get the location of a service instance and make a direct call.
    - Example technologies: Netflix Eureka, Consul.

- **Server-Side Discovery**:
    - Clients make requests to a load balancer, which queries the service registry and forwards the request to an appropriate service instance.
    - Example technologies: AWS Elastic Load Balancer, Kubernetes.

#### Example Technologies:
- **Netflix Eureka** : A REST-based service registry used by Netflix OSS.
- **Consul** : A service mesh solution providing service discovery, configuration, and segmentation.
- **Zookeeper** : A centralized service for maintaining configuration information, naming, and providing distributed synchronization.