package ParkingLot.strategies;

import ParkingLot.models.*;
import ParkingLot.repositories.ParkingLotRepository;

public class RandomSlotAssigmentStrategy implements SlotAssignmentStrategy{
    @Override
    public ParkingSlot getSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for(ParkingFloor parkingFloor: parkingLot.getFloor())
        {
            for(ParkingSlot parkingSlot : parkingFloor.getParkingSlots()){
                if(parkingSlot.getSupportedVehicleTypes().contains(vehicleType) && parkingSlot.getSlotStatus().equals(SlotStatus.EMPTY)){
                    return parkingSlot;
                }
            }
        }
        return null;
    }

}
