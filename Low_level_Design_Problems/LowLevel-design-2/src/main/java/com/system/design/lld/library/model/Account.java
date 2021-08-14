package com.system.design.lld.library.model;

import lombok.Builder;
import lombok.Data;

@Data
public abstract class Account {
    private String userId;
    private String userName;
    private String password;
    public abstract boolean resetPassword();
}
