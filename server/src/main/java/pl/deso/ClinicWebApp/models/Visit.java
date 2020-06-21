package pl.deso.ClinicWebApp.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (
   uniqueConstraints = @UniqueConstraint (columnNames = {"visitDate", "visitLocation"})
)
public class Visit {

    @Id
    @GeneratedValue
    int idVisit;
    String visitPatientEmail;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    Date visitDate;
    String visitLocation;

    public int getIdVisit() {
        return idVisit;
    }

    public void setIdVisit(int idVisit) {
        this.idVisit = idVisit;
    }

    public String getVisitPatientEmail() {
        return visitPatientEmail;
    }

    public void setVisitPatientEmail(String visitPatientEmail) {
        this.visitPatientEmail = visitPatientEmail;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitLocation() {
        return visitLocation;
    }

    public void setVisitLocation(String visitLocation) {
        this.visitLocation = visitLocation;
    }
}
