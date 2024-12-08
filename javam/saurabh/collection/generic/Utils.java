package javam.saurabh.collection.generic;

import java.util.List;

public class Utils {
    public static void printAnimals(List<? extends Animal> animals){
        for(Animal animal : animals){
            System.out.println(animal.getClass());
        }
//        animals.add(new Cat());
    }
}

// List<Animal> is not related to List<Dog>
// Animal is related to Dog

// List<something> = new ArrayList<>();