package com.system.design.systemdesign.directorystructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Directory extends Entity {
    private List<Directory> directoryList;
    private List<File> fileList;

    public Directory(String folderName) {
        super(folderName);
    }

    public Directory(String folderName, Directory directory) {
        super(folderName,directory);
        this.directoryList = new ArrayList<>();
    }

    public void createFile( String filename , String content ){
        File file = new File(filename , content, this);
        fileList.add(file);
    }
    public void createFolder( String folderName){
        Directory directory = new Directory(folderName,this);
        this.directoryList.add(directory);
    }
    public boolean deleteFile( String fileName){
        if( this.fileList.contains(fileName)){
            this.fileList.remove(fileName);
            return true;
        }
        return false;
    }
    public void deleteFolder( String folderName){
        if( this.directoryList.contains(folderName)){

        }
    }
}
