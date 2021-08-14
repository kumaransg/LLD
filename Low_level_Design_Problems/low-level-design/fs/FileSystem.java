package fs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class FileSystem {

    FSNode root;

    public FileSystem() {
        root = new FSNode("/", false);
    }

    public List<String> ls(String path) {

        FSNode curr = navigateFS(path);

        List<String> resList = new ArrayList<>();
        if(curr.isFile){
            resList.add(curr.dirName);
        }
        else{
            curr.dirMap.forEach((dirName, fsNode) -> resList.add(dirName));
        }

        return resList;
    }

    public void mkdir(String path) {

        String[] splitPath = path.split("\\/");
        FSNode curr = root;
        int inx = 1;

        while(inx < splitPath.length){
            if(curr.dirMap.containsKey(splitPath[inx])){
                curr = curr.dirMap.get(splitPath[inx]);
            }
            else{
                FSNode newNode = new FSNode(splitPath[inx], false);
                curr.dirMap.put(splitPath[inx], newNode);
                curr = newNode;
            }
            inx++;
        }
    }

    public void addContentToFile(String filePath, String content) {

        String[] splitPath = filePath.split("\\/");
        FSNode curr = root;

        int inx = 1;

        while(inx < splitPath.length-1){
            if(curr.dirMap.containsKey(splitPath[inx])){
                curr = curr.dirMap.get(splitPath[inx]);
            }
            else{
                FSNode newNode = new FSNode(splitPath[inx], false);
                curr.dirMap.put(splitPath[inx], newNode);
                curr = newNode;
            }
            inx++;
        }

        FSNode fileNode = curr.dirMap.get(splitPath[inx]);
        if(fileNode == null)
            fileNode = new FSNode(splitPath[inx], true);

        fileNode.setContent(content);
        curr.dirMap.put(splitPath[inx], fileNode);
    }

    public String readContentFromFile(String filePath) {

        return navigateFS(filePath).getContent();
    }

    private FSNode navigateFS(String path){

        String[] splitPath = path.split("\\/");
        FSNode curr = root;

        int inx = 1;

        while(inx < splitPath.length){
            if(curr.dirMap.containsKey(splitPath[inx])){
                curr = curr.dirMap.get(splitPath[inx]);
            }
            else{
                break;
            }
            inx++;
        }

        return curr;
    }
}

class FSNode{

    String dirName;
    boolean isFile;
    StringBuilder content;

    Map<String, FSNode> dirMap;

    public FSNode(String dirName, boolean isFile){
        this.dirName = dirName;
        this.isFile = isFile;
        if(!isFile){
            dirMap = new TreeMap<>();
        }
        content = new StringBuilder();
    }

    public void setContent(String content){
        this.content.append(content);
    }

    public String getContent(){
        return content.toString();
    }
}