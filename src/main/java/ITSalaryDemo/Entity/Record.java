package ITSalaryDemo.Entity;

import lombok.Getter;

@Getter
public class Record{
    String recordId;
    Fields fields;

    @Override
    public String toString() {
        return this.recordId+" "
                +fields.category+" "+fields.jobTitle+" "+fields.experienceLevel+" "
                +fields.totalPayRange+" "+fields.totalPayMax+" "+fields.totalPayMin+" "
                +fields.baseSalaryRange+" "+fields.baseSalaryMax+" "+fields.baseSalaryMin+""+fields.baseSalaryAve+" "
                +fields.region+" "+fields.country+" ";
    }
}

