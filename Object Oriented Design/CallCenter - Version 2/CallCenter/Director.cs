namespace CallCenter
{
    public class Director : Employee
    {
        public Director(Dispatcher dispatcher) : base(EmployeeLevel.Director, dispatcher)
        {
        }
    }
}