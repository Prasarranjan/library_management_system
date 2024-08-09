package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import userDao.*;
import java.io.IOException;
import java.io.PrintWriter;
import user.*;

@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        user book = new user();
        book = userDao.getUserbyid(id);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Update Book</title>");

        out.print("<style>");
        out.print("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
        out.print(".container { width: 50%; margin: auto; padding: 20px; background-color: #fff; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
        out.print("h2 { text-align: center; color: #333; }");
        out.print("label { display: block; margin-top: 10px; color: #555; }");
        out.print("input[type='text'], input[type='number'] { width: 100%; padding: 8px; margin-top: 5px; border: 1px solid #ccc; border-radius: 4px; }");
        out.print("input[type='submit'] { margin-top: 20px; background-color: #4CAF50; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; }");
        out.print("input[type='submit']:hover { background-color: #45a049; }");
        out.print(".btn-back { margin-top: 20px; background-color: #007bff; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; text-decoration: none; display: inline-block; }");
        out.print(".btn-back:hover { background-color: #0056b3; }");
        out.print("</style>");

        out.print("</head>");
        out.print("<body>");

        out.print("<div class='container'>");
        out.print("<h2>Update Book Details</h2>");

        out.print("<form action='updateServlet' method='post'>");
        out.print("<input type='hidden' name='id' value='" + book.getId() + "' />");

        out.print("<label for='name'>Book Name:</label>");
        out.print("<input type='text' name='name' value='" + book.getName() + "' required />");

        out.print("<label for='author'>Author Name:</label>");
        out.print("<input type='text' name='author' value='" + book.getAuthor() + "' required />");

        out.print("<label for='price'>Price:</label>");
        out.print("<input type='number' step='0.01' name='price' value='" + book.getPrice() + "' required />");

        out.print("<label for='publisher'>Publisher:</label>");
        out.print("<input type='text' name='publisher' value='" + book.getPublisher() + "' required />");

        out.print("<label for='isbn'>ISBN:</label>");
        out.print("<input type='text' name='isbn' value='" + book.getIsbn() + "' required />");

        out.println("<tr><td colspan='2' style='text-align: center;'><input type='submit' value='Update'/></td></tr>");


        out.print("</body>");
        out.print("</html>");
    }
}
