package task;

abstract class remote {
    boolean on, off;

    abstract void show();
}

class TV extends remote {
    String color;
    int size;
    String type;

    TV(String color, int size, String type, boolean on) {
        this.color = color;
        this.size = size;
        this.type = type;
        this.on = on;
        this.off = !on;
    }

    void show() {
        System.out.println("---- TV Details ----");
        System.out.println("Color: " + color);
        System.out.println("Size: " + size + " inches");
        System.out.println("Type: " + type);
        System.out.println("Power: " + (on ? "ON" : "OFF"));
    }
}

class DVDReader extends remote {
    String color;
    int size;
    int weight;
    String ptype;

    DVDReader(String color, int size, int weight, String ptype, boolean on) {
        this.color = color;
        this.size = size;
        this.weight = weight;
        this.ptype = ptype;
        this.on = on;
        this.off = !on;
    }

    void show() {
        System.out.println("---- DVD Reader Details ----");
        System.out.println("Color: " + color);
        System.out.println("Size: " + size + " cm");
        System.out.println("Weight: " + weight + " g");
        System.out.println("Player Type: " + ptype);
        System.out.println("Power: " + (on ? "ON" : "OFF"));
    }
}

public class Main {
    public static void main(String[] args) {
        TV tv = new TV("Black", 55, "LED", true);
        DVDReader dvd = new DVDReader("Silver", 12, 1500, "BluRay", false);
        tv.show();
        dvd.show();
    }
}
