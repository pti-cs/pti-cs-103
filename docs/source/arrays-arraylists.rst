Arrays
======

Topics
------

1. Motivation
2. Creating arrays
3. Programming with arrays
4. Exchanging and shuffling
5. Exercises

Motivation
----------

Consider this snippet of code:

.. code:: java

	if      (day ==  0) System.out.println("Monday");
	else if (day ==  1) System.out.println("Tuesday");
	else if (day ==  2) System.out.println("Wednesday");
	else if (day ==  3) System.out.println("Thursday");
	else if (day ==  4) System.out.println("Friday");
	else if (day ==  5) System.out.println("Saturday");
	else if (day ==  6) System.out.println("Sunday");

.. epigraph::

	**Question:** What does this code do?

This code prints the day of the week after conditioning on the value of an integer `day`. But this code is repetitive. It would be useful if we had some way of creating a list of days of the week, and then just specifying which of those days we wanted to print. Something like this:

.. code:: java

	System.out.println(DAYS_OF_WEEK[day]);

To achieve this in Java, we need arrays. An *array* is an ordered and fixed-length list of values that are of the same type. We can access data in an array by *indexing*, which means referring to specific values in the array by number. If an array has :code:`n` values, then we think of it as being numbered from :code:`0` to :code:`n-1`.

Creating arrays
---------------

The syntax for creating an array in Java has three parts:

1. Array type
2. Array name
3. Either: array size or specific values

For example, this code creates an array of size :code:`n = 10` and fills it with all :code:`0.0`s.

.. code:: java

	double[] arr;                    // Declare array
	arr = new double[n];             // Initialize the array
	for (int i = 0; i < n; i++) {    // Iterate over array
	    arr[i] = 0.0;                 // Initialize elements to 0.0
	}

The key steps are: we first declare and initialize the array. We then loop over the array to initialize specific values. We can also initialize the array at compile time, for example

.. code:: java

	String[] DAYS_OF_WEEK = {
	//  Indices:
	//  0         1          2            3           4         5           6
	    "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
	};

Notice the difference in syntax. When creating an empty array, we must specify a size. When initialize an array at compile time with specific values, the size is implicit in the number of values provided.

Finally, in Java, it is acceptable to move the brackets to directly after the type declaration to directly after the name declaration. For example, these two declarations are equivalent:

.. code:: java

	int arr[];
	int[] arr; 

Programming with arrays
-----------------------

Indexing
~~~~~~~~

Consider the array :code:`DAYS_OF_WEEK` from the previous section. We can *index* the array using the following syntax:

.. code:: java

	System.out.println(DAYS_OF_WEEK[3]);  // Prints "Thursday"

In Java, array's are said to use *zero-based indexing* because the first element in the array is accessed with the number :code:`0` rather than `1`.

	**Question:** What does :code:`System.out.println(DAYS_OF_WEEK[1]);` print?

	**Question:** What does this code do? What number does it print?

	.. code:: java

		double sum = 0.0;
		double[] arr = { 1, 2, 2, 3, 4, 7, 9 }
		for (int i = 0; i < arr.length; i++) {
		    sum += arr[i];
		}
		System.out.println(sum / arr.length);

Array length
~~~~~~~~~~~~

As mentioned previously, arrays are *fixed-length*. After you have created an array, it's length is unchangeable. You can access the length of an array :code:`arr[]` with the code :code:`arr.length`.

	**Question:** What does :code:`System.out.println(DAYS_OF_WEEK.length);` print?

	**Exercise:** Write a :code:`for` loop to print the days of the week in order (Monday through Sunday) using an array rather than seven :code:`System.out.println` function calls.

Default initialization
~~~~~~~~~~~~~~~~~~~~~~

In Java, the default initial values for numeric primitive types is :code:`0` and :code:`false` for the :code:`boolean` type.

	**Exercise:** Consider this code from earlier:

	.. code:: java

		double[] arr;
		arr = new double[n];
		for (int i = 0; i < n; i++) {
		    arr[i] = 0.0;
		}

		Rewrite this code to be a single line.

Bounds checking
~~~~~~~~~~~~~~~

Consider this snippet of code.

	**Question:** Where is the bug?

	.. code:: java

		int[] arr = new int[100]; 
		for (int i = 0; i <= 100; ++i) {
		    System.out.println(arr[i]);
		}

The issue is that the program attempts to access the value :code:`arr[100]`, while the last element in the array is :code:`arr[99]`.

This kind of bug is called an "off-by-one error" and is so common... well, it has a name. In general, an off-by-one-error is one in which a loop iterates one time too many or too few.

	**Question:** Where is the off-by-one-error?

	.. code:: java

		int[] arr = new int[100]; 
		for (int i = 100; i > 0; --i) {
		    System.out.println(arr[i]);
		}

	**Exercise:** Fill in the missing code in this :code:`for` loop to print the numbers in reverse order, i.e. :code:`5, 4, 3, 2, 1`:

	.. code:: java

		int[] arr = { 1, 2, 3, 4, 5 };
		for (???) {
		    System.out.println(arr[i]);
		}

Exchanging and shuffling
------------------------

Two common tasks when manipulating arrays are *exchanging two values* and *shuffling* values. (*Sorting* is more complicated and will be address later.)

To exchange to values, consider the following code:

.. code:: java

	double[] arr = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
	int i = 1;
	int j = 4;
	double tmp = arr[i]; 
	arr[i] = arr[j]; 
	arr[j] = tmp;

.. pull-quote::

	**Exercise:** What are the six values in the array, in order?

To shuffle the array, consider the following code:

.. code:: java

	int n = arr.length; 
	for (int i = 0; i < n; i++) { 
	    int r = i + (int) (Math.random() * (n-i)); 
	    String tmp = arr[r];
	    arr[r] = arr[i];
	    arr[i] = tmp;
	}

.. pull-quote::

	**Question:** What does this code do:

	.. code:: java

		for (int i = 0; i < n/2; i++) {
		    double tmp = arr[i];
		    arr[i] = arr[n-1-i];
		    arr[n-i-1] = tmp;
		}

5. Exercises
------------

1. Write a program that reverses the order of values in an array.
2. What is wrong with this code snippet?

	.. code:: java

		int[] arr;
		for (int i = 0; i < 10; i++) {
		    arr[i] = i;
		}

3. Write a program :code:`HowMany.java` that takes an arbitrary number of command line arguments and prints how many there are.

References
----------

- `Computer Science: An Interdisciplinary Approach <https://introcs.cs.princeton.edu/java/14array/>`_, Robert Sedgewick and Kevin Wayne.