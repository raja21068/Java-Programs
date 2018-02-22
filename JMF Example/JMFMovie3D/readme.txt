
Chapter 28.3. Playing Movies in a Java 3D World (Part 1)


This code comes from the website for the book:

  Killer Game Programming in Java
  Andrew Davison
  O'Reilly, May 2005
  ISBN: 0-596-00730-2
  http://www.oreilly.com/catalog/killergame/
  http://fivedots.coe.psu.ac.th/~ad/jg

However, this example and the associated chapter do _NOT_ appear 
in the printed book.

Contact Address:
  Dr. Andrew Davison
  Dept. of Computer Engineering
  Prince of Songkla University
  Hat Yai, Songkhla 90112, Thailand
  E-mail: ad@fivedots.coe.psu.ac.th


If you use this code, please mention my name, and include a link
to the book's Web site.

Thanks,
  Andrew

---------------------------------
Compilation: 

$ javac *.java
    // you must have Java 3D and JMF installed for the compilation to succeed;
    // if you get "Warning" messages, please see the note below


Java 3D is available from http://java.sun.com/products/java-media/3D/
or https://java3d.dev.java.net/
Either Java 3D 1.3.1 or 1.3.2 is fine.

JMF is available from http://java.sun.com/products/java-media/jmf/
I installed JMF Performance Pack for Windows v.2.1.1e 


---------------------------------
Execution: 

$ java Movie3D <movie fnm>

e.g. 

$ java Movie3D john.mpg

The movie should be located in the movies/ subdirectory.
The best performing movies use MPEG-1 format with no audio
track. See the chapter for a discussion about this.

Move the viewpoint by dragging the mouse. Hold the ALT key and drag to
move in and out.

-----------
Note on "unchecked or unsafe operation" Warnings

I have not used J2SE 5.0's type-safe collections, so that this code 
will compile in early versions of J2SE (e.g. version 1.4).

The warning messages are always related to my use of collections
(e.g. ArrayList) without specifying a type for the objects they will
contain at run time.

No. of Warnings generated in J2SE 5.0 for the example:
/Movie3D: 9 warnings

---------
Last updated: 20th May 2005