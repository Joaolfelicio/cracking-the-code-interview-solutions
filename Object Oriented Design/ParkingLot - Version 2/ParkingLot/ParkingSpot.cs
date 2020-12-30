namespace ParkingLot
{
    public class ParkingSpot
    {
        public Vehicle Vehicle { get; set; }
        public VehicleSize VehicleSize { get; private set; }
        public int Row { get; private set; }
        public int SpotNumber { get; private set; }
        public Level Level { get; private set; }

        public bool IsAvailable() => Vehicle == null;

        public bool CanFitVehicle(Vehicle vehicle)
        {
            return IsAvailable() && vehicle.CanFitInSpot(this);
        }

        public bool Park(Vehicle vehicle)
        {
            if (!CanFitVehicle(vehicle)) return false;

            Vehicle = vehicle;
            Vehicle.ParkInSpot(this);
            return true;
        }

        public void RemoveVehicle()
        {
            Level.SpotFreed();
            Vehicle = null;
        }
    }
}