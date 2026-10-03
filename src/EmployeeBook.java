public class EmployeeBook {

    private final static int numberOfEmployees = 10;
    private final Employee[] employee = new Employee[numberOfEmployees];

    public void addNewEmployee(int department, String lastname,
                               String firstname, String middlename, int salary) throws RuntimeException {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                employee[i] = new Employee(department, lastname, firstname, middlename, salary);
                return;
            }
        }
        throw new RuntimeException("Не возможно добавить пользователя. Ограничение по количеству");
    }

    public boolean addNewEmployee(Employee newEmployee) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                employee[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    public void removeEmployee(int id) throws RuntimeException {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getId() == id) {
                employee[i] = null;
                return;
            }
        }
        throw new RuntimeException("Не найден пользователь с ID: " + id);
    }

    public void printEmployeeInfo() {
        for (Employee employees : employee) {
            if (employees == null) {
                continue;
            }
            System.out.println(employees.toString());
        }
    }

    public void printByDepartment(int departmentId) {
        for (Employee employees : employee) {
            if (employees != null && employees.getDepartmentId() == departmentId) {
                System.out.println(employees);
            }
        }
    }

    public Employee printById(int id) {
        for (Employee employees : employee) {
            if (employees != null && employees.getId() == id) {
                return employees;
            }
        }
        return null;
    }

    public void printEmployeeInfoNoDep() {
        for (Employee employees : employee) {
            System.out.println("ID: " + employees.getId() + " | ФИО: " + employees.getEmployeeLastName()
                    + " " + employees.getEmployeeFirstName() + " "
                    + employees.getEmployeeMiddleName() + " | Зарплата: " + employees.getEmployeeSalary());
        }
    }

    public float salaryCalculate() {
        float total = 0;
        for (Employee employees : employee) {
            if (employees != null) {
                total += employees.getEmployeeSalary();
            }
        }
        return total;
    }

    public float salaryCalculate(int departmentId) {
        float total = 0;
        for (Employee employees : employee) {
            if (employees != null && employees.getDepartmentId() == departmentId) {
                total += employees.getEmployeeSalary();
            }
        }
        return total;
    }

    public Employee calculateMaxSalary() {
        Employee maxSalary = employee[0];
        for (Employee employees : employee) {
            if ((employees != null && maxSalary.getEmployeeSalary() < employees.getEmployeeSalary())) {
                maxSalary = employees;
            }
        }
        return maxSalary;
    }

    public Employee calculateMaxSalary(int departmentId) {
        Employee maxSalary = employee[0];
        for (Employee employees : employee) {
            if (employees != null && employees.getDepartmentId() == departmentId
                    && (maxSalary.getEmployeeSalary() < employees.getEmployeeSalary())) {
                maxSalary = employees;
            }
        }
        return maxSalary;
    }

    public Employee calculateMinSalary() {
        Employee minSalary = employee[0];
        for (Employee employees : employee) {
            if (employees != null && (minSalary.getEmployeeSalary() > employees.getEmployeeSalary())) {
                minSalary = employees;
            }
        }
        return minSalary;
    }

    public Employee calculateMinSalary(int departmentId) {
        Employee minSalary = employee[0];
        for (Employee employees : employee) {
            if (employees != null && employees.getDepartmentId() == departmentId &&
                    (minSalary.getEmployeeSalary() > employees.getEmployeeSalary())) {
                minSalary = employees;
            }
        }
        return minSalary;
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

    public float calculateAverageSalary(int departmentId) {
        float avgSum = 0;
        int count = 0;
        for (Employee employees : employee) {
            if (employees != null && employees.getDepartmentId() == departmentId) {
                avgSum += employees.getEmployeeSalary();
                count++;
            }
        }
        return avgSum / count;
    }

    public void printEmployeeFullName() {
        for (Employee employees : employee) {
            System.out.println("Ф.И.О сотрудника: " + employees.getEmployeeLastName() + " "
                    + employees.getEmployeeFirstName() + " " + employees.getEmployeeMiddleName());

        }
    }

    public float salaryIndexIncrease(float index) {
        for (Employee employees : employee) {
            if (employees != null) {
                employees.setEmployeeSalary( (int) (employees.getEmployeeSalary()
                        + (employees.getEmployeeSalary() / 100 * index)));
            }
        }
        return index;
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

    public void findLessLimitCurrentSalary(float limitSalary) {
        System.out.println("Ниже установленного порога:");
        for (Employee employees : employee) {
            if (employees != null && employees.getEmployeeSalary() < limitSalary) {
                System.out.println("ID: " + employees.getId() + " | ФИО: " + employees.getEmployeeLastName()
                        + " " + employees.getEmployeeFirstName() + " "
                        + employees.getEmployeeMiddleName() + " | Зарплата: " + employees.getEmployeeSalary());
            }
        }
    }

    public void findMoreLimitCurrentSalary(float limitSalary) {
        System.out.println("Выше установленного порога:");
        for (Employee employees : employee) {
            if (employees != null && employees.getEmployeeSalary() >= limitSalary) {
                System.out.println("ID: " + employees.getId() + " | ФИО: " + employees.getEmployeeLastName()
                        + " " + employees.getEmployeeFirstName() + " "
                        + employees.getEmployeeMiddleName() + " | Зарплата: " + employees.getEmployeeSalary());
            }
        }
    }

    public void calcTaxes(String taxType) {
        for (Employee employees: employee) {
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
                    }
                    else if (employees.getEmployeeSalary() <= 350) {
                        tax = employees.getEmployeeSalary() * 0.17f;
                    }
                    else {
                        tax = employees.getEmployeeSalary() * 0.21f;
                    }
                    break;
            }
            System.out.println(employees.getEmployeeLastName()
                    + " " + employees.getEmployeeFirstName()
                    + " | Налог: " + tax);
        }
    }

    public void findFirstEmployeeByDepartmentAndSalaryMoreThanLimit (int departmentId, int salary) {
        for (int i = 0; i < employee.length; i++) {
            Employee employees = employee[i];

            if (employees != null && employees.getDepartmentId() == departmentId && employees.getEmployeeSalary() > salary) {
                System.out.println("Порядковый номер сотрудника с зарплатой больше указанной: " + (i + 1));
                employees.printShortInfo();
                break;
            }
        }
    }

    public void findEmployeesWithSalaryLessThanLimit(int wage, int employeeNumber) {
        int i = 0;
        int iCount = 0;

        System.out.println("Информация о сотрудниках с зарплатой меньше указанной: " + wage);
        while (i < employee.length) {
            if (employee[i] != null && employee[i].getEmployeeSalary() < wage) {
                employee[i].printShortInfo();
                iCount++;
            }

            if (iCount == employeeNumber) {
                break;
            }
            i++;
        }
    }

    public boolean checkExistEmployeeOrNot( Employee searchEmployee) {
        for (Employee employees: employee) {
            if (employees != null && employees.equals(searchEmployee)) {
                return true;
            }
        }
        return false;
    }
}