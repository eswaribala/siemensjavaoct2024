package com.siemens.webstore.services;

import com.siemens.webstore.models.Booking;

public class BookingThread implements Runnable{

    private Booking booking;

    public BookingThread(Booking booking, String name){

        this.booking=booking;
        new Thread(this,name).start();
    }

    @Override
    public void run() {

        synchronized (booking){
            System.out.println(Thread.currentThread().getName());
            this.booking.bookTicket();
        }

    }
}
