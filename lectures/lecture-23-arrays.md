### TODO

- Will the distinction between _declaring_ and _initializing_ have already been covered by this point?
- Should our lectures have acknowledgements?

---

# CS 103 Introduction to Computer Science

## Lecture 23. Arrays

### Topics

1. Motivation
2. Creating arrays
3. Programming with arrays
4. Exchanging and shuffling
5. Exercises


### 1. Motivation

Consider this snippet of code:

```java
else if (day ==  1) System.out.println("Monday");
else if (day ==  2) System.out.println("Tuesday");
else if (day ==  3) System.out.println("Wednesday");
else if (day ==  4) System.out.println("Thursday");
else if (day ==  5) System.out.println("Friday");
else if (day ==  6) System.out.println("Saturday");
if      (day ==  7) System.out.println("Sunday");
```

> **Question:** What does this code do?

This code prints the day of the week after conditioning on the value of an integer `day`. But this code is repetitive. It would be useful if we had some way of creating a list of days of the week, and then just specifying which of those days we wanted to print. Something like this:

```java
System.out.println(DAYS_OF_WEEK[day]);
```

To achieve this in Java, we need arrays. An _array_ is an ordered and fixed-length list of values that are of the same type. We can access data in an array by _indexing_, which means referring to specific values in the array by number. If an array has `n` values, then we think of it as being numbered from `0` to `n-1`.

### 2. Creating arrays

The syntax for creating an array in Java has three parts:

1. Array type
2. Array name
3. Either: array size or specific values

For example, this code creates an array of size `n = 10` and fills it with all `0.0`s.

```java
double[] arr;                    // Declare array
arr = new double[n];             // Initialize the array
for (int i = 0; i < n; i++) {    // Iterate over array
   arr[i] = 0.0;                 // Initialize elements to 0.0
}
```

The key steps are: we first declare and initialize the array. We then loop over the array to initialize specific values. We can also initialize the array at compile time, for example

```java
String[] DAYS_OF_WEEK = {
    "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
}; 
```

Notice the difference in syntax. When creating an empty array, we must specify a size. When initialize an array at compile time with specific values, the size is implicit in the number of values provided.

Finally, in Java, it is acceptable to move the brackets to directly after the type declaration to directly after the name declaration. For example, these two declarations are equivalent:

```java
int arr[];
int[] arr; 
```

### 3. Progamming with arrays

#### 3.1. Indexing

Consider the array `DAYS_OF_WEEK` from the previous section. We can _index_ the array using the following syntax:

```java
System.out.println(DAYS_OF_WEEK[3]);  // Prints "Thursday"
```

In Java, array's are said to use _zero-based indexing_ because the first element in the array is accessed with the number `0` rather than `1`.

> **Question:** What does `System.out.println(DAYS_OF_WEEK[1]);` print?

#### 3.2. Array length

As mentioned previously, arrays are _fixed-length_. After you have created an array, it's length is unchangeable. You can access the length of an array `arr[]` with the code `arr.length`.

> **Question:** What does `System.out.println(DAYS_OF_WEEK.length);` print?

> **Exercise:** Write a `for` loop to print the days of the week in order (Monday through Sunday) using an array rather than seven `System.out.println` function calls.

#### 3.3. Default initialization

In Java, the default initial values for numeric primitive types is `0` and `false` for the `boolean` type.

> **Question:** Consider this code from earlier:
>
> ```java
> double[] arr;
> arr = new double[n];
> for (int i = 0; i < n; i++) {
>    arr[i] = 0.0;
> }
> ```
>
> Rewrite this code to be a single line.

#### 3.4. Bounds checking

Consider this snippet of code. Where is the bug?

```
int[] arr = new int[100]; 
for (int i = 0; i <= 100; ++i) 
{
    System.out.println(arr[i]);
}
```

The issue is that the program attempts to access the value `arr[100]`, while the last element in the array is `arr[99]`.

This kind of bug is called an "off-one-one error" and is so common... well, it has a name. In general, an off-by-one-error is one in which a loop iterates one time too many or too few.

### 4. Exchanging and shuffling

Two common tasks when manipulating arrays are _exchanging two values_ and _shuffling_ values. (_Sorting_ is more complicated and will be address later.)

To exchange to values, consider the following code:

```java
double[] arr = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
int i = 1;
int j = 4;
double tmp = arr[i]; 
arr[i] = arr[j]; 
arr[j] = tmp;
```

> **Exercise:** What are the six values in the array, in order?

To shuffle the array, consider the following code:

```java
int n = arr.length; 
for (int i = 0; i < n; i++) { 
   int r = i + (int) (Math.random() * (n-i)); 
   String tmp = deck[r];
   arr[r] = arr[i];
   arr[i] = tmp;
} 
```

> **Exercise:** In words, what does this code do?

### 5. Exercises

1. Write a program that reverses the order of values in an array.
2. What is wrong with this code snippet?

```java
int[] arr;
for (int i = 0; i < 10; i++) {
   arr[i] = i;
}
```

3. Write a program `HowMany.java` that takes an arbitrary number of command line arguments and prints how many there are. 