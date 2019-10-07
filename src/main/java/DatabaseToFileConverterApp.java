
import java.io.IOException;
import java.util.Scanner;

public class DatabaseToFileConverterApp {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the format of data you want :- ");
        System.out.println("XML");
        System.out.println("JSON");
        System.out.println("CSV");
        System.out.println("EXIT");
        String option = sc.next();
        boolean x= true;
        while(x){
            switch(option){
                case "XML":new DataBaseToXMLConverter().convertToXML();break;
                case "JSON":new DatabaseToJSONConverter().convertToJSON();break;
                case "CSV":new DatabaseToCSVConverter().convertToCSV();break;
                case "EXIT": x=false;break;
                case "exit": x=false;
            }
        }


    }

}
