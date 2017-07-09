package com.chen.controller;

import com.chen.model.Account;
import com.chen.model.Category;
import com.chen.service.IAccountService;
import com.chen.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */
@Controller
@RequestMapping(value = {"/account"})
@SessionAttributes(value = {"user"})
public class AccountCobtroller {
    @Autowired
    private IAccountService service;
    @Autowired
    private ICategoryService cservice;



    @RequestMapping(value = {"/sign-in"})
    public String login(){

        return "shop/login.ftl";
    }
    @RequestMapping(value="/login")
    public String login(Account account,
                        Model model){
        Account a=service.selectByUsername(account);
        if(a!=null){
            model.addAttribute("user",a);

            return "shop/main.ftl";
        }else{
            model.addAttribute("errer","登录失败，请重新登陆");
            return "shop/login.ftl";
        }


    }

    @RequestMapping(value = {"/catall"})
    public String category(Model model){
        Account account=new Account();
        model.addAttribute("account",account);
        List<Category> list=cservice.selectAll();
        model.addAttribute("catlist",list);
        return "shop/registerUser.ftl";
    }
    @RequestMapping(value = {"/register"})
    public String jiaoYan(
            @Valid  @ModelAttribute("account") Account account,
            BindingResult result,
            Model model
    ){
        if(result.hasErrors()){
            List<Category> list=cservice.selectAll();
            model.addAttribute("catlist",list);
            return "shop/registerUser.ftl";
        }else{
            account.getProfile().setUsername(account.getUsername());
            if(service.insert(account)>0){
                return "shop/login.ftl";
            }
            List<Category> list=cservice.selectAll();
            model.addAttribute("catlist",list);
            return "shop/registerUser.ftl";

        }

    }
}
