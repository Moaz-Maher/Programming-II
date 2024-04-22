public class Cart {
    private int customerId, nProducts;
    Product[] products;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public int getnProducts() {
        return nProducts;
    }

    public void setnProducts(int nProducts) {
        this.nProducts = Math.abs(nProducts);
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts() {
        this.products = new Product[nProducts];
    }

    public void addProduct(Product product) {
        this.products[--nProducts] = product;
    }

    public void removeProduct(int index) {
        this.products[index] = null;
    }

    public float calculatePrice() {
        float totalPrice = 0;
        for (int i = 0; i < products.length; i++) {
            totalPrice += products[i].getPrice();
        }
        return totalPrice;
    }

    public boolean placeOrder(String Choice) {
        if (Choice.toUpperCase().equals("Y")) {
            return true;
        } else {
            return false;
        }
    }
}
