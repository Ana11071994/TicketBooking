package bookingEntity;

public class BookingEntity {
	protected int id;
	protected String name;
	protected String row;
	protected String seatNo;
	protected String movieName;
	protected String phoneNo;
	
	public BookingEntity(String name, String row, String seatNo, String movieName, String phoneNo) {
		super();
		
		this.name = name;
		this.row = row;
		this.seatNo = seatNo;
		this.movieName = movieName;
		this.phoneNo = phoneNo;
	}
	public BookingEntity(int id, String name, String row, String seatNo, String movieName, String phoneNo) {
		super();
		this.id = id;
		this.name = name;
		this.row = row;
		this.seatNo = seatNo;
		this.movieName = movieName;
		this.phoneNo = phoneNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
}
