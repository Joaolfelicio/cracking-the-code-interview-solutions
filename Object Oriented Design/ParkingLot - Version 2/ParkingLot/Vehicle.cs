using System;
using System.Collections.Generic;
using System.Text;

namespace ParkingLot
{
    public abstract class Vehicle
    {
        protected List<ParkingSpot> ParkingSpots { get; set; } = new List<ParkingSpot>();
        protected string LicensePlate { get; set; }
        public int SpotsNeeded { get; set; }
        protected VehicleSize VehicleSize { get; set; }

        public void ParkInSpot(ParkingSpot parkingSpot) => ParkingSpots.Add(parkingSpot);

        public void FreeSpots()
        {
            foreach (var parkingSpot in ParkingSpots)
            {
                parkingSpot.RemoveVehicle();
            }
            ParkingSpots.Clear();
        }

        public abstract Boolean CanFitInSpot(ParkingSpot parkingSpot);
    }
}
