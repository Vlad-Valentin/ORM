package com.example.product_service.dal;

//import com.example.connection_package.ConnectionHelper;

import com.example.product_service.models.Product;
import com.example.product_service.models.UserProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserProductDAO {

    public static ArrayList<UserProduct> getAll() {
        ArrayList<UserProduct> result = new ArrayList<>();

        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM public.\"userProducts\"")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(new UserProduct(resultSet.getInt(1),
                        resultSet.getInt(2)));
            }

            resultSet.close();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Product> getProductsForUser(int userId) {
        List<UserProduct> ownedProducts = UserProductDAO.getAll().stream().filter(userProduct -> userProduct.getUserId() == userId).collect(Collectors.toList());
        List<Product> products = new ArrayList<>();
        for (UserProduct userProduct : ownedProducts) {
            products.add(ProductDAO.get(userProduct.getProductId()));
        }

        return products;
    }

    public static void add(UserProduct userProduct) {
        if (userProduct == null) {
            return;
        }

        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO public.\"userProducts\"(\n" +
                     "\t\"userId\", \"productId\")\n" +
                     "\tVALUES (?, ?);")) {

            preparedStatement.setInt(1, userProduct.getUserId());
            preparedStatement.setInt(2, userProduct.getProductId());

            preparedStatement.execute();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int userId, int productId) {

        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM public.\"userProducts\" WHERE \"userId\" = ? AND \"productId\" = ?")) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, productId);

            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
