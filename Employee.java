public class Employee {
    String name;
    int age;
    String position;
    public Employee (String name, int age, String position){
    this.name= name;
    this.age = age;
    this.position = position;

    }
    public String calculateSalary(double salary){

        return String.format("The salary is: %.2f", salary);
    }
    public String calculateSalary(double salary, double bonuses){
        double total= salary+bonuses;
        return String.format("The salary is: %.2f", total);
    }
    public String calculateSalary(double salary, double bonuses, double extraHours){
        double total = salary+bonuses+(extraHours*20);
        return String.format("The salary is: %.2f", total);
    }
}
