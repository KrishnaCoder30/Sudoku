// import javax.swing.*;
// import javax.swing.event.DocumentListener;

// import java.awt.*;
// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;
// import java.lang.*;

// public class Sudoku {

//     static boolean isStarted = false; // Flag to check if the game has started or not
//     static JFrame frame; // Create the main window of the application
//     final static JButton startButton = new JButton();
//     final static JButton giveUp = new JButton();
//     final static JButton submitButton = new JButton();
//     final static JTextField grid[][] = new JTextField[9][9];
//     final static JButton Hint = new JButton("Hint");
//     final static JButton Genrate = new JButton("Genrate");
//      public static int countHint = 0;
//      public static JLabel Ans;
//      public static JTextField x = new JTextField();
//      public static JTextField y = new JTextField();
//      public static JLabel Column = new JLabel("Column");
//      public static JLabel Row = new JLabel("Row");
//     static int difficulty = 0;
//     public static int board[][] = new int[9][9];
//     public static int ans[][] = new int[9][9];
//     public static void main(String[] args) {
//         intialise();
//     }

//     public static void intialise(){
//         frame = new JFrame("Sudoku");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setBackground(Color.GRAY);
//         frame.setSize(1200, 1000);
//         frame.getContentPane().setLayout(null);
        

//         int h = 65;
//         int w = 65;
//         int hi =  50;
//         int wi = 50;

//         // BorderFactory border = new BorderFactory();
//         for (int i = 0; i < 9; i++) {


//             for (int j = 0; j < 9; j++) {
//                 grid[i][j] = new JTextField();
//                 grid[i][j].setBounds((i+1+i/3) * h, (j+1+j/3) * w, hi, wi);
//                 grid[i][j].setOpaque(true);
//                 grid[i][j].setBackground(Color.WHITE);
//                 grid[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 1));
//                 grid[i][j].setEditable(true);
//                 grid[i][j].setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 22));
//                 frame.getContentPane().add(grid[i][j]);
//                 grid[i][j].setHorizontalAlignment(SwingConstants.CENTER);
//             }
//         }

//         JLabel difficultyLevel = new JLabel("Select difficulty Level:");
// 	    difficultyLevel.setFont(new Font("Calibri Light", Font.BOLD, 20));
// 	    difficultyLevel.setBounds(850, 200, 300, 24);
// 	    frame.getContentPane().add(difficultyLevel);

//         final JRadioButton easyButton = new JRadioButton("    Easy");
//         easyButton.setFont(new Font("Calibri Light", Font.BOLD, 20));
//         easyButton.setBounds(850,240,300,24);
//         // easyButton.setMargin(new Insets(0,20,0,0 ));

//         final JRadioButton mediumButton = new JRadioButton("    Medium");
//         mediumButton.setFont(new Font("Calibri Light", Font.BOLD, 20));
//         mediumButton.setBounds(850,280,300,24);

//         final JRadioButton hardButton = new JRadioButton("    Hard");
//         hardButton.setFont(new Font("Calibri Light", Font.BOLD, 20));
//         hardButton.setBounds(850,320,300,24);

        
//         ButtonGroup group = new ButtonGroup();
//         group.add(easyButton);
//         group.add(hardButton);
//         group.add(mediumButton);
        

//         frame.add(easyButton);
//         frame.add(mediumButton);
//         frame.add(hardButton);

//         Hint.setBounds(850, 500, 150, 40);
//         Hint.setText("Hint");
//         Hint.setFont(new Font("Calibri Light", Font.BOLD, 20));
//         Hint.setVisible(false);
//         frame.add(Hint);




//         submitButton.setText("Submit");
//         submitButton.setFont(new Font("Calibri Light", Font.BOLD, 20));
//         submitButton.setVisible(false);
//         submitButton.setBounds(850, 450, 300, 40);
//         frame.add(submitButton);
        

//         startButton.setText("Start Game");
//         startButton.setFont(new Font("Calibri Light", Font.BOLD, 20));
//         startButton.setBounds(850, 400, 300, 40);
//         startButton.setVerticalAlignment(JButton.CENTER);
//         startButton.setHorizontalAlignment(JButton.CENTER);
//         frame.add(startButton);

