using System;
using System.Collections.Generic;
using System.Text;

namespace ParkingLot
{
    public class ParkingSpot
    {
        public ParkingSpot(Size size, int rowNumber, int floor, bool isHandicappedSpot)
        {
            Size = size;
            RowNumber = rowNumber;
            Floor = floor;
            IsHandicappedSpot = isHandicappedSpot;
        }

        public Size Size { get; }
        public Vehicle Vehicle { get; private set; }
        public int RowNumber { get; }
        public int Floor { get; }
        public bool IsHandicappedSpot { get; }

        public bool IsSpotFree() => Vehicle == null;
        private bool CanVehicleFit(Size vehicleSize) => (int) vehicleSize <= (int) Size;

        public void ParkVehicle(Vehicle vehicle)
        {
            if (CanVehiclePark(vehicle)) Vehicle = vehicle;
        }

        public Vehicle FreeSpot()
        {
            if (IsSpotFree()) return null;
            var vehicle = Vehicle;
            Vehicle = null;
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
