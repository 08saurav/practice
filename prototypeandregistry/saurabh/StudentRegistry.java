package prototypeandregistry.saurabh;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    private Map<String,Student>  map = new HashMap<>();
    public void register (String key, Student value){
        map.put(key, value);
    }
    public Student getStudent(String key){
        return map.get(key).copy();
    }
}
