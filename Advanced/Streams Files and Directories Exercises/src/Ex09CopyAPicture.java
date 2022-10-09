import java.io.*;

public class Ex09CopyAPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("pictures.jpg");
        FileOutputStream fos=new FileOutputStream("copyPicture.jpg");

        byte [] buffer=new byte[1024];
        while (fis.read(buffer)>=0){
            fos.write(buffer);
        }
        fis.close();
        fos.close();
    }
}
