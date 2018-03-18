# java-tdd-kata-calculator-2.0
TDD Kata Calculator from another author.

## Definition
1. An empty string returns zero, e.g., `calculate("") = 0`

2. A single number returns the value, e.g., `calculate("1") = 1`

3. Two numbers, comma delimited, returns the sum, e.g., `calculate("1,2,3") = 6`

4. Two numbers, newline delimited, returns the sum, e.g., `calculate("1\n2\n3") = 6`

5. Three numbers, delimited either way, returns the sum, e.g., `calculate("1,2,3\n4") = 10`

6. Negative numbers throw an exception

7. Numbers greater than 1000 are ignored, e.g., `calculate(1,2,3,1000,1001) = 1006`

#Extras

8. A single char delimiter can be defined on the first line, e.g., `calculate(//#3#6#11) = 20`

9. A multi char delimiter can be defined on the first line, e.g., `calculate("[###]2###2###6") = 10`

10. Many single or multi-char delimiters can be defined, e.g., `calculate("//@[!!!]4@6!!!15") = 25`

11. Non numbers on expression return error: `"Expression must only contain numbers."`
