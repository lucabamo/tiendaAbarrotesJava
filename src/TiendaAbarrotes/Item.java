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
    
    /*
        Declaración de las variables globales
    */
    private int id;
    private String name;

    /*
        constructor de la clase recibe un id y un nombre
    */
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //constructor por default
    public Item() {

    }

    //constructor de la calse que recibe un id
    public Item(int parseInt) {
        this.id = parseInt;

    }

    /*
        Método sobreescrito para hacer que dos items sean iguales si tienen el mismo id
    */
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

    /*
        Getters y setters
    */
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

    /*
        Método sobreescrito para regresar solo el nombre
    */
    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

}
