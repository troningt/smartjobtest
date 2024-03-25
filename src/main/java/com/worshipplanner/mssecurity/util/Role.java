package com.worshipplanner.mssecurity.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Role {
    CUSTOMER(List.of(Permission.READ_ALL_USERS)),
    ADMINISTRATOR(Arrays.asList(Permission.READ_ALL_USERS, Permission.SAVE_USER));

    private List<Permission> permissions;

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
