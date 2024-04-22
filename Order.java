public class Order {
    private int customerId, orderId = 1;
    private Product[] products;
    private float totalPrice;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public int getOrderId() {
        return (++orderId);
    }

    public void setOrderId() {
        this.orderId = Math.abs(orderId);
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = Math.abs(totalPrice);
    }

    public void printOrderInfo() {
        System.out.println("Here's your order's summary:");
        System.out.println("Order id: " + orderId + "\tCustomer id: " + customerId);
        System.out.println("Products:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].getName() + " - $" + products[i].getPrice());
            totalPrice += products[i].getPrice();
        }
        System.out.println("Total price: $" + totalPrice);
    }
}