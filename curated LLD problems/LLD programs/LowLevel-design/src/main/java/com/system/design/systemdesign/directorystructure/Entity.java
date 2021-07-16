package com.system.design.systemdesign.directorystructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Entity {
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
    private LocalDateTime lastAccessed;
    private int size;
    private Entity parent;
    private boolean isParent;
    private String createdBy;
    private String updatedBy;

    public Entity(String name) {
        this.name = name;
    }

    public Entity(String name, Entity parent) {
        this.name = name;
        this.parent = parent;
    }
}
