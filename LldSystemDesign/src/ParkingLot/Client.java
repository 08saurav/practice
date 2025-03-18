package ParkingLot;

import ParkingLot.contollers.TokenController;
import ParkingLot.dtos.IssueTokenRequestDTO;
import ParkingLot.repositories.GateRepository;
import ParkingLot.repositories.ParkingLotRepository;
import ParkingLot.repositories.TokenRepository;
import ParkingLot.repositories.VehicleRepository;
import ParkingLot.services.TokenService;

public class Client {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TokenRepository tokenRepository = new TokenRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TokenService tokenService = new TokenService(gateRepository,vehicleRepository,parkingLotRepository,tokenRepository);
        TokenController tokenController = new TokenController(tokenService);
    }
}

// Issue Token
// Generate Bill : Please implement this

// Controllers
// Services
// Repositories


// x -> y -> z
// Topological sort