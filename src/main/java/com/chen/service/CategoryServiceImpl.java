package com.chen.service;

import com.chen.dao.CartMapper;
import com.chen.dao.CategoryMapper;
import com.chen.dao.OrdersMapper;
import com.chen.dao.PetMapper;
import com.chen.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper dao;
    @Autowired
    private PetMapper pdao;
    @Autowired
    private CartMapper cdao;
    @Autowired
    private OrdersMapper odao;
    public List<Category> selectAll() {
        return dao.selectAll();
    }
    public List<Product> petPro(Map map){
        return pdao.petPro(map);
    }

    public List<Item> itemPro(Map map) {
        return pdao.itemPro(map);
    }

    public List<Cart> querycart(Map map) {
        return cdao.querycart(map);
    }

    public List<Cart> deleteByPrimaryKey(CartKey key) {

        cdao.deleteByPrimaryKey(key);
        return queryCart(key);
    }

    public void updateCart(Map map) {
        cdao.updateCart(map);
    }


    public List<Cart> queryCart(CartKey key) {
        CartExample ce=new CartExample();
        ce.createCriteria().andOrderidEqualTo(key.getOrderid());

        return cdao.selectByExample(ce);
    }

    public int updateByPrimaryKey(Orders orders) {
        return odao.updateByPrimaryKey(orders);
    }

}
