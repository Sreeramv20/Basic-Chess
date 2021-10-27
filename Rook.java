package com.company;

public class Rook extends ChessPiece {
    public Rook(int a, int b) {
        setPositioni(b);
        setPositionj(a);
    }

    public boolean move(ChessBoard n, int a, int b, int c, int d) throws OutOfBoardException, PathwayException {
        int v1=a;
        int v2=b;
        int v3=c;
        int v4=d;
        if (d >= 8 || c >= 8) {
            tof=false;
            System.out.println("Rook: (" + a + "," + b + ") (" + c + "," + d + ")");
            System.out.println("Invalid Move.(" + a + "," + b + ") (" + c + "," + d + ") Out of Board. ");
            System.out.println("=======================================");
            System.out.println(n);
            throw new OutOfBoardException();
        } else if (a == c || b == d) {
            //tof = true;
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
                System.out.println("ROOK: (" + v1 + "," + v2 + ") (" + v3 + "," + v4 + ")");
                System.out.println("Invalid Move. Another Piece is in the way. (" + v1 + "," + v2 + ") (" + v3 + "," + v4 + ")");
                System.out.println("=======================================");
                System.out.println(n);
                throw new PathwayException();
            }
        }
        return tof;
    }

            public String getPieceName () {
                return "rook";
            }
            public String getSymbol () {
                return "-r- ";
            }
        }

