/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author hachem
 */
public class SaveableDictionary {
    private final Map<String, String> translations;
    private String source;

    public SaveableDictionary(String file) {
        this.translations = new HashMap<>();
        this.source = file;
    }
    
    public SaveableDictionary() {
        this.translations = new HashMap<>();
    }
    
    
    
    public void add(String word, String translation) {
        this.translations.putIfAbsent(word, translation);
        this.translations.putIfAbsent(translation, word);
    }
    
    public String translate(String word) {
        return this.translations.get(word);
    }
    
    public void delete(String word) {
        if (this.translations.containsKey(word)) {
            String pairing = this.translations.get(word);
            this.translations.remove(pairing);
            this.translations.remove(word);
        }
    }
    
    public boolean load() {
        try (Scanner reader = new Scanner(Paths.get(source))) {            
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);                
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public boolean save() {
    try (FileWriter fw = new FileWriter(this.source)) {
        Set<String> saved = new HashSet<>();
        for (String word : this.translations.keySet()) {
            if (!saved.contains(word)) {
                String translation = this.translations.get(word);
                fw.write(word + ":" + translation + System.lineSeparator());
                saved.add(word);
                saved.add(translation);
            }
        }
        return true;
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    return false;
}

}
