package GroominSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int n;
    private List <Pet> salon = new ArrayList<>();

    public GroomingSalon(int n) {
        this.n = n;
    }
    //Method add(Pet pet) – adds an entity to the data if there is an empty place in the grooming salon for the pet.
    public void add(Pet pet){
        if (this.salon.size() < this.n){
        this.salon.add(pet);
        }
    }

    //Method remove(String name) – removes the pet by given name, if such exists, and returns boolean.
    public boolean remove(String name) {
        for (Pet element: this.salon) {
            if(element.getName().equals(name)){
                this.salon.remove(element);
                return true;
            }
        }
        return false;
    }

    //Method getPet(String name, String owner) – returns the pet with the
    // given name and owner or null if no such pet exists.
    public Pet getPet(String name, String owner){
        for (Pet element: this.salon) {
            if (element.getName().equals(name) && element.getOwner().equals(owner)){
                return element;
            }
        }
        return null;
    }

    //Getter getCount – returns the number of pets
    public int getCount() {
        return this.salon.size();
    }

    //getStatistics() – returns a String in the following format:
    //" The grooming salon has the following clients:
    // {name} {owner}
    // {name} {owner}
    //(…)"
    public void getStatistics(){
        System.out.println("The grooming salon has the following clients:");
        for (Pet element: this.salon) {
            System.out.printf("%s %s%n", element.getName(), element.getOwner());
        }
    }

}
