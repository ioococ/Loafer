public class Animal {
    private String name;
    private int id;

    public Animal(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void eat() {
        System.out.println(name + " is eating");
    }

    public void sleep() {
        System.out.println(name + "is sleeping");
    }

    public void intro() {
        System.out.println("No." + id + "  I'm " + name);
    }
}
