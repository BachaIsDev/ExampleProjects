package config;

import dao.ProductDao;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/html/updatePerson.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDao = new ProductDao();
        int id = Integer.parseInt(req.getParameter("id"));
        Product productOld = productDao.findById(id);
        Product productNew = new Product();

        productNew.setId(productOld.getId());
        productNew.setName(req.getParameter("name"));
        productNew.setCost(Integer.parseInt(req.getParameter("cost")));

        productDao.update(productNew);
    }
}
