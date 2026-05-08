//Patient class stores information about each patient
class Patient {
    int id;        //unique patient ID
    String name;   //patient's name
    int severity;  //severity of condition (0=emergency, 1=critical, 5=minor)
    String issue;  //patient complaint or issue

    //Constructor
    public Patient(int id, String name, int severity, String issue) {
        this.id = id;
        this.name = name;
        this.severity = severity;
        this.issue = issue;
    }
}
