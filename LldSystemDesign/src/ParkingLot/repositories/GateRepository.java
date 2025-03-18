package ParkingLot.repositories;

import ParkingLot.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {
    private Map<Long, Gate> gates = new TreeMap<>();
    public Optional<Gate> findGateByID(Long id) {
//        db.execute('Select * from gate where id = id');
        if(gates.containsKey(id)) {
            return Optional.of(gates.get(id));
        }
        return Optional.empty();
    }
}
