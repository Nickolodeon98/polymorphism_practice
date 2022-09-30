class Product {
    private final int price;
    private String name;
    Product(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class Tv extends Product {
    Tv(int price) {
        super(price);
        super.setName("Tv");
    }
    @Override
    public String toString() {
        return super.getName();
    }
}

class Computer extends Product {
    Computer(int price) {
        super(price);
        super.setName("Computer");
    }
    @Override
    public String toString() {
        return super.getName();
    }
}

class Audio extends Product {
    Audio(int price) {
        super(price);
        super.setName("Audio");
    }
    @Override
    public String toString() {
        return super.getName();
    }
}
class Buyer {
    private int money;
    private Product[] cart;
    private int cartState;
    Buyer(int money, int cartSize) {
        this.money = money;
        this.cart = new Product[cartSize];
        cartState = -1;
    }
    public void buy(Product p) {
        if (this.money < p.getPrice()) {
            return;
        }
        this.money -= p.getPrice();

        add(p);
    }

    public void add(Product p) {
        if (cartState >= this.cart.length-1) {
            Product[] newCart = new Product[this.cart.length*2];
            System.arraycopy(this.cart, 0, newCart, 0, cart.length);
            this.cart = newCart;
        }
        cartState++;
        this.cart[cartState] = p;
    }

    public void summary() {
        int total = 0;
        System.out.print("목록: ");
        for (Product pr : this.cart) {
            if (pr == null) break;
            System.out.print(pr + " ");
            total += pr.getPrice();
        }
        System.out.println();
        System.out.println("사용 금액: " + total);
        System.out.println("남은 금액: " + this.money);
    }
}

public class Poly {
    public static void main(String[] args) {
        Product[] pArr = {new Tv(22000), new Computer(7000), new Computer(6000), new Tv(30000)};

        Buyer buyer = new Buyer(200000, 3);

        for (Product product : pArr) {
            buyer.buy(product);
        }

        buyer.summary();
    }
}
