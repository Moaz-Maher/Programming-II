import javax.swing.JOptionPane;

public class Order {
    private int customerId;
    private static int orderIdCounter = 1;
    private int orderId;
    private Product[] products;
    private float totalPrice;

    public Order() {
        this.orderId = orderIdCounter++;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = Math.abs(totalPrice);
    }

    public void printOrderInfo() {
        StringBuilder message = new StringBuilder();
        message.append("Order ID: ").append(orderId).append("\n");
        message.append("Customer ID: ").append(customerId).append("\n\n");
        message.append("Product Details:\n");
        for (Product product : products) {
            if (product != null) {
                message.append(product.getName()).append(" - $").append(product.getPrice()).append("\n");
                totalPrice += product.getPrice();
            }
        }
        message.append("\nTotal Price: $").append(totalPrice);

        JOptionPane.showMessageDialog(null, message.toString(), "Order Summary", JOptionPane.INFORMATION_MESSAGE);
    }
}
