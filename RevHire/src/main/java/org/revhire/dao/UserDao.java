package org.revhire.dao;
import org.revhire.util.ConnectionUtil;

import java.sql.Connection;

public class UserDao {
    Connection c;
    UserDao(){
        c= ConnectionUtil.getConnection();
    }

    public boolean registerUser(
            //UserRegistration userRegistration
            ){
        return false;
    }
}
