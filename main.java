public class main {
    public static void main(String[] args) {
        Producto producto1=new Producto("galletas", 15.5F, 200);
        Producto producto2=new Producto("jabón", (float) 12.95F);
        System.out.println("precio producto 1: "+producto1.getPrice());
        System.out.println("producto 2:"+producto2.getName());
        producto2.setPrice(20F);
        System.out.println(producto2.getPrice());
        System.out.println( "Stock producto 1: "+producto1.getStock());
        producto1.reducirStock(201);
        producto1.setName("barras energeticas");
        System.out.println(producto1.getName());
        Producto producto3 = new Producto("agua", 30);
        producto3.setStock(25);
        System.out.println(producto3.getStock());
        producto3.aumentarStock(40);
        System.out.println("stock producto 3: "+producto3.getStock());
    }
}
