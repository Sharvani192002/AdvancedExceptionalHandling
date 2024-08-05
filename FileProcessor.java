import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileProcessor {
    public void processfiles(List<String> filepaths){
        for(String filepath : filepaths){
            try (BufferedReader reader=new BufferedReader(new FileReader(filepath))){
                String line;
                while ((line= reader.readLine())!=null){
                    System.out.println(line);
                }
            }catch (IOException e){
                System.out.println("Error reading file: " + filepath);
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args){
        List<String> filepaths =List.of("file1.txt","file2.txt","file3.txt");
        FileProcessor processor =new FileProcessor();
        processor.processfiles(filepaths);
    }
}
