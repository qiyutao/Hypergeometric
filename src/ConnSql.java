import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ConnSql {
	Vector<Hyper> m_vt = null;
	Connection con = null;
	Statement stmt = null;
	
	public ConnSql() {
		m_vt = new Vector<Hyper>();
	}
	
	public void connect() {
		String url = "jdbc:sqlserver://localhost:1433;" +
				"databaseName=HypergeometricTest;";
		String userName = "sa";  
        String password = "123456";
        
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		try {
			con = DriverManager.getConnection(url, userName, password);
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void inData() {
		ResultSet rs = null;
		String name = null;
		double[] part = new double[5];
		Hyper tmp = null;
		
		try {
			String sql = "select * from hypertest";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				part[0] = rs.getDouble(1);
				name = rs.getString(2);
				part[1] = rs.getDouble(3);
				part[2] = rs.getDouble(4);
				part[4] = rs.getDouble(5);
				part[3] = rs.getDouble(6);
				tmp = new Hyper((int)part[0], name, (int)part[1], (int)part[2], (int)part[3],(int)part[4]);
				m_vt.add(tmp);
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void outData() {
		Hyper hy = null;
		String sql;
		String sql1 = "update hypertest set java = ";
		String sql2 = " where DB_ID = ";
		
		for (int i = 0; i < m_vt.size(); i++)
		{
			hy = m_vt.get(i);
			hy.calculate();
			sql = sql1 + hy.getValue() + sql2 + hy.getID();
			try {
				stmt.execute(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//hy.dis_cur();
		}
		
	}
}
