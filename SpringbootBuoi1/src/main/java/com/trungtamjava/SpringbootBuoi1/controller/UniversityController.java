package com.trungtamjava.SpringbootBuoi1.controller;

import com.trungtamjava.SpringbootBuoi1.model.University;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class UniversityController {
    List<University> list = new ArrayList<>();

        // thêm

        // bước 1 :
    @GetMapping("/university/add")
    public String add(){
        return "university/add";
    }
    @PostMapping("university/add")
    public String addForm( @ModelAttribute University university){
        list.add(university);
     return "redirect:/university/search";
    }
    @GetMapping("/university/search")
    public String search(Model model){
        model.addAttribute("list" ,list);
        return "university/search";
    }

    // Bước 2 : view one
@GetMapping("/university/view")
    public String view(@RequestParam("id") int id , Model model){
        list.forEach(p->{
            if(p.getId() == id){
                model.addAttribute("uni" ,p);
                return ;
            }
        });
        return "university/view";
    }

// Edit
    @GetMapping("university/edit/{id}")
    public String edit(@PathVariable("id") int id ,Model model ){
       list.forEach(p->{
           if(p.getId() == id){
               model.addAttribute("uni",p);
           }
       });
      return "university/edit";
    }
    @PostMapping("university/edit")
    public String editForm(@ModelAttribute("uni") University university ){
        list.forEach(p->{
            if(p.getId() == university.getId()){
                p.setTentruong(university.getTentruong());
                p.setVitri(university.getVitri());
                p.setXephang(university.getXephang());
                p.setLoaidaotao(university.getLoaidaotao());
            }
        });
        return "redirect:/university/search";
    }

    // Delete
    @GetMapping("university/delete/{id}")
    public String delete(@PathVariable("id") int id){
        Iterator<University> iUniversity = list.iterator();
        while (iUniversity.hasNext()){
            University uni = iUniversity.next();
            if(uni.getId() == id){
                iUniversity.remove();
            }
        }

     return "redirect:/university/search";
    }

}
