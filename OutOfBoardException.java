package com.company;

public class OutOfBoardException extends Exception{
    public OutOfBoardException() {
        System.out.println();
    }
    public OutOfBoardException(String error) {
        System.out.println(error);
    }
}
