package io;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream("google.jpg");
            os = new FileOutputStream("copy.jpg");

            int data = is.read();
            while((data=is.read()) != -1) {
                os.write(data);
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found: " + e);
        } catch (IOException e) {
            System.out.println("error: " + e);
        } finally {
            try {
                if(is != null) {
                    is.close();
                }

                if(os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
