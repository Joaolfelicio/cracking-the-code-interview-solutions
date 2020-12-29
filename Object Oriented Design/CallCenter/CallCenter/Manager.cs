using System.Buffers.Text;

namespace CallCenter
{
    public class Manager : Employee
    {
        public Manager() : base(EmployeeLevel.Manager)
        {
        }
    }
}