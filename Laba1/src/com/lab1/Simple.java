package com.lab1;

import java.io.IOException;
import java.util.Scanner;

class Simple {

    private String[] flags;

    Simple(String[] args){
        this.flags = args;
    }

    void GetHash() throws IOException {

        String FilePath = "";
        Scanner in = new Scanner(System.in);
        try {
            switch (flags[0]) {
                case "-sha256":
                    if (flags[1].equals("-f")) {
                        for (int i = 2; i < flags.length; i++ ) {
                            FilePath = flags[i];
                            int num = i-1;
                            System.out.println("\nFile" + num);
                            GetHash SimGetHash1 = new GetHash(FilePath);
                            SimGetHash1.Sha256();
                        }
                    }
                    if (flags[1].equals("")) {
                        System.out.println("\nEnter the path of your file: \n");
                        FilePath = in.nextLine();
                    }
                    break;

                case "-md5":
                    if (flags[1].equals("-f")) {
                        for (int i = 2; i < flags.length; i++ ) {
                            FilePath = flags[i];
                            int num = i-1;
                            System.out.println("\nFile" + num);
                            GetHash SimGetHash2 = new GetHash(FilePath);
                            SimGetHash2.Md5();
                        }
                    }
                    if (flags[1].equals("")) {
                        System.out.println("\nEnter the path of your file: \n");
                        FilePath = in.nextLine();
                    }

                    break;

                default:
                    System.out.print("\nChoose the algorithm: -sha256 or -md5 \n");
                    break;
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("\nEnter correct arguments.\n");
            ex.getMessage();
        }
    }
}
