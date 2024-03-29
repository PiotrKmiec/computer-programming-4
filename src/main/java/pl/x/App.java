package pl.x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.x.productcatalog.HashMapProductStorage;
import pl.x.productcatalog.ProductCatalog;

import java.math.BigDecimal;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createNewProductCatalog() {
        ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());

        String prodId = productCatalog.addProduct("Zwiadowcy","Fantasy 4 kids");
        productCatalog.assignImage(prodId, "IMAGE PATH PLACEHOLDER");
        productCatalog.changePrice(prodId, BigDecimal.TEN);
        productCatalog.publishProduct(prodId);

        return productCatalog;
    }
}
