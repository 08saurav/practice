package builder.saurabh;

public class Student {

    public static class Builder {
        private String name;
        private int rollNumber;
        private int grade;
    
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
    
        public Builder setRollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
            return this;
        }
    
        public Builder setGrade(int grade) {
            this.grade = grade;
            return this;
        }
        public String getName(){
            return this.name;
        }
        public int getRollNumber(){
            return this.rollNumber;
        }
        public int getGrade(){
            return this.grade;
        }
        public Student build(){
            if(this.grade < 5) {
                // throw new IllegalArgumentException()
                throw new IllegalArgumentException("Grade should be greater than or equal to 5");
            }
            return new Student(this);
        }
    }
    

    String name;
    int rollNumber;
    int grade;

    public Student(Builder builder) {
        this.name = builder.getName();
        this.rollNumber = builder.getRollNumber();
        this.grade = builder.getGrade();
    }

    public static Builder getBuilder ()
    {
        return new Builder();
    }
}
