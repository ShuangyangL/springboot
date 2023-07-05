package ITSalaryDemo.Controller;

import ITSalaryDemo.Entity.Record;
import ITSalaryDemo.Service.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {
    private DataService dataService = new DataService();

    @GetMapping("/listRecords")
    public List<Record> getAllRecords()
    {
        // This function is used to call the ListRecords api from airtable
        return dataService.getAllRecordsJson();
    }

    @GetMapping("/getRecords/{region}/{country}/{jobTitle}")
    public List<Record> getRecords(@PathVariable("region")String region, @PathVariable("country") String country, @PathVariable("jobTitle") String jobTitle)
    {
        return dataService.getRecords(region, country, jobTitle);
    }

    /*
    @GetMapping("/getRecords/{region}/{country}/{jobTitle}")
    public String getTotalPayRange(@PathVariable("region")String region, @PathVariable("country") String country,@PathVariable("jobTitle") String jobTitle)
    {
        return dataService.getTotalPayRange(region, country, jobTitle);
    }

    @GetMapping("/getRecords/{region}/{country}/{jobTitle}")
    public String getTotalPayMax(@PathVariable("region")String region, @PathVariable("country") String country,@PathVariable("jobTitle") String jobTitle)
    {
        return dataService.getTotalPayMax(region, country, jobTitle);
    }

    @GetMapping("/getRecords/{region}/{country}/{jobTitle}")
    public String getTotalPayMin(@PathVariable("region")String region, @PathVariable("country") String country,@PathVariable("jobTitle") String jobTitle)
    {
        return dataService.getTotalPayMin(region, country, jobTitle);
    }

    @GetMapping("/getRecords/{region}/{country}/{jobTitle}")
    public String getBaseSalaryRange(@PathVariable("region")String region, @PathVariable("country") String country,@PathVariable("jobTitle") String jobTitle)
    {
        return dataService.getBaseSalaryRange(region, country, jobTitle);
    }

    @GetMapping("/getRecords/{region}/{country}/{jobTitle}")
    public String getBaseSalaryAve(@PathVariable("region")String region, @PathVariable("country") String country,@PathVariable("jobTitle") String jobTitle)
    {
        return dataService.getBaseSalaryAve(region, country, jobTitle);
    }

    @GetMapping("/getRecords/{region}/{country}/{jobTitle}")
    public String getBaseSalaryAve(@PathVariable("region")String region, @PathVariable("country") String country,@PathVariable("jobTitle") String jobTitle)
    {
        return dataService.getBaseSalaryMax(region, country, jobTitle);
    }

    @GetMapping("/getRecords/{region}/{country}/{jobTitle}")
    public String getBaseSalaryAve(@PathVariable("region")String region, @PathVariable("country") String country,@PathVariable("jobTitle") String jobTitle)
    {
        return dataService.getBaseSalaryMin(region, country, jobTitle);
    }

     */
}
