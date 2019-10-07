import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseToCSVConverter {

    static DatabaseToModelConverter dtmc = new DatabaseToModelConverter();


    private static final String SAMPLE_CSV_FILE = "emp.csv";

    public void convertToCSV() throws IOException {
        EmployeeContainer employeeContainer = dtmc.createModel("emp");
        Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Name", "Hobbies", "Department"));
         {
             for(Employee emp:employeeContainer.emp){
                 List employeeRecord = new ArrayList<>();
                 employeeRecord.add(String.valueOf(emp.getEmpId()));
                 employeeRecord.add(emp.getEmpName());
                 employeeRecord.add(Arrays.toString(emp.getHobbies()));
                 employeeRecord.add(emp.getDept());
                 csvPrinter.printRecord(employeeRecord);
             }
            csvPrinter.flush();
        }
    }

}
