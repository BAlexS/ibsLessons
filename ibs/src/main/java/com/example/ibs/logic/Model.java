package com.example.ibs.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {

    public static final Model instance = new Model();

    public final Map<Integer, User> map;

    public Model() {
        map = new HashMap<>();

        map.put(1, new User("Anton", "Krov", 5555) );
        map.put(2, new User("Kolay", "Ostap", 6666));
        map.put(3, new User("Andrew", "Mars", 7777));
        map.put(4, new User("Max", "Ivanov", 8888));
    }

    public static Model getInstance() {
        return instance;
    }

    public void add(int id, User user) {
        map.put(id, user);
    }

    public Map<Integer, User> getList() {
        return map;
    }

    public void doDelete(int id) {
        map.remove(id);
    }

    public void doPut(int id, String name, String surname,double salary) {
        map.get(id).setName(name);
        map.get(id).setSurname(surname);
        map.get(id).setSalary(salary);
    }

}
