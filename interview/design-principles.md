# SOLID

Developed for OOP and recognized as best practices for
software development.

1. Single Responsibility Principle (SRP)
Single class should be responsible for doing one thing well and not many things.
2. Open-Closed Principle (OCP)
Classes should be open for extension but not modification. This means that adding new functionality
must not modify existing code.
3. Liskov Substitution Principle (LSP)
Subclass must be usable in place of its super(parent) class without changing functionality.
4. Interface Segregation Principle (ISP)
Software entities(classes) should NOT depend only on interfaces that they do not use. Every entity
needs an interface tailored to the needs of this entity.
For example, class that communicates with DB must NOT use interface for every possible
DB operation. It needs an interface only with READ and WRITE methods.
5. Dependency Inversion Principle (DIP)
Class should depend on abstractions and interfaces and not on some class implementation.
For example, you make shopping cart system. The class should NOT depend on an actual product
class implementation. Product class should implement an interface or abstract class and you
can just use methods like `getPrice` or `getQuantity` specified in the interface or in
the abstract class. Such apps are easier to maintain. If product class implementation changes,
it does not affect the shopping cart class.



# DRY (Don't Repeat Yourself)
This principle emphasizes the importance of not duplicating code, and instead encourages 
creating reusable code that can be called from multiple places.

# YAGNI (You Ain't Gonna Need It): 
This principle suggests that you should avoid writing code that you don't currently need, 
as it can lead to unnecessary complexity and wasted effort.

# KISS (Keep It Simple, Stupid): 
This principle encourages writing code that is simple and easy to understand, rather than 
overcomplicating things unnecessarily.

# Separation of Concerns: 
This principle suggests dividing a software system into different components or modules that 
handle different aspects of the system's functionality, making the system easier to understand and modify.

# Composition over Inheritance: 
This principle suggests that using composition (combining multiple smaller classes or components 
to create a larger system) is often preferable to using inheritance (creating new classes by 
inheriting from existing ones), as it can lead to a more flexible and maintainable codebase.


# Domain driven design(DDD)
Software design approach that focuses on the core domain of software application that is a business problem 
software is trying to solve. By following DDD developers create software that is more aligned with business problem.
DDD forces close collaboration of developers and domain experts(e.g. Security Analysts).
Key concepts and principles:
1. domain specific language that is shared and used by everyone.
2. bounded context: break down large systems within domain into smaller parts. Each has its own responsibilities.
3. Aggregates: Aggregates are clusters of related objects that are treated as a single unit. Aggregates define rules how 
objects within aggregate are mutated.
Each aggregate consists of:
  - Aggregate Root: specific entity that serves as access point to the aggregate main(e.g. Order)
  - Entity objects: any object that has their own identity and lifecycles(e.g. Product, User)
  - Value Objects: immutable objects without lifecycles. The are used as properties for Entities(e.g. Money, DateRange)
Order aggregate in example can expose such methods:
addItem, addAddress etc.
4. domain events: significant occurrences or state transitions within the domain. In e-commerce example a significant
event is order placement. System can publish the event(e.g. save in DB) and make it available for other parts of the
system that are interested in event and trigger further actions.
5. domain services: domain services represent operations or behaviors that do not naturally belong to a specific entity 
or value object but are still relevant to the domain. These service also enforce rules and behaviours within a system.
For example PaymentService, PricingService, AuthService.
