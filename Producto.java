public class Producto {
    private String name;
    private float price;
    private int stock;

    public Producto (String name, float price, int stock){
        this.name=name;
        this.price=price;
        this.stock=stock;
    }
    public Producto(String name, float price){
        this.name=name;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        if (name equals("")) {
            System.out.println("El nombre no puede ser nulo");
        }
        else { this.name=name;
        }
    }

    public float getPrice(){
        return price;
    }
    public void setPrice(float price){
        if (price>0){
            this.price=price;
        }
        else{
            System.out.println("No es un precio válido");
        }
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){

        if (stock>0){
            this.stock= stock;
        }
        else{
            System.out.println("No se puede ingresar un Stock negativo para"+this.name);
        }
    }

    public void aumentarStock(int cantidad){
        this.stock= this.stock+cantidad;
    }
    public void reducirStock(int cantidad){
        if(cantidad>this.stock){
            System.out.println("El stock actual no es suficiente para cubrir esa demanda de "+this.name);
        }
        else {
            this.stock = this.stock - cantidad;
        }
    }
}
