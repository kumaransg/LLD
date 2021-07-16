package com.system.design.systemdesign.directorystructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class File extends Entity {
    private String content;
    public File( String name , String content){
        super(name);
        this.content = content;
    }
    public File( String name , String content , Entity parent ){
        super(name,parent);
        this.content = content;
    }
    public void rename( String fileName){
        this.setName(fileName);
    }
    public void delete(){

    }
}
