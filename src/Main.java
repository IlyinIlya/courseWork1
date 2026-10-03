public class Main {
    public static void main(String[] args) {

        EmployeeBook eBook = new EmployeeBook();
        eBook.addNewEmployee(1, "Булгакова",
                "София", "Леоновна", 328);
        eBook.addNewEmployee(2, "Родина",
                "Александра", "Артемьевна", 315);
        eBook.addNewEmployee(3, "Зайцева",
                "Елизавета", "Ивановна", 340);
        eBook.addNewEmployee(5, "Демин",
                "Матвей", "Андреевич", 278);
        eBook.addNewEmployee(4, "Румянцев",
                "Илья", "Никитич", 325);
        eBook.addNewEmployee(2, "Лопатин",
                "Тимофей", "Викторович", 307);
        eBook.addNewEmployee(1, "Котова",
                "Сафия", "Михайловна", 297);
        eBook.addNewEmployee(5, "Федосеев",
                "Алексей", "Львович", 351);
        eBook.addNewEmployee(4, "Смирнов",
                "Александр", "Александрович", 330);
        eBook.addNewEmployee(3, "Кузьмина",
                "Мария", "Максимовна", 335);

        // Вывод информации по всем сотрудникам
        eBook.printEmployeeInfo();
        // Расчет общей суммы по ЗП, поиск минимальной/максимальной ЗП, расчет средней ЗП
        System.out.println("Сотрудник с минимальной зарплатой: " + eBook.calculateMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + eBook.calculateMaxSalary());
        System.out.println("Средняя зарплата за месяц составляет: " + eBook.calculateAverageSalary());
        // Вывод информации: ФИО сотрудников
        eBook.printEmployeeFullName();
        // Расчет индексирования ЗП
        System.out.println("Если процент повышения зарплаты: " + eBook.salaryIndexIncrease(7) + "%, то:");
        eBook.printEmployeeInfo();
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
        //Вывод информации о сотруднике по ID
        eBook.printById(5);
    }
}