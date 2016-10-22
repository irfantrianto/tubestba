/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tba;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author adamg_000
 */
public class TBA {
    private static State q0 = new State(0);

    private static State q1 = new State(1, q0);

    private static State q2 = new State(-1, q0);
    private static State q3 = new State(-1, q0);
    private static State q4 = new State(2, q0);

    private static State q5 = new State(-1, q0);
    private static State q6 = new State(-1, q0);
    private static State q7 = new State(3, q0);

    private static State q8 = new State(-1, q0);
    private static State q9 = new State(4, q0);

    private static State q10 = new State(-1, q0);
    private static State q11 = new State(-1, q0);
    private static State q12 = new State(5, q0);

    private static State q13 = new State(-1, q0);
    private static State q14 = new State(6, q0);

    private static State q15 = new State(-1, q0);
    private static State q16 = new State(-1, q0);
    private static State q17 = new State(-1, q0);
    private static State q18 = new State(7, q0);

    private static State q19 = new State(8, q0);

    private static State q20 = new State(9, q0);
    private static State q21 = new State(10, q0);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createStates();
        while(true)
            run();
    }

    private static void createStates() {
        q0.setPaths('p', q1);
        q0.setPaths('q', q1);
        q0.setPaths('r', q1);
        q0.setPaths('s', q1);
        q0.setPaths('(', q20);
        q0.setPaths(')', q21);
        
        q0.setPaths('n', q2);
        q2.setPaths('o', q3);
        q3.setPaths('t', q4);
        q4.setPaths('(', q20);
        q4.setPaths(')', q21);
        
        q0.setPaths('a', q5);
        q5.setPaths('n', q6);
        q6.setPaths('d', q7);
        q7.setPaths('(', q20);
        q7.setPaths(')', q21);
        
        q0.setPaths('o', q8);
        q8.setPaths('r', q9);
        q9.setPaths('(', q20);
        q9.setPaths(')', q21);
        
        q0.setPaths('x', q10);
        q10.setPaths('o', q11);
        q11.setPaths('r', q12);
        q12.setPaths('(', q20);
        q12.setPaths(')', q21);
        
        q0.setPaths('i', q13);
        q13.setPaths('f', q14);
        q14.setPaths('(', q20);
        q14.setPaths(')', q21);
        
        q0.setPaths('t', q15);
        q15.setPaths('h', q16);
        q16.setPaths('e', q17);
        q17.setPaths('n', q18);
        q18.setPaths('(', q20);
        q18.setPaths(')', q21);
        
        q14.setPaths('f', q19);
        q19.setPaths('(', q20);
        q19.setPaths(')', q21);
    }

    private static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("String: ");
        String n = scanner.nextLine();
        boolean dead = false;
        State currentState = q0;
        
        for(int i = 0; i < n.length(); i++) {
            if(n.charAt(i) != ' ') {
                State nextPath = currentState.findPath(n.charAt(i));                
                if(nextPath != null) {
                    currentState = nextPath;
                }
                else {
                    System.out.println("Error");
                    dead = true;
                    break;
                }
            }
            else {
                System.out.print(currentState.getId() +" ");
                currentState = q0;
            }
        }
        if(currentState.getId() != 0 && !dead)
            System.out.print((currentState.getId() == -1)? "Error": currentState.getId());
        System.out.println();
    }
    
}
