import java.io.File;

class PhotoFile{
    private String filepath;
    private String filename;
    private long filelength;

    public PhotoFile(String filepath, String filename, long filelength){
        this.filepath = filepath;
        this.filename = filename;
        this.filelength = filelength;
    }

    public void display(){
        System.out.println(filepath + "; " + filename + "; " + filelength);
    }
}

class ArrayFiles{
    private PhotoFile[] a;
    private int length = 0;

    public ArrayFiles(){
        a = new PhotoFile[100_000_000];
    }

    public void add(String filepath, String filename, long filelength){

        a[length] = new PhotoFile(filepath, filename, filelength);
        length++;
    }

    public int length(){
        return length;
    }

    public void print(){
        for (int i = 0; i < length; i++){
            a[i].display();
        }
    }
}

public class duplicatefiles {

    public static ArrayFiles array_files = new ArrayFiles();
    public static long count_dir = 0;

    static void p(String s){
        System.out.println(s);
    }

    static void printDir(String dir){
        count_dir++;
        p("" + count_dir);

        // Определяем объект для каталога
        File dirSource = new File(dir);

        // Получаем список файлов и каталогов
        String[] files = dirSource.list();

        // Перебираем список файлов и каталогов
        for (String s : files) {

            File fileCurrent = new File(dir + s);

            if(fileCurrent.isDirectory()) {
//                p(dir + s + "\\");
                printDir(dir + s + "\\");
            } else {
                long len = fileCurrent.length();
                //p(dir + ";" + s + ";" + len);
                array_files.add(dir, s, len);
            }
        }
    }

    public static void main(String[] args) {
        String mainDir = "D:";
        p("Строим дерево вложенных папок и файлов с их размерами v.0.1 20200119");
        p("Начальная папка:");
        p(mainDir);
        p("Вложения:");
        printDir(mainDir);
        p("");
        array_files.print();
    }

}

