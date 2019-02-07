Numbering Systems
=================

.. contents:: Topics
  :local:
  :depth: 1
  :backlinks: none

Overview
--------

How do we represent numbers? Based on how we represent numbers, certain operations can be easier or
harder. Today, we’ll consider two representations: decimal and binary numbers. Decimal numbers (decimal
notation or base 10) are what we’re all used to seeing in our daily lives. For example we could consider
the string of numbers:

.. math::
  19.874

And we know this represents the value nineteen thousand eight hundred seventy four. However, we could
consider representing numbers differently. Depending on how we represent numbers specific operations
become easier or harder. Let’s go back to our example and now we’ll multiply by 10.

.. math::
   19,874 &\\
   \times\hspace{0.75cm}10& \\
   \hline
   198,740 &

Decimal Numbers
---------------

When we see numbers in our daily lives there’s an implicit assumption that these numbers are
decimal numbers, whether this is a price, the temperature, or time. We can be explicit about
what representation we are using by subscripting our numbers with the base.

.. math::
  \mathbf{19,875_{10}} \text{ or } \mathbf{12.38_{10}}

In this class, unless otherwise stated we’ll consider all numbers to be represented in base 10.

Radix Decomposition
-------------------

How do we actually go from numbers in base 10 to finding their value? We can break down the number
by each position. Let’s go back to our running example:

.. math::
  19,874 &= 1 \times 10,000 & + 9 \times 1000 & + 8 \times 100  & + 7 \times 10   & + 4 \times 1    \\
         &= 1 \times 10^4   & + 9 \times 10^3 & + 8 \times 10^2 & + 7 \times 10^1 & + 4 \times 10^0

How do we know the value is nineteen thousand eight hundred seventy four? We can break it down digit
by digit and add together the values. We have 4 in the 1s (the right-most position), 7 in the 10’s
position, 8 in the hundreds position, 9 in the thousands, and 1 in the ten-thousands position. Or in
other words, at each successive position we multiply the value of the digit at that position by the
next power of 10 to determine its value. This even works for non-whole numbers. Consider the number:

.. math::
  12.38 &= 1 \times 10   & + 2 \times 1    & + \frac{3}{10}     & + \frac{8}{100}    \\
        &= 1 \times 10^1 & + 2 \times 10^0 & + 3 \times 10^{-1} & + 8 \times 10^{-2}

We find 1 in the tens position, 2 in the ones position, 3 in the tenths position, and 8 in the
hundredths position. For non-whole numbers we treat every digit to the right of the decimal (or radix)
point exactly the same as we do for whole numbers. Everything to the left of the radix point we
successively divide by the next power of ten. Now that we know how to determine the value of a decimal
number, how can we do this for other number representations. We’ll now transition to considering binary
numbers.

Binary Numbers
--------------

What are binary numbers? They’re just another way to represent numbers; however, instead of having ten
digits (one to nine) we have two bits (zero and one). Last week, we learned about computer hardware. A
computer’s primary purpose is to compute; so we need to be able to store numbers on a computer’s hardware.
Without getting too technical, a computer represents numbers in a sequence of transistors, each storing an
electrical charge. These charges can be on (high voltage) or off (low voltage) or somewhere inbetween.
However, like with a light bulb that may burn brighter or be dimmer based on the incoming charge, we only
consider if the state is on or off.

In effect, computers represent numbers in binary. To better understand how computers work, we’ll practice
with binary numbers. Let’s consider a few example numbers.

.. math::
  \mathbf{1_2}      = \mathbf{1_{10}}    \text{ and }
  \mathbf{11_2}     = \mathbf{3_{10}}    \text{ and }
  \mathbf{101_2}    = \mathbf{5_{10}}    \text{ and }
  \mathbf{110.01_2} = \mathbf{6.25_{10}}

Here we see how we represent 1, 3, 5, and 6.25 in binary notation.

Binary Arithmetic
-----------------
Just as we perform arithmetic on decimal numbers, we can perform arithmetic on binary numbers. The process
is exactly the same, except we work with bits instead of digits. Let’s start by looking at addition and
multiplication.

.. math::
   10110101 & \\
  +\hspace{1mm}1010110 &\\
  \hline
  100001011 & \\

  110101 &\\
  \times\hspace{3mm} 1101 & \\
  \hline
     110101 &\\
   11010100 &\\
  110101000 &\\
  \hline
  1010110001 &

Here we see how to add the binary representations of 181 and 86 and get 267 as the result. We also see how to
do long form multiplication of 53 and 13 to get 689. You’ll notice this is exactly the same as for decimal
numbers but we force ourselves to only work with bits, carrying the one to the next place when necessary. Both
subtraction and division work similarly.

Now we’ll turn our attention to three important arithmetic operations on binary numbers **and**, **or**, and
**exclusive or**. These are generally called bit-wise operations as they apply to each bit place without
considering the result of other placements. For these operations, we’ll pad the shorter of the two numbers
with zeros when needed.

==== ===== ======= ====== =======
A    B     A and B A or B A xor B
==== ===== ======= ====== =======
0    0     0       0      0
0    1     0       1      1
1    0     0       1      1
1    1     1       1      0
==== ===== ======= ====== =======

Let’s practice a few examples!

.. math::
  101011001 &\\
  \mathbf{\text{and}}\hspace{1cm} 11101 &\\
  \hline
  11001&

  101010110 &\\
  \mathbf{\text{or}}\hspace{6mm} 111011 &\\
  \hline
  101111111 &

  1100011 &\\
  \mathbf{\text{xor}}\hspace{1mm} 110110 &\\
  \hline
  1010101 &

We notice that all of the operators perform the operation to each bit position independently
of the rest of the positions in the numbers.

Binary to Decimal Conversion
----------------------------

How do we go from binary numbers to decimal and back? We’ll now examine how to take binary
numbers and convert them to their decimal notation. This works exactly like the decimal
decomposition we learned at the beginning of class. And in fact this works to convert a number
represented in any base to decimal.

.. math::
  101011001_2 &= 2^9 & + 2^7 & + 2^5 & + 2^4 & + 2^0 \\
              &= 512 & + 127 & + 32  & + 16  & + 1   \\
              &= 689


Decimal to Binary Conversion
----------------------------

Now, let’s look at the opposite conversion, converting decimal numbers to binary. This will
use successive division and subtraction as opposed to addition in multiplication. We will
successively divide by two, if the remainder is non-zero we’ll keep the bit at the current
position. We’ll continue until we can no longer divide by two. Again, this works for any base,
not just base two.

============= ====== =========
Initial Value Result Remainder
============= ====== =========
267           133    1
133           66     1
66            33     0
33            16     1
16            8      0
8             4      0
4             2      0
2             1      0
1             0      1
============= ====== =========

.. math::
  \mathbf{267_{10}} = \mathbf{100001011_{2}}

Conclusion
----------

Today, we covered two very important number representations. In particular, decimal notation
that we’re used to seeing in everyday life and binary notation that is useful for understanding
how computers manipulate numbers. We covered binary addition, multiplication, and three bitwise
arithmetic operations (and, or, and xor). Then we showed how we can convert between binary and
decimal notation for numbers. Next lecture, we’ll review what we’ve learned about binary
numbers and introduce Hexadecimal numbers, another important number representation in computer
science.
