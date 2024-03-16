package com.nurlandaryn.springMVC.controllers;

import com.nurlandaryn.springMVC.dao.HeroesDAO;
import com.nurlandaryn.springMVC.entity.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/mist")
public class MistControllers {

    private final HeroesDAO heroesDAO;

    public MistControllers(HeroesDAO heroesDAO) {
        this.heroesDAO = heroesDAO;
    }

    @GetMapping()
    public String getHeroes(Model model){
        model.addAttribute("heroes", heroesDAO.getHeroes());
        return "mist/heroes";
    }

    @GetMapping("/{id}")
    public String showHero(@PathVariable("id") int id, Model model){
        model.addAttribute("oneHero", heroesDAO.show(id));
        return "mist/show";
    }

    @GetMapping("/newHero")
    public String newHero(Model model){
        model.addAttribute("hero", new Hero());
        return "mist/newHero";
    }

    @PostMapping()
    public String addHero(@ModelAttribute("hero") Hero hero){
        heroesDAO.addHero(hero);
        return "redirect:/mist";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("hero", heroesDAO.show(id));
        return "mist/update";
    }

    @PatchMapping("/{id}")
    public String editHero(@ModelAttribute("hero") Hero hero, @PathVariable("id") int id){
        heroesDAO.updateHero(id, hero);
        return "redirect:/mist";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        heroesDAO.delete(id);
        return "redirect:/mist";
    }
}
