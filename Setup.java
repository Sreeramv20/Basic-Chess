package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Setup {

    public static void main(String[] args) throws FileNotFoundException, OutOfBoardException {
        Scanner scan = new Scanner(new File("input1.txt"));
        String line;
        String[] lineSegment;
        DefaultPiece df = new DefaultPiece();
        ChessBoard n = new ChessBoard(df, 8);
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            lineSegment = line.split(" "); // stores all input in array of Strings
            if (lineSegment[0].equals("pawn")) {
                Pawn newPawn = new Pawn();
                n.setPiece(newPawn, Integer.parseInt(lineSegment[1]), Integer.parseInt(lineSegment[2]));
            } else if (lineSegment[0].equals("rook")) {
                Rook newRook = new Rook(Integer.parseInt(lineSegment[1]), Integer.parseInt(lineSegment[2]));
                n.setPiece(newRook, Integer.parseInt(lineSegment[1]), Integer.parseInt(lineSegment[2]));
            } else if (lineSegment[0].equals("knight")) {
                Knight newKnight = new Knight(Integer.parseInt(lineSegment[1]), Integer.parseInt(lineSegment[2]));
                n.setPiece(newKnight, Integer.parseInt(lineSegment[1]), Integer.parseInt(lineSegment[2]));
            } else if (lineSegment[0].equals("bishop")) {
                Bishop newBishop = new Bishop(Integer.parseInt(lineSegment[1]), Integer.parseInt(lineSegment[2]));
                n.setPiece(newBishop, Integer.parseInt(lineSegment[1]), Integer.parseInt(lineSegment[2]));
            }
        }
        System.out.println(n);
    }
}
