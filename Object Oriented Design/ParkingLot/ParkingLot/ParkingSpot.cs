using System;
using System.Collections.Generic;
using System.Net.Security;
using System.Text;

namespace ParkingLot
{
    public class ParkingSpot
    {
        public ParkingSpot(Size size, int rowNumber, Floor floor, bool isHandicappedSpot)
        {
            Size = size;
            RowNumber = rowNumber;
            Floor = floor;
            IsHandicappedSpot = isHandicappedSpot;
        }

        public Size Size { get; }
        public Vehicle Vehicle { get; private set; }
        public int RowNumber { get; }
        public Floor Floor { get; }
        public bool IsHandicappedSpot { get; }

        public bool IsSpotFree() => Vehicle == null;
        private bool CanVehicleFit(Size vehicleSize) => (int) vehicleSize <= (int) Size;

        public void ParkVehicle(Vehicle vehicle)
        {
            if (CanVehiclePark(vehicle)) Vehicle = vehicle;
            Floor.SpotTaken();
        }

        public Vehicle FreeSpot()
        {
            if (IsSpotFree()) return null;
            var vehicle = Vehicle;
            Vehicle = null;
            Floor.SpotFreed();
            return vehicle;
        }

        public bool CanVehiclePark(Vehicle vehicle)
        {
            if (vehicle.IsHandicapped)
            {
                return IsSpotFree() && CanVehicleFit(vehicle.Size);
            }
            return !IsHandicappedSpot && IsSpotFree() && CanVehicleFit(vehicle.Size);
        }
    }
}
