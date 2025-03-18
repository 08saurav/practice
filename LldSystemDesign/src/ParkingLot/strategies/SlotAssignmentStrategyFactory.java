package ParkingLot.strategies;

import ParkingLot.models.SlotAssignmentStrategyType;

public class SlotAssignmentStrategyFactory {
    public static SlotAssignmentStrategy getSlotAssignmentByType(SlotAssignmentStrategyType slotAssignmentStrategyType) {
        return new RandomSlotAssigmentStrategy(); // TODO: take parkingLot repository in variable and use it
    }
}
