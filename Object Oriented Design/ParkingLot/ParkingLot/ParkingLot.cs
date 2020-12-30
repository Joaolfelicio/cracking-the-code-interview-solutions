using System.Collections.Generic;

namespace ParkingLot
{
    public class ParkingLot
    {
        public ParkingLot(int numOfTerminals)
        {
            ParkingManager = new ParkingManager();
            Terminals = new List<Terminal>(numOfTerminals);
            
            for (int i = 0; i < numOfTerminals; i++)
            {
                Terminals.Add(new Terminal(ParkingManager));
            }
        }

        public List<Terminal> Terminals { get; set; }
        public ParkingManager ParkingManager { get; set; }
    }
}