public class Rectangle {

    public String area (int length, int width){
        int area = length*width;
        return String.format("The total area is: %d", area);
    }
    public String area (double length, double width){
        double area = length*width;
        return String.format("The total area is: %.3f", area);
    }
    public String perimeter (int length, int width){
        int perimeter = (length*2)+(width*2);
        return String.format("The total perimeter is: %d", perimeter);
    }
    public String perimeter (double length, double width){
        double perimeter = (length*2)+(width*2);
        return String.format("The total perimeter is: %.3f", perimeter);
    }


}
