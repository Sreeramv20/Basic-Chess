package com.company;

public class IllegalChessMoveException extends Exception{
    public IllegalChessMoveException() {
        System.out.println();
    }
    public IllegalChessMoveException(String error) {
        System.out.println(error);
    }
}
