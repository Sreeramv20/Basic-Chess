package com.company;

import java.util.Locale;

public class ChessBoard {
    private int size;
    private ChessPiece[][] board = new ChessPiece[0][0];

    public ChessBoard(ChessPiece e,int size) {
        board = new ChessPiece[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = (e);
            }
        }
    }
    public String toString() {
        String x = "";
        for (int i = 7; i >= 0; i--) {
            x+="="+i+"= ";
            for (int j = 0; j < board[i].length; j++) {
                x = x + (board[j][i].getSymbol());
            }
            x += "\n";
        }
        x+="=== ";
        for(int m=0;m<board.length;m++){
            x+="="+m+"= ";
        }
        return x;
    }
    public void  setPiece(ChessPiece s, int i, int j) throws OutOfBoardException {
        board[i][j] = s;
        }
    public void removePiece(int i1,int i2){
        DefaultPiece df= new DefaultPiece();
        board[i1][i2]=df;
    }
    public ChessPiece getPiece(int i, int j){
        return board[i][j];
    }
}
