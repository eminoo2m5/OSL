import java.util.ArrayList;

public class Checkout {
	//private boolean pricingRules;
    private ArrayList<Item> items;
    private ArrayList<String> skus;
    private double total;
    private PricingRules rules;

    public Checkout() {
        total = 0;
        items = new ArrayList<Item>();
        skus = new ArrayList<String>();
	}
	public Checkout(PricingRules pricingRules) {
		rules = pricingRules;
        total = 0;
        items = new ArrayList<Item>();
        skus = new ArrayList<String>();
	}
	
    public void total(){
        //check first special
        double discount1 = rules.rule1(items);
        double discount2 = rules.rule2(items);
        double discount3 = rules.rule3(items);

        // System.out.println(total);
        // System.out.println(discount1);
        // System.out.println(discount2);
        // System.out.println(discount3);

        total = total - discount1 - discount2 - discount3;
        System.out.println(skus);
        System.out.println(total);
    }

	private void scan(Item a){
        items.add(a);
        String sku = a.getSKU();
        skus.add(sku);
        double price = a.getPrice();
        total += price;
    }

	public static void main(String[] args) {
        Item item1 = new Item("ipd","Super iPad", 549.99);
        Item item2 = new Item("mbp","Macbook Pro", 1399.99);
        Item item3 = new Item("atv","Apple Tv", 109.5);
        Item item4 = new Item("vga","VGA adapter", 30.00);
        PricingRules pricingRules = new PricingRules();
        Checkout co = new Checkout(pricingRules);
        co.scan(item3);
        co.scan(item3);
        co.scan(item3);
        co.scan(item4);
        co.total();

        Checkout co2 = new Checkout(pricingRules);
        co2.scan(item3);
        co2.scan(item1);
        co2.scan(item1);
        co2.scan(item3);
        co2.scan(item1);
        co2.scan(item1);
        co2.scan(item1);
        co2.total();

        Checkout co3 = new Checkout(pricingRules);
        co3.scan(item2);
        co3.scan(item4);
        co3.scan(item1);
        co3.total();
    }
		
}
