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
        //Поиск первого сотрудника отдела с зарплатой больше указанной
        eBook.findFirstEmployeeByDepartmentAndSalaryMoreThanLimit(1, 127);
        eBook.findFirstEmployeeByDepartmentAndSalaryMoreThanLimit(1, 128);
        eBook.findFirstEmployeeByDepartmentAndSalaryMoreThanLimit(1, 397);
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
        System.out.println(eBook.printById(555));
        eBook.printEmployeeInfo();

        // Проверка пустого и частично заполненного массива.
        EmployeeBook testeBook = new EmployeeBook();

        System.out.println("Средняя зарплата: " + testeBook.calculateAverageSalary());
        System.out.println(testeBook.addNewEmployee(new Employee(
                2, "Цукерберг",
                "Марк", "Эллиот", 100)));
        testeBook.printEmployeeInfo();
        System.out.println("Средняя зарплата: " + testeBook.calculateAverageSalary());
    }
}