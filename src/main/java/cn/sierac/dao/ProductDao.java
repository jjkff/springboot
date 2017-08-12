package cn.sierac.dao;

import cn.sierac.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Jack on 2017/8/5.
 */
@Mapper
public interface ProductDao {

     Product findByCode(String code );

     List<Product> findAll(Product product);

}
