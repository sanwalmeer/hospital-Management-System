package model;

public class patient {

    private int id;
    private String name;
    private int age;
    private String disease;

    public patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDisease() {
        return disease;
    }

    @Override
    public String toString() {
        return "Patient [ID=" + id + ", Name=" + name + ", Age=" + age + ", Disease=" + disease + "]";
    }
}
