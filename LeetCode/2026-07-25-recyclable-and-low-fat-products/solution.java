// Time complexity: O(n)
// Space complexity: O(n)
public List<Integer> findRecyclableAndLowFatProducts() {
    List<Integer> result = new ArrayList<>();
    // Assuming we have a connection to the database
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Products", "username", "password");
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT product_id FROM Products WHERE low_fats = 'Y' AND recyclable = 'Y'");
    while (rs.next()) {
        result.add(rs.getInt("product_id"));
    }
    return result;
}