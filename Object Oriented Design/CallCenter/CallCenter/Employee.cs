using System;
using System.Collections.Generic;
using System.Text;

namespace CallCenter
{
    public abstract class Employee
    {
        protected Employee(EmployeeLevel employeeLevel)
        {
            IsWorking = true;
            EmployeeLevel = employeeLevel;
        }
         
        public EmployeeLevel EmployeeLevel { get; set; }

        public bool IsWorking { get; set; }

        public bool IsAvailable => Call == null && IsWorking;

        private Call Call { get; set; }

        public void TakeCall(Call call)
        {
            if (IsAvailable)
            {
                Call = call;
            }
        }

        public void FinishCall() => Call = null;

    }
}
