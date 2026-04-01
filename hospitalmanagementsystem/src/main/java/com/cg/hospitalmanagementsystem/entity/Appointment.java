import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Entity
@Table(name = "appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {



    @Id
    @Column(name = "AppointmentID")
    private Integer appointmentId;



    @ManyToOne
    @JoinColumn(name="Patient", referencedColumnName = "SSN")
    private Patient patient;



    @ManyToOne
    @JoinColumn(name = "PrepNurse", referencedColumnName = "EmployeeID")
    private Nurse prepNurse;


    @ManyToOne
    @JoinColumn(name = "Physician", referencedColumnName = "EmployeeID")
    private Physician physician;


    @Column(name = "Starto")
    private LocalDateTime starto;




    @Column(name = "Endo")
    private LocalDateTime endo;




    @Column(name = "ExaminationRoom")
    private String examinationRoom;
}




