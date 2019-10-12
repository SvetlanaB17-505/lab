package com.lab1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


class Interactive {


    void GetHash() throws IOException {

        boolean end = false;
        String FilePath = "";
        Scanner in = new Scanner(System.in);

        do {
            try {
                System.out.println("Enter the path of your file: ");
                FilePath = in.nextLine();
                if (FilePath.toLowerCase().equals("stop")) {
                    end = true;
                    continue;
                }
                GetHash IntGetHash = new GetHash(FilePath);
                IntGetHash.Sha256();
                IntGetHash.Md5();

                System.out.println("Press 'Y' to get hashsum of another file or press any key to exit");
                String ans = in.nextLine();
                if (!ans.toLowerCase().equals("y")) {
                    end = true;
                }
            }catch (FileNotFoundException ex) {
                System.out.println("File doesn't exist");
            }
        } while (!end);
    }
}