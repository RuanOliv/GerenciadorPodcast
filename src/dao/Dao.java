package dao;

import util.ConnectionFactory;
import java.sql.Connection;

public class Dao {
    
    protected Connection con;
    
    public Dao(){
        this.con = ConnectionFactory.getConexao();
    }
    
}