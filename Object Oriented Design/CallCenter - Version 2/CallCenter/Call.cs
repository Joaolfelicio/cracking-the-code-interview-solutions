using System;

namespace CallCenter
{
    public class Call
    {
        public Call(Caller caller)
        {
            Caller = caller;
        }

        public void Reply(string message) => Console.WriteLine(message);

        public EmployeeLevel MinEmployeeLevel { get; set; }
        public Employee EmployeeResponsible { get; set; }
        public Caller Caller { get; set; }

        public EmployeeLevel IncrementEmployeeLevel()
        {
            var currentLevel = (int) MinEmployeeLevel;

            return (EmployeeLevel) currentLevel + 1;
        }

        public void Disconnect() => Reply("Thank you for calling.");
    }
}