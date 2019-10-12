package com.lab1;

import java.io.*;

class Main {

    public static void main (String[] args) throws IOException {

        try {

            String key = args[0];

            if ("-i".equals(key)) {
                Interactive IntMode = new Interactive();
                IntMode.GetHash();
            } else {
                Simple SimMode = new Simple(args);
                SimMode.GetHash();
            }
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("\nEnter correct arguments.\n");
        }

    }
}