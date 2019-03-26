Hardware, Variables and Data Types
==================================

.. contents:: Topics
  :local:
  :depth: 2
  :backlinks: none
  
Hardware
********

Overivew Sentence.. Todo...

Computer Systems
----------------

A computer systems is a collection of components that allows a user to perform the basic
operations of input processing, storage, control, and output. Understanding how each of
these components combine allows us to create powerful information processing tools. Today we
will talk about each of these aspects in turn. Below, we see how some of these parts come together
to form a computer system (similar to the ones you'll use to program in this course).

.. figure:: images/cs_intro_hardware_overview.png
  :align: center
  
  Interconnected parts of a computer system (keyboard, mouse, monitor, DVD player / burner, speaker, hard drive, CPU).
  
This lecture is meant to serve as an overview of several key parts of computer systems. We'll focus on the
central processing unit (CPU), main and secondary memory, and input and output devices.


Central Processing Unit (CPU)
-----------------------------

The central processing unit (CPU) --- processor, main processor, etc. --- of a computer is the physical
circuitry of a computer that performs instructions. The CPU is in charge of fetching, decoding, and
executing all instructions. The basic building blocks of these instructions include arithmetic, logic,
control, input, and output. The set of basic instructions available to the CPU effects, what the computer
system can do (and how efficiently). Some CPU's are designed to handle a relatively small number of
instructions (integer addition, multiplication, division, conditional branching, store to memory, load
to memory). While others CPU's are designed to handle a large number of instructions (e.g. swap content
of memory locations, increment and store, etc. in addition to the simpler instructions).

While these instructions can be quite simple, we build up complex behaviours by combining these actions
into programs. When reasoning about how our programs will work, we should be aware of the limitations
imposed by the hardware we use. In mathematics, we often consider things in a very abstract way. In models
of computer systems, we often use unbounded arithmetic and allow a computer to have infinite memory; however,
in practice we need to run programs on processors with bounded computational and memory capabilities. In most
systems we encounter today, the CPU allows for 32 or 64 bit computations or memory read and writes in a single
instruction. Because reading and writing to memory takes a long time (in comparison to arithemetic and logic
instructions), almost all CPUs include a very small number of memory blocks on the physical CPU to store
intermediate results of instructions, called registers. In modern CPUs this is further increased by allowing
even more levels of memory, called caches (Level 1, Level 2, and Level 3), that trade off between speed of access
and the size of the memory. We won't go in depth on how these work, but briefly mention them to help you
understand how modern computer systems work to acheive greater efficiency.

Memory
------

One of the most important parts of a computer, is the memory. There are two major types of memory, Main Memory
(RAM), and Secondary Memory (e.g. hard dists, solid-state drives, tape drives, etc.) Main memory is voalitile,
meaning it only persists while the computer is on. Between turning a computer on and off the main memory is
whiped. Secondary memory, on the other hand is persistent, it lasts between restarts of the computer system.
Main memory, is where the CPU stores programs and data it needs to execute instructions. Secondary memory, is
where persistent data such as files will be stored. When the CPU needs, it can bring data from secondary storage
to main memory or persists data in main memory to secondary memory.

Input and Output Devices
------------------------

The final parts of a computer system we'll talk about today, are input and output devices. Input and output devices
are pervasive and necessary to allow humans to interact with computer systems. Otherwise, these systems would be a
large block that computes some value, but we would have no method to inspect what this value is. Even the earliest
computing systems consisted of a terminal (keyboard and textual interface) and a computer. How do these input and
output devices work? Many input and output devices connect to a computer by interfacing with main memory. This is
known as memory mapped input and output. The device and computer agree upon a known interface and communicate by
storing values in the main memory. The exact method and values depend upon the agreed upon interface. Today there
are a great variety of input and output devices including monitors, speakers, keyboards, mice, CD/DVD drives, usb
drives, projectors, robotic arms, electric motors, etc.

Variables and Data Types
************************

Recall that in our discussion about the CPU, we mentioned that we're able to store the results of computations to
reference later. This allows us to build up more complex behaviors, and sometimes save a lot of repeated
computations (and time). Now, we're going to switch from talking about hardware in general, and talk about some
specifics of the Java programming language and how it handles variables and native data types (these align closely
with the type of data CPUs can handle in a single instruction). Last week, we saw our first java program that printed
out "Hello world!". Today, we'll introduce how to store data and operate on this stored data.

Variables
---------

Variables in programming languages, are similar to the ones we've seen in mathematics. They store a value that can be referenced. Unlike many of the variables in math, we can update the value it holds during the course of the program.
Consider the following block of code. We created a variable named x and assigned it the integer value 0. We then print
it's value to the screen. Reassign the value of x to 3 and print the new value to the screen. The basic declaration of
a variable in java consists of specifying a type, a name, and optionally an initial value (if no value is specified, the
default value for the given type is used, instead). In this program, we created a variable with type int (the type of integer values).

.. code:: java

    public class Example1 {
      public static void main(String[] args) {
        int x = 0;
        System.out.println(x);  // prints 0 to the screen
        x = 3;
        System.out.println(x);  // prints 3 to the screen        
      }
    }


