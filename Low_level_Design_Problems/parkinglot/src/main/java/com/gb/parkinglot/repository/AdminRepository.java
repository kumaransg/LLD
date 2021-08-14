package com.gb.parkinglot.repository;

import com.gb.parkinglot.model.account.Admin;

import java.util.*;

public class AdminRepository {
    public static Map<String, Admin> adminMap = new HashMap<>();
    public static List<Admin> admins = new ArrayList<>();

    public Admin addAdmin(Admin admin) {
        adminMap.putIfAbsent(admin.getId(), admin);
        admins.add(admin);
        return admin;
    }

    public Admin getAdminByEmail(String email) {
        Optional<Admin> admin =
                admins.stream().filter(adm -> adm.getEmail().equalsIgnoreCase(email)).findFirst();

        return admin.isPresent() ? admin.get() : null;
    }

    public Admin getAdminById(String id) {
        return adminMap.get(id);
    }
}
