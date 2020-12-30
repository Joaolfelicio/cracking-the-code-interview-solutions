using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;

namespace CallCenter
{
    public class Dispatcher
    {
        public const int QuantityLevels = 3;
        public const int QuantityPerLevel = 5;

        private Employee[] EmployeesWorking { get; set; } = new Employee[QuantityLevels * QuantityPerLevel];
        private Queue<Call> IncomingCalls { get; set; }

        public void AddIncomingCall(Call call) => IncomingCalls.Enqueue(call);

        public void DispatchCall()
        {
            var call = IncomingCalls.Peek();

            var startIndex = GetEmployeeStartIndex(call.MinEmployeeLevel);

            var employeeFound = false;

            for (var i = startIndex; i < EmployeesWorking.Length; i++)
            {
                if (EmployeesWorking[i].IsAvailable && call.MinEmployeeLevel <= EmployeesWorking[i].EmployeeLevel)
                {
                    EmployeesWorking[i].TakeCall(call);
                    employeeFound = true;
                    break;
                }
            }

            if (employeeFound) IncomingCalls.Dequeue();
        }

        private int GetEmployeeStartIndex(EmployeeLevel minEmployeeLevel)
        {
            var employeeLevel = (int) minEmployeeLevel;

            int startIndex = employeeLevel * QuantityPerLevel;

            return startIndex;
        }
    }
}