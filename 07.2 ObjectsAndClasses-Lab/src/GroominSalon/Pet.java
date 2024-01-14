package GroominSalon;

public class Pet {
    //Java class Pet with the following fields:
    //· name: String
    private String name;
    //· age: int
    private int age;
    //· owner: String
    private String owner;

    public Pet(String name, int age, String owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getOwner() {
        return this.owner;
    }

    @Override
    public String toString() {
        //"{name} {age} - ({owner})"
        return String.format("%s %d - %s", this.name, this.age, this.owner);
    }

}
