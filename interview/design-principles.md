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
Developing system with deep understanding of the system domain.
Promotes:
- domain specific language that is shared and used by everyone.
- bounded context: break down large systems within domain into smaller parts. Each has its own responsibilities.
