package ParkingLot.models;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private int floorNumber;
    private List<VehicleType> allowedVehicleTypeList;
    private List<ParkingSlot> parkingSlots;
    private FloorStatus floorStatus;

    public FloorStatus getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(FloorStatus floorStatus) {
        this.floorStatus = floorStatus;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<VehicleType> getAllowedVehicleTypeList() {
        return allowedVehicleTypeList;
    }

    public void setAllowedVehicleTypeList(List<VehicleType> allowedVehicleTypeList) {
        this.allowedVehicleTypeList = allowedVehicleTypeList;
    }
}
