package JavaApplication2;
import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.Preferences;

public class JavaApplication2 {
    
    //PART OF PROGRAM FOR SAVING vvvvvv
    
    //creates preference variable
    public static Preferences prefs;
    
    //method to set game list preference
    public static void setPreferences(String[] sGames, String usrnme){
        //creates instance of preference variable
        prefs = Preferences.userRoot().node(setPreferences().class.getName()); 
        
        //single string variable to store all saved games on, uses commas to seperate the titles
        String savedGames = "";
        //loop index variable
        int i = 0;
        
        //takes each value from the array containing the game variables and appends it to the end of the savedGames string
        while(sGames.length != i)
        {
            savedGames += (sGames[i] + ","); 
            i++;
        }
        
        prefs.put(usrnme, savedGames);
    }
    
    //method to retrieve game list preference as array
    public static String[] retrievePreferences(String usrname){
        String svdGames = prefs.get(usrname, "GAME LIST");
        
        String[] retrGameList = svdGames.split(",");
        
        return retrGameList;
    }
    
    //PART OF PROGRAM FOR SAVING ^^^^^
    
    public static void main(String[] args) {
        
        String[] demoInput = {"A", "B", "C", "D"};
        
        setPreferences(demoInput, "Test");
        
        String[] retrInput = retrievePreferences("Test");
        
        for(int i = 0; i < retrInput.length; i++){
            System.out.println(retrInput[i]);
        }
        
        
    }
    
}
