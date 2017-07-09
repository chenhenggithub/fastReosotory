package com.chen.controller;

import com.chen.model.*;
import com.chen.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
@Controller
@RequestMapping(value = {"/category"})
public class CategoryController {
    @Autowired
    private ICategoryService service;
    @RequestMapping(value = {"/main"})
    public String main(){
        return "shop/main.ftl";
    }
    @RequestMapping(value = {"/product/name/{catid}"})
    public String product(
            @PathVariable(value = "catid")String catid,
            Model model){
        System.out.println(catid);
        Map<String,String> map=new HashMap<String,String>();
        map.put("in_catid",catid);
        List<Product> list=service.petPro(map);
        model.addAttribute("plist",list);
        return "shop/product.ftl";
    }
    @RequestMapping(value = {"/item/productid/{productid}"})
    public String items(
            @PathVariable(value = "productid")String productid,
            Model model
            ){
        Map<String,String> map=new HashMap<String,String> ();
        map.put("in_productid",productid);
        List<Item> iList=service.itemPro(map);
        model.addAttribute("ilist",iList);
        return "shop/items.ftl";
    }
    @RequestMapping(value = {"/item1/itemid/{itemid}"})
    public String item(
            @PathVariable(value = "itemid")String itemid,
            Model model
            ){
        Map<String,String> map=new HashMap<String, String>();
        map.put("in_itemid",itemid);
        List<Item> list=service.itemPro(map);
        model.addAttribute("item",list.get(0));

        return "shop/item.ftl";
    }
    @RequestMapping(value = {"/querycart/itemid/{itemid}/quantity/{quantity}"})
    public String cart(
            @PathVariable(value = "itemid")String itemid,
            @PathVariable(value = "quantity")String quantiry,
            Model model
    ){
        Map<String,String> map=new HashMap<String,String>();
        map.put("in_itemid",itemid);
        map.put("in_quantity",quantiry);
        List<Cart> list=service.querycart(map);
        System.out.println("oo");
        model.addAttribute("cartlist",list);
        return "shop/addCart.ftl";
    }
    @RequestMapping(value = {"/deleteCart/orderid/{orderid}/itemid/{itemid}"})
    public String deleteCart(
            @PathVariable(value = "orderid")String orderid,
            @PathVariable(value = "itemid")String itemid,
            Model model
    ){
        CartKey cart=new CartKey();
        cart.setOrderid(Integer.parseInt(orderid));
        cart.setItemid(itemid);
        List<Cart> list=service.deleteByPrimaryKey(cart);
        model.addAttribute("cartlist",list);
        return "shop/addCart.ftl";


    }
    @RequestMapping(value = {"/updateCart"})
    public String updateCart(
           String[] orderids,
           String[] itemids,
           String[] qtys,
           Model model
    ){
        System.out.println(itemids[0]);
        for(int i=0;i<orderids.length;i++){
            Map<String,String> map=new HashMap<String,String>();
            map.put("in_orderid",orderids[i]);
            map.put("in_itemid",itemids[i]);
            map.put("in_quantity",qtys[i]);
            service.updateCart(map);
        }
        CartKey key=new CartKey();
        key.setOrderid(Integer.parseInt(orderids[0]));
        List<Cart> list=service.queryCart(key);
        model.addAttribute("cartlist",list);
        return "shop/addCart.ftl";
    }
    @RequestMapping(value = {"/check/orderid/{orderid}/zqty/{zqty}"})
    public String checkOut(
            @PathVariable(value = "orderid")String orderid,
            @PathVariable(value = "zqty")String zqty
    ){
        System.out.println(orderid+"---"+zqty);
        Orders orders=new Orders();
        orders.setOrderid(Integer.parseInt(orderid));
        orders.setOrderdate(new Date());
        orders.setTotalprice(new BigDecimal(zqty));
        service.updateByPrimaryKey(orders);
        return "shop/main.ftl";
    }
}
