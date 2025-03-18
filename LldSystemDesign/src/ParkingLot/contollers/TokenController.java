package ParkingLot.contollers;

import ParkingLot.dtos.IssueTokenRequestDTO;
import ParkingLot.dtos.IssueTokenResponseDTO;
import ParkingLot.dtos.ResponseStatus;
import ParkingLot.models.Token;
import ParkingLot.services.TokenService;

public class TokenController {
    private TokenService tokenService;

    public TokenController(TokenService tokenService){
        this.tokenService = tokenService;
    }
    public IssueTokenResponseDTO issueToken(IssueTokenRequestDTO issueTokenRequestDTO){
//            Call the service
        IssueTokenResponseDTO issueTokenResponseDTO = new IssueTokenResponseDTO();
        try {
            Token token = tokenService.issueToken(
                    issueTokenRequestDTO.getGateId(),
                    issueTokenRequestDTO.getVehicleType(),
                    issueTokenRequestDTO.getVehicleNumber(),
                    issueTokenRequestDTO.getOwnerName()
            );
            issueTokenResponseDTO.setToken(token);
            issueTokenResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e){
            issueTokenResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            issueTokenResponseDTO.setFailureMessage(e.getMessage());
        }
        return issueTokenResponseDTO;
    }
}
