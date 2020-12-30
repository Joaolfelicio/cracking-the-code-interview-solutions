namespace ParkingLot
{
    public class ParkingManager
    {
        public Floor[] Floors { get; private set; }

        public int FreeSpots { get; private set; } = 1000;
        public bool IsParkingFull() => FreeSpots == 0;


        public ParkingSpot ParkVehicle(Vehicle vehicle)
        {
            foreach (var floor in Floors)
            {
                var parkingSpot = floor.GetParkingSpot(vehicle);

                if (parkingSpot != null)
                {
                    parkingSpot.ParkVehicle(vehicle);
                    FreeSpots--;
                    return parkingSpot;
                }
            }
            return null;
        }

        public void FreeSpot(ParkingTicket parkingTicket)
        {
            var vehicle = parkingTicket.ParkingSpot.FreeSpot();
            if (vehicle != null) FreeSpots++;
        }
    }
}