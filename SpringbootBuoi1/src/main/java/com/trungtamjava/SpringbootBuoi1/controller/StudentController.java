package com.trungtamjava.SpringbootBuoi1.controller;

import com.trungtamjava.SpringbootBuoi1.model.Person;
import com.trungtamjava.SpringbootBuoi1.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class StudentController {
    // Controller map url sử dụng phương thức get trả về một trang html
    // trong trang html tạo một form trả về trang search

    List<Student> list = new ArrayList<>();
    @GetMapping("/student/add")
public String addStudent(){
    return "student/add";
}


    @PostMapping("/student/search")
    public String addPerson(@ModelAttribute Student student){
        list.add(student);
        return "redirect:/student/search";
    }

    @GetMapping("/student/search")
    public String search(Model model){
        model.addAttribute("list",list);
        return "student/search";
    }
        @GetMapping(value = "/student/get/{id}")
        public String get(Model model , @PathVariable("id") int id){
            list.forEach(p ->{
               if(p.getId() == id){
                   model.addAttribute("p",p);
                   return;
               }
            });

        return "student/view";
        }
        @GetMapping("/student/delete")
        public String delete(@RequestParam("id") int id){
            Iterator<Student> studentIterator = list.iterator();
            while(studentIterator.hasNext()){
                Student st = studentIterator.next();
                if(st.getId() == id){
                    studentIterator.remove();
                }
            }
        return "redirect:/student/search";
        }
        @GetMapping("/student/edit")
        public String edit(@RequestParam("id") int id , Model model){
// truyền model object person  person sang trang edit

        list.forEach(p ->{
            if(p.getId() == id){
                model.addAttribute("p",p);
                return;
            }
        });
        return "student/edit";
        }
        @PostMapping("/student/edit")
        public String editForm(@ModelAttribute("p") @Valid Student st , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "student/edit";
        }
            list.forEach( p ->{
                if(st.getId() == p.getId()){
                    p.setName(st.getName());
                    p.setEmail(st.getEmail());
                    p.setPhone(st.getPhone());
                    p.setCity(st.getCity());
                }
            });
        return "redirect:/student/search";
        }




}
