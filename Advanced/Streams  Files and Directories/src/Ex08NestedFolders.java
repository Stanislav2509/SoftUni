import java.io.File;

public class Ex08NestedFolders {
    public static void main(String[] args) {
        String address="resources\\Files-and-Streams";

        File root=new File(address);

        if(root.isDirectory()){
            File[]files= root.listFiles();
            for (File f : files) {
                System.out.println(f.getName());
            }
        }
//        ArrayDeque<File> queue=new ArrayDeque<>();
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            File file=queue.poll();
//            System.out.println(file.getName());
//            File [] files=file.listFiles();
//            if(files!=null){
//                for (File f : files) {
//                    queue.offer(f);
//                }
//            }
//        }
    }
}
