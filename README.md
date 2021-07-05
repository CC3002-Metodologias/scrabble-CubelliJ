Author: Joaquin Cubelli

***

Interactive graphic programming language heavely inspired by Scratch. This work is licensed under a Creative Commoms Attribution 4.0 International Licence and aims purely to be used with the purpose of teaching in the context of the course CC3002 Metodologías de Diseño y programación of the Computer Sciences Department (DCC) of the University of Chile.

***

# Scrabble documentation

### Scrabble's Types:

This graphic programming language consists on the following types:

- Scrabble Numbers:
  - Integers (SInt)
  - Floats (SFloat)
  - Binary (SBinary)

- Scrabble String (SString)
- Scrabble Boolean (SBool)

#### Conversions:

These types allow to be converted between each other using the methods to\<SSType>() according to the conversions showed in this table:

|             | String | Bool | Float | Int | Binary |
|-------------|--------|------|-------|-----|--------|
| toSString() | Yes     | Yes   | Yes    | Yes  | Yes     |
| toSBool()   | No     | Yes   | No    | No  | No     |
| toSFloat()  | No     | No   | Yes    | Yes  | Yes     |
| toSInt()    | No     | No   | No    | Yes  | Yes     |
| toSBinary() | No     | No   | No    | Yes  | Yes     |

#### Operations:

And the following operations can be achieved with them:

|                 | String | Bool    | Float       | Int        | Binary     |
|-----------------|--------|---------|-------------|------------|------------|
| String operates | +      | +       | +           | +          | +          |
| Bool operates   |        | and, or |             |            | and, or    |
| Float operates  |        |         | +, -, x, /  | +, -, x, / | +, -, x, / |
| Int Operates    |        |         |             | +, -, x, / | +, -, x, / |
| Binary Operates |        | and, or |             | +, -, x, / | +, -, x, / |

Trying to make forbidden conversions or operations will result on an error or in a null result.

#### Programming on Scrabble:

A program can be constructed by the use of operations and variables.

The operations defined previously can be used in this fashon:

>       new Add(
> 
>               new SBinary("0100")),
> 
>               new SInt(16)).operate();
> This should return a new SBinary("011000") // 16 + 4 = 20

However, variables can be used to define certain values. For example we have,

>       Var("x", new SInt(20));

And if used in a VarFactory class, two variables can link to the same value in memory, for example:

>       VarFactory factory = new VarFactory();
>       factory.createVar("x", new SInt(20));
>       factory.createVar("y", new SInt(20));
>    Both variables x and y will be using the same value stored in memory.

This variables can save the result of an operation, for example:

>       factory.createVar("cond", SBool(true));
>       iComponent cond1 = new If(
>                                 factory.get("cond"),
>                                    new Add(
>                                        factory.get("x"), 
>                                        factory.get("y")),  
>                                    new Sub(
>                                        factory.get("x"),   
>                                        new SInt(5)));
>       factory.createVar("x", cond1.operate()); 
> If true, x will become 40, else x will decrease to 15.

While loops can be made too.

The nodes can be extended as a tree, making possible the creation of really complex programms.



