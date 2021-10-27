package com.company;

public abstract class ChessPiece {
    public boolean tof=false;
    public String pieceName;

    public int positioni=0;
    public int positionj=0;
    public int movecount=0;

    public boolean move(ChessBoard n, int a, int b, int c, int d) throws OutOfBoardException, PathwayException {
        return tof;
    }

    public ChessPiece() {
    }

    public int getPositioni() {
        return positioni;
    }

    public int getPositionj() {
        return positionj;
    }

    public void setPositioni(int positioni) {
        this.positioni = positioni;
    }

    public void setPositionj(int positionj) {
        this.positionj = positionj;
    }
    public abstract String getPieceName();
    public abstract String getSymbol();
    public boolean isPathValid(ChessBoard n,int[][] x) throws PathwayException {
        boolean pe = false;
        for(int i=0;i<x.length;i++){
            ChessPiece p = n.getPiece(x[i][0],x[i][1]);
            if(!p.getPieceName().equals("empty")){
                pe=true;
                break;
            }
        }
        if(pe){
            throw new PathwayException("PathwayException");
        }
        return true;
    }
    public void setPieceName(String pieceName) {
        this.pieceName = pieceName;
    }
}
