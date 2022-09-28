package com.example.manageproduct.servlet;

import com.example.manageproduct.dao.ProductDAOImpl;
import com.example.manageproduct.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class ServletProduct extends HttpServlet {
    private static final long serialVersionUID =1L;
    private ProductDAOImpl productDAO;
    public void init(){
        productDAO= new ProductDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html;charset=UTF-8");
      req.setCharacterEncoding("utf-8");
      String action = req.getServletPath();
        System.out.println("action = " + action);

      try {
          switch (action){
              case "/new":
                  showNewForm(req,resp);
                  break;
              case"/insert":
                  insertProduct(req, resp);
                  break;
              case"/delete":
                  deleteProduct(req,resp);
                  break;
              case"/edit":
                  showEditForm(req,resp);
                  break;
              case"/update":
                  updateProduct(req,resp);
                  break;
              case"/search":
                  searchByName(req,resp);
              default:
                  listProduct(req,resp);
          }
      }catch (SQLException e){
          throw  new ServletException(e);
      }
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException{
        String product =req.getParameter("product");
        List<Product> productList=productDAO.getProductBySearch(product);
        req.setAttribute("productLists",productList);
        RequestDispatcher dispatcher=req.getRequestDispatcher("search_product.jsp");
        dispatcher.forward(req,resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productDAO.deleteProduct(id);
        resp.sendRedirect("list");
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("nameProduct");
        Double price=Double.parseDouble(req.getParameter("priceProduct"));
        String describe = req.getParameter("describe");
        String vendor= req.getParameter("vendor");
        String image =req.getParameter("image");
        Product product=new Product(id,name,price,describe,vendor,image);
        productDAO.updateProduct(product);
        resp.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product existingProduct= productDAO.selectProduct(id);
        req.setAttribute("product",existingProduct);
        RequestDispatcher dispatcher=req.getRequestDispatcher("edit_product.jsp");
        dispatcher.forward(req,resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
        RequestDispatcher dispatcher=req.getRequestDispatcher("add_product.jsp");
        dispatcher.forward(req,resp);
    }

    private void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String name = req.getParameter("nameProduct");
        String p = req.getParameter("priceProduct");
        double price= Double.parseDouble(p);
        String describe = req.getParameter("describe");
        String vendor = req.getParameter("vendor");
        String image = req.getParameter("image");
        Product newProduct= new Product(name,price,describe,vendor,image);
        productDAO.insertProduct(newProduct);
        resp.sendRedirect("list");
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException{
        List<Product> productList=productDAO.selectAllProduct();
        req.setAttribute("productLists",productList);
        RequestDispatcher dispatcher=req.getRequestDispatcher("view_product.jsp");
        dispatcher.forward(req,resp);
    }
}
