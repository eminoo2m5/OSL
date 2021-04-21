public class Item extends Checkout{
    private String sku;
    private String name;
    private double price;

    public Item(String sku, String name, double price){
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSKU(){
        return this.sku;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
}
