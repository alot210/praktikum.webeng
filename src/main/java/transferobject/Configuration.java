package transferobject;

import java.sql.Connection;

public class Configuration {

    static Connection con;

    public static Connection  setSQLConnection(Connection _con){
        con = _con;
        return con;
    }

    public static Connection getSQLConnection(){
        return con;
    }
}
