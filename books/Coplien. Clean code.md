# Ch1
If you start having bad code, it incentivises others to make more bad code.

Clean code is:
- elegant and efficient. Straightforward and makes it hard for bugs to hide.
- error handling is complete
- does one thing well
- simple and direct. Reads like a well written prose
- when you read it, you feel that person cared about it
- has meaningfull names
- is easy to enhance by other devs
- runs all tests
- contains no duplicates
- minimizes number of entities such as classes, functions etc
- when you read it, you read what you expected
- code makes the language look like it was meant for the problem

# Ch3 Function
- function should do just one thing
- code under `if` or `for` statements should be a separate function
- funcitons must be small
- function should deal with one single level of abstraction. The deeper levels should be covered with other functions
- function names and argument names should describe what the function does.
For example
```
openFile(name)
```
- ideally functions have no more than 1 argument. Never more than three. Try combining arguments into objects if needed.
- avoid using flag(bool) arguments. This is indicator that a function DOES NOT do one thing but many.
- avoid side effects(some other calls or initiations) in a function
- avoid code duplications.

# Ch4 Comments
- do not comment bad code. Improve the code and do not write comments.
- TODOs are fine but revisit and fix them regularly.
- Comment code lines only when you cannot find a descriptive function or variable
name.
- comments are often misleading and get outdated. Avoid comments.
- never code out some code chunks. Everything is saved in code version system. Just delete it!

# Ch5 Formatting
- divide with an empty line things that do not belong together(eg imports, function declarations, blocks with instance variables etc)
- variables that are needed in one place should be declared before place where they are used.
- variables that are needed everywhere i a class should be declared on top of the class.
- Vertical proximity: functions that are related should be next to each other vertically.
- Good idea to never have to scroll to the right. Keep your lines under 70 chars.