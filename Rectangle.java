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
        double ar= 0;
        ar = broad*height;
        return ar;
    }
    public double perimeter(){
        double p = 0;
        p = (height*2)+(height*2);
        return p;
    }
    public void showResults (){
        System.out.println("El area del rectangulo "+number+ " es "+area()+
                ", su perimetro es "+perimeter()+ " y su color es "+color);
        System.out.println("**************************************");
    }
}
