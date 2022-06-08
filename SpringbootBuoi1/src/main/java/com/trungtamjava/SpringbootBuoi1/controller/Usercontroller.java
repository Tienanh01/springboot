package com.trungtamjava.SpringbootBuoi1.controller;

import com.trungtamjava.SpringbootBuoi1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class Usercontroller {
    List<User> userList = new ArrayList<>();
    //create
    // create 1:  Tạo đường dẫn đến trang create
    @GetMapping(value = "/user/create")
    public String create(){
        return "user/create";
    }

    // create 2:  Map /user/add theo dường dẫn action trong form  và add thêm một object vừa nhập
    @PostMapping("/user/read12")
    public String add(@ModelAttribute User user){
            userList.add(user);
        return "redirect:/user/read";
    }
    //update
    // read
    // create 3 : sau khi chạy method post trả về trang read , tạo url user/read
    //  gửi list<User> qua trang read sau đó trang read.html sẽ trả hiển thị toàn bộ list
    @GetMapping("/user/read")
    public String read(Model model){
        model.addAttribute("user",userList);
        return "user/read";
    }
    //delete
    @GetMapping("/user/delete")
     public  String delete(@RequestParam("id") int id){
        Iterator<User> userIterator = userList.iterator();
        while (userIterator.hasNext()){
            User u = userIterator.next();
            if(u.getId() == id){
                userIterator.remove();
            }
        }
        return "redirect:/user/read";
     }
     @GetMapping("/user/detail")
     public String detail(@RequestParam("id") int id , Model model){
            userList.forEach(p->{
                if(p.getId() == id){
                    model.addAttribute("user",p);
                    return;
                }
            });
        return "user/detail";
     }



        @GetMapping("/user/edit")
     public String edit(@RequestParam("id") int id , Model model){
        userList.forEach(p->{
            if(p.getId() == id){
                model.addAttribute("user",p);
                return;
            }
        });
        return "user/edit";
     }

     @PostMapping("/user/edit")
     public String editForm(@ModelAttribute("user") User user){
         userList.forEach( p ->{
             if(p.getId() == user.getId()){
                p.setName(user.getName());
                p.setUsername(user.getUsername());
                p.setPassword(user.getPassword());
                p.setRole(user.getRole());
             }
         });
        return "redirect:/user/read";
     }
}
