package com.mayank.fooddelivery.datastore;

import com.mayank.fooddelivery.model.User;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class UserData {
    private Map<String, User> userById = new HashMap<>();
}
