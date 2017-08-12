package cn.sierac.service;

import cn.sierac.dao.ProductDao;
import cn.sierac.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jack on 2017/8/5.
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional(readOnly = true)
    public Product findByCode(String code){
        return productDao.findByCode(code);
    }

    @Transactional(readOnly = true)
    public List<Product> findAll(Product product){
        return productDao.findAll(product);
    }
}
