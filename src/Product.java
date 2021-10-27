//Skapa en ny klass i mappen src/ och kalla den klassen för Product
public class Product {
    String productName;
    int productPrice;
    String productDescription;

    public Product(String productName, int productPrice, String productDescription){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;

    }

    //the toString method used to print the value of the variables in the class
    //Without this method the arrayList type (Product), will not print the values inside the array
    public String toString() {
        //We return the name and the price only
        return productName + ": " + productPrice + " Kr ";
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
