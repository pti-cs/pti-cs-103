## TODO:

- How to deal with references? (similar to Greg's question)
- Consider adding history of CS

# CS 103 Introduction to Computer Science

## Lecture 1. Introduction

### Topics

1. Overview of course
2. Components of a computer
3. Types of computers
4. Why computers are useful
5. First program

### 1. Overview of course

Knowing just a little bit of computer science can get you started right away in actual applications. One of the goals of this course is to learn about the fascinating subject of computer science. Another is to develop algorithmic thinking skills that will help with day-to-day critical problem-solving skills. But perhaps the most important goal of the course is to develop coding skills, which will not only open up new job opportunities but also make you more effective in most areas of business. 

In the first semester, we will spend the first two classes of each week on computer science theory and special topics. The final day of each week will be a lab day, where we actually start practicing coding skills. 

In the second semester, we will start focusing more on practical coding, with a single day a week for theory and 2 lab periods per week for coding. 

Broadly, we will cover the following topics: 
* How modern computers work
- Hardware
- Software
- Computer networks and information systems
* Algorithms for quickly solving complex problems
- Searching
- Sorting
* Data structures 
- Arrays
- ArrayLists
* Applications of Computer science
- Basic coding in Java
- How to use productivity software

### 2. Components of a computer
A computer is an electronic device used to process data. Its basic role is to convert data into information that is useful to people. 

There are 4 primary components of a computer:

#### 2.1 Hardware
Computer hardware consists of physical, electronic devices. These are the parts you actually can see and touch. Some examples include
- Central processing unit (CPU) 
- Monitor
- CD drive
- Keyboard
- Computer data storage
- Graphic card
- Sound card
- Speakers
- Motherboard

We will discuss these components in more detail in lecture 3. 

#### 2.2 Software
Software (otherwise known as "programs" or "applications") are organized sets of instructions for controlling the computer. 

There are two main classes of software:
- Applications software: programs allowing the human to interact directly with the computer
- Systems software: programs the computer uses to control itself

Some more familiar applications software include
- Microsoft Word: allows the user to edit text files
- Internet Explorer: connects the user to the world wide web
- iTunes: organizes and plays music files

While systems software allows the user to interact with the computer, systems software keeps the computer running. The operating system (OS) is the most common example of systems software, and it schedules tasks and manages storage of data. 

We will dive deeper into the details of both applications and systems software in lecture 4.

#### 2.3 Data
Data is fundamentally information of any kind. One key benefit of computers is their ability to reliably store massive quantities of data for a long time. Another is the speed with which they can do calculations on data once they recieve instructions from a human user. 

While humans can understand data with a wide variety of perceptions (taste, smell, hearing, touch, sight), computers read and write everything internally as "bits", or 0s and 1s. 

Computers have software and hardware which allow them to convert their internal 0s and 1s into text, numerals, and images displayed on the monitor; and sounds which can be played through the speaker. 

Similarly, humans have hardware and software used for converting human signals into computer-readable signals: a microphone converts sound, a camera converts pictures, and a text editor converts character symbols. 

#### 2.4 Users
Of course, there would be no data and no meaningful calculations without the human user. Computers are ultimately tools for making humans more powerful. 

As we will see in the next section, however, different types of computers have different roles for the user. 

### 3. Types of computers

#### 3.1 Supercomputers
These are the most powerful computers out there. The are used for problems that take a long time to calculate. They are rare because of their size and expense, and therefore primarily used by big organizations like universities, corporations, and the government. 

The user of a supercomputer typically gives the computer a list of instructions, and allows the supercomputer to run on its own over the course of hours or days to complete its task. 

#### 3.2 Mainframe computers
Although not as powerful as supercomputers, mainframe computers can handle more data and run much faster than a typical personal computer. Often, they are given instructions only periodically by computer programmers, and then run on their own for months at a time to store and process incoming data. For example, census number-crunching, consumer statistics, and transactions processing all use mainframe computers. 

#### 3.3 Personal computers
These are the familiar computers we use to interact with applications every day. Full-size desktop computers and laptop computers are examples. 

#### 3.4 Embedded systems
In the modern "digital" age, nearly all devices we use have computers embedded within them. From cars to washing machines to watches to heating systems, most everyday appliances have a computer within them that allows them to function.

#### 3.4 Mobile devices
In the past 2 decades, mobile devices have exploded onto the scene, and smartphones have essentially become as capable as standalone personal computers for many tasks. 

### 4 Why computers are useful

Computers help us in most tasks in the modern age. We can use them, for example, to
- write a letter
- do our taxes
- play video games
- watch videos
- surf the internet
- keep in touch with friends
- date
- order food
- control robots and self-driving cars

> **Exercise:** What are some other tasks a computer can accomplish?  

This is why the job market for computer scientists continues to expand, and why computer skills are more and more necessary even in non-computational jobs.

According to a [Stackoverflow survey from 2018](https://insights.stackoverflow.com/survey/2018/), 11% of coders have only been at it for 0-2 years. This demonstrates two things:
1. The job market for people with coding skills is continually expanding
2. It doesn't take much to become a coder

Some examples of careers in computer science include
- IT management / consulting
- Game developer
- Web developer
- UI/UX designer
- Data analyst
- Database manager

### 5 [First program](https://introcs.cs.princeton.edu/java/11hello/)
Note: this entire section is taken from the intro to CS course at Princeton. 

We will now write our first program in Java, which will demonstrate the 3 basic steps to get a simple program running.

1. Create the program by typing it into a text editor and saving it to, for example, MyProgram.java
2. Compile it by typing "javac MyProgram.java" in the terminal window. 
3. Execute (or run) it by typing "java MyProgram" in the terminal window. 

The first step creates the program; the second translates it into a language more suitable for machine execution (and puts the result in a file named MyProgram.class); the third actually runs the program. 

#### 5.1 Creating a Java program
A program is nothing more than a sequence of characters, like a sentence, a paragraph, or a poem. To create one, we need only define that sequence characters using a text editor in the same way as we do for email. HelloWorld.java is an example program. Type these character into your text editor and save it into a file named HelloWorld.java.

```java
public class HelloWorld {
   public static void main(String[] args) {
      // Prints "Hello, World" in the terminal window.
      System.out.println("Hello, World");
   }
}
```

#### 5.2 Compiling a Java program. 

A compiler is an application that translates programs from the Java language to a language more suitable for executing on the computer. It takes a text file with the .java extension as input (your program) and produces a file with a .class extension (the computer-language version). To compile HelloWorld.java type the boldfaced text below at the terminal. (We use the % symbol to denote the command prompt, but it may appear different depending on your system.)

```
javac HelloWorld.java
```

If you typed in the program correctly, you should see no error messages. Otherwise, go back and make sure you typed in the program exactly as it appears above.

#### 5.3 Executing (or running) a Java program
Once you compile your program, you can execute it. This is the exciting part, where the computer follows your instructions. To run the HelloWorld program, type the following in the terminal window:

```
java HelloWorld
```

If all goes well, you should see the following response

```
Hello, world
```

#### 5.4 Understanding a Java program
The key line with System.out.println() prints the text "Hello, World" in the terminal window. When we begin to write more complicated programs, we will discuss the meaning of public, class, main, String[], args, System.out, and so on.

#### 5.5 Creating your own Java program
For the time being, all of our programs will be just like HelloWorld.java, except with a different sequence of statements in main(). The easiest way to write such a program is to:
- Copy HelloWorld.java into a new file whose name is the program name followed by .java.
- Replace HelloWorld with the program name everywhere.
- Replace the print statement by a sequence of statements.

> **Exercise:**
Create your own program, "HelloMe.java", that prints out "Hello <name>" with your own name in place of <name>. 