PTI CS 103 - Introduction to Computer Science
==============================================

Course outline
---------------

First semester

- 2 classes per week
- 1 lab per week
- 1 quiz per week (5-10 min. review)

Second semester

- 3 interactive classes/labs per week
- 1 quiz per week (5-10 min. review)

First semester
~~~~~~~~~~~~~~~

#. Introduction
#. Hardware
#. Hardware
#. Software
#. Software
#. Computer Networks
#. Computer Networks
#. Review / midterm
#. Information Systems
#. Information Systems
#. Productivity Software
#. Productivity Software
#. Productivity Software
#. Review / midterm

Second semester
~~~~~~~~~~~~~~~~

#. Methods
#. Methods
#. Methods
#. Debugging and testing
#. Classes
#. Classes
#. Classes
#. Review / midterm
#. Arrays & ArrayLists
#. Arrays & ArrayLists
#. Arrays & ArrayLists
#. Searching and sorting
#. Searching and sorting
#. Review / midterm

Generating the lecture notes
------------------------------

The lecture notes are automatically compiled and generated via `Sphinx
<http://www.sphinx-doc.org/en/master/>`_.

Content for the lectures is stored on `docs/source`. Each week should go in a separate .rst file. 

Adding content 
~~~~~~~~~~~~~~~ 

- install sphinx on your computer (you'll probably want to do this via pip) 
- review `ReStructured Text syntax <http://www.sphinx-doc.org/en/master/usage/restructuredtext/basics.html>`_
- `cd` to `docs/source` and create a new `.rst` file (feel free to model off of `introduction.rst`)
- change the `index.rst` file to include the name of your file in the toctree (i.e. table of contents tree)

Building locally
~~~~~~~~~~~~~~~~~~

A Makefile is located in the `docs` directory. To generate an html, type `make html`. To generate a pdf, type `make latexpdf`. This will generate the final files within a directory called `build` within `docs`. 

Building on readthedocs
~~~~~~~~~~~~~~~~~~~~~~~~~

You can see the html version of the lectures compiled at `the Read the Docs site`_. This updates automatically every time there is a push to the GitHub. 

.. _the Read the Docs site: https://pti-cs-103.readthedocs.io/

