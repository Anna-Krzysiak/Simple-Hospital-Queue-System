Read Me

Hospital Patient Management System (Read Me)

Overview
This program simulates a hospital patient management system using a priority queue (min-heap) and a circular queue. Patients are prioritized based on severity, and doctor appointments are managed in a first-come, first-served basis.

Notes
- Press Enter after every input
- Lower severity value = higher priority
- Emergency patients have severity = 0
- Doctor queue has a maximum capacity of 5 patients
- Priority queue automatically sorts patients using a min-heap

How to Run the Program
Make sure all files are in the same folder:
HospitalQueueSystem.java
CircularQueue.java
Patient.java
PatientComparator.java

Open a terminal or command prompt and navigate to the folder.

Run the program:
java HospitalQueueSystem

Menu Options

When the program runs, you will see:

--- Hospital Queue Menu ---
1. Add Patient
2. View Next Patient
3. Treat Patient (move to doctor queue)
4. Add Emergency Patient
5. Process Appointment (doctor treats patient)
6. View Doctor Queue
7. View All Waiting Patients
8. Exit

Example Usage
1. Add a Patient

Type: 1 + [Enter]

Example:

Enter patient name: John + [Enter]
Enter severity (1 = Critical, 5 = Minor): 3 + [Enter]
Enter patient's issue/complaint: Headache + [Enter]

Example output:

Patient John added to waiting queue.

2. Add an Emergency Patient

Type: 4 + [Enter]

Example:

Enter emergency patient name: Sarah + [Enter]
Enter patient's issue/complaint: Heart Attack + [Enter]

Example output:

Emergency patient Sarah added to waiting queue.

3. View Next Patient

Type: 2 + [Enter]

Example output:

Next patient: Sarah (Severity 0, Issue: Heart Attack)

4. Treat Patient (Move to Doctor Queue)

Type: 3 + [Enter]

Example output:

Sarah moved to doctor queue.

5. View Doctor Queue

Type: 6 + [Enter]

Example output:

Patients in doctor queue:
Sarah (Severity 0, Issue: Heart Attack)

6. Process Appointment

Type: 5 + [Enter]

Example output:

Sarah has been treated and discharged. Issue: Heart Attack

7. View All Waiting Patients

Type: 7 + [Enter]

Example output:

All waiting patients (by severity):
1 - John (Severity 3, Issue: Headache)

8. Exit

Type: 8 + [Enter]

Example output:

Exiting System. Goodbye!
