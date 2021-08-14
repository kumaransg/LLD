package fs;

public class FSDriver {

    public static void main(String[] args) {

        FileSystem obj = new FileSystem();

        obj.mkdir("/a/b/c");
        obj.addContentToFile("/a/readme.txt", "hello A");
        obj.addContentToFile("/a/b/readu.txt", "heyo B");
        obj.addContentToFile("/readroot.txt", "heyo root");
        obj.addContentToFile("/a/b/d/readu.txt", "heyo new");


        System.out.println(obj.readContentFromFile("/a/readme.txt"));
        System.out.println(obj.readContentFromFile("/a/b/readu.txt"));
        System.out.println(obj.readContentFromFile("/readroot.txt"));
        System.out.println(obj.readContentFromFile("/a/b/d/readu.txt"));

        System.out.println(obj.ls("/"));
        System.out.println(obj.ls("/a"));
        System.out.println(obj.ls("/a/b/c"));
        System.out.println(obj.ls("/a/b"));
    }
}