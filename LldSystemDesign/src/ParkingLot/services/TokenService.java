package ParkingLot.services;

import ParkingLot.models.*;
import ParkingLot.repositories.GateRepository;
import ParkingLot.repositories.ParkingLotRepository;
import ParkingLot.repositories.TokenRepository;
import ParkingLot.repositories.VehicleRepository;
import ParkingLot.strategies.SlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TokenService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TokenRepository tokenRepository;
    public TokenService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TokenRepository tokenRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.tokenRepository = tokenRepository;
    }
    public Token issueToken(
            Long gateId,
            VehicleType vehicleType,
            String vehicleNumber,
            String ownerName
    ){
//        Create a Token,
//        Assign Task
//        Return
//        using the gateId , we need the gate object from the database
        Token token = new Token();
        token.setEntryTime(new Date());
//        Check if already exist
        Optional<Gate> gateOptional = gateRepository.findGateByID(gateId);
        if(gateOptional.isEmpty()){
            throw new IllegalArgumentException("Gate with ID " + gateId + " not found");
        }
        Gate gate = gateOptional.get();
        token.setGeneratedAt(gate);
        token.setGeneratedBy(gate.getOperator());
        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle savedVehicle;
        if(vehicleOptional.isEmpty()){
//            If it's a new vehicle then save in db and use it
            Vehicle vehicle = new Vehicle();
            vehicle.setNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(ownerName);
            savedVehicle = vehicleRepository.save(vehicle);
        }else {
//            if vehicle already exist
            savedVehicle = vehicleOptional.get();
        }
        token.setVehicle(savedVehicle);
//        Assign a Slot
//           2. We can have different strategies to allocate the slot
//         ParkingLot parkingLot = parkingLotRepository.findParkingLotByGate(gate);
        ParkingLot parkingLot = parkingLotRepository. findParkingLotByGate(gate);
         ParkingSlot parkingslot = SlotAssignmentStrategyFactory.getSlotAssignmentByType(
                 parkingLot.getSlotAssignmentStrategyType()).getSlot(parkingLot,vehicleType);
         token.setParkingSlot(parkingslot);
         parkingLot.setParkingLotStatus(ParkingLotStatus.FILLED);
         Token savedToken = tokenRepository.saveToken(token);
         savedToken.setNumber(token.getId()+"-TOKEN");
//        Return
//        token.set
        return savedToken;

    }

}
