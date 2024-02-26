public class main {
    public static void main(String[] args) {
        Rectangle rectangulo = new Rectangle();
        System.out.println(rectangulo.area(4, 5));
        System.out.println(rectangulo.perimeter(4, 5));
        System.out.println(rectangulo.area(6.5, 7.5));
        System.out.println(rectangulo.perimeter(6.5, 7.5));
        Employee empleado = new Employee( "Alberto", 27, "doctor");
        System.out.println(empleado.calculateSalary(20000.2));
        System.out.println(empleado.calculateSalary(20000, 5000));
        System.out.println(empleado.calculateSalary(20000, 5000, 6));
        TaxCalculator impuesto = new TaxCalculator();
        System.out.println(impuesto.calculateTaxes(20000));
        System.out.println( impuesto.calculateTaxes(600, 15));
        System.out.println(impuesto.calculateTaxes(500,14, 20));
    }
}
