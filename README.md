# Student-Tuition-API #

## Project Description ##

You will be developing a simple software that maintains a student roster for tuition purpose and processes the tuition.
The software shall be able to add and remove students to and from the roster, update student information, calculate
tuition dues and process payments. For tuition purpose, students are classified as New Jersey resident and non-New
Jersey resident. The international students pay the non-resident tuition and fees, as well as additional fees. Tristate
students are students from Connecticut and New York, and they get special discount on the tuition. The table below
shows the tuition and fees for a single semester. In addition to the fee schedule below, for the students who enrolled
more than 16 credit hours will pay additional tuition for the credit hours exceed 16, using the same per credit hour
rate as the parttime students. A student who enrolled at least 12 credit hours is considered as a full time, otherwise
will be classified as a parttime student. However, International students must enroll as a full time. For all students,
the maximum number of credit hours is 24, minimum is 3.

Students may have different tuition remissions as listed below. However, parttime students do not qualify.

* A resident student could get a one-time financial aid with a maximum amount of $10,000.
* Non-resident students from the tristate area get the tuition discount: $4,000 for New York state residents, and
$5,000 for Connecticut residents.
* International students who are participating in the study abroad program do not pay the tuition. However, they
need to pay the fees. The maximum number of credit hours for the international students in the study abroad
program is 12 credit hours.
* Here are some tuition calculation examples.
  * Resident students with 18 credit hours: 12,536 + 3,268 + 404 * (18 – 16) = $16,612
  * Non-resident students with 12 credit hours: 29,737 + 3,268 = $33,005
  * Tristate student with 9 credits: 966 * 9 + 3,268 * 80% = $11,308.40
  * International student with 12 credits: 29,737 + 3,268 + 2,650 = $35,655
  * International student in study abroad program with 12 credits: 3,268 + 2,650 = $5,918

## Project Requirement ##
1. This is a group assignment. You MUST work in pair to get the credit for this project.
2. You MUST follow the software development ground rules, or you will lose points for not having a good
programming style.
3. Sample input and output are posted as “project2TestCases.txt” and “project2SampleOutput.txt” on Canvas for
your reference. The graders will be using the test cases in “project2TestCases.txt” to run your project. Your
project should take the sample input in sequence without getting any exception and without terminating
abnormally. Your output should match the output in “project2SampleOutput.txt”. You will lose 2 points for each
incorrect output or for each exception.
4. Each Java class must go in a separate file. -2 points if you put more than one Java class into a file.
5. Your program MUST handle bad commands. -2 points for each bad command not handled.
6. You are NOT allowed to use any Java library classes, except Scanner, StringTokenizer, Calendar,
DecimalFormat and the necessary Exception classes. You will lose 5 points for each additional Java library
class imported.
7. When you import Java library classes, do not use the * to import all classes in that Java package. -2 points for
each violation.
8. You MUST create a Class Diagram for this project to document the software structure. The diagram is worth 5
points. You will lose the 5 points if you submit a hand-drawing diagram.
9. You must create Java classes with the following inheritance relationships. -5 points for each class missing, or
incorrect inheritance structure. All instance variables must be “private” or lose 2 points for each non-private
modifier. All static constants must be private, except for the ones used by more than one classes.
  * Student class defines the common data items and operations for all student instances; each student must include a profile, including name and major, to uniquely identifies the student in the roster. There are other common data items may need to be defined in this class.
  * Resident class extends Student class and includes specific data and operations to resident students.
  * NonResident class extends Student class and includes specific data and operations to non-resident students.
  * TriState class extends NonResident class and includes specific data and operations to students live in Connecticut or New York.
  * International class extends NonResident class and includes specific data and operations to students from overseas.
10. You are not allowed to have redundant code in this project; -2 points for each violation below.
  * Unused code: you write code that was never called or used.
  * Duplicate code segments for the same purpose in more than one places/classes.
  * Define common instance variables in each of the subclasses listed in #9, while they should be defined in the superclass.
  * Define specific instance variables in the superclasses listed in #9, while they are not used by all the subclasses.
  * Define some variables as instance variables, but those variables should really be local in the methods within
the class.
11. Polymorphism is required. An instance of student Roster holds a list of students with various status, including
resident, nonresident, international and tristate students. You cannot use the getClass() method to check the class
type listed in #9 above, or you will lose 10 points. Tuition calculation will be based on the actual type of the
instance in the roster.
12. You must include an overriding toString() method method in ALL classes listed in #9 above. -2 points for each
toString() method missing. The toString() methods in all subclasses MUST reuse the code in the superclass by
calling the toString() method defined in the superclass. -2 point for each violation. Override the equals() method
where necessary. Always add the tag @Override on top of the overriding methods, -2 point for each violation.
13. Student class must include a do-nothing method listed below. You cannot change the signature of this method,
or you will lose 5 points. All the subclasses MUST override this method and add the @Override tag.
14. In addition to the classes listed in #9, you must include the following classes. -5 points for each class missing.
You CANNOT perform I/O in all classes, EXCEPT the TuitionManager class, and the print methods in the
Roster class. You will lose 2 points for each violation. The floating-point numbers must be displayed with 2
decimal places, or -1 point for each violation. You can use DecimalFormat.format() or String.format()
methods for this purpose.
* Date class. Import this class from your Project 1. The class implements the Java Interface Comparable. However,
in this project, any years before 2021 are considered as invalid.
* Profile class. Define the profile of a student, including name and major. A student profile uniquely identifies a
student in the student roster. You cannot add or change the instance variables. You must override the equals()
and toString() method with the @Override tag. -2 points for each violation.
* Roster class. This a growable array list data structure with an initial capacity of 4, and automatically grows
(increases) the capacity by 4 whenever it is full. The array list does not decrease in capacity. You must define the
two instance variables below. You are not allowed to add additional instance variables, -2 points for each
violation. You must implement the methods listed below or lose 2 points each. The remove() method maintains
the relative sequence of objects in the array after the deletion, -3 points if this is not done. You can define
necessary private and public methods to be used by the client TuitionManager. However, all the public methods
defined in this class take either no parameter, or only a single parameter (Student student), -2 points for each
violation. You cannot use Arrays.sort() or System.arraycopy() or you will lose 5 points.
* TuitionManager class.
This is the user interface class that performs Input/Output (read/write.) This class uses an instance of Roster class
to process the tuitions. You are not allowed to use Java library class ArrayList or other Java collection classes,
or you will get 0 points for this project. This class handles all exceptions and invalid data before it calls the
methods in Roster class to complete the associated commands. For example, InputMismatchException,
NumberFormatException, NoSuchElementException, invalid credit hours, invalid major code, or invalid state
codes, etc. Whenever there is an exception or invalid data, display a message on the console. Please see the
sample output for the messages. You will lose 2 points for each exception not caught or invalid data not checked
or messages not displayed.
A command line always begins with a command in uppercase letters followed by some data tokens delimited by
a comma. The commands are case-sensitive, i.e., the commands with lowercase letters are invalid. In addition,
you are required to handle the bad commands not supported. -2 points for each invalid command not handled.
You must implement a run() method to handle all commands listed below. This is the only public method. You
should try to keep the run() method under 50 lines. You can define additional helper (private) methods and try to
keep all the private methods under 40 lines so it’s easier for you to manage your code. Each major and the state
is a 2-character string; they are not case sensitive, i.e., CS, cS, Cs, or cs are considered as valid for Computer
Science major; and ny, Ny, nY, or NY are valid state codes for New York state.
