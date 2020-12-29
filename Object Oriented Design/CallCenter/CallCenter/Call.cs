using System;

namespace CallCenter
{
    public class Call
    {
        public string Source { get; set; }
        public string Reason { get; set; }
        public DateTime ArrivalTime { get; set; }
        public EmployeeLevel MinEmployeeLevel { get; set; }
    }
}