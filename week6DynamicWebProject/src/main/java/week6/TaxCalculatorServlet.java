package week6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TaxCalculatorServlet")  // Specifies the URL pattern for the servlet
public class TaxCalculatorServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	   	
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        double income = Double.parseDouble(request.getParameter("income"));
        double taxrate = Double.parseDouble(request.getParameter("taxrate"));
        
        double tax = (taxrate/100) * income;
        String ftax = String.format("%.2f", tax);
        
        out.println("<html><body>");
        out.println("<div><center><h1>Tax Calculator</h1></center>");
        out.println("<p>Income: $" + income + "</p>");
        out.println("<p>Calculated Tax: $" + ftax + "</p></div>");
        out.println("<style>body{font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; align-items: center;}");
        out.println("div{border: solid black 0.1em;border-radius: 2em;	padding: 2em;</div>}");
        out.println("</body></html>");
    }
}
