using System;
using System.Collections.Generic;
using System.Text;

namespace ParkingLot
{
    public class ParkingTicket
    {
        public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot)
        {
            Vehicle = vehicle;
            ParkingSpot = parkingSpot;
            ArrivalTime = DateTime.Now;
        }

        public Vehicle Vehicle { get; set; }
        public ParkingSpot ParkingSpot { get; set; }
        public DateTime ArrivalTime { get; set; }
    }
}
