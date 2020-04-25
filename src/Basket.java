import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {

    Map<Item, Integer> orderedItems = new TreeMap<>();

    public void addItem(Item item){
        addItem(item, 1);
    }

    public void addItem(Item item, int amount){
        if (amount < 0){
            throw new IllegalArgumentException("Ammount can't be less than 0!");
        }
        orderedItems.put(item, amount);
    }

    public void deleteItem(Item item){
        deleteItem(item, 1);
    }

    public void deleteItem(Item item, int amount){
        if (amount < 0){
            throw new IllegalArgumentException("You can't delete less than 1 item from your basket!");
        }
        amount = orderedItems.get(item) - amount;
        if (amount == 0){
            orderedItems.remove(item);
        } else if (amount > orderedItems.get(item)){
            throw new IllegalArgumentException("You can't delete more items than you have in your basket!");
        }
    }

    public double getValue(){
        double value = 0;
        //kinda got lost there also
        for (Map.Entry<Item, Integer> orderItem : orderedItems.entrySet()){
            value += orderItem.getKey().getPrice() * orderItem.getValue();
        }
        return value;
    }

    //couldn't figure it by myself
    public Map<Item, Integer> getOrder(){
        return Collections.unmodifiableMap(orderedItems);
    }

}
