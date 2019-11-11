import java.util.*;

// Создать список объетов List<Employee>
// и сортировать по:
// имени
// имени и зарплете
// имени, зарплете, возрасту и компании

public class Employee implements Comparable {
    private String name;
    private String company;
    private int salary;
    private int age;

    // TODO: конструктор, геттеры и сеттеры


    public Employee(String name, String company, int salary, int age) {
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        Random randomName = new Random();
        Random randomCompany = new Random();
        Random randomSalary = new Random();
        Random randomAge = new Random();

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
            employees.add(new Employee(names[randomName.nextInt(names.length)], companies[randomCompany.nextInt(companies.length)], randomSalary.nextInt(7000) + 3000, randomAge.nextInt(39) + 21));
        }
        return employees;
    }

    ArrayList<Employee> employeesList = new ArrayList<>();

    Comparator<Employee> NameComparator = new EmployeeNameComparator();
    TreeSet<Employee> TreeSetName = new TreeSet<>(NameComparator);

    Comparator<Employee> NameSalaryComparator = new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator());
    TreeSet<Employee> TreeSetNameSalary = new TreeSet<>(NameSalaryComparator);

    Comparator<Employee> NameSalaryAgeCompanyComparator = new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator().
            thenComparing(new EmployeeAgeComparator().thenComparing(new EmployeeCompanyComparator())));
    TreeSet<Employee> TreeSetNameSalaryAgeCompany = new TreeSet<>(NameSalaryAgeCompanyComparator);


    public void createList() {
        employeesList.addAll(employeeGenerator(55));
        System.out.println(employeesList);
    }

    public void sort1() {
        TreeSetName.addAll(employeesList);
        System.out.println(TreeSetName);
    }

    public void sort2() {
        TreeSetNameSalary.addAll(employeesList);
        System.out.println(TreeSetNameSalary);
    }

    public void sort3() {
        TreeSetNameSalaryAgeCompany.addAll(employeesList);
        System.out.println(TreeSetNameSalaryAgeCompany);
    }

    public static void main(String[] args) {

        Employee em = new Employee("", "", 0, 0);

        em.createList();
        em.sort1();
        em.sort2();
        em.sort3();
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.hashCode(), o.hashCode());
    }

}


class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o2.getSalary(), o1.getSalary());
    }
}

class EmployeeAgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class EmployeeCompanyComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}