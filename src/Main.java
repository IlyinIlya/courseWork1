public class Main {
    public static void main(String[] args) {
        //Создание книги и добавление сотрудников
        EmployeeBook eBook = new EmployeeBook();

        System.out.println(eBook.addNewEmployee(new Employee(1, "Булгакова",
                "София", "Леоновна", 128)));

        System.out.println(eBook.addNewEmployee(new Employee(2, "Родина",
                "Александра", "Артемьевна", 115)));

        System.out.println(eBook.addNewEmployee(new Employee(3, "Зайцева",
                "Елизавета", "Ивановна", 240)));

        System.out.println(eBook.addNewEmployee(new Employee(5, "Демин",
                "Матвей", "Андреевич", 278)));

        System.out.println(eBook.addNewEmployee(new Employee(4, "Румянцев",
                "Илья", "Никитич", 325)));

        System.out.println(eBook.addNewEmployee(new Employee(2, "Лопатин",
                "Тимофей", "Викторович", 307)));

        System.out.println(eBook.addNewEmployee(new Employee(1, "Котова",
                "Сафия", "Михайловна", 397)));

        System.out.println(eBook.addNewEmployee(new Employee(5, "Федосеев",
                "Алексей", "Львович", 351)));

        System.out.println(eBook.addNewEmployee(new Employee(4, "Смирнов",
                "Александр", "Александрович", 430)));

        System.out.println(eBook.addNewEmployee(new Employee(3, "Кузьмина",
                "Мария", "Максимовна", 435)));

        System.out.println(eBook.addNewEmployee(new Employee(2, "Петров",
                "Иван", "Романович", 432)));
        //Вывод всех сотрудников
        eBook.printEmployeeInfo();
        //Средняя зарплата
        System.out.println("Средняя зарплата за месяц составляет: " + eBook.calculateAverageSalary());
        //Налоги (подсчет Пропорционального и Прогрессивного налогов)
        System.out.println("Пропорциональный налог:");
        eBook.calcTaxes("PROPORTIONAL");
        System.out.println("Прогрессивный налог:");
        eBook.calcTaxes("PROGRESSIVE");
        //Индексация зарплаты
        System.out.println("Если процент повышения зарплаты: " + eBook.salaryIndexIncrease(7) + "%, то:");
        eBook.printEmployeeInfo();
        // Расчет индексирования ЗП при задании фильтра по отделу
        int departmentID = 5;
        System.out.println("Если процент повышения зарплатыв отделе № " + departmentID + ": "
                + eBook.salaryIndexIncrease(9, departmentID) + "%, то:");
        //Поиск первого сотрудника отдела с зарплатой больше указанной
        eBook.findFirstEmployeeByDepartmentAndSalaryMoreThanLimit(1, 300);
        //Поиск сотрудников с зарплатой меньше указанной
        eBook.findEmployeesWithSalaryLessThanLimit(230, 3);
        //Проверка существования сотрудника
        Employee employee1 = new Employee(1, "Булгакова",
                "София", "Леоновна", 128);
        System.out.println(eBook.checkExistEmployeeOrNot(employee1));
        //Проверка существования сотрудника с несуществующей зарплатой:
        Employee employee2 = new Employee(1, "Булгакова",
                "София", "Леоновна", 127);
        System.out.println(eBook.checkExistEmployeeOrNot(employee2));
        //Вывод информации о сотруднике по ID
        System.out.println(eBook.printById(5));

        //Найти свободную ячейку в массиве и положить в нее данные нового сотрудника
        Employee employee2 = new Employee(1, "Булгаков",
                "Федор", "Леонидович", 256);
        System.out.println("Добавление сотрудника: " + eBook.addNewEmployee(employee2));

        // Расчет общей суммы по ЗП, поиск минимальной/максимальной ЗП, расчет средней ЗП
        System.out.println("Сотрудник с минимальной зарплатой: " + eBook.calculateMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + eBook.calculateMaxSalary());
        // Вывод информации: ФИО сотрудников
        eBook.printEmployeeFullName();

        // Поиск минимальной/максимальной ЗП при задании фильтра по отделам
        int departmentID = 5;
        System.out.println("В отделе № " + departmentID + " минимальная зарплата сотрудника: "
                + eBook.calculateMinSalary(departmentID));
        System.out.println("В отделе № " + departmentID + " максимальная зарплата сотрудника: "
                + eBook.calculateMaxSalary(departmentID));
        // Расчет суммы ЗП при задании фильтра по отделу
        System.out.println("Сумма затрат на зарплаты в отделе № " + departmentID + " составляет: "
                + eBook.salaryCalculate(departmentID));
        // Расчет средней ЗП при задании фильтра по отделу
        System.out.println("Средняя зарплата в отделе № " + departmentID + " составляет: "
                + eBook.calculateAverageSalary(departmentID));
        // Расчет индексирования ЗП при задании фильтра по отделу
        System.out.println("Если процент повышения зарплатыв отделе № " + departmentID + ": "
                + eBook.salaryIndexIncrease(9, departmentID) + "%, то:");
        eBook.printByDepartment(departmentID);
        // Вывод информации по всем сотрудником, исключая номер отдела
        eBook.printEmployeeInfoNoDep();
        // Вывод информации по сотрудникам с ЗП меньше лимита
        float limitSalary = 330;
        eBook.findLessLimitCurrentSalary(limitSalary);
        // Вывод информации по сотрудникам с ЗП меньше лимита
        eBook.findMoreLimitCurrentSalary(limitSalary);
        //Удалить сотрудника по ID
        eBook.removeEmployee(2);
        eBook.printEmployeeInfo();
        //Добавить нового сотрудника
        eBook.addNewEmployee(2, "Петров", "Иван", "Романович", 432);
        eBook.printEmployeeInfo();

    }
}