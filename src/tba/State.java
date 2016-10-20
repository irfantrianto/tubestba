/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author adamg_000
 */
public class State {
    private State from;
    private int id;
    private Map<Character, State> next;
    
    public State(int id) {
        this.id = id;
        next = new HashMap<>();
    }
    
    public State(int id, State initial) {
        this.id = id;
        next = new HashMap<>();
        setPaths(' ', initial);
    }
    
    public State(int id, Map<Character, State> next) {
        this.id = id;
        this.next = next;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setPaths(Character input, State next) {
        this.next.put(input, next);
    }
    
    public State findPath(Character input) {
        for(Map.Entry<Character, State> entry: next.entrySet()) {
            if(entry.getKey() == input) {
                return entry.getValue();
            }
        }
        return null;
    }
    
    public void removePath(Character input) {
        this.next.remove(id);
    }
}
