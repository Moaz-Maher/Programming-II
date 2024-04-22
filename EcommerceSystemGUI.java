import javax.swing.JOptionPane;
public class EcommerceSystem {
    public static void main(String[] args) throws Exception {

        ElectronicProduct electronicProduct = new ElectronicProduct();
        electronicProduct.setName("smartphone");
        electronicProduct.setProductId(1);
        electronicProduct.setPrice(599.9f);
        electronicProduct.setBrand("Samsung");
        electronicProduct.setWarrantyPeriod(1);

        ClothingProduct clothingProduct = new ClothingProduct();
        clothingProduct.setName("T-shirt");
        clothingProduct.setProductId(2);
        clothingProduct.setPrice(19.99f);
        clothingProduct.setSize("Medium");
        clothingProduct.setFabric("Cotton");

        BookProduct bookProduct = new BookProduct();
        bookProduct.setName("OOP");
        bookProduct.setProductId(3);
        bookProduct.setPrice(39.99f);
        bookProduct.setAuthor("O'Reilly");
        bookProduct.setPublisher("X Publications");

        Customer customer = new Customer();
        customer.setName(JOptionPane.showInputDialog(null, "Enter your name"));
        customer.setAddress(JOptionPane.showInputDialog(null, "Enter your address"));
        int customerId = Integer.parseInt(JOptionPane.showInputDialog("Enter your id"));
        customer.setCustomerId(customerId);

        Cart cart = new Cart();
        int nProducts = Integer.parseInt(JOptionPane.showInputDialog("How many products you want to add to your cart?"));
        cart.setnProducts(nProducts);
        cart.setProducts();
        System.out.print(electronicProduct.getProductId() + "- " + electronicProduct.getName() + "\t");
        System.out.print(clothingProduct.getProductId() + "- " + clothingProduct.getName() + "\t");
        System.out.println(bookProduct.getProductId() + "- " + bookProduct.getName());
        while (nProducts > 0) {
            int choice = Integer.parseInt(JOptionPane.showInputDialog(electronicProduct.getProductId() + "- " + electronicProduct.getName() + "\n" + clothingProduct.getProductId() + "- " + clothingProduct.getName() + "\n" + bookProduct.getProductId() + "- " + bookProduct.getName() + "\n" + "Which product do you want to to add to your cart?"));
            if (choice == electronicProduct.productId) {
                cart.addProduct(electronicProduct);
            } else if (choice == clothingProduct.getProductId()) {
                cart.addProduct(clothingProduct);
            } else if (choice == bookProduct.getProductId()) {
                cart.addProduct(bookProduct);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid option");
                continue;
            }
            nProducts--;
        }

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setOrderId();
        order.setProducts(cart.getProducts());
        order.setTotalPrice(cart.calculatePrice());
        if (cart.placeOrder(JOptionPane.showInputDialog("Your total price is: $" + cart.calculatePrice() + "\n" + "Would you like to placeyour order for the products in the cart?(Y/N)"))) {
            order.printOrderInfo();
        } else {
            JOptionPane.showMessageDialog(null, "Your order has been canceled");
        }
    }
}
