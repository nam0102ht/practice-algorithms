package com.ntnn.recursion;

import java.io.File;
import java.io.FileNotFoundException;

public class DiskUsage {
    public static long getUsage(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        File child;
        long total = file.length();
        if(!file.isDirectory()) {
            throw new FileNotFoundException("File not found");
        }
        for(String childName : file.list()) {
            file = new File(childName);
            total += file.length();
        }
        return total;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String name = "D:\\English Town";
        System.out.println(getUsage(name));
    }
}
