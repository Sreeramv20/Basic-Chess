package com.company;

public class PathwayException extends Exception{
    public PathwayException() {

    }
    public PathwayException(String error) {
        System.out.println(error);
    }
}
