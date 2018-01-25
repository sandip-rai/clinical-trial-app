# project1-ICS372

# program info

Design and build a program for a hospital conducting a clinical trial at a number of remote sites.

Nurses will use the software to record data that patients have entered into their journals.  It
will be evaluated against the following requirements:
1.
The software shall read a file that is in JSON format containing patient readings.
2.
The software shall support 4 different types of items in the input file: weight reading, temp
reading, blood pressure reading, and number of steps.
3.
The software shall read and store the item ID for each entry and associate it with the
specified patient ID.
4.
The software shall read and store the associated metadata for each item.
5.
The software shall support the following commands for each patient: add reading, start
patient trial, and end patient trial.
6.
The software shall only allow adding readings to a patient that is part of the trial.
7.
The software shall keep records for a patient that has left a trial, but will disregard new
readings.
8.
The software shall be able to export all the readings into a single JSON file
9.
The software shall show the list of associated readings for each patient.
Usage of the Java standard libraries or other libraries as part of your program is expected.  Make sure
you include external jar files with your source when you submit it.  Documentation of the program is
expected as well.  Be sure to include a class diagram of the program and a sequence diagram of the
check in and check out process.
