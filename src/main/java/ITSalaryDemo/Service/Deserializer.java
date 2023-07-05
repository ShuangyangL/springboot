package ITSalaryDemo.Service;

import ITSalaryDemo.Entity.Record;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Deserializer {
    public List<Record> deserialize(String jsonString){
        jsonString = jsonString.replace("\"id\"", "\"recordId\"");

        jsonString = jsonString.replace("Base Salary Range in USD", "baseSalaryRange");
        jsonString = jsonString.replace("Average Base Salary in USD", "baseSalaryAve");
        jsonString = jsonString.replace("Max Base Salary in USD", "baseSalaryMax");
        jsonString = jsonString.replace("Min Base Salary in USD", "baseSalaryMin");

        jsonString = jsonString.replace("Total Pay Range in USD", "totalPayRange");
        jsonString = jsonString.replace("Max Total Pay in USD", "totalPayMax");
        jsonString = jsonString.replace("Min Total Pay in USD", "totalPayMin");

        jsonString = jsonString.replace("Job Title", "jobTitle");
        jsonString = jsonString.replace("Category", "category");
        jsonString = jsonString.replace("Experience Level", "experienceLevel");

        jsonString = jsonString.replace("Region", "region");
        jsonString = jsonString.replace("Country", "country");

        JSONObject obj = new JSONObject(jsonString);
        JSONArray jsonArray = obj.getJSONArray("records");
        Type listOfMyClassObject = new TypeToken<ArrayList<Record>>() {}.getType();

        Gson gson = new Gson();
        List<Record> recordList = gson.fromJson(jsonArray.toString(), listOfMyClassObject);

        /*
        for(int i =0; i<recordList.size();i++)
        {
            Record record = recordList.get(i);
            System.out.println(record.toString());
        }
         */
        return recordList;
    }
}
