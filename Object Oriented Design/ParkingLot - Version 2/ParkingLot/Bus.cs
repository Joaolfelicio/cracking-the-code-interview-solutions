namespace ParkingLot
{
    public class Bus : Vehicle
    {
        public Bus()
        {
            SpotsNeeded = 5;
            VehicleSize = VehicleSize.Large;
        }

        public override bool CanFitInSpot(ParkingSpot parkingSpot)
        {
            return parkingSpot.VehicleSize == VehicleSize.Large;
        }
    }
}