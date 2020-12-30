namespace ParkingLot
{
    public class Terminal
    {
        public Terminal(ParkingManager parkingManager)
        {
            ParkingManager = parkingManager;
        }

        public long Id { get; set; }
        private ParkingManager ParkingManager { get; set; }

        public ParkingTicket RegisterEntrance(Vehicle vehicle)
        {
            if (ParkingManager.IsParkingFull()) return null;

            var parkingSpot = ParkingManager.ParkVehicle(vehicle);

            if (parkingSpot == null) return null;

            return new ParkingTicket(vehicle, parkingSpot);
        }

        public void RegisterExit(ParkingTicket parkingTicket)
        {
            ParkingManager.FreeSpot(parkingTicket);
        }
    }
}