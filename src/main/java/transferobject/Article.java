package transferobject;

public class Article {

    public int id;
    public String name;
    public int price;
    public int amount = 0;

    public Article(int _id, String _name, int _price, int _amount) {
        id = _id;
        name = _name;
        price = _price;
        amount = _amount;
    }

    public Article() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
