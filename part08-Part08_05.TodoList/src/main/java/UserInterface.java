/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author hachem
 */
public class UserInterface {
    private TodoList todos;
    private Scanner scanner;

    public UserInterface(TodoList todos, Scanner scanner) {
        this.todos = todos;
        this.scanner = scanner;
    }
    
    public void start() {
        while (true) {
            System.out.println("Command:");
            String cmd = scanner.nextLine();
            if (cmd.equals("stop")) {
                break;
            }
            if (cmd.equals("add")) {
                this.add();
            }
            if (cmd.equals("list")) {
                this.list();
            }
            if (cmd.equals("remove")) {
                this.remove();
            }
        }
    }
    
    public void add() {
        System.out.println("To add:");
        String task = scanner.nextLine();
        this.todos.add(task);
    }
    
    public void list() {
        this.todos.print();
    }
    
    public void remove() {
        System.out.println("Which one is removed?");
        int toRemove = Integer.valueOf(scanner.nextLine());
        this.todos.remove(toRemove);
    }
}