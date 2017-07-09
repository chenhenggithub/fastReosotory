package com.chen.service;

import com.chen.model.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
public interface ICategoryService {
    public List<Category> selectAll();
    public List<Product> petPro(Map map);
    public List<Item> itemPro(Map map);
    public List<Cart> querycart(Map map);
    public List<Cart> deleteByPrimaryKey(CartKey key);
    public void updateCart(Map map);
    public List<Cart> queryCart(CartKey key);
    public int updateByPrimaryKey(Orders orders);
}
