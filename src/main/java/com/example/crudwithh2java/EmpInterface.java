package com.example.crudwithh2java;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmpInterface{
    public boolean insert(Emp emp) throws SQLException;
    public ArrayList<Emp> listall() throws SQLException;
    public boolean update(Emp emp)throws SQLException;
    public boolean delete(Emp emp) throws SQLException;
}
