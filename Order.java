import javax.swing.JOptionPane;

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
        JOptionPane.showMessageDialog(null,
                "Here's your order's summary\n" + "Order id: " + orderId + "\nCustomer id: " + customerId);
        String message = "";
        for (int i = 0; i < products.length; i++) {
            message += products[i].getName() + " - $" + products[i].getPrice() + "\n";
            totalPrice += products[i].getPrice();
        }
        JOptionPane.showMessageDialog(null, message, "Product Details", JOptionPane.INFORMATION_MESSAGE);
    }
}
