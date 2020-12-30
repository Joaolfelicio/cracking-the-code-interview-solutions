namespace ParkingLot
{
    public abstract class Vehicle
    {
        protected Vehicle(Size size, bool isHandicapped)
        {
            Size = size;
            IsHandicapped = isHandicapped;
        }

        public string LicensePlate { get; set; }
        public Size Size { get; set; }
        public bool IsHandicapped { get; set; }
    }
}