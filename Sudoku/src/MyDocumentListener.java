import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;
import java.awt.*;

public class MyDocumentListener implements DocumentListener {

    private boolean internalChange = false;

    @Override
    public void insertUpdate(DocumentEvent e) {
        handleChange(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        handleChange(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // not used for JTextField
    }

    private void handleChange(DocumentEvent e) {
        if (!Sudoku.isStarted || internalChange) return;

        try {
            JTextField field = (JTextField) e.getDocument().getProperty("owner");
            if (field == null) return;

            Integer r = (Integer) field.getClientProperty("row");
            Integer c = (Integer) field.getClientProperty("col");
            if (r == null || c == null) return;

            String text = field.getText();
            System.out.println(text);

            if (text.isEmpty()) {
                Sudoku.board[r][c] = 0;
                return;
            }

            if (!text.matches("[1-9]")) {
                showErrorAndClear(field);
                return;
            }

            int val = Integer.parseInt(text);

            // 🔥 TEMPORARILY place value
            int old = Sudoku.board[r][c];
            Sudoku.board[r][c] = val;

            // 🔥 NOW validate
            if (!Sudoku.isValid(Sudoku.board, new Point(r, c), val)) {
                Sudoku.board[r][c] = old;   // revert
                showErrorAndClear(field);
                return;
            }

            // ✅ VALID ENTRY
            Sudoku.board[r][c] = val;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showErrorAndClear(JTextField field) {
        internalChange = true;

        JOptionPane.showMessageDialog(
            null,
            "Invalid move",
            "Error",
            JOptionPane.ERROR_MESSAGE
        );

        // 🔥 Defer text clearing to avoid re-entrant DocumentEvent
        SwingUtilities.invokeLater(() -> {
            field.setText("");
            internalChange = false;
        });
    }
}
