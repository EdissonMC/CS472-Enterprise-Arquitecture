package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //    public int productNumber;
//    public String name;
//    public double price;

    public void clearDB() {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        jdbcTemplate.update("DELETE from product", namedParameters);
        jdbcTemplate.update("DELETE from supplier", namedParameters);

    }

    public void save(Product product) {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("productNumber", product.getProductNumber());
        namedParameters.put("name", product.getName());
        namedParameters.put("price", product.getPrice());

        jdbcTemplate.update("INSERT INTO product VALUES ( :productNumber, :name, :price)", namedParameters);


        Map<String, Object> nameParametersSupplier = new HashMap<String, Object>();
        nameParametersSupplier.put("name", product.getSupplier().getName());
        nameParametersSupplier.put("phone", product.getSupplier().getPhone());
        nameParametersSupplier.put("productNumber", product.getProductNumber());
        jdbcTemplate.update("INSERT INTO supplier VALUES (  :name, :phone, :productNumber)", nameParametersSupplier);


    }


    public List<Product> getAllProducts() {
        List<Product> products = jdbcTemplate.query("SELECT * FROM product",
                new HashMap<String, Product>(),
                (rs, rowNum) -> new Product(
                        rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")
                ));

        for (Product product: products){
            Supplier supplier= getSupplierByProduct(product.getProductNumber());
            product.setSupplier(supplier);
        }

        return products;
    }


    public Product findByProductNumber(int productNumber) {

        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("productNumber", productNumber);
//        "SELECT * FROM product WHERE "
//                + "productNumber =:productNumber ",
        Product product = jdbcTemplate.queryForObject(
                "SELECT * FROM product WHERE productNumber =:productNumber ",
                namedParameters,
                (rs, rowNum) -> new Product(
                        rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")
                ));

        Supplier supplier= getSupplierByProduct(productNumber);
        product.setSupplier(supplier);
        return product;
    }

    public Product findByProductName(String nameSearch) {
        Map<String, Object> nameParameters = new HashMap<>();
        nameParameters.put("name", nameSearch);

        Product product = jdbcTemplate.queryForObject(
                "SELECT * FROM product WHERE name=:name",
                nameParameters,
                (rs, rowNum) -> new Product(
                        rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")
                )
        );

        Supplier supplier= getSupplierByProduct(product.getProductNumber());
        product.setSupplier(supplier);

        return product;
    }

    public Boolean deleteProductByNumber(int productNumber) {

        Map<String, Object> nameParameters = new HashMap<>();
        nameParameters.put("productNumber", productNumber);

        return jdbcTemplate.update("DELETE FROM product WHERE productNumber=:productNumber", nameParameters) == 1 &&
                jdbcTemplate.update("DELETE FROM supplier WHERE productNumber=:productNumber", nameParameters) == 1;
    }


    public Supplier getSupplierByProduct(int productNumber) {

        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("productNumber", productNumber);


        Supplier supplier = jdbcTemplate.queryForObject(
                "SELECT * FROM supplier WHERE productNumber =:productNumber ",
                namedParameters,
                (rs, rowNum) -> new Supplier(
                        rs.getString("name"),
                        rs.getString("phone")
                ));

        return supplier;
    }


}
