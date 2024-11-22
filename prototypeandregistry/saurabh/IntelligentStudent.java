package prototypeandregistry.saurabh;

public class IntelligentStudent extends Student {
    int iq;
    IntelligentStudent ()
    {

    }
    IntelligentStudent (IntelligentStudent other){
        super(other);
        this.iq = other.iq;
    }
    @Override
    public Student copy(){
        System.out.println("IntelligentStudent");
        return new IntelligentStudent(this);
    }
}
