package pl.deso.ClinicWebApp.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Visit {

    @Id
    @GeneratedValue
    int idVisit;

    User visitDoctor;
    User visitPatient;
    Date visitDate;
    String visitLocation;

    public Visit(int idVisit, User visitDoctor, User visitPatient, Date visitDate, String visitLocation) {
        this.idVisit = idVisit;
        this.visitDoctor = visitDoctor;
        this.visitPatient = visitPatient;
        this.visitDate = visitDate;
        this.visitLocation = visitLocation;
    }

    public int getIdVisit() {
        return idVisit;
    }

    public void setIdVisit(int idVisit) {
        this.idVisit = idVisit;
    }

    public User getVisitDoctor() {
        return visitDoctor;
    }

    public void setVisitDoctor(User visitDoctor) {
        this.visitDoctor = visitDoctor;
    }

    public User getVisitPatient() {
        return visitPatient;
    }

    public void setVisitPatient(User visitPatient) {
        this.visitPatient = visitPatient;
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
