using System;
using System.Collections.Generic;
using System.Text;

namespace CallCenter
{
    public abstract class Employee
    {
        protected Employee(EmployeeLevel employeeLevel, Dispatcher dispatcher)
        {
            EmployeeLevel = employeeLevel;
            Dispatcher = dispatcher;
        }
         
        private Dispatcher Dispatcher { get; set; }
        public EmployeeLevel EmployeeLevel { get; set; }
        public bool IsAvailable => Call == null;
        private Call Call { get; set; }

        public void TakeCall(Call call) => Call = call;

        public void CallCompleted()
        {
            if (Call != null)
            {
                Call.Disconnect();
                Call = null;
            }

            AssignNewCall();
        }

        private bool AssignNewCall()
        {
            if (!IsAvailable) return false;

            return Dispatcher.AssignCall(this);
        }

        public void EscalateCall()
        {
            if (Call != null)
            {
                Call.IncrementEmployeeLevel();
                Dispatcher.DispatchCall(Call);
                Call = null;
            }

            AssignNewCall();
        }
    }
}
