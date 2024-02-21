public class Rectangle {
    int number;
    double broad;
    double height;
    String color;
    public Rectangle (int number, double broad, double height, String color){
        this.broad = broad;
        this.height = height;
        this.color = color;
        this.number = number;
    }
    public double area (){
        double area;
        area = broad*height;
        return area;
    }
    public double perimeter(){
        double perimeter ;
        perimeter = (height*2)+(height*2);
        return perimeter;
    }
    public void showResults (){
        System.out.println("El area del rectangulo "+number+ " es "+area()+
                ", su perimetro es "+perimeter()+ " y su color es "+color);
        System.out.println(" ");
    }
    String getRectangleInfo (){
        return String.format(
                "number: %d, broad:%f, height: %f, color: %s, area: %f, perimeter: %f",
                number, broad, height, color, area(), perimeter());
    }
}
