package bookingweb;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bookingDao.BookingDao;
import bookingEntity.BookingEntity;


/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookingDao bookingDao=new BookingDao();
    
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		bookingDao =new BookingDao();
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action =request.getServletPath();
		System.out.println(action);
		
		
		switch (action) {
		
		case "/viewList":{
			try {
				listUser(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
	}
		case "/booking":{
			booking(request, response);
			break;
			
		}
		case "/insert":{
			try {
				insertUser(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "/delete":{
			try {
				deleteUser(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "/edit":{
			try {
				showEditForm(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "/update":{
			try {
				updateUser(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			break;
		}
		default:
		
			break;
		}
	}
	
	private void booking(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		RequestDispatcher dispatcher=request.getRequestDispatcher("Booking-form.jsp");
		dispatcher.forward(request, response);
	}
		private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("update-form.jsp");
			dispatcher.forward(request, response);
		}
		
		private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
			String customerName=request.getParameter("name");
			String customerRow=request.getParameter("row");
			String customerSeatNo=request.getParameter("seat");
			String movieName=request.getParameter("movie");
			String cutomerPhoneNo=request.getParameter("phone");
			
			BookingEntity regist=new BookingEntity(customerName, customerRow, customerSeatNo, movieName, cutomerPhoneNo);
			bookingDao.insertUser(regist);
			
			response.sendRedirect("viewList");
		}
	
		
//		.....................delete...................................................................................................................
		
		private void deleteUser(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException{
			int id =Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
				bookingDao.deleteUser(id);
			response.sendRedirect("viewList");
			
			}
//		
//		.....................edit........................................................................................................................
		
		private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException,ServletException
		{
			int id=Integer.parseInt(request.getParameter("id"));
			BookingEntity exitingUser;
			try {
				 exitingUser =bookingDao.selectUser(id);
//				 response.sendRedirect("update-form.jsp");
				 RequestDispatcher dispatcher =request.getRequestDispatcher("update-form.jsp");
				 request.setAttribute("ticketlist", exitingUser);
				 dispatcher.forward(request, response);
				 response.sendRedirect("update-form.jsp");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//	....................update......................................................................................................................
		
		private void updateUser(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException
		{
			int id=Integer.parseInt(request.getParameter("id"));
			
			String customerName=request.getParameter("name");
			String customerRow=request.getParameter("row");
			String customerSeatNo=request.getParameter("seat");
			String movieName=request.getParameter("movie");
			String cutomerPhoneNo=request.getParameter("phone");
			BookingEntity update=new BookingEntity(id, customerName, customerRow, customerSeatNo, movieName, cutomerPhoneNo);
			bookingDao.updateUser(update);
			
			response.sendRedirect("viewList");
		}
//		................default.............................................................................................................
		
		private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException,IOException
		{
			try {
				List<BookingEntity> listUser=bookingDao.selectAllUsers();
				request.setAttribute("alldata", listUser);
				RequestDispatcher dispatcher=request.getRequestDispatcher("Booking-list.jsp");
				dispatcher.forward(request, response);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
}