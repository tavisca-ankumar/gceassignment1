import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseToModelConverter {

    static DatabaseConnector db;
    static{
         db = new DatabaseConnector();
    }
    EmployeeContainer employeeContainer;

    public EmployeeContainer createModel(String databaseTableName) {
        try{
            Statement statement=db.sqlConnection.createStatement();
            String query = "select * from "+databaseTableName;
            int count = getCount(db,databaseTableName);
            ResultSet resultSet=statement.executeQuery(query);

            employeeContainer = new EmployeeContainer(count);
            int i=0;
            while(resultSet.next()){
                Employee tempEmp = new Employee();
                tempEmp.setEmpId(resultSet.getInt(1));
                tempEmp.setEmpName(resultSet.getString(2));
                tempEmp.setHobbies(resultSet.getString(3).split(", "));
                tempEmp.setDept(resultSet.getString(4));
                employeeContainer.emp[i]=tempEmp;
                i++;
            }
        }
        catch (SQLException e) {
            System.out.println("SQL Error: "+e.getMessage());
        }

        return employeeContainer;

    }

    private int getCount(DatabaseConnector db, String databaseTableName) throws SQLException {

        Statement state=db.sqlConnection.createStatement();
        String query = "select count(*) from "+databaseTableName;
        ResultSet resultSet = state.executeQuery(query);
        int count = 0;
        while (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        return count;
    }


}
