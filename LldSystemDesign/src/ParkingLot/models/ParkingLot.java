package ParkingLot.models;

import java.util.List;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor> parkingFloor;
    private int capacity;
    private List<Gate> entryGate;
    private List<Gate> exitGate;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType> allVehicleTypes;

    public SlotAssignmentStrategyType getSlotAssignmentStrategyType() {
        return slotAssignmentStrategyType;
    }

    public void setSlotAssignmentStrategyType(SlotAssignmentStrategyType slotAssignmentStrategyType) {
        this.slotAssignmentStrategyType = slotAssignmentStrategyType;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<ParkingFloor> getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(List<ParkingFloor> parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    private SlotAssignmentStrategyType slotAssignmentStrategyType;

    public List<ParkingFloor> getFloor() {
        return parkingFloor;
    }

    public void setFloor(List<ParkingFloor> parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Gate> getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(List<Gate> entryGate) {
        this.entryGate = entryGate;
    }

    public List<Gate> getExitGate() {
        return exitGate;
    }

    public void setExitGate(List<Gate> exitGate) {
        this.exitGate = exitGate;
    }

    public List<VehicleType> getAllVehicleTypes() {
        return allVehicleTypes;
    }

    public void setAllVehicleTypes(List<VehicleType> allVehicleTypes) {
        this.allVehicleTypes = allVehicleTypes;
    }
}
