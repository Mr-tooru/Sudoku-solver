package com.company;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;



public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sudoku Solver");
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField[][] cells = new JTextField[9][9];
        JPanel grid = new JPanel(new GridLayout(9, 9));
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                ((AbstractDocument) cell.getDocument()).setDocumentFilter(new NumberFilter());
                cells[r][c] = cell;
                grid.add(cell);
            }
        }

        JButton sButton = new JButton("Solve");
        sButton.addActionListener(e -> { int[][] board = new int[9][9];
            if (!extractNumbers(cells, board) || !solve(board)) {
                JOptionPane.showMessageDialog(frame, "Unsolvable!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                for (int r = 0; r < 9; r++) {
                    for (int c = 0; c < 9; c++) {
                        if (cells[r][c].getText().isEmpty()) { cells[r][c].setText(String.valueOf(board[r][c]));
                            cells[r][c].setForeground(Color.BLUE);
                        }   }   }   }   });
        frame.add(grid, BorderLayout.CENTER);
        frame.add(sButton, BorderLayout.EAST);
        frame.setVisible(true);
    }
    private static boolean extractNumbers(JTextField[][] cells, int[][] board) {
        try {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    String text = cells[r][c].getText();
                    board[r][c] = text.isEmpty() ? 0 : Integer.parseInt(text);
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean solve(int[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(board, r, c, num)) {
                            board[r][c] = num;
                            if (solve(board)) return true;
                            board[r][c] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int[][] board, int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num || board[i][c] == num || board[r / 3 * 3 + i / 3][c / 3 * 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }

    static class NumberFilter extends DocumentFilter {
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text.matches("[1-9]")) super.replace(fb, offset, length, text, attrs);
        }

        public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
            if (text.matches("[1-9]")) super.insertString(fb, offset, text, attr);
        }
    }
}