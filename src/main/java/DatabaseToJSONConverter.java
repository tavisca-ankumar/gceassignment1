import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DatabaseToJSONConverter {

    static DatabaseToModelConverter dtmc = new DatabaseToModelConverter();

    public void convertToJSON()
    {
        ObjectMapper mapper = new ObjectMapper();
        EmployeeContainer employeeContainer = dtmc.createModel("emp");

        try
        {
            mapper.writeValue(new File("employee.json"), employeeContainer.emp);
        } catch (JsonGenerationException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
