# angular-5-spring-REST-service
Web application created in Angular 5 with Spring REST service.

## Introduction

In this assignment, we developed a single page application with using Angular
5. Spring and Hibernate technologies are also used for back-end side. The client
side will be based on Angular while Spring Rest Services will be the server side.The
persistence layer provided by Hibernate and PostgreSQL database management
system.

### Use Case Diagram

![alt text](/diagrams/use-case.png)

- Multiple user can register to the system.
- Only registered user can access to application.
- Application allowed multitype user registration.
- Every customer can create order, check status of an order and update
her/him informations.
- Every owner can create, list, delete, update product also create, list and edit
customers.View orders, list specific customer orders and update order status
besides done by owners.
- Customers cannot access to owners part.

### Class Diagram

![alt text](/diagrams/class-diagram.png)

- Application starting with app.component.html.
- All routes keeps in app-routing.module.ts
- Module declarations, imported modules, provider services and bootstrap
module keeps in app.module.ts.
- We have the proxy.config.json file for routing request from angular
components to server side.
- We used spring rest services.We route the responses to angular through
cross origin annotation.
- All databases operations are done by repository classes through hibernate.

### Deployment Diagram

![alt text](/diagrams/deployment-diagram.png)
- Application uses Angular for front-end (client side), REST services for back-end
(server side).
- Angular running on localhost port:4200.
- REST services running on localhost port:8080.
- Clients reach the application via HTML browsers.
