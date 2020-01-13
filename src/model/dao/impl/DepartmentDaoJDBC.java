package model.dao.impl;

import db.DbExcepetion;
import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
               PreparedStatement st = null;
        try{
            st = conn.prepareStatement("INSERT INTO department "
            +"(Name, Id) "
            +"VALUES"
            + "(? , ?)", Statement.RETURN_GENERATED_KEYS);
            
            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());
            
            int rowsAffected = st.executeUpdate();
            
            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }
            else{
                throw new DbExcepetion("Unexpecd error!No rows affected");
            }
        }
        catch(SQLException e){
            throw new DbExcepetion(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department obj) {
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }
   
}
