package com.book.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通用户权限检查
 */
public class UserPermissionUtil {
    private static List<String> permissions = new ArrayList<>();

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public UserPermissionUtil() {
        permissions.add("/user/login");
        permissions.add("/user/islogin");
        permissions.add("/user/register");
        permissions.add("/user/loginUser");
        permissions.add("/user/logout");
        permissions.add("/user/book");
        permissions.add("/user/UserName");
        permissions.add("/user/isregister");
        permissions.add("/books/newBook");
        permissions.add("/books/bookList");
        permissions.add("/books/borrow");
        permissions.add("/books/search");
        permissions.add("/books/newsearch");
        permissions.add("/books/bookadd");
        permissions.add("/books/bookedit");
        permissions.add("/books/bookinfo");
        permissions.add("/books/selectName");
        permissions.add("/records/records");
        permissions.add("/records/recordscurr");
        permissions.add("/records/recordsadd");
        permissions.add("/records/recordsList");
        permissions.add("/records/currList");
        permissions.add("/records/back");
        permissions.add("/records/add");
        permissions.add("/records/recordsconfirm");
        permissions.add("/records/confirm");
    }

    public boolean checkPermissions(String path){
        for (String permission : permissions) {
            if(path.equals(permission)){
                return true;
            }

        }
        return false;
    }
}
