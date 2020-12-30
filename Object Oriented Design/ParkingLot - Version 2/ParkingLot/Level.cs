namespace ParkingLot
{
    public class Level
    {
        private int Floor { get; set; }
        private ParkingSpot[] ParkingSpots { get; set; }
        private int AvailableSpots { get; set; } = 0;

        public bool ParkVehicle(Vehicle vehicle)
        {
            if (AvailableSpots < vehicle.SpotsNeeded) return false;

            var spotNumber = FindAvailableSpots(vehicle);

            if (spotNumber < 0) return false;

            return ParkStartingAtSpot(spotNumber, vehicle);
        }

        private bool ParkStartingAtSpot(in int spotNumber, Vehicle vehicle)
        {
            vehicle.FreeSpots();
            var success = true;

            for (int i = spotNumber; i < spotNumber + vehicle.SpotsNeeded; i++)
                success &= ParkingSpots[i].Park(vehicle);

            AvailableSpots -= vehicle.SpotsNeeded;
            return success;
        }

        private int FindAvailableSpots(Vehicle vehicle)
        {
            int spotsNeeded = vehicle.SpotsNeeded;
            int lastRow = -1;
            int spotsFound = 0;

            for (int i = 0; i < ParkingSpots.Length; i++)
            {
                var parkingSpot = ParkingSpots[i];

                if (lastRow != parkingSpot.Row)
                {
                    spotsFound = 0;
                    lastRow = parkingSpot.Row;
                }

                if (parkingSpot.CanFitVehicle(vehicle))
                {
                    spotsFound++;
                }
                else
                {
                    spotsFound = 0;
                }

                if (spotsFound == spotsNeeded)
                {
                    return i - (spotsNeeded - 1);
                }
            }

            return -1;
        }

        public void SpotFreed()
        {
            AvailableSpots++;
        }
    }
}