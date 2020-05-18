package com.balabala.balabala.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.balabala.balabala.domain.User;
import com.balabala.balabala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping({"/editUser","/editUser/{uid}"})
    public String edit(@PathVariable(name = "uid",required = false) Integer uid, Model model){
        User user=new User();
        if(uid!=null&&uid>0){
            user=userService.findById(uid);
        }
        model.addAttribute("sexes",User.Sex.toList());
        model.addAttribute("user",user);
        return "editUser";
    }

    @PostMapping("/saveUser")
    public String save(@Valid User user, BindingResult result, RedirectAttributes attr){
        try{
            if (result.hasErrors()) {
                return "redirect:/editUser";
            }
            if(user.getUserId()!=null&&user.getUserId()>0){
                User u=userService.findById(user.getUserId());
                user.setPassword(u.getPassword());
            }
            userService.save(user);
            attr.addFlashAttribute("ok","保存成功！");
            return "redirect:/listUsers";
        } catch (Exception e) {
            return "redirect:/editUser";
        }
    }

    @RequestMapping("/listUsers")
    public String list(String keyword, Model model, Pageable pageable){
        model.addAttribute("keyword",keyword);
        if(keyword!=null)
            keyword="%"+keyword+"%";
        else
            keyword="%%";
        Page<User> ppu=userService.findAll(keyword,pageable);//默认分页从0页（第一页），取每页20条数据
        model.addAttribute("pages",ppu);
//        System.out.println("========================"+ppu.toString());
//        System.out.println(userService.findById(1).toString());
        return "listUsers";
    }

    @GetMapping("/deleteUser/{uid}")
    public String delete(@PathVariable("uid")Integer uid){
        userService.deleteById(uid);
        return "redirect:/listUsers";
    }

    @PostMapping("/deleteUsers")
    public String deletes(String uids){
        List<User> users=new ArrayList<>();
        JSONObject json=JSONObject.parseObject(uids);
        JSONArray jsonArray=json.getJSONArray("uids");//前端传递时使用uids作为json数据的键
        for(int i=0;i<jsonArray.size();i++){
            users.add(userService.findById(jsonArray.getInteger(i)));
        }
        userService.deletes(users);
        return "redirect:/listUsers";
    }
}
