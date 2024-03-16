package com.nurlandaryn.springMVC.dao;

import com.nurlandaryn.springMVC.entity.Hero;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class HeroesDAO {
    private ArrayList<Hero> heroes;
    private static int id;
    {
        heroes = new ArrayList<>();
        heroes.add(new Hero(++id, "Naruto", "Hokage"));
        heroes.add(new Hero(++id, "Sasuke", "Nukenin"));
        heroes.add(new Hero(++id, "Sakura", "Jonin"));
        heroes.add(new Hero(++id, "Kakashi", "Hokage"));
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void addHero(Hero hero) {
        hero.setId(++id);
        heroes.add(hero);
    }

    public Hero show(int id){
        return heroes.stream()
                .filter(h -> h.getId() == id).findAny().orElse(null);
    }

    public void updateHero(int id, Hero hero){
        Hero updatedHero = show(id);

        updatedHero.setName(hero.getName());
        updatedHero.setRang(hero.getRang());
    }

    public void delete(int id){
        heroes.removeIf(h -> h.getId() == id);
    }
}
