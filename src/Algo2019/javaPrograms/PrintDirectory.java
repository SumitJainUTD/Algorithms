package Algo2019.javaPrograms;

import java.io.File;

public class PrintDirectory {

    public static void print(String filePath){
        File file = new File(filePath);
        printUtil(file, "");
    }

    public static void printUtil(File file, String tabs){
        if(file.isDirectory()){
            //print directory name
            System.out.println(tabs + "["+file.getName()+"]");

            File [] subFiles = file.listFiles();
            for (int i = 0; i <subFiles.length ; i++) {
                if(subFiles[i].isDirectory()) {
                    //recursive call to directory with extra \t
                    printUtil(subFiles[i], tabs + "\t");
                }else{
                    //print files in sub directory with extra \t
                    System.out.println(tabs + "\t" + subFiles[i].getName());
                }
            }
        }else{
            //print file inside main directory
            System.out.println(file.getName());
        }
    }

    public static void main(String[] args) {
        String path = "/Users/SumitJain/Tutorial Horizon/Hellojava";
        print(path);
    }
}