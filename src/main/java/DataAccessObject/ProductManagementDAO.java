package DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBUtil.DBUtil;
import PlainOldJavaObject.Product;

public class ProductManagementDAO {

// BEGIN METHOD getAllProduct()	
	public static List<Product> getAllProducts() {

		List<Product> productList = new ArrayList<Product>();

		try {
			Connection conn = DBUtil.getConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM product");
			while (rs.next()) {
				Product product = new Product(rs.getString("prod_id"), rs.getString("prod_name"),
						rs.getString("prod_category"), rs.getInt("prod_price"));
				productList.add(product);
			}

			// close connection
			DBUtil.closeConnection(conn);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}
// END METHOD getAllProduct()	

// ---------------------------------------------

	// BEGIN METHOD getProductById()

	public static Product getProductById(String productId) {
		Product product = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM product WHERE prod_id = ?");
			ps.setString(1, productId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product = new Product(rs.getString("prod_id"), rs.getString("prod_name"), rs.getString("prod_category"),
						rs.getInt("prod_price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	// END METHOD getProductById()

	// ---------------------------------------------

	// BEGIN METHOD addProduct()
	public static int addProduct(Product product) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO product VALUES(?,?,?,?)");
			ps.setString(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductCategory());
			ps.setInt(4, product.getProductPrice());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	// END METHOD addProduct()

	// ---------------------------------------------

	// BEGIN METHOD updateProduct()
	public static int updateProduct(Product product) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE product SET prod_name=?, prod_category=?, prod_price=? WHERE prod_id=?");
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductCategory());
			ps.setInt(3, product.getProductPrice());
			ps.setString(4, product.getProductId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}
	// END METHOD updateProduct()

	// ---------------------------------------------

	// BEGIN METHOD deleteProduct()
	public static int deleteProduct(String productId) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM product where prod_id=?");		
			ps.setString(1, productId);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	// END METHOD deleteProduct()
}
