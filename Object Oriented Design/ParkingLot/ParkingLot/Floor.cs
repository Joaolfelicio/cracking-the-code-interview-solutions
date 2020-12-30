using System.Collections.Generic;

namespace ParkingLot
{
    public class Floor
    {
        public int FloorNumber { get; set; }
        public List<ParkingSpot[]> ParkingSpots { get; set; }

        public bool HasAvailableSpot(Vehicle vehicle)
        {
            var vehicleSize = (int) vehicle.Size;

            for (int i = vehicleSize; i < ParkingSpots.Count; i++)
            {
                for (int j = 0; j < ParkingSpots[i].Length; j++)
                {
                    if (ParkingSpots[i][j].CanVehiclePark(vehicle)) return true;
                }
            }
            return false;
        }

        public ParkingSpot GetParkingSpot(Vehicle vehicle)
        {
            var vehicleSize = (int) vehicle.Size;

            for (int i = vehicleSize; i < ParkingSpots.Count; i++)
            {
                for (int j = 0; j < ParkingSpots[i].Length; j++)
                {
                    if (ParkingSpots[i][j].CanVehiclePark(vehicle)) return ParkingSpots[i][j];
                }
            }
            return null;
        }
    }
}