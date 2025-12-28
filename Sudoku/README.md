# 🧩 Sudoku Game (Java Swing)

A fully interactive **Sudoku game built using Java Swing**, featuring **dynamic puzzle generation**, **real-time validation**, and an **intelligent hint system** based on the current board state.

This project implements **actual Sudoku logic using backtracking**, not predefined boards.

---

## 🚀 Features

### ✅ Core Gameplay
- Dynamic Sudoku board generation (Easy / Medium / Hard)
- Interactive GUI using **Java Swing**
- Editable and non-editable cells clearly distinguished
- Real-time validation of moves (row / column / 3×3 box)

### 🧠 Intelligent Hint System
- User can request a hint for a **specific cell**
- Hint is computed by **solving the current board**
- Does **not** rely on predefined answers
- Hint UI automatically resets after **10 seconds**
- Hints are blocked if the board is invalid

### 🔍 Validation & Safety
- Invalid moves detected instantly
- Prevents duplicate numbers in:
  - rows
  - columns
  - 3×3 sub-grids
- Input restricted to digits **1–9**
- Board state always remains consistent

### 🧩 Solver & Generator
- Sudoku solver implemented using **backtracking**
- Generator creates a **new puzzle every game**
- No hardcoded boards
- Difficulty controls number of removed cells

---

## 🗂️ Project Structure
Sudoku/
└── Sudoku/
    ├── Sudoku.java
    ├── SudokuGenrator.java
    ├── MyDocumentListener.java
    └── README.md

---

## 🧠 How It Works

### 🔹 Board Generation
1. A complete valid Sudoku grid is generated using backtracking
2. Cells are removed based on selected difficulty
3. Resulting board is always solvable

### 🔹 Validation
- Each editable cell listens for user input
- Input is temporarily placed, validated, and reverted if invalid
- Ensures strict adherence to Sudoku rules

### 🔹 Hint Logic
- Uses the **current board state**
- Solves a copy of the board using backtracking
- Returns the correct value for the requested cell
- Hint UI resets automatically after 10 seconds

---

## 🎮 How to Run

### Prerequisites
- Java JDK 8 or later

### Steps
```bash
git clone https://github.com/KrishnaCoder30/Sudoku.git
cd Sudoku/Sudoku
javac *.java
java Sudoku


