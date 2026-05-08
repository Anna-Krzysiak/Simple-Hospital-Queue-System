// Circular queue class to manage doctor appointments
class CircularQueue {
    int front, rear, size, capacity; // front = first patient, rear = last patient, size = current # of patients, capacity = max patients
    Patient[] queue; // array to store patients

    //Constructor: sets up the circular queue with given capacity
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        front = 0; // first index
        size = 0;  // initially empty
        rear = capacity - 1; // rear index starts at the end
        queue = new Patient[capacity]; // array to hold patients
    }

    //Check if queue is full
    //O(1) --> just compares two numbers
    boolean isFull() {
        return size == capacity;
    }

    // Check if queue is empty
    // O(1) --> just compares two numbers
    boolean isEmpty() {
        return size == 0;
    }

    //Add patient to doctor queue
    void enqueue(Patient p) {
        if (isFull()) { //check if there is space
            System.out.println("Doctor queue is full! Cannot add " + p.name);
            return;
        }
        rear = (rear + 1) % capacity; //move rear in circular motion, when rear + 1 (moves the rear pointer one step forward in the array) reaches capacity, it wraps back to 0.
        queue[rear] = p; //put patient at rear
        size++; //increase current size
        System.out.println(p.name + " moved to doctor queue.");
        //Time complexity: O(1) --> just does arithmetic and array insert
    }

    //Remove patient from doctor queue (doctor treats patient)
    void dequeue() {
        if (isEmpty()) { //check if queue is empty
            System.out.println("No patients in doctor queue.");
            return;
        }
        System.out.println(queue[front].name + " has been treated and discharged. Issue: "
                + queue[front].issue);
        front = (front + 1) % capacity; //move front in circular motion,
        size--; //decrease size
        //Time complexity: O(1) --> just moves front pointer
    }

    // View all patients in doctor queue
    void viewQueue() {
        if (isEmpty()) {
            System.out.println("Doctor queue is empty.");
            return;
        }
        System.out.println("Patients in doctor queue:");
        for (int i = 0; i < size; i++) { // loop through all patients
            int index = (front + i) % capacity; // wrap around if needed
            System.out.println(queue[index].name + " (Severity "
                    + queue[index].severity + ", Issue: " + queue[index].issue + ")");
        }
        // Time complexity: O(n) -> must look at all patients in queue
    }
}

/*
Summary of CircularQueue Time Complexities:
- enqueue() --> O(1): add patient
- dequeue() --> O(1): remove patient
- isFull()/isEmpty()--> O(1)
- viewQueue() --> O(n): loop through all patients
*/
