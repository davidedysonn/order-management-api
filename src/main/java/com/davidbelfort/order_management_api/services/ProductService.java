package com.davidbelfort.order_management_api.services;

import com.davidbelfort.order_management_api.entities.Order;
import com.davidbelfort.order_management_api.entities.Product;

public interface ProductService {
    Product create (Product product);
    Product read (Long id);
    Product readName (String name);
    Product update (Long id);
    Void delete (Long id);
}
