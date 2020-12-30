namespace ParkingLot
{
    public class ParkingManager
    {
        public Floor[] Floors { get; private set; }
        
        public bool IsParkingFull() => ParkingFreeSpots() == 0;

        public void FreeSpot(ParkingTicket parkingTicket) => parkingTicket.ParkingSpot.FreeSpot();

        public ParkingSpot ParkVehicle(Vehicle vehicle)
        {
            foreach (var floor in Floors)
            {
                var parkingSpot = floor.GetParkingSpot(vehicle);

                if (parkingSpot != null)
                {
                    parkingSpot.ParkVehicle(vehicle);
                    return parkingSpot;
                }
            }
            return null;
        }

        public int ParkingFreeSpots()
        {
            var total = 0;
            foreach (var floor in Floors) total += floor.FloorFreeSpots;
            return total;
        }
    }
}
