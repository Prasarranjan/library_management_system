package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import user.user;
import userDao.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/submitBook")
public class submitBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name =request.getParameter("name");
        String author=request.getParameter("author");
        int price= Integer.parseInt(request.getParameter("price"));
        String publisher=request.getParameter("publisher");
        String isbn=request.getParameter("isbn");
        user u=new user();
        u.setName(name);
        u.setAuthor(author);
        u.setPrice(price);
        u.setPublisher(publisher);
        u.setIsbn(isbn);
        int result = userDao.saveDetails(u);
        if (result == 1) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Book Addition Status</title>");

            out.print("<style>");
            out.print("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
            out.print(".container { width: 50%; margin: auto; padding: 20px; background-color: #fff; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); text-align: center; }");
            out.print("h2 { color: #4CAF50; }");
            out.print(".btn { margin-top: 20px; background-color: #007bff; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; text-decoration: none; display: inline-block; }");
            out.print(".btn:hover { background-color: #0056b3; }");
            out.print("</style>");

            out.print("</head>");
            out.print("<body>");

            out.print("<div class='container'>");
            out.print("<h2>Book Successfully Added!</h2>");
            out.print("<a href='index.jsp' class='btn'>Add Another Book</a>");
            out.print("<a href='viewServlet' class='btn'>View Books</a>");
            out.print("</div>");

            out.print("</body>");
            out.print("</html>");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Book Addition Status</title>");

            out.print("<style>");
            out.print("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
            out.print(".container { width: 50%; margin: auto; padding: 20px; background-color: #fff; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); text-align: center; }");
            out.print("h2 { color: #f44336; }");
            out.print(".btn { margin-top: 20px; background-color: #007bff; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; text-decoration: none; display: inline-block; }");
            out.print(".btn:hover { background-color: #0056b3; }");
            out.print("</style>");

            out.print("</head>");
            out.print("<body>");

            out.print("<div class='container'>");
            out.print("<h2>Failed to Add Book!</h2>");
            out.print("<a href='addBookForm.jsp' class='btn'>Try Again</a>");
            out.print("<a href='viewBooksServlet' class='btn'>View Books</a>");
            out.print("</div>");

            out.print("</body>");
            out.print("</html>");
        }


    }
}