//         Genrate.setText("Generate");
//         Genrate.setFont(new Font("Calibri Light", Font.BOLD, 20));
//         Genrate.setBounds(850, 630, 300, 40);
//         Genrate.setVisible(false);
//         frame.add(Genrate);

//         startButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {

//                 if(isStarted ){
//                     isStarted = false;
//                     ans = SudokuGenrator.Ans(difficulty);
//                     for(int i = 0; i < 9; i++){
// 						for(int j = 0; j < 9; j++){
                            
                                
//                             grid[i][j].setBackground(Color.WHITE);
// 							grid[i][j].setEditable(false);
// 							grid[i][j].setText(Integer.toString(ans[i][j]));
// 						}
// 					}
                    
//                     startButton.setText("Start");
//                     submitButton.setVisible(false);
//                 }
//                 else{
//                     ans = new int[9][9];
//                     board = new int[9][9];
//                     difficulty=0;

//                     for(int i = 0; i < 9; i++){
//                         for(int j = 0; j < 9; j++){
                            
                                
//                             grid[i][j].setBackground(Color.WHITE);
//                             grid[i][j].setEditable(false);
//                             grid[i][j].setText("");
                           
//                         }
//                     }

//                     if(easyButton.isSelected()){
//                         difficulty = 1;
//                     }else if (mediumButton.isSelected()) {
//                         difficulty = 2;
//                     }else if (hardButton.isSelected()) {
//                         difficulty = 3;
//                     }
//                     SudokuGenrator sudoku = new SudokuGenrator();
//                     board = sudoku.Generate(difficulty);
//                     ans = sudoku.Ans(difficulty);
                    
//                     for (int i = 0; i < 9; i++) {
//                         for (int j = 0; j < 9; j++) {
//                             if(board[i][j] != 0){
                                
//                                 grid[i][j].setText(String.valueOf(board[i][j]));
//                                 grid[i][j].getCaret().setVisible(false);
//                                 grid[i][j].setEditable(false);
                                
//                             }
//                             else{
//                                 grid[i][j].setBackground(Color.YELLOW);
//                                 grid[i][j].getDocument().addDocumentListener(new MyDocumentListener());
//                                 grid[i][j].setEditable(true);
//                             }
                            
//                         }
//                     }

//                     // startButton.setEnabled(false);
//                     // startButton.setVisible(false);

//                     startButton.setText("Give Up!!!");
//                     submitButton.setVisible(true);
//                     Hint.setVisible(true);
//                     isStarted = true;
//                 }
                
//                 // giveUp.setText("Give Up!!");
//                 // giveUp.setFont(new Font("Calibri Light", Font.ITALIC, 20));
//                 // giveUp.setBounds(850, 400, 300, 40);
//                 // giveUp.setVisible(true);
//                 // frame.add(giveUp);


                
                


//             }
//         });

//         // giveUp.addActionListener(new ActionListener() {
//         //     @Override
//         //     public void actionPerformed(ActionEvent e) {

//         //         giveUp.setEnabled(false);
//         //         giveUp.setVisible(false);
//         //         submitButton.setVisible(false);
//         //         submitButton.setEnabled(false);
//         //         isStarted = false;
//         //         startButton.setEnabled(true);
//         //         startButton.setVisible(true);

//         //         ans = SudokuGenrator.Ans(difficulty);
//         //         System.out.println("Difficulty : " + difficulty);
//         //         // board = sudoku.Generate(difficulty);
//         //         for (int i = 0; i < 9; i++) {
//         //             for (int j = 0; j < 9; j++) {
//         //                 // board[i][j] = 0;
//         //                 // difficulty = 0;
//         //                 System.out.print(" " + ans[i][j]);
//         //                 grid[i][j].setEditable(false);
//         //                 grid[i][j].setText(Integer.toString(ans[i][j]));
                        
//         //             }
//         //             System.out.println();

//         //         }
                
                
//         //         // Sudoku.main(null);
//         //     }
            
//         // });

//         submitButton.addActionListener(new ActionListener() {
            
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 isStarted = false;
//                 ans = SudokuGenrator.Ans(difficulty);
//                 // startButton.setEnabled(true);
//                 // startButton.setVisible(true);
//                 submitButton.setVisible(false);
//                 startButton.setText("Start");
//                 // giveUp.setVisible(false);
//                 boolean chk = ChkWin();
//                 System.out.println("chk : " + chk);
//                 for(int i = 0; i < 9; i++){
//                     for(int j = 0; j < 9; j++){
                        
                            
//                         grid[i][j].setBackground(Color.WHITE);
//                         grid[i][j].setEditable(false);
//                         grid[i][j].setText("");
                       
