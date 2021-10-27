package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChessMoves {

    public static void main(String[] args) throws FileNotFoundException, OutOfBoardException, IllegalChessMoveException {
        DefaultPiece df= new DefaultPiece();
        ChessBoard n = new ChessBoard(df, 8);
        Scanner scan = new Scanner(new File("input2.txt"));
        String line1;
        String[] lineSegment;
        while (scan.hasNextLine()) {
            line1 = scan.nextLine();
            lineSegment = line1.split(" "); // stores all input in array of Strings
            try {
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
                } else if (lineSegment[0].equals("move")) {
                    Move(n,lineSegment[0], lineSegment[1], lineSegment[2], lineSegment[3], lineSegment[4]);
                }
            } catch (OutOfBoardException e ) {
                // throw new OutOfBoardException("Out of Board");
            }
            catch (IllegalChessMoveException ex ) {
                //throw new IllegalChessMoveException("IllegalChessMoveException");
            } catch (PathwayException e) {
            }
        }
    }




    public static void Move(ChessBoard n, String lineSegment,String linesegment1,String linesegment2,String linesegment3,String linesegment4) throws IllegalChessMoveException, OutOfBoardException, PathwayException {
        //TESTING FOR ILLEGAL MOVE EXCEPTION HERE IN THE MOVE CLASS AS WELL AS MAKES THE PIECE MOVE
        if (lineSegment.equals("move")) {
            int val1 = Integer.parseInt(linesegment1);
            int val2 = Integer.parseInt(linesegment2);
            ChessPiece piece = n.getPiece(val1, val2);
            if (piece.getPieceName().equals("pawn")) {
                boolean pr=piece.move(n,val1, val2, Integer.parseInt(linesegment3), Integer.parseInt(linesegment4));
                if (pr) {
                    System.out.println("PAWN: (" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("Moved!(" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("=======================================");
                    Pawn movePawn = new Pawn(true);
                    n.setPiece(movePawn, Integer.parseInt(linesegment3), Integer.parseInt(linesegment4));
                    n.removePiece(val1, val2);
                    System.out.println(n);
                } else {//ILLEGAL MOVE EXCEPTION
                    System.out.println("PAWN: (" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("Invalid Move.(" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ") Pawn Illegally Moved. ");
                    System.out.println("=======================================");
                    System.out.println(n);
                    throw new IllegalChessMoveException();
                }
            }
            if (piece.getPieceName().equals("rook")) {//ILLEGAL MOVE EXCEPTION
                Rook moveRook = new Rook(val1, val2);
                if (piece.move(n,val1, val2, Integer.parseInt(linesegment3), Integer.parseInt(linesegment4))) {
                    System.out.println("Rook: (" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("Moved!(" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("=======================================");
                    n.setPiece(moveRook, Integer.parseInt(linesegment3), Integer.parseInt(linesegment4));
                    n.removePiece(val1, val2);
                    System.out.println(n);
                } else {
                    System.out.println("ROOK: (" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("Invalid Move.(" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ") Rook Illegally Moved ");
                    System.out.println("=======================================");
                    System.out.println(n);
                    throw new IllegalChessMoveException();
                }
            }
            if (piece.getPieceName().equals("knight")) {//ILLEGAL MOVE EXCEPTION
                Knight moveKnight = new Knight(val1, val2);
                if (piece.move(n,val1, val2, Integer.parseInt(linesegment3), Integer.parseInt(linesegment4))) {
                    System.out.println("KNIGHT: (" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("Moved!(" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("=======================================");
                    n.setPiece(moveKnight, Integer.parseInt(linesegment3), Integer.parseInt(linesegment4));
                    n.removePiece(val1, val2);
                    System.out.println(n);
                } else {
                    System.out.println("KNIGHT: (" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("Invalid Move.(" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ") Knight Illegally Moved");
                    System.out.println("=======================================");
                    System.out.println(n);
                    throw new IllegalChessMoveException();
                }
            }
            if (piece.getPieceName().equals("bishop")) {//ILLEGAL MOVE EXCEPTION
                Bishop moveBishop = new Bishop(val1, val2);
                if (piece.move(n,val1, val2, Integer.parseInt(linesegment3), Integer.parseInt(linesegment4))) {
                    System.out.println("BISHOP: (" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("Moved!(" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("=======================================");
                    n.setPiece(moveBishop, Integer.parseInt(linesegment3), Integer.parseInt(linesegment4));
                    n.removePiece(val1, val2);
                    System.out.println(n);
                } else {
                    System.out.println("BISHOP: (" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("Invalid Move.(" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ") Bishop Illegally Moved. ");
                    System.out.println("=======================================");
                    System.out.println(n);
                    throw new IllegalChessMoveException();

                }
            }
            if (piece.getPieceName().equals("king")) {
                King moveKing = new King(val1, val2);
                if (piece.move(n,val1, val2, Integer.parseInt(linesegment3), Integer.parseInt(linesegment4))) {
                    System.out.println("KING: (" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("Moved!(" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("=======================================");
                    n.setPiece(moveKing, Integer.parseInt(linesegment3), Integer.parseInt(linesegment4));
                    n.removePiece(val1, val2);
                    System.out.println(n);
                } else {//ILLEGAL MOVE EXCEPTION
                    System.out.println("KING: (" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ")");
                    System.out.println("Invalid Move.(" + val1 + "," + val2 + ") (" + Integer.parseInt(linesegment3) + "," + Integer.parseInt(linesegment4) + ") King Illegally Moved. ");
                    System.out.println("=======================================");
                    System.out.println(n);
                    throw new IllegalChessMoveException();
                }
            }

                }
            }
        }

