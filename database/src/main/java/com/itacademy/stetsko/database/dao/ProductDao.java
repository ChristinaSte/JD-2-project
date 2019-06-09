package com.itacademy.stetsko.database.dao;

import com.itacademy.stetsko.database.entity.Product;

import javax.jms.Session;
import java.util.List;
import java.util.Locale;

public class ProductDao {

    private static final ProductDao INSTANCE = new ProductDao( );

    public Product findById(Session session, Long id) {
        return session.get(Product.class, id);
    }

    public List<Product> findAll(Session session) {
        return session.
                createQuery("SELECT p FROM Product p", Product.class)
                .list( );
    }

    public List<Product> findBySeason(Session session, Locale.Category season) {
        return session.
                createQuery("SELECT p FROM Product p WHERE p.season =:season", Product.class)
                .setParameter("season", season.getName( ))
                .list( );
    }

    public List<Product> findByType(Session session, Locale.Category type) {
        return session.
                createQuery("SELECT p FROM Product p WHERE p.type =:type", Product.class)
                .setParameter("type", type.getName( ))
                .list( );
    }

    public static ProductDao getInstance() {
        return INSTANCE;
    }
}
