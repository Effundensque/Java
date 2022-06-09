package eu.ase.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaneDAO {
	private static Connection connection;
	
	public static void setConnection(String dbFile)
	{
		try {
			Class.forName("org.sqlite.JDBC");
			connection=DriverManager.getConnection("jdbc:sqlite:"+dbFile);
			connection.setAutoCommit(false);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String selectData() throws SQLException{
		String sqlSelect="select * from PLANES";
		Statement statement=connection.createStatement();
		ResultSet rs = statement.executeQuery(sqlSelect);
		String result="";
		while(rs.next())
		{
			result+=rs.getInt("id")+":"+rs.getString("PRODUCER")+":"+rs.getDouble("PRICE")+":"
					+rs.getDouble("WEIGHT")+"\r\n";
					
		}
		return result;
	}
	
	public static String selectData(double priceThreshold) throws SQLException
	{
		String sqlSelect="select * from PLANES";
		Statement statement=connection.createStatement();
		ResultSet rs = statement.executeQuery(sqlSelect);
		String result="";
		while(rs.next())
		{
			if (rs.getDouble("PRICE")>priceThreshold)
			result+=rs.getInt("id")+":"+rs.getString("PRODUCER")+":"+rs.getDouble("PRICE")+":"
					+rs.getDouble("WEIGHT")+"\r\n";
					
		}
		return result;
		
		
	}
	
	public static void saveDataInDb(int id, Plane p) throws SQLException
	{
		String sqlInsert="INSERT INTO PLANES(id,producer,price,weight) VALUES(?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sqlInsert);
		statement.setInt(1, id);
		statement.setString(2, p.getProducer());
		statement.setDouble(3, p.getPrice());
		statement.setDouble(4, p.getWeight());
		statement.executeUpdate();
		statement.close();
		connection.commit();
		
		
	}
	public static List<Vehicle> selectDataIntoList() throws SQLException
	{
		List<Vehicle> lista = new ArrayList<Vehicle>();
		String sqlSelect="select * from PLANES";
		Statement statement=connection.createStatement();
		ResultSet rs = statement.executeQuery(sqlSelect);
		String result="";
		while(rs.next())
		{
			int id = rs.getInt("id");
			String producer = rs.getString("PRODUCER");
			double price= rs.getDouble("PRICE");
			float weight = rs.getFloat("WEIGHT");
			Plane newPlane=new Plane(weight,price,producer);
			lista.add(newPlane);
					
		}
		return lista;
	}
}
