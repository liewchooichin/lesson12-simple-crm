
package com.pace.app.lesson12_simple_crm;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

@RestController
public class ProductController {
  // logger
  private static final Logger logger = LoggerFactory.getLogger(
    ProductController.class
  );
  // productc records
  private ArrayList<Product> products = new ArrayList<>();

  public ProductController(){
    logger.info("Creating items in product list.");
    products.add(new Product("Chickpeas", "Canned chickpeas", 3.25));
    products.add(new Product("Frozen vegetables", "Easy to use frozen veges", 7.75));
    products.add(new Product("Green apples", "Crunchy green apples", 4.50));
  }

  // create
  @PostMapping("/products")
  public ResponseEntity<Product> createProducts (@RequestBody Product newProduct) {
      //process POST request
      logger.info("POST: Create item " + newProduct.toString());
      products.add(newProduct);
      return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
  }
  
  // get all
  @GetMapping("/products")
  public ArrayList<Product> getAllProducts() {
      logger.info("GET all products.");
      return products;
  }

  // get product info
  private int getProductIndex(String id){
    for(Product product: products){
      if(product.getId().equals(id)){
        return products.indexOf(product);
      }
    }
    // not found
    throw new ProductNotFoundException(id);
  }
  
  // get one product
  @GetMapping("/products/{id}")
  public ResponseEntity<Product> getMethodName(
    @PathVariable String id) {
      try{
        int index = getProductIndex(id);
        Product item = (Product) products.get(index);
        logger.info("GET one item " + item.toString());
        return new ResponseEntity<>(item, HttpStatus.OK);
      } catch(ProductNotFoundException exception){
        logger.error("GET: Product id not found: " + id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }

  // update
  @PutMapping("/products/{id}")
  public ResponseEntity<Product> updateProduct(
    @PathVariable String id, 
    @RequestBody Product updatedProduct) {
      //process PUT reques
      try{
        int index = getProductIndex(id);
        logger.info("PUT: Update product with id " + id);
         // set will return previous state of item before changes.
        Product item = products.get(index);
        item.setName(updatedProduct.getName());
        item.setDescription(updatedProduct.getDescription());
        item.setPrice(updatedProduct.getPrice());
        products.set(index, item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
      } catch (ProductNotFoundException exception){
          logger.error("PUT: Id of product not found: " + id);
          return new ResponseEntity<>(updatedProduct, HttpStatus.CREATED);
      }
  }
  
  // delete
  @DeleteMapping("/products/{id}")
  public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String id){
    // delete
    try{
      int index = getProductIndex(id);
      logger.info("DELETE: Product id " + id);
      Product deletedProduct = products.remove(index);
      if(deletedProduct != null)
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      else
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
    } catch(ProductNotFoundException exception){
      logger.error("DELETE: Id of product not found: " + id);
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

} // end of class