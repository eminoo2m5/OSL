import java.util.ArrayList;

public class PricingRules extends Checkout {
    public PricingRules(){}

    public double rule1(ArrayList<Item> items){
        int tvs = 0;
        double price = 0;
        for (int i = 0; i < items.size();i++){
            if (items.get(i).getSKU() == "atv") {
                price = items.get(i).getPrice();
                tvs++;
            }
        }
        int tv_discount = tvs/3;
        return tv_discount * price;
    }

    public double rule2(ArrayList<Item> items){
        int iPads = 0;
        for (int i = 0; i < items.size();i++){
            if (items.get(i).getSKU() == "ipd") {
                iPads++;
            }
        }
        if (iPads > 4){
            return iPads * 50;
        }
        else return 0;
    }

    public double rule3(ArrayList<Item> items){
        int mac = 0;
        int adapter = 0;
        double price = 0;
        for (int i = 0; i < items.size();i++){
            if (items.get(i).getSKU() == "mbp") mac++;
            if (items.get(i).getSKU() == "vga") {
                adapter++;
                price = items.get(i).getPrice();
            }
        }
        if (mac > adapter) return adapter * price;
        else if (mac < adapter) return mac * price;
        else return adapter * price;
    }
}