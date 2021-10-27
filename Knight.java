package com.company;

public class Knight extends ChessPiece{
    public Knight(int a, int b) {
        setPositioni(b);
        setPositionj(a);
    }
    public boolean move(ChessBoard n, int a, int b, int c, int d) throws OutOfBoardException, PathwayException {
       //CHECKS IF PIECE IS AT DESTINATION
        if(!n.getPiece(c,d).getSymbol().equals("--- ")){
            System.out.println("KNIGHT: (" + a + "," + b + ") (" + c + "," + d + ")");
            System.out.println("Invalid Move. (" + a + "," + b + ") (" + c + "," + d + ") Another Piece is in the way.");
            System.out.println("=======================================");
            System.out.println(n);
            throw new PathwayException();
        }
        //TESTS FOR OUT OF BOARD. ELSE IFS CHECK TO SEE IF MOVE IS VALID
        if(c>=8||d>=8){
            tof=false;
            System.out.println("KNIGHT: (" + a + "," + b + ") (" + c + "," + d + ")");
            System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Out of Board. ");
            System.out.println("=======================================");
            System.out.println(n);
            throw new OutOfBoardException();
        }
        else if(c==a-2&&d==b+1){
            tof=true;
        }
        else if(c==a-1&&d==b+2){
            tof=true;
        }
        else if(c==a+2&&d==b+1){
            tof=true;
        }
        else if(c==a+1&&d==b+2){
            tof=true;
        }
        else if(c==a-2&&d==b-1){
            tof=true;
        }
        else if(c==a-2&&d==b-2){
            tof=true;
        }
        else if(c==a+1&&d==b-2){
            tof=true;
        }
        else if(c==a+2&&d==b-1){
            tof=true;
        }
        else {
            tof = false;
        }
        return tof;
    }
    public String getPieceName() {
        return "knight";
    }
    public String getSymbol() {
        return "-h- ";
    }
}
