import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcommerceSystemGUI extends JFrame {
    private JTextField nameField, addressField, customerIdField, numProductsField;
    private JButton submitButton, addProductButton;
    private JLabel nameLabel, addressLabel, customerIdLabel, numProductsLabel;
    private JList<String> productList;
    private DefaultListModel<String> productListModel;
    private int numSelectedProducts, numProducts;
    private Cart cart;

    public EcommerceSystemGUI() {
        setTitle("E-commerce System");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        nameLabel = new JLabel("Enter your name");
        nameField = new JTextField();
        addressLabel = new JLabel("Enter your address");
        addressField = new JTextField();
        customerIdLabel = new JLabel("Enter your id");
        customerIdField = new JTextField();
        numProductsLabel = new JLabel("Enter number of products");
        numProductsField = new JTextField();
        numProductsField.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                if (!numProductsField.getText().isEmpty()) {
                    numProducts = Integer.parseInt(numProductsField.getText());
                    addProductButton.setEnabled(true);
                }
            }
        });
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(customerIdLabel);
        inputPanel.add(customerIdField);
        inputPanel.add(numProductsLabel);
        inputPanel.add(numProductsField);

        JPanel productListPanel = new JPanel(new BorderLayout());
        productListModel = new DefaultListModel<>();
        productList = new JList<>(productListModel);
        productListPanel.add(new JScrollPane(productList), BorderLayout.CENTER);

        JPanel productButtonPanel = new JPanel(new FlowLayout());
        addProductButton = new JButton("Add Product");
        addProductButton.setEnabled(false);
        addProductButton.addActionListener(e -> {
            String selectedProduct = (String) JOptionPane.showInputDialog(null, "Select a product", "Product Selection", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Smartphone", "T-shirt", "Book"}, "Smartphone");
            if (selectedProduct != null && numSelectedProducts < numProducts) {
                productListModel.addElement(selectedProduct);
                numSelectedProducts++;
                if (numSelectedProducts == numProducts) {
                    addProductButton.setEnabled(false);
                }
            }
        });
        productButtonPanel.add(addProductButton);
        productListPanel.add(productButtonPanel, BorderLayout.SOUTH);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(productListPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            createCart();
            displayOrderSummary();
        });
        buttonPanel.add(submitButton);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        numSelectedProducts = 0;
        setVisible(true);
    }

    private void createCart() {
        cart = new Cart();
        cart.setCustomerId(Integer.parseInt(customerIdField.getText()));
        cart.setnProducts(numProducts);
        cart.setProducts();
        for (int i = 0; i < productListModel.getSize(); i++) {
            String product = productListModel.getElementAt(i);
            switch (product) {
                case "Smartphone":
                    ElectronicProduct smartphone = new ElectronicProduct();
                    smartphone.setName("Smartphone");
                    smartphone.setPrice(599.9f);
                    cart.addProduct(smartphone);
                    break;
                case "T-shirt":
                    ClothingProduct tShirt = new ClothingProduct();
                    tShirt.setName("T-shirt");
                    tShirt.setPrice(19.99f);
                    cart.addProduct(tShirt);
                    break;
                case "Book":
                    BookProduct book = new BookProduct();
                    book.setName("Book");
                    book.setPrice(39.99f);
                    cart.addProduct(book);
                    break;
            }
        }
    }

    private void displayOrderSummary() {
        StringBuilder message = new StringBuilder();
        message.append("<html><body>");
        message.append("<h2 style='text-align:center;'>Order Summary</h2>");
        message.append("<p><b>Name:</b> ").append(nameField.getText()).append("</p>");
        message.append("<p><b>Address:</b> ").append(addressField.getText()).append("</p>");
        message.append("<p><b>Customer ID:</b> ").append(customerIdField.getText()).append("</p>");
        message.append("<p><b>Total Products:</b> ").append(numSelectedProducts).append("</p>");
        message.append("<p><b>Selected Products:</b></p>");
        message.append("<ul>");
        float totalPrice = 0.0f;
        for (Product product : cart.getProducts()) {
            message.append("<li>").append(product.getName()).append(" - $").append(product.getPrice()).append("</li>");
            totalPrice += product.getPrice();
        }
        message.append("</ul>");
        message.append("<p><b>Total Price:</b> $").append(totalPrice).append("</p>");
        message.append("</body></html>");

        JOptionPane.showMessageDialog(null, message.toString());
    }

    public static void main(String[] args) {
        new EcommerceSystemGUI();
    }
}