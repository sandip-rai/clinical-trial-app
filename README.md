# project1-ICS372

# program info

Designed and build an Android and a Java program simulating a hospital conducting a clinical trial at a number of remote sites.

<b>Java Program Version 1 fulfilled requirements</b>:

Nurses will use the software to record data that patients have entered into their journals.  It
will be evaluated against the following requirements:

1.The software shall read a file that is in JSON format containing patient readings.

2.The software shall support 4 different types of items in the input file: weight reading, temp
reading, blood pressure reading, and number of steps.

3.The software shall read and store the item ID for each entry and associate it with the
specified patient ID.

4.The software shall read and store the associated metadata for each item.

5.The software shall support the following commands for each patient: add reading, start
patient trial, and end patient trial.

6.The software shall only allow adding readings to a patient that is part of the trial.

7.The software shall keep records for a patient that has left a trial, but will disregard new
readings.

8.The software shall be able to export all the readings into a single JSON file

9.The software shall show the list of associated readings for each patient.

Usage of the Java standard libraries or other libraries as part of your program is expected.  Make sure
you include external jar files with your source when you submit it.  Documentation of the program is
expected as well.  Be sure to include a class diagram of the program and a sequence diagram of the
check in and check out process.

<b>Java Program Version 2 fulfilled requirements</b>:

After the success of the initial phase of the library application, the project has been expanded to include
new features that your backers would like to see implemented. Unfortunately, at this point very little
definition work has been performed, and this work will fall on your team instead. You will need to convert
the vague feature requests below into a set of use cases, requirements, and sequence diagrams for initial
review and then implement those designs.

New feature 1: We have new 3 new clinics participating in the trial. We would like to keep track of which
readings are collected at which clinic. We need to know the clinic name and a unique id for each clinic.

New feature 2: The system currently loses its state every time the program is stopped, please retain the
patients and readings that were previously entered.

New feature 3: We are merging this study with a similar one in another health system. That system
already publishes data in XML format (also their system has a lot of bugs, so sometimes the data has
issues). These should be integrated into our data set.

New feature 4: We’d like a graphical interface for the system so users can point and click to perform
operations .

The management team is also concerned about demonstrating the robust nature of the code, so unit test
should start to be part of the code provided.

<b>Android Version fulfilled requirements</b>:

The Clinical Studies Director just got the Galaxy S9 and loves the user interface so much, she decided to
provide the software along with hardware as a complete data collection solution to new clinics.

Unfortunately, she failed to check with the engineering team and spent the entire hardware budget
purchasing Android devices to run your software. The Executive Director is desperately asking your
development team to rectify the situation and make good on the promises that have been made.

The existing requirements specification should be applicable, except for the following new requirement:
Requirement: The software shall support running on an Android phone.

In addition, the following need has been identified: Status of patients needs to be more granular.
Currently, the patient is either in a trial or the trial has ended. The patient can now be in one of several
situations: Active in a Trial, Withdrawn from the Trial, Failed Trial, and Completed Trial.

Patients who are in an active trial or have completed a trial should show readings, otherwise no readings should be shown.
Also, only patients which are active in a trial should be allowed to have readings added.

Your team is free to modify the existing code to allow for smoother implementation of the new
requirements. The only condition is that the existing use cases should be utilized as much as possible,
and existing code should be ported to the new application. Beyond that, alteration of the app to fit the
Android platform and use model is encouraged.
