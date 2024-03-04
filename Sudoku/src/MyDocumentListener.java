import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;

import java.awt.*;

import java.awt.event.*;

public class MyDocumentListener implements DocumentListener{
    public void insertUpdate(DocumentEvent e) {
        
        try{

            if(Sudoku.isStarted == true){
                String insertedText = e.getDocument().getText(e.getOffset(), e.getLength());
                System.out.println("Text inserted: " + insertedText);
                    // JTextField textField = (JTextField) e.getDocument().getProperty("parent");
                Point p = Sudoku.getXY();
                int val = Integer.parseInt(insertedText);
                if(Sudoku.isValid(Sudoku.board, p, val)){
                    
                }
                else{
                    JOptionPane .showMessageDialog(null, "Ja bete Pehle Sudoku Sikh kar aa", "Error", JOptionPane.ERROR_MESSAGE);
                    Sudoku.clear(p);
                }
                System.out.println("The Coordinates of the textfield are : " + p.x + " " + p.y);
            }
            
        } 
        catch (BadLocationException ex) {
        
            ex.printStackTrace(); // or any other handling mechanism
        }
        
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
            // Perform actions when text is removed
            
            Sudoku.Recreate();

            // Call your functions here
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // Not used for plain text components
        try{
            String insertedText = e.getDocument().getText(e.getOffset(), e.getLength());
            System.out.println("Text updated: " + insertedText);
                // JTextField textField = (JTextField) e.getDocument().getProperty("parent");
            Point p = Sudoku.getXY();
            int val = Integer.parseInt(insertedText);
            if(Sudoku.isValid(Sudoku.board, p, val)){
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Ja bete Pehle Sudoku Sikh kar aa", "Error", JOptionPane.ERROR_MESSAGE);
                
                Sudoku.clear(p);
            }
            System.out.println("The Coordinates of the textfield are : " + p.x + " " + p.y);
        } 
        catch (BadLocationException ex) {
        
            ex.printStackTrace(); // or any other handling mechanism
        }
    }



    

}
