package com.company;

public class DefaultPiece extends ChessPiece {
    @Override
    public String getPieceName() {
        return "empty";
    }

    @Override
    public String getSymbol() {
        return "--- ";
    }
}
