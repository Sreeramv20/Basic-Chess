package com.company;

public class Queen extends ChessPiece{
    public Queen(int a, int b) {
        setPositioni(b);
        setPositionj(a);
    }
    public boolean move(ChessBoard n, int a, int b, int c, int d) throws OutOfBoardException, PathwayException {
        int v1=a;
        int v2=b;
        int v3=c;
        int v4=d;
        if(c>=8||d>=8){
            tof=false;
            System.out.println("Queen: (" + a + "," + b + ") (" + c + "," + d + ")");
            System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Out of Board. ");
            System.out.println("=======================================");
            System.out.println(n);
            throw new OutOfBoardException();
        }
        else if(a == c || b == d){
            boolean isEmpty = true;
            //CHECKS FOR PIECE IN WAY
            if (a == c) {
                if (b < d) {
                    b++;
                    for (; b <= d; b++) {
                        if (!n.getPiece(a, b).getSymbol().equals("--- ")) {
                            isEmpty = false;
                            break;
                        }
                    }
                } else if (b > d) {
                    b--;
                    for (; b >= d; b--) {
                        if (!n.getPiece(a, b).getSymbol().equals("--- ")) {
                            isEmpty = false;
                            break;
                        }
                    }
                }
            } else if (b == d) {
                if (a < c) {
                    a++;
                    for (; a <= c; a++) {
                        if (!n.getPiece(a, d).getSymbol().equals("--- ")) {
                            isEmpty = false;
                            break;
                        }
                    }
                } else if (a > c) {
                    a--;
                    for (; a >= c; a--) {
                        if (!n.getPiece(a, d).getSymbol().equals("--- ")) {
                            isEmpty = false;
                            break;
                        }
                    }
                }
            }
            if (isEmpty) {
                tof = true;
            } else {
                //CALLS EXCEPTION
                tof = false;
                System.out.println("QUEEN: (" + v1 + "," + v2 + ") (" + v3 + "," + v4 + ")");
                System.out.println("Invalid Move. Another Piece is in the way. (" + v1 + "," + v2 + ") (" + v3 + "," + v4 + ")");
                System.out.println("=======================================");
                System.out.println(n);
                throw new PathwayException();
            }
        }
        else if(c == a + 1 | c == a - 1 && d == b + 1 || d == b - 1){
            if(!n.getPiece(c,d).getSymbol().equals("--- ")){
                System.out.println("Queen: (" + a + "," + b + ") (" + c + "," + d + ")");
                System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Another Piece is in the way.");
                System.out.println("=======================================");
                System.out.println(n);
                throw new PathwayException();
            }
        }
        else if(Math.abs(a-c)==Math.abs(b-d)){
            tof=true;
            if(a>c&&b>d){
                for (int i=1;i<=Math.abs(a-c);++i){
                    if(!n.getPiece(a-i,b-i).getSymbol().equals("--- ")){
                        System.out.println("QUEEN: (" + a + "," + b + ") (" + c + "," + d + ")");
                        System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Another Piece is in the way.");
                        System.out.println("=======================================");
                        System.out.println(n);
                        throw new PathwayException();
                    }
                }
            }
            else if (a>c&&b<d){
                for(int i=1;i<=Math.abs(a-c);++i){
                    if(!n.getPiece(a-i,b+i).getSymbol().equals("--- ")){
                        System.out.println("QUEEN: (" + a + "," + b + ") (" + c + "," + d + ")");
                        System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Another Piece is in the way.");
                        System.out.println("=======================================");
                        System.out.println(n);
                        throw new PathwayException();
                    }
                }
            }
            else if(a<c&&b<d){
                for(int i=1; i<=Math.abs(a-c); ++i){
                    if(!n.getPiece(a+i,b+i).getSymbol().equals("--- ")){
                        System.out.println("QUEEN: (" + a + "," + b + ") (" + c + "," + d + ")");
                        System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Another Piece is in the way.");
                        System.out.println("=======================================");
                        System.out.println(n);
                        throw new PathwayException();
                    }
                }
            }
            else if(a<c&&b>d){
                for(int i=1;i<=Math.abs(a-c);++i){
                    if(!n.getPiece(a+i,b-i).getSymbol().equals("--- ")){
                        System.out.println("QUEEN: (" + a + "," + b + ") (" + c + "," + d + ")");
                        System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Another Piece is in the way.");
                        System.out.println("=======================================");
                        System.out.println(n);
                        throw new PathwayException();
                    }
                }
            }
        }
        else {
            tof=false;
        }
        return tof;
    }
    public String getPieceName() {
        return "queen";
    }
    public String getSymbol() {
        return "-Q- ";
    }
}