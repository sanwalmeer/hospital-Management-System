package model;

public class doctor {
   
    private int id;
    private String name;
    private String specialization;

    public doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }

    @Override
    public String toString() {
        return "Doctor [ID=" + id + ", Name=" + name + ", Specialization=" + specialization + "]";
    }
}


