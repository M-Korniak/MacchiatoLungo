# MacchiatoLungo
Project that simulates simple programming language "Macchiato". 

# How does it work?
Program provides two ways to run a program:

Execution without debugging: In this mode, the program runs from start to finish unless an execution error occurs. Even in case of an error, the debugger is not activated.
Execution with debugging: In this mode, the program pauses immediately (before executing the first instruction) and waits for commands entered from standard input.
The debugger accepts one-character commands. After the command name (as described later), there may be one or more spaces followed by an optional integer.

# Debugger command set:

c(ontinue): A parameterless command. In the debugging mode, it resumes the program's execution from the current point to the end. If the program has already finished, the command only displays an appropriate message and does nothing more.

s(tep) <number>: In the debugging mode, this command executes exactly <number> steps. A step is defined as the execution of a single instruction (including nested instructions). After executing the specified number of steps, it displays the instruction (which may be a compound instruction) to be executed next. If the program reaches its end before executing the specified number of instructions, it displays an appropriate message and terminates normally.

d(isplay) <number>: This command displays the current variable values. The parameter indicates how many levels of higher blocks' variable values should be displayed. The d 0 command means displaying the current variable values. If the specified number is greater than the nesting level of the current program instruction, it only displays an appropriate message.

e(xit): This command terminates the program's execution and ends the debugger. It does not display the final variable values.

d(ump) <number>: his command allows you to create a memory dump of the program to a file. The command is represented by 'm' and requires a single parameter, which is the file path. The effect of this command should be the textual representation of the program's memory dump saved in the specified file. The memory dump includes:

Visible procedure declarations, including their names and parameter names (without their bodies).
The current variable values (as in the d 0 command).

The Macchiato language only allows variables with single-letter names (English alphabet letters from 'a' to 'z'). All variables are of type int, similar to Java.

# Programs can contain the following instructions:

Block: A block consists of variable declarations and a sequence of instructions. Each of these parts can be empty. Declarations in a block are visible from their declaration point to the end of their block (and nowhere else). Local declarations can shadow outer declarations.

For Loop: A for loop executes a block of instructions a specified number of times. It uses a loop variable that takes on values from 0 to the specified number - 1. The number of iterations is determined by an expression, and this expression is only evaluated once before the loop begins. If the computed value is less than or equal to zero, the loop doesn't execute any iterations. An error in evaluating the expression terminates the loop.

Conditional Statement (if-else): The meaning of this instruction is standard. It first evaluates the first expression, then the second expression. An error in evaluating either expression terminates further execution of this instruction. The else part with its instructions is optional.

Assignment: An assignment sets a variable to the value of an expression. An error in evaluating the expression terminates the assignment instruction. An error occurs if there is no visible variable with the specified name at that point in the program.

Print Statement: It evaluates an expression and prints its value to the standard output. If evaluating the expression fails, this instruction does not print anything.

Procedure: Can be thought of as functions that take zero or more parameters and do not return a value (i.e., they are of type void). You can declare procedures and then call them with appropriate arguments within your program.

# Within blocks, you can have variable declarations:

Variable Declaration: This introduces a variable into the current scope (associated with the containing block) and initializes it with the evaluated value of an expression. You cannot declare two or more variables with the same name within the same block. Variable names from different blocks can be the same, which means that variables can shadow each other (instructions and expressions always see the variable declared in the nearest enclosing block).

You can only declare variables at the beginning of a block, within the variable declarations.

If an error occurs during the execution of an instruction, program execution is terminated, and an error message is printed. This message includes the values of all variables visible within the block where the error occurred (these variables can be declared in that block or in surrounding blocks). The instruction directly causing the error is also printed.

# In the Macchiato language, all expressions have integer values. An expression can have one of the following forms:

Integer Literal: The value of this expression is the value of the literal. The syntax and range of literals are the same as in Java for the int type.

Variable: The value of this expression is the value of the variable visible at that point in the program. If no visible variable has the specified name, evaluating the value results in an error.

Addition: This expression calculates the sum of two expressions. It first evaluates the first expression, then the second, and adds the obtained values. If the addition exceeds the range, you should provide the same result as Java for such values.

Subtraction: This expression calculates the difference between two expressions. It first evaluates the first expression, then the second, and subtracts the second value from the first. If the result is out of range, you should provide the same result as Java.

Multiplication: This expression calculates the product of two expressions. It first evaluates the first expression, then the second, and multiplies the obtained values. If the result is out of range, you should provide the same result as Java.

Division: This expression performs integer division between two expressions. It first evaluates the first expression, then the second, and divides the first value by the second. If the second expression evaluates to zero, evaluating the division results in an error. If the two expressions have different signs, you should provide the same result as Java.

Modulo: This expression calculates the remainder of integer division between two expressions. It first evaluates the first expression, then the second, and calculates the remainder of the first value divided by the second. If the second expression evaluates to zero, evaluating the modulo results in an error. If the two expressions have different signs, you should provide the same result as Java.

# Builder

To make it more convenient to create Macchiato programs in Java, a set of classes and methods provide a DSL-like approach, allowing you to add declarations and instructions sequentially using method calls (similar to the builder pattern). Additionally, you can create expressions using clear, static functions.
