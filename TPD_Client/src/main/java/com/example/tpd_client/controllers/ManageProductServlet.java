package com.example.tpd_client.controllers;

import com.example.tpd_client.dal.ProductDAO;
import com.example.tpd_client.dal.UserProductDAO;
import com.example.tpd_client.models.Product;
import com.example.tpd_client.models.UserProduct;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@WebServlet(name = "manageProductsServlet", value = "/manage-products")
public class ManageProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/manage-products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String button = request.getParameter("button");
        if (button == null) {
            return;
        }
        if (button.equals("home")) {
            response.sendRedirect(request.getContextPath() + "/home");
        }

        if (button.equals("add-product")) {
            String result;
            try {
                result = TryToAddProduct(request);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (result != null) {
                System.err.println(result);
            }

            response.sendRedirect(request.getContextPath() + "/home");
        }
    }

    private String TryToAddProduct(HttpServletRequest request) throws IOException, InterruptedException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());

        if (name.isEmpty() || price == 0) {
            return "All fields must be filled";
        }

        List<Product> ownedProducts = UserProductDAO.getProductsForUser(Integer.parseInt(request.getSession().getAttribute("userId").toString()));
        if (containsProduct(ownedProducts, name, price).isPresent()) {
            return "The user already owns the specified product.";
        }

        List<Product> allProducts = ProductDAO.getAllProducts();

        Optional<Product> product = containsProduct(allProducts, name, price);

        int productId;
        if (!product.isPresent()) {
            Product newProduct = new Product(allProducts.size() + 1, name, price);
            ProductDAO.add(newProduct);
            productId = allProducts.size() + 1;
        } else {
            productId = product.get().getId();
        }
        UserProduct newUserProduct = new UserProduct(userId, productId);
        UserProductDAO.add(newUserProduct);

        return null;
    }

    private Optional<Product> containsProduct(List<Product> products, String name, int price) {
        Predicate<Product> namePredicate = product -> product.getName().equals(name);
        Predicate<Product> pricePredicate = product -> product.getPrice() == price;
        Predicate<Product> combinedPredicates = namePredicate.and(pricePredicate);
        return products.stream().filter(combinedPredicates).collect(Collectors.toList()).stream().findFirst();
    }
}
