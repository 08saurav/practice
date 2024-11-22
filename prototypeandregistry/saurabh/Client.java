package prototypeandregistry.saurabh;

public class Client {
    public static void fillRegister(StudentRegistry std){
        Student april2023 = new Student();
        april2023.id = 1;
        april2023.name = "Saurabh";
        april2023.rank = 2;
        std.register("april2023",april2023);

        IntelligentStudent april2023IS = new IntelligentStudent();
        april2023IS.id = 2;
        april2023IS.name = "Shivendra";
        april2023IS.rank = 1;
        april2023IS.iq = 150;
        std.register("april2023IS",april2023IS);

    }
    public static void main(String[] args) {
        StudentRegistry std = new StudentRegistry();
        fillRegister(std);

        Student april2023 = std.getStudent("april2023");
        System.out.println("Student 1: " + april2023.id + " " + april2023.name + " " + april2023.rank);

        IntelligentStudent intStd = std.getStudent("april2023IS");
        // IntelligentStudent intStd = (IntelligentStudent) april2023IS;
        System.out.println("Student 2: " + intStd.id + " " + intStd.name + " " + intStd.rank+" "+intStd.iq);
    }
}
