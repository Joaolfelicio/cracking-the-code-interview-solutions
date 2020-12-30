namespace ParkingLot
{
    public class Car : Vehicle
    {
        public Car()
        {
            SpotsNeeded = 1;
            VehicleSize = VehicleSize.Compact;
        }

        public override bool CanFitInSpot(ParkingSpot parkingSpot)
        {
            return parkingSpot.VehicleSize == VehicleSize.Large || parkingSpot.VehicleSize == VehicleSize.Compact;
        }
    }
}