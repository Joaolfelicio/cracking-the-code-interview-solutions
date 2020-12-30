namespace ParkingLot
{
    public class ParkingLot
    {
        private Level[] Levels { get; set; }

        public bool ParkVehicle(Vehicle vehicle)
        {
            foreach (var level in Levels)
            {
                if (level.ParkVehicle(vehicle)) return true;
            }
            return false;
        }
    }
}