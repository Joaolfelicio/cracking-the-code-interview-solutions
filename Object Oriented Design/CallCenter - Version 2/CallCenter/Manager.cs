using System.Buffers.Text;

namespace CallCenter
{
    public class Manager : Employee
    {
        public Manager(Dispatcher dispatcher) : base(EmployeeLevel.Manager, dispatcher)
        {
        }
    }
}