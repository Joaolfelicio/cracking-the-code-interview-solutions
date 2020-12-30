namespace CallCenter
{
    public class Respondent : Employee
    {
        public Respondent(Dispatcher dispatcher) : base(EmployeeLevel.Respondent, dispatcher)
        {
        }
    }
}