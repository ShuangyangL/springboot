package ITSalaryDemo.Service;

import ITSalaryDemo.Entity.HttpClient;
import ITSalaryDemo.Entity.Record;
import ITSalaryDemo.Entity.Fields;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.json.*;

import java.util.ArrayList;
import java.util.List;


@Service
public class DataService{
    private String baseId = "appcPVyfCzg6u8Tpi";
    private String tableId = "tblFJTeVe7bNlbT26";

    private List<Record> allRecordsList;
    private String allRecordsJson = "";

    public DataService(){}

    public List<Record> getAllRecordsJson()
    {
        // This function is used to get all the data and deserialize the data for later use

        // This url link is the ListRecords url from airtable api
        String url="https://api.airtable.com/v0/"+baseId+"/"+tableId;
        HttpMethod method = HttpMethod.GET;

        Deserializer deserializer = new Deserializer();

        // allRecordsJson store temporary json string
        if(allRecordsJson.isEmpty())
        {
            // if allRecordsJson is empty, fetch the first 100 records
            allRecordsJson = (new HttpClient()).getResponse(url,method,null);
            // deserialize the Json String
            allRecordsList = deserializer.deserialize(allRecordsJson);

            // if there are more than 100 records, we need to get the offset to get the next 100 records
            JSONObject obj = new JSONObject(allRecordsJson);
            String offset = obj.getString("offset");
            while(offset.length() != 0)
            {
                // request for the next 100 records
                allRecordsJson = (new HttpClient()).getResponse(url+"?offset="+offset, method,null);

                if(allRecordsJson.contains("offset"))
                {
                    // if the new json string contains offset, continue request the next 100 records
                    obj = new JSONObject(allRecordsJson);
                    offset = obj.getString("offset");

                    // deserialize the json string and add to the record list
                    allRecordsList.addAll(deserializer.deserialize(allRecordsJson));
                    System.out.println("offset: "+offset);
                }
                else
                {
                    // if there is no offset in the latest request, it means that all records of the table are retrieved
                    System.out.println("no offset, end of the table");
                    allRecordsList.addAll(deserializer.deserialize(allRecordsJson));
                    break;
                }
            }
        }
        //allRecordsList = deserializer.deserialize(allRecordsJson);
        //System.out.println(allRecordsJson);

        /*
        for(int i =0; i<allRecordsList.size();i++)
        {
            Record record = allRecordsList.get(i);
            System.out.println(record.toString());
        }
         */

        return allRecordsList;
    }

    public List<Record> getRecords(String region, String country, String jobTitle){
        // This function get one or multiple records according to the region, country, and jobTitle

        getAllRecordsJson();

        List<Record> recordList = new ArrayList<Record>();
        for(int i = 0; i<allRecordsList.size();i++)
        {
            Record record = allRecordsList.get(i);
            Fields field = record.getFields();
            if(field.getRegion().equals(region) && field.getCountry().equals(country) && field.getJobTitle().equals(jobTitle))
            {
                recordList.add(record);
            }
        }

        if(recordList.isEmpty())
        {
            System.out.println("Record Not Found");
        }

        return recordList;
    }
}


