package prototypeandregistry.saurabh;

public class Student implements Prototype<Student> {
    int id;
    String name;
    int rank;
    Student (){

    }  
    Student (Student other) {
        this.id = other.id;
        this.name = other.name;
        this.rank = other.rank;        
    }
    @Override
    public Student copy(){
        System.out.println("Student");
        return new Student(this);
    }

}
