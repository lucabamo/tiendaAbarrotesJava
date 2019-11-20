/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;

import java.util.Objects;

/**
 *
 * @author Karla Rosas
 */
public class Item {

    private int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item() {

    }

    public Item(int parseInt) {
        this.id = parseInt;

    }

    @Override
    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }
        Item item = (Item) o;

        return Objects.equals(this.getId(), item.getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        return hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

}
