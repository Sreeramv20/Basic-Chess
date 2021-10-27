package com.company;

public class King extends ChessPiece {
    public King(int a, int b) {
        setPositioni(b);
        setPositionj(a);
    }

    public boolean move(ChessBoard n, int a, int b, int c, int d) throws OutOfBoardException, PathwayException {
        //CHECKS IF ANOTHER PIECE IS AT THE DESTINATION
        if(!n.getPiece(c,d).getSymbol().equals("--- ")){
            System.out.println("KING: (" + a + "," + b + ") (" + c + "," + d + ")");
            System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Another Piece is in the way.");
            System.out.println("=======================================");
            System.out.println(n);
            throw new PathwayException();
        }
        //CHECKS TO SEE IF IT IS OUT OF BOARD
        if (c >= 8 || d >= 8) {
            tof = false;
            System.out.println("King: (" + a + "," + b + ") (" + c + "," + d + ")");
            System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Out of Board. ");
            System.out.println("=======================================");
            System.out.println(n);
            throw new OutOfBoardException();
        } else if (c == a + 1 || c == a - 1 && d == b + 1 || d == b - 1) {
            tof = true;
        } else {
            tof = false;
        }
        return tof;
    }
    public String getPieceName() {
        return "king";
    }
    public String getSymbol() {
        return "-K- ";
    }
}
