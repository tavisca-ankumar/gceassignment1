import java.beans.XMLEncoder;
import java.io.*;

public class DataBaseToXMLConverter {

    private static final String SERIALIZED_FILE_NAME="employee.xml";
    static DatabaseToModelConverter dtmc = new DatabaseToModelConverter();

    public void convertToXML() throws IOException {
        EmployeeContainer employeeContainer = dtmc.createModel("emp");
        XMLEncoder encoder=null;
        try{
            encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
        }catch(FileNotFoundException fileNotFound){
            System.out.println("ERROR: While Creating or Opening the File dvd.xml");
        }
        encoder.writeObject(employeeContainer.emp);
        encoder.close();

        ObjectOutputStream  oos = new ObjectOutputStream(new FileOutputStream("abc.xml"));
        oos.writeObject(employeeContainer.emp);
        oos.close();
    }

}
