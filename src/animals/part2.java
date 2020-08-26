package animals;

import java.io.*;

public class part2 {
    public static void main(String[] args) {
        InputStream in;
        OutputStream out;

        try {
            FileOutputStream fos = new FileOutputStream("part2.txt", true);
            byte[] arr = {'C', 'l', 'o', 's', 'e', ' ', 'y', 'o', 'u', 'r', ' ', 'e', 'y', 'e', 's', ',', ' ', 'p', 'a', 'y', ' ', 't', 'h', 'e',
                    ' ', 'p', 'r', 'i', 'c', 'e', ' ', 'f', 'o', 'r', ' ', 'y', 'o', 'u', 'r', ' ', 'p', 'a', 'r', 'a', 'd', 'a', 'i', 's', 'e', '\n'};

            fos.write(arr);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            FileOutputStream fos = new FileOutputStream("part2.txt", true);
            byte[] arr2 = {'D', 'e', 'v', 'i', 'l', 's', ' ', 'f', 'e', 'e', 'd', ' ', 'o', 'n', ' ', 't', 'h', 'e', ' ',
                    's', 'e', 'e', 'd', 's', ' ', 'o', 'f', ' ', 't', 'h', 'e', ' ', 's', 'o', 'u', 'l', '\n'};

            fos.write(arr2);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }



    }

}
