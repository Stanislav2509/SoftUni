import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Ex12CreateZipArchive {
    public static void main(String[] args) throws IOException {
        ZipOutputStream output=new ZipOutputStream(new FileOutputStream("files.zip"));
        ZipEntry e=new ZipEntry("merges.txt");
        output.putNextEntry(e);

        FileReader fr=new FileReader("merges.txt");
        int bytes= fr.read();
        while (bytes>=0){
            output.write((char)bytes);
            bytes= fr.read();
        }

        output.closeEntry();
        output.close();

    }
}
