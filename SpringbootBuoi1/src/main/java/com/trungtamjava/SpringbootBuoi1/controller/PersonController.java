package com.trungtamjava.SpringbootBuoi1.controller;


import com.trungtamjava.SpringbootBuoi1.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class PersonController {

    List<Person> list = new ArrayList<>();

// Khi người dùng nhập địa chỉ trên trình duyệt
// Controller map đại chỉ người dùng và trả về trang view tương ứng
// trong trang view có 1 form để nhập liệu method post
// khi click buton save trên form --> chuyển đến một địa chỉ trên trình duyệt theo acction truyền vào
    // sau khi sử lý ở controller thì trả về trang hiển thị
//
    @GetMapping("/person/add")
    public String add() {
        return "person/add";
    }
    @PostMapping(value = "/person/add1")
    public String addPerson(@ModelAttribute Person p) {
        list.add(p);
        return "redirect:/person/search";
    }
    @GetMapping("/person/search")
    public String search(Model model) {
        model.addAttribute("pList", list);
        return "person/search";
    }

    // hiển thị một bản ghi

    // khi nhấn vào thẻ a ở trang search sẽ nhận được id của bản ghi hiện tại
    // thực hiện gửi một object đến trang detail.html
    // ở trang detail lấy được object của bản ghi hiện tại và hiển thị các giá tri

    @GetMapping(value = "/person/get/{id}")
    public String get(Model model, @PathVariable("id") int id) {

        list.forEach(p -> {
            if (p.getId() == id) {
                model.addAttribute("p", p);
                return;
            }
        });
        return "person/detail.html";
    }

        //Xóa bản ghi
        //khi nhấn vào thẻ a ở trang search sẽ nhận được id của bản ghi hiện tại

    @GetMapping(value = "/person/delete")
    public String delete(@RequestParam("id") int id) {
        Iterator<Person> itr = list.iterator();
        while (itr.hasNext()) {
            Person p = itr.next();
            if (p.getId() == id) {
                itr.remove();
            }
        }
        return "redirect:/person/search";
    }
    // edit một bản ghi

    // lây được id của bản ghi
    // gửi đối tượng p có id lấy được qua trang edit.html
    //


    @GetMapping("/person/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        list.forEach(p -> {
            if (p.getId() == id) {
                model.addAttribute("person", p);
                return;
            }
        });
        return "person/edit.html";
    }

//    @PostMapping(value = "/person/edit")
//    public String editPerson(@ModelAttribute Person person) {
//       list.forEach( p ->{
//           if(p.getId() == person.getId()){
//               p.setAge(person.getAge());
//               p.setName(person.getName());
//               p.setCountry(person.getCountry());
//           }
//       });
        @PostMapping(value = "/person/edit")
        public String editPerson(@ModelAttribute("person") @Valid Person person , BindingResult bindingResult) {
            if(bindingResult.hasErrors()){
                return "person/edit";
            }
            list.forEach( p ->{
                if(p.getId() == person.getId()){
                    p.setAge(person.getAge());
                    p.setName(person.getName());
                    p.setCountry(person.getCountry());
                }
            });


        return "redirect:/person/search";
    }
}