//                     }
//                 }
//                 if (chk) {
//                     JOptionPane.showMessageDialog(null, "Hurray!!!! \n You Won", "Result", JOptionPane.INFORMATION_MESSAGE);
//                 }
//                 else{
//                     JOptionPane.showMessageDialog(null, "Some of the values are wrong or not filled Yet \n You Loose", "Result", JOptionPane.INFORMATION_MESSAGE);
//                 }
//                 // Sudoku.main(null);
//             }
//         });

//         Ans = new JLabel();
//         // Ans.setText("Answer : " + ans[i-1][j-1]);
//         Ans.setFont(new Font("Calibri Light", Font.ITALIC, 20));
//         Ans.setBounds(1000, 620, 150, 40);
//         Ans.setVisible(false);
//         frame.add(Ans);
//         Row.setFont(new Font("Calibri Light", Font.ITALIC, 20));
//         Row.setBounds(850, 550, 150, 40);
//         Row.setVisible(false);
                    
//         Column.setFont(new Font("Calibri Light", Font.ITALIC, 20));
//         Column.setBounds(850, 590, 150, 40);
//         Column.setVisible(false);

        
//         x.setBounds(1000, 550, 300, 40);
//         y.setBounds(1000, 590, 300, 40);
//         x.setVisible(false);
//         y.setVisible(false);

//         frame.add(Row);
//         frame.add(x);
//         frame.add(Column);
//         frame.add(y);

//         Hint.addActionListener(new ActionListener() {

//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 // countHint++;
//                 if(countHint < 3){
                    
//                     Column.setVisible(true);
//                     Row.setVisible(true);
//                     x.setVisible(true);
//                     y.setVisible(true);
//                    Genrate.setVisible(true);
                    
//                     frame.revalidate();

//                 }
                
                


//             }
//         });

//         Genrate.addActionListener(new ActionListener() {

//             @Override
            
//             public void actionPerformed(ActionEvent e) {
//                 if(countHint < 3){
//                     countHint++;
//                     String X  = x.getText();
//                     int i = Integer.parseInt(X);
//                     String Y  = y.getText();
//                     int j = Integer.parseInt(Y);
//                     Genrate.setText("Ans: "+ ans[i-1][j-1]);
//                     Genrate.setVisible(true);
//                     Ans.setVisible(true);
//                 }
//                 else{
//                     JOptionPane.showMessageDialog(null , "Behnchod Kitne Hints Laga IIT m AAgaya hai na" , "Galli Galloch" , JOptionPane.WARNING_MESSAGE);
//                 }
                
                
//                 // Sudoku.main(null);
//             }
//         });






//         frame.setVisible(true);

//     }

//     public static Point getXY() {
//         Point p = new Point(-1,-1);
//         // String text = textField.getText();
//         // int number = Integer.parseInt(text); 
//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
                
//                 String text = grid[i][j].getText();
//                 if(text.isEmpty() != true){
//                     try{
//                         int k = Integer.parseInt(text);
//                         if(k != board[i][j]){
//                             p.x = i;
//                             p.y = j;
//                             board[i][j] = k;
//                             return p;
//                         }
//                     }
//                     catch(NumberFormatException e){
                        
//                         JOptionPane.showMessageDialog(null, "Bsdk tuzhse Sudoku toh nahi Hone Wala Maa Chuda", "Error", JOptionPane.ERROR_MESSAGE);
                        
//                         break;
//                     }
                    
//                 }
                
//             }
//         }
//         return p;
//     }
//     public static void clear(Point p){
//         grid[p.x][p.y].setText("b");
//     }

//     public static boolean ChkWin(){
//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 try{
//                     if(ans[i][j] != Integer.parseInt(grid[i][j].getText())){
//                         return false;
//                     }
//                 }
//                 catch(NumberFormatException e){
//                     return false;
//                 }
                
//             }
//         }
//         return true;
//     }

