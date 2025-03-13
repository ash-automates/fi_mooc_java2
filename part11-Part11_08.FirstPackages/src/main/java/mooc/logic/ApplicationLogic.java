/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mooc.logic;

import java.util.stream.IntStream;
import mooc.ui.UserInterface;

/**
 *
 * @author hachem
 */
public class ApplicationLogic {
    private final UserInterface ui;
    
    public ApplicationLogic(UserInterface ui) {
        this.ui = ui;
    }
    
    public void execute(int times) {
        int i = 0;
        while (i < times) {
            System.out.println("Application logic is working");
            this.ui.update();
            i++;
        }
    }        
}
