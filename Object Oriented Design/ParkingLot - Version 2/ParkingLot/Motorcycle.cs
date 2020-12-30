namespace ParkingLot
{
    public class Motorcycle : Vehicle
    {
        public Motorcycle()
        {
            VehicleSize = VehicleSize.Motorcycle;
            SpotsNeeded = 1;
        }
        public override bool CanFitInSpot(ParkingSpot parkingSpot)
        {
            return true;
        }
    }
}