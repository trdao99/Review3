package tonghop2.business;

import tonghop2.businessImp.Employee;

public interface IEmployee {
    public long BASIC_SALARY = 1300000;
    Employee inputData();
    void displayData();
}
