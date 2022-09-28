package com.example.manageproduct.dao;

import com.example.manageproduct.dbconnect.DBConnect;
import com.example.manageproduct.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductService{
    Connection connection= DBConnect.getConnection();
    public ProductDAOImpl(){}



    @Override
    public List<Product> selectAllProduct() {
        List<Product> products= new ArrayList<>();
       try {
           String sql = "Select* from product";
           PreparedStatement ps = connection.prepareStatement(sql);
           ResultSet rs= ps.executeQuery();
           while (rs.next()){
               int id= rs.getInt("id");
               String name= rs.getString("nameProduct");
            Double price = rs.getDouble("priceProduct");
            String describe = rs.getString("describe");
            String vendor = rs.getString("vendor");
            String image = rs.getString("image");
            products.add(new Product(id,name, price, describe,vendor,image));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
        return products;
    }

    @Override
    public void insertProduct(Product product) {
     try {
         String sql = "INSERT INTO Product ( nameProduct, priceProduct, describe, vendor,image) VALUES (?,?,?,?,?)";
         PreparedStatement ps=connection.prepareStatement(sql);
         ps.setString(1, product.getNameProduct());
         ps.setDouble(2, product.getPriceProduct());
         ps.setString(3,product.getDescribe());
         ps.setString(4,product.getVendor());
         ps.setString(5,product.getImage());
         ps.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
    }

    @Override
    public Product selectProduct(int id) {
      Product product= null;
      try {
          String sql = "Select * from product where id=?";
          PreparedStatement ps= connection.prepareStatement(sql);
          ps.setInt(1,id);
          ResultSet rs= ps.executeQuery();
          while(rs.next()){

              String name= rs.getString("nameProduct");
              Double price = rs.getDouble("priceProduct");
              String describe = rs.getString("describe");
              String vendor = rs.getString("vendor");
              String image = rs.getString("image");
              product =new Product(id,name, price, describe,vendor,image);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return product;
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean checkUpdate = false;
      String sql = "update product set nameProduct=?, priceProduct=?, `describe`=?, vendor=?, image=? where id =?";
      try{
          PreparedStatement statement = connection.prepareStatement(sql);
          statement.setString(1, product.getNameProduct());
          statement.setDouble(2, product.getPriceProduct());
          statement.setString(3, product.getDescribe());
          statement.setString(4, product.getVendor());
          statement.setString(5, product.getImage());
          statement.setInt(6, product.getId());
          checkUpdate = statement.executeUpdate() >0;
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return checkUpdate;
    }

    @Override
    public boolean deleteProduct(int id) {
       boolean rowDeleted= false;
       try {
           String sql="Delete from product where id=?";
           PreparedStatement ps=connection.prepareStatement(sql);
           ps.setInt(1,id);
           rowDeleted=ps.executeUpdate()>0;
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return rowDeleted;
    }

    @Override
    public List<Product> getProductBySearch(String product) {
        List<Product> list=new ArrayList<>();
        Product p= null;
        try {
            String sql ="select * from product where nameProduct like ?  or `describe` like ? or vendor like ?";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, "%"+product+"%");
            ps.setString(2, "%"+product+"%");
            ps.setString(3, "%"+product+"%");
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                int id= rs.getInt("id");
                String name= rs.getString("nameProduct");
                Double price = rs.getDouble("priceProduct");
                String describe = rs.getString("describe");
                String vendor = rs.getString("vendor");
                String image = rs.getString("image");
                list.add(new Product(id,name, price, describe,vendor,image));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
