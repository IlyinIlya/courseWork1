public class EmployeeBook {

    private final static int numberOfEmployees = 10;
    private final Employee[] employee = new Employee[numberOfEmployees];

    public boolean addNewEmployee(Employee newEmployee) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                employee[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    public void printEmployeeInfo() {
        for (Employee employees : employee) {
            if (employees == null) {
                continue;
            }
            System.out.println(employees.toString());
        }
    }

    public float calculateAverageSalary() {
        int avgSum = 0;
        float salarySum = 0;

        for (Employee employees : employee) {
            if (employees == null) {
                break;
            }
            avgSum++;
            salarySum += employees.getEmployeeSalary();
        }
        if (avgSum == 0) {
            return 0;
        }
        return salarySum / avgSum;
    }

    public float salaryIndexIncrease(float index, int departmentId) {
        for (Employee employees : employee) {
            if (employees == null || employees.getDepartmentId() != departmentId) {
                continue;
            }
            if (index == 0) {
                continue;
            }
            employees.setEmployeeSalary((int) (employees.getEmployeeSalary()
                    + employees.getEmployeeSalary() / 100 * index));
        }
        return index;
    }

    public void calcTaxes(String taxType) {
        for (Employee employees : employee) {
            if (employees == null) {
                continue;
            }

            float tax = 0;

            switch (taxType) {
                case "PROPORTIONAL":
                    tax = employees.getEmployeeSalary() * 0.13f;
                    break;
                case "PROGRESSIVE":
                    if (employees.getEmployeeSalary() <= 150) {
                        tax = employees.getEmployeeSalary() * 0.13f;
                    } else if (employees.getEmployeeSalary() <= 350) {
                        tax = employees.getEmployeeSalary() * 0.17f;
                    } else {
                        tax = employees.getEmployeeSalary() * 0.21f;
                    }
                    break;
            }
            System.out.println(employees.getEmployeeLastName()
                    + " " + employees.getEmployeeFirstName()
                    + " | Налог: " + tax);
        }
    }

    public void findFirstEmployeeByDepartmentAndSalaryMoreThanLimit(int departmentId, int salary) {
        for (int i = 0; i < employee.length; i++) {
            Employee employees = employee[i];

            if (employees != null
                    && employees.getDepartmentId() == departmentId
                    && employees.getEmployeeSalary() > salary) {
                System.out.println("Порядковый номер сотрудника с зарплатой " +
                        "больше указанной: " + (i + 1));
                employees.printShortInfo();
                break;
            }
        }
    }

    public void findEmployeesWithSalaryLessThanLimit(int wage, int employeeNumber) {
        int i = 0;
        int iCount = 0;

        System.out.println("Информация о сотрудниках с зарплатой меньше указанной: " + wage);
        while (i < employee.length && iCount < employeeNumber) {
            if (employee[i] != null && employee[i].getEmployeeSalary() < wage) {
                employee[i].printShortInfo();
                iCount++;
            }
            i++;
        }
    }

    public boolean checkExistEmployeeOrNot(Employee searchEmployee) {
        for (Employee employees : employee) {
            if (employees != null && employees.equals(searchEmployee)) {
                return true;
            }
        }
        return false;
    }

    public Employee printById(int id) {
        for (Employee employees : employee) {
            if (employees != null && employees.getId() == id) {
                return employees;
            }
        }
        return null;
    }
}