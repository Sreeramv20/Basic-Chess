package com.company;

public class Bishop extends ChessPiece{
    public Bishop(int a, int b) {
        setPositioni(b);
        setPositionj(a);
    }
    public boolean move(ChessBoard n, int a, int b, int c, int d) throws OutOfBoardException, PathwayException {
        if(c>=8||d>=8){
            tof=false;
            System.out.println("BISHOP: (" + a + "," + b + ") (" + c + "," + d + ")");
            System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Out of Board. ");
            System.out.println("=======================================");
            System.out.println(n);
            throw new OutOfBoardException();
        }
        else if(Math.abs(a-c)==Math.abs(b-d)){
            tof=true;
            if(a>c&&b>d){
                for (int i=1;i<=Math.abs(a-c);++i){
                    if(!n.getPiece(a-i,b-i).getSymbol().equals("--- ")){
                        System.out.println("BISHOP: (" + a + "," + b + ") (" + c + "," + d + ")");
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
                        System.out.println("BISHOP: (" + a + "," + b + ") (" + c + "," + d + ")");
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
                        System.out.println("BISHOP: (" + a + "," + b + ") (" + c + "," + d + ")");
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
                        System.out.println("BISHOP: (" + a + "," + b + ") (" + c + "," + d + ")");
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
        return "bishop";
    }

    @Override
    public String getSymbol() {
        return "-b- ";
    }
}
