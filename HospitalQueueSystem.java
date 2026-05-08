import java.util.PriorityQueue; //import PriorityQueue (for min-heap)
import java.util.Scanner; //import Scanner for user input

//Main class for the hospital queue system
public class HospitalQueueSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //creation of Scanner to read user input

        //New PriorityQueue (heap) object to store waiting patients created here
        //Lower severity number = higher priority
        //add/poll = O(log n), peek = O(1)
        PriorityQueue<Patient> heap = new PriorityQueue<>(new PatientComparator());

        // CircularQueue object for doctor appointments created here (max size 5)
        //enqueue/dequeue = O(1)
        CircularQueue appointments = new CircularQueue(5);

        int id = 1; //unique ID for each patient

        //infinite loop to keep menu running
        while (true) {
            // display menu options
            System.out.println("\n--- Hospital Queue Menu ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Next Patient");
            System.out.println("3. Treat Patient (move to doctor queue)");
            System.out.println("4. Add Emergency Patient");
            System.out.println("5. Process Appointment (doctor treats patient)");
            System.out.println("6. View Doctor Queue");
            System.out.println("7. View All Waiting Patients");
            System.out.println("8. Exit");

            int choice = sc.nextInt(); //read user choice
            sc.nextLine(); //clear the buffer

            switch (choice) {

                case 1: //add a normal patient
                    System.out.print("Enter patient name: ");
                    String name = sc.nextLine(); // get name

                    int severity = 0;

                    //loop until valid severity is entered
                    while (true) {
                        System.out.print("Enter severity (1 = Critical, 5 = Minor): ");
                        severity = sc.nextInt();
                        sc.nextLine(); // clear buffer

                        if (severity >= 1 && severity <= 5)
                            break; // valid input

                        System.out.println("Invalid severity! Please enter 1-5.");
                    }

                    System.out.print("Enter patient's issue/complaint: ");
                    String issue = sc.nextLine(); // get issue

                    //create new patient object
                    Patient p = new Patient(id++, name, severity, issue);

                    //adds a new patient to the heap and then moves it up (bubble/sift up) to the correct spot
                    heap.add(p); //O(log n) insert into priority queue --> O(log n) since a PriorityQueue in Java is implemented using a binary heap (basically a binary tree).
                    System.out.println("Patient " + name + " added to waiting queue.");
                    break;

                case 2: //view next patient (highest priority)
                    if (heap.isEmpty()) {
                        System.out.println("No patients waiting.");
                    } else {
                        Patient next = heap.peek(); // O(1) view top of heap
                        System.out.println("Next patient: " + next.name + " (Severity "
                                + next.severity + ", Issue: " + next.issue + ")");
                    }
                    break;

                case 3: //move patient to doctor queue
                    if (heap.isEmpty()) {
                        System.out.println("No patients to move.");
                    } else {
                        //poll removes and returns highest-priority patient, then moves elements down to fix the heap (bubble/sift down)
                        Patient treated = heap.poll(); // O(log n) remove highest priority
                        appointments.enqueue(treated); // O(1) add to circular queue
                    }
                    break;

                case 4: //add emergency patient
                    System.out.print("Enter emergency patient name: ");
                    String ename = sc.nextLine();

                    System.out.print("Enter patient's issue/complaint: ");
                    String eissue = sc.nextLine();

                    //emergency = severity 0 (highest priority)
                    Patient emergency = new Patient(id++, ename, 0, eissue);

                    heap.add(emergency); //O(log n)
                    System.out.println("Emergency patient " + ename + " added to waiting queue.");
                    break;

                case 5: //doctor treats patient (remove from queue)
                    appointments.dequeue(); //O(1)
                    break;

                case 6: //view doctor queue
                    appointments.viewQueue(); //O(n)
                    break;

                case 7: //view all waiting patients
                    if (heap.isEmpty()) {
                        System.out.println("No patients waiting.");
                    } else {
                        // copy heap so original is not destroyed
                        PriorityQueue<Patient> temp = new PriorityQueue<>(heap);

                        System.out.println("All waiting patients (by severity):");

                        //removing all elements = O(n log n) --> since loop runs n times (once per patient) and we call poll which is log n.
                        while (!temp.isEmpty()) {
                            Patient pp = temp.poll(); //O(log n)
                            System.out.println(pp.id + " - " + pp.name
                                    + " (Severity " + pp.severity
                                    + ", Issue: " + pp.issue + ")");
                        }
                    }
                    break;

                case 8: //exit program
                    System.out.println("Exiting system. Goodbye!");
                    sc.close(); // close scanner
                    return;

                default: //invalid option
                    System.out.println("Invalid choice. Please select 1-8.");
            }
        }
    }
}

/*
Time Complexity Summary:
- heap.add() --> O(log n)
- heap.poll() --> O(log n)
- heap.peek() --> O(1)
- enqueue/dequeue (circular queue) --> O(1)
- viewing all patients --> O(n log n)
*/