using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Runtime.CompilerServices;

namespace CallCenter
{
    public class Dispatcher
    {
        private const int QuantityLevels = 3;
        private const int QuantityRespondents = 10;
        private const int QuantityManagers = 5;
        private const int QuantityDirectors = 2;

        private List<List<Employee>> Employees { get; set; }
        
        // Queue for each call employee level
        private List<Queue<Call>> CallQueues { get; set; }

        public Dispatcher()
        {
            Employees = new List<List<Employee>>(QuantityLevels);
            CallQueues = new List<Queue<Call>>(QuantityLevels);

            // Create all employees
            var respondents = new List<Employee>();
            for (var i = 0; i < QuantityRespondents; i++)
            {
                respondents.Add(new Respondent(this));
            }
            Employees.Add(respondents);

            var managers = new List<Employee>();
            for (var i = 0; i < QuantityManagers; i++)
            {
                managers.Add(new Manager(this));
            }
            Employees.Add(managers);

            var directors = new List<Employee>();
            for (var i = 0; i < QuantityDirectors; i++)
            {
                directors.Add(new Director(this));
            }
            Employees.Add(directors);
        }


        public Employee GetResponsibleEmployee(Call call)
        {
            for (var level = (int) call.MinEmployeeLevel; level < QuantityLevels; level++)
            {
                var employees = Employees[level];

                foreach (var employee in employees)
                {
                    if (employee.IsAvailable) return employee;
                }
            }
            return null;
        }

        public void DispatchCall(Caller caller)
        {
            var call = new Call(caller);
            DispatchCall(call);
        }

        public void DispatchCall(Call call)
        {
            var employee = GetResponsibleEmployee(call);

            if (employee != null)
            {
                employee.TakeCall(call);
                call.EmployeeResponsible = employee;
            }
            else
            {
                call.Reply("Please hold the line while our employees are busy.");
                var minLevel = (int) call.MinEmployeeLevel;
                CallQueues[minLevel].Enqueue(call);
            }
        }

        public bool AssignCall(Employee employee)
        {
            for (var i = (int) employee.EmployeeLevel; i >= 0; i--)
            {
                if(CallQueues[i].Count > 0)
                {
                    employee.TakeCall(CallQueues[i].Dequeue());
                    return true;
                }
            }
            return false;
        }
    }
}