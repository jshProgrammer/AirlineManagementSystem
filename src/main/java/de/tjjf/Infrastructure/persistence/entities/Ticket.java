package de.tjjf.Infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Ticket implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketId;

   @ManyToOne(fetch = FetchType.EAGER, optional = true)
   @JoinColumn(name = "personId", referencedColumnName = "personId", insertable = false, updatable = false)
   private Client client;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "employee_id", referencedColumnName = "personId", insertable = false, updatable = false)
    private Employee employee;

    //@ManyToOne
    //@JoinColumn(name = "employee_id", nullable = false)
    //private Employee employee
    //@ManyToOne
    //@JoinColumn(name = "client_id")
    //private Client client;
//
    //@ManyToOne
    //@JoinColumn(name = "employee_id")
    //private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id", referencedColumnName = "flightNum")
    private Flight flight;

    @Column(nullable=false)
    private Date dateTimeOfBooking;

    @Column(nullable=false)
    private int totalPrice;

    @Column(nullable=false)
    private int seatNum;

    @Column(nullable=false)
    private String seatingClass;

    @Column(nullable=false)
    private String ticketStatus;

    @Column(nullable=false)
    private int maxWeightOfLuggage;

    public Ticket(){}

    private Ticket(Flight flight, Date dateTimeOfBooking, int totalPrice, int seatNum, String seatingClass, String ticketStatus, int maxWeightOfLuggage) {
        this.flight = flight;
        this.dateTimeOfBooking = dateTimeOfBooking;
        this.totalPrice = totalPrice;
        this.seatNum = seatNum;
        this.seatingClass = seatingClass;
        this.ticketStatus = ticketStatus;
        this.maxWeightOfLuggage = maxWeightOfLuggage;
    }

    public Ticket(Flight flight, Date dateTimeOfBooking, int totalPrice, int seatNum, String seatingClass, String ticketStatus, int maxWeightOfLuggage, Client client) {
        this(flight, dateTimeOfBooking, totalPrice, seatNum, seatingClass, ticketStatus, maxWeightOfLuggage);
        this.client = client;
    }

    public Ticket(Flight flight, Date dateTimeOfBooking, int totalPrice, int seatNum, String seatingClass, String ticketStatus, int maxWeightOfLuggage, Employee employee) {
        this(flight, dateTimeOfBooking, totalPrice, seatNum, seatingClass, ticketStatus, maxWeightOfLuggage);
        this.employee = employee;
    }


    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Flight getFlightNum() {
        return flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlightNum(Flight flightNum) {
        this.flight = flightNum;
    }

    public Date getDateTimeOfBooking() {
        return dateTimeOfBooking;
    }

    public void setDateTimeOfBooking(Date dateTimeOfBooking) {
        this.dateTimeOfBooking = dateTimeOfBooking;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public String getSeatingClass() {
        return seatingClass;
    }

    public void setSeatingClass(String seatingClass) {
        this.seatingClass = seatingClass;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public int getMaxWeightOfLuggage() {
        return maxWeightOfLuggage;
    }

    public void setMaxWeightOfLuggage(int maxWeightOfLuggage) {
        this.maxWeightOfLuggage = maxWeightOfLuggage;
    }
}
