package builder.saurabh;

public class Runner {

    public static void main(String[] args) {
// Using Builder Pattern

        // Builder b = new Builder();
        // Builder b = Student.getBuilder();

        // Using Builder Pattern with Setters
        // b.setGrade(10);
        // b.setName("Saurabh");
        // b.setRollNumber(1);
        // Student student = new Student(b);

// Using Builder Pattern with Static Method


        // Using Builder Pattern with Static Factory Method
        // Student student = Student.builder().setGrade(10).setName("Saurabh").setRollNumber(1).build();

        // Using Builder Pattern with Fluent Interface
        // Student student = new Student.Builder().setGrade(10).setName("Saurabh").setRollNumber(1).build();
        
// Using Builder Pattern with Method Chaining

        Student student = Student.getBuilder().setName("Saurabh").setRollNumber(1).setGrade(10).build();
        
        System.out.println(student.name + " " + student.rollNumber + " " + student.grade);

    }
    
}
/*
 * Class with lots attributes
 * class with lots of configuration like house class , 
 * some houses have one feature another house can have another feature
 * 
 * one way is to create different constructor for differrent configuation
 * disadvantage : we need to take care of null attribute as well as one miss can create big issue since attributes are high
 * setters can also be used
 * disadvantage : we will give alot of hold in our class which can lead to 
 * mismanagement of important class which should not be touch by everyone
 * 
 * 
 * 
 */
