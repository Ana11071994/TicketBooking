package bookingDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookingEntity.BookingEntity;

public class BookingDao {
	private String jdbc="jdbc:mysql://localhost:3306/ticketbookinglist?useSSL=false";
	private String jdbcUsername="root";
	private String jdbcPassword="1194";
	private String jdbcDriver="com.mysql.cj.jdbc.Driver";
	
	private static final String INSERT_USER_DATA="INSERT INTO ticketlist"+"(id,cus_name,cus_row,cus_seat,movie_name,phone_no) values"+"(?,?,?,?,?,?);";

	private static final String SELECT_USER_BY_ID="select id,cus_name,cus_row,cus_seat,movie_name,phone_no from ticketlist where id=?"; 
	private static final String SELECT_ALL_USER="SELECT * from ticketlist";
	private static final String DELETE_USER_SQL="delete from ticketlist where id=?;";
	private static final String UPDATE_USER_SQL="update ticketlist set cus_name=?,cus_row=?,cus_seat=?,movie_name=?,phone_no=? where id=?;"; 
	

	public BookingDao() {
		// TODO Auto-generated constructor stub
		
	}
//	database connection
	
	protected Connection getConnection(){
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(jdbc, jdbcUsername, jdbcPassword);
		}catch (SQLException e) {
			System.out.println("cannot connect with database");
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;	
	}
	
	
	
//	insert data 
	public void insertUser(BookingEntity regist)
	{
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER_DATA))
		{
			preparedStatement.setInt(1, regist.getId());
			preparedStatement.setString(2, regist.getName());
			preparedStatement.setString(3, regist.getRow());
			preparedStatement.setString(4, regist.getSeatNo());
			preparedStatement.setString(5, regist.getMovieName());
			preparedStatement.setString(6, regist.getPhoneNo());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		}catch (SQLException e)
			{
				e.printStackTrace();
			}			
	}
//	........................................................................................................................................
//	select user by id 
	public BookingEntity selectUser(int id) {
		BookingEntity bookingEntity=null;
		
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER_BY_ID);){
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			
			ResultSet rs= preparedStatement.executeQuery();
			
//			4 process the resultSet object.
			while (rs.next()) {
				String cusname =rs.getString("cus_name");
				String cusrow =rs.getString("cus_row");
				String cusseat =rs.getString("cus_seat");
				String moviename =rs.getString("movie_name");
				String cusphoneno =rs.getString("phone_no");
				bookingEntity =new BookingEntity(id,cusname, cusrow, cusseat,moviename, cusphoneno);		
			}
		}catch (Exception e) {
		e.printStackTrace();
			// TODO: handle exception
		}
		return bookingEntity;	
	}
	
	
//...................................................................................................................................
	
	
//	select all user
	 public List<BookingEntity> selectAllUsers() {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < BookingEntity > users = new ArrayList<>();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();
	           
	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("cus_name");
	                String row = rs.getString("cus_row");
	                String seat = rs.getString("cus_seat");
	                String moviename = rs.getString("movie_name");
	                String contact = rs.getString("phone_no");
	                users.add(new BookingEntity(id, name, row, seat, moviename, contact));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return users;
	    }
		 
	
//	..................................................................................................................................
	 
//	 update data into database 
	 
	 
	 private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}

	public boolean updateUser(BookingEntity booking) throws SQLException {
		 boolean rowUpdated;
		 try (Connection  connection =getConnection();
				 PreparedStatement statement=connection.prepareStatement(UPDATE_USER_SQL);){
			 System.out.println("updated cusDetails :"+statement);
			 statement.setString(1, booking.getName());
			 statement.setString(2,booking.getRow());
			 statement.setString(3,booking.getSeatNo());
			 statement.setString(4, booking.getMovieName());
			 statement.setString(5,booking.getPhoneNo());
			 statement.setInt(6, booking.getId());
			 
			 rowUpdated =statement.executeUpdate()>0; 
		 }
		 return rowUpdated;	 
	 }
//	...............................................................................................................................................

	//	 delete user details into database
	 
	 public boolean deleteUser(int id) throws SQLException{
		 boolean  rowDeleted;
		 try(Connection connection =getConnection();
				 PreparedStatement statement =connection.prepareStatement(DELETE_USER_SQL);){
			 statement.setInt(1, id);
			 rowDeleted=statement.executeUpdate()>0;
		 }
		 return rowDeleted;
}
}
