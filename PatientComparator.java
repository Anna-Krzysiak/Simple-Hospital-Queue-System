import java.util.Comparator; // import Comparator interface

//Comparator to tell PriorityQueue how to compare patients
class PatientComparator implements Comparator<Patient> {// New class called PatientComparator that will implement the rules for comparing Patient objects

    public int compare(Patient p1, Patient p2) {
        //smaller severity = higher priority
        //runs in O(1) time complexity because it's just a simple subtraction
        return p1.severity - p2.severity;
    }
}