package com.company;
public class Pawn extends ChessPiece {
    boolean checkFirstMove;

    public Pawn(){

    }
    public Pawn(boolean firstMove) {
        checkFirstMove=firstMove;
    }
    public boolean move(ChessBoard n, int a, int b, int c, int d) throws OutOfBoardException, PathwayException {
        int [][]x = new int[8][8];
        //TESTS FOR OUT OF BOARD
        if(d>=8||c>=8) {
            tof = false;
            System.out.println("PAWN: (" + a + "," + b + ") (" + c + "," + d + ")");
            System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Out of Board. ");
            System.out.println("=======================================");
            System.out.println(n);
            throw new OutOfBoardException();
        }
        else if(!checkFirstMove && d==b+2||d==b+1||d==b-2||d==b-1) {
            //TESTS TO SEE IF MOVE IS VALID FOR FIRST MOVE AS WELL AS CHECKS FOR PIECE IN WAY OR AT DESTINATION
            tof = true;
            checkFirstMove = false;
            x[0] = new int[]{c, d - 1};
            x[1] = new int[]{c, d};
            if (d == b + 2) {
                if ((!n.getPiece(c, d).getSymbol().equals("--- ")) || (!n.getPiece(c, d - 1).getSymbol().equals("--- "))) {
                    System.out.println("PAWN: (" + a + "," + b + ") (" + c + "," + d + ")");
                    System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Another Piece is in the way.");
                    System.out.println("=======================================");
                    System.out.println(n);
                    throw new PathwayException();
                }
            }
                else if (d == b + 1||d==b-1){
                    if(!n.getPiece(c, d).getSymbol().equals("--- ")){
                        System.out.println("PAWN: (" + a + "," + b + ") (" + c + "," + d + ")");
                        System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Another Piece is in the way.");
                        System.out.println("=======================================");
                        System.out.println(n);
                        throw new PathwayException();
                    }
            }
                else if(d==b-2){
                if ((!n.getPiece(c, d).getSymbol().equals("--- ")) || (!n.getPiece(c, d + 1).getSymbol().equals("--- "))) {
                    System.out.println("PAWN: (" + a + "," + b + ") (" + c + "," + d + ")");
                    System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Another Piece is in the way.");
                    System.out.println("=======================================");
                    System.out.println(n);
                    throw new PathwayException();
                }
            }
            }
        else if(checkFirstMove && d==b+1||d==b-1){
            //CHECKS IF MOVE IS VALID WHEN IT IS NOT A FIRSTMOVE
            if(d==b+1&&(!n.getPiece(c,d).getSymbol().equals("--- "))){
                System.out.println("PAWN: (" + a + "," + b + ") (" + c + "," + d + ")");
                System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Another Piece is in the way.");
                System.out.println("=======================================");
                System.out.println(n);
                throw new PathwayException();
            }
            else if(d==b-1&&(!n.getPiece(c,d).getSymbol().equals("--- "))){
                System.out.println("PAWN: (" + a + "," + b + ") (" + c + "," + d + ")");
                System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Another Piece is in the way.");
                System.out.println("=======================================");
                System.out.println(n);
                throw new PathwayException();
            }
            tof=true;
            x[0]= new int[]{c, d};
        }
        else {
            tof=false;
        }

//        if(tof){
//
//            return isPathValid(n, x);
//        }
//        return false;
        return tof;
    }

    public String getPieceName() {
        return "pawn";
    }
    public String getSymbol() {
        return "-p- ";
    }

    @Override
    public boolean isPathValid(ChessBoard n, int[][] x){
        try {
            return super.isPathValid(n, x);
        }
        catch (PathwayException e){
            System.out.println("PathwayException");
        }
        return false;
    }
}
