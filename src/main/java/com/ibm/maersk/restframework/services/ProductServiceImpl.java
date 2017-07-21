package com.ibm.maersk.restframework.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.maersk.restframework.domain.Product;
import com.ibm.maersk.restframework.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> listAllProducts() {
        logger.debug("listAllProducts called");
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        logger.debug("getProductById called");
        return productRepository.findOne(id);
    }

    public Product saveProduct(Product product) {
        logger.debug("saveProduct called");
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        logger.debug("deleteProduct called");
        productRepository.delete(id);
    }
}
