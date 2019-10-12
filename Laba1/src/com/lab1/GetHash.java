package com.lab1;

import java.io.IOException;
import java.io.FileInputStream;
import org.apache.commons.codec.digest.DigestUtils;

class GetHash {
    private String FilePath;

    GetHash(String filePath) {
        this.FilePath = filePath;
    }

    void Sha256() throws IOException{
        String result = DigestUtils.sha256Hex(new FileInputStream(FilePath));
        System.out.println("\nSha256 Hash: " + result + "\n");
    }

    void Md5() throws IOException{
        String result = DigestUtils.md5Hex(new FileInputStream(FilePath));
        System.out.println("\nMd5 Hash: " + result + "\n");
    }
}