Basic Types
-----------

What types of variables can we declare? We will go over a set of basic (or native or primitive) types that can be declared and how they differ. Below we see a table of each native type. Along side each type, we see how many bits each value takes (how much memory required to store a single value of the given type), what the minimum and maximum value / precision we can achieve with the given type. And an example declaration of a variable for the given type. Note that the void type is empty and we cannot create a variable of type void. Void represents the special type of return values for functions that do not return any value. The types byte, char, short, int, and long are integer types and represents integer values upto a given limit. Float and double are floating point numbers (numbers that allow for fraction parts, we will not discuss how these values are stored in memory). Boolean values represent truth (true or false).

+---------+------+-----------+-----------------+---------------------------------------------------------+------------------+
| Type    | Bits | Min Value | Max Value       | Precision                                               | Example          |
+---------+------+-----------+-----------------+---------------------------------------------------------+------------------+
| byte    | 8    | -128      | 127             | -128 to 127                                             | byte b = -3      |
+---------+------+-----------+-----------------+---------------------------------------------------------+------------------+
| char    | 16   | 0         | 2^16-1          | 0 to 67108863                                           | char c = 'a'     |
+---------+------+-----------+-----------------+---------------------------------------------------------+------------------+
| short   | 16   | -2^15     | 2^15-1          | -33554432 to 33554431                                   | short s = -2     |
+---------+------+-----------+-----------------+---------------------------------------------------------+------------------+
| int     | 32   | -2^31     | 2^31-1          | -2,147,483,648 to 2,147,483,647                         | int i = 1241     |
+---------+------+-----------+-----------------+---------------------------------------------------------+------------------+
| long    | 64   | -2^63     | 2^63-1          | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 | long l = -12     |
+---------+------+-----------+-----------------+---------------------------------------------------------+------------------+
| float   | 32   | 2^-149    | (2-2^-23)2^127  | 1.4E-45 to 3.402,823,5E+38                              | float f = 3.1    |
+---------+------+-----------+-----------------+---------------------------------------------------------+------------------+
| double  | 64   | 2^-1074   | (2-2^-52)2^1023 | 4.9E-324 to 1.797,693,134,862,315,7E+308                | double d = 3.1   |
+---------+------+-----------+-----------------+---------------------------------------------------------+------------------+
| boolean | --   | --        | --              | false, true                                             | boolean b = true |
+---------+------+-----------+-----------------+---------------------------------------------------------+------------------+
| void    | --   | --        | --              | --                                                      | --               |
+---------+------+-----------+-----------------+---------------------------------------------------------+------------------+

Operators
---------

How do we manipulate values of these types? We can modify values using operators. These values take one or more values and produces a new value. For interger type variables, we have the common arithmetic operators: addition (+), multiplication (x), division (/), modulo (%), increment (++), decrement (++), and assignment (=).

.. code:: java

    public class Example2 {
      public static void main(String[] args) {
        int x = 0;
        ++x;  // equivalent to x = x + 1  (pre increment)
        System.out.println(x);   // prints 1 to the screen

        System.out.println(x++); // prints 1 to the screen then increments x (post increment)
        System.out.println(x);   // prints 2 to the screen
        
        System.out.println(3 + 7); // prints 10
        System.out.println(4 - 6); // prints -2        
        
        int y = (x * 5) % 3;    // y = (2 * 5) % 3 = 10 % 3 = 1   -- 10 = 3 * 3 + 1
        
        System.out.println(y + x); // pritns 3 to the screen
      }
    }

In addition to the common arithmetic operations, we also have logic opeartions: equality (==), inequality (!=), less than (<), greater than (>), and (& or &&), or (| or ||), not (!), and xor (^). Below are table of how these operators perform. The single ampersand and bar and and or operations are non-short circuiting (e.g. they always evaluate both sides of the operator). This is important because of side-effects of these expressions (e.g. (0 == 1) && (1 / 0 != 3) vs (0 == 1) & (1 / 0 != 3) the first will work but the second will throw and errow when run).

+---+---+-------+-------+--------+--------+-------+----+
| A | B | A & B | A | B | A && B | A || B | A ^ B | !A |
+---+---+-------+-------+--------+--------+-------+----+
| T | T | T     | T     | T      | T      | F     | F  |
+---+---+-------+-------+--------+--------+-------+----+
| T | F | F     | T     | F      | T      | T     | F  |
+---+---+-------+-------+--------+--------+-------+----+
| F | T | F     | T     | F      | T      | T     | T  |
+---+---+-------+-------+--------+--------+-------+----+
| F | F | F     | F     | F      | F      | F     | T  |
+---+---+-------+-------+--------+--------+-------+----+

+---+---+--------+--------+-------+-------+
| x | y | x == y | x != y | x < y | x > y |
+---+---+--------+--------+-------+-------+
| 0 | 1 | F      | T      | T     | F     |
+---+---+--------+--------+-------+-------+
| 2 | 2 | T      | F      | F     | F     |
+---+---+--------+--------+-------+-------+
| 7 | 3 | F      | T      | F     | T     |
+---+---+--------+--------+-------+-------+
