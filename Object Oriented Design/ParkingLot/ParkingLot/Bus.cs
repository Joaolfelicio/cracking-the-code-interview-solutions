using System;
using System.Collections.Generic;
using System.Text;

namespace ParkingLot
{
    public class Bus : Vehicle
    {
        public Bus(bool isHandicapped) : base(Size.Large, isHandicapped)
        {
        }
    }
}
