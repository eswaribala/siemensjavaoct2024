package com.siemens.webstore.models;

import java.time.LocalDate;

public class Booking {
    private long bookingId;
    private LocalDate bookingDate;

    private int cost;

    public Booking() {
    }

    public Booking(long bookingId, LocalDate bookingDate, int cost) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.cost = cost;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean bookTicket(){
        if((LocalDate.now().isBefore(bookingDate))&&(this.cost>0))
            return true;
        else
            return false;
    }
}