//     public static void Recreate(){
//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 if(board[i][j] != 0 && grid[i][j].getText().isEmpty()){
//                     //grid[i][j].setText(Integer.toString(board[i][j]));
//                     board[i][j]=0;
//                 }
//             }
//         }
//     }

//     public static boolean isValid(int[][] board,Point p , int val){

//         if(val > 9 || val < 1){
//             return false;
//         }
//         for (int i = 0; i < 9; i++) {
//             if(board[p.x][i] == val && i!=p.y){
//                 // board[p.x][i] = 0;
//                 // System.out.println("Column  " + i);
//                 return false;
//             }
//         }

//         for (int i = 0; i < 9; i++) {
//             if(board[i][p.y] == val && i!=p.x){
//                 // board[i][p.y] = 0;
//                 // System.out.println("Row");
//                 return false;
//             }
//         }

//         //Check box

//         int x = p.x - p.x%3;
//         int y = p.y - p.y%3;
//         for (int i = 0; i < 3; i++) {
//             for (int j = 0; j < 3; j++) {
//                 if(board[x+i][y+j] == val && (x+i) != p.x && (y+j) != p.y){
//                     // board[x+i][y+j] = 0;
//                     // System.out.println("Box");
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

// }


import java.util.*;

public class SudokuGenrator {

    private static final int N = 9;
    private int[][] question = new int[N][N];
    private int[][] answer   = new int[N][N];
    private Random rand = new Random();

    // =======================
    // PUBLIC API (DO NOT CHANGE)
    // =======================

    // Called by GUI
    public int[][] Generate(int difficulty) {
        generateNewSudoku(difficulty);
        return copy(question);
    }

    // Called by GUI
    public int[][] Ans(int difficulty) {
        return copy(answer);
    }

    // =======================
    // INTERNAL LOGIC
    // =======================

    private void generateNewSudoku(int difficulty) {
        int[][] full = new int[N][N];

        // 1️⃣ Generate full valid solution
        fillDiagonal(full);
        fillRemaining(full);

        answer = copy(full);

        // 2️⃣ Remove cells to make puzzle
        question = copy(full);
        int removals = getRemovalCount(difficulty);
        removeCells(question, removals);
    }

    // =======================
    // SOLUTION GENERATION
    // =======================

    private void fillDiagonal(int[][] board) {
        for (int i = 0; i < N; i += 3)
            fillBox(board, i, i);
    }

    private void fillBox(int[][] board, int r, int c) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 9; i++) nums.add(i);
        Collections.shuffle(nums, rand);

        int idx = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[r + i][c + j] = nums.get(idx++);
    }

    private boolean fillRemaining(int[][] board) {
        int[] pos = findEmpty(board);
        if (pos == null) return true;

        int r = pos[0], c = pos[1];
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 9; i++) nums.add(i);
        Collections.shuffle(nums, rand);

        for (int num : nums) {
            if (isSafe(board, r, c, num)) {
                board[r][c] = num;
                if (fillRemaining(board)) return true;
                board[r][c] = 0;
            }
        }
        return false;
    }

    private int[] findEmpty(int[][] board) {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (board[i][j] == 0)
                    return new int[]{i, j};
        return null;
    }

    private boolean isSafe(int[][] board, int r, int c, int num) {
        for (int i = 0; i < 9; i++)
            if (board[r][i] == num || board[i][c] == num)
                return false;

        int br = r - r % 3;
        int bc = c - c % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[br + i][bc + j] == num)
                    return false;

        return true;
    }

    // =======================
    // PUZZLE CREATION
    // =======================

    private void removeCells(int[][] board, int count) {
        while (count > 0) {
            int r = rand.nextInt(9);
            int c = rand.nextInt(9);
            if (board[r][c] != 0) {
                board[r][c] = 0;
                count--;
            }
        }
    }

    private int getRemovalCount(int difficulty) {
        if (difficulty == 1) return 40; // Easy
        if (difficulty == 2) return 48; // Medium
        if (difficulty == 3) return 55; // Hard
        return 45;
    }

    // =======================
    // UTIL
    // =======================

    private int[][] copy(int[][] src) {
        int[][] dst = new int[N][N];
        for (int i = 0; i < N; i++)
            System.arraycopy(src[i], 0, dst[i], 0, N);
        return dst;
    }
}


