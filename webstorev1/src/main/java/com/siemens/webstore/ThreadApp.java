package com.siemens.webstore;

import com.github.javafaker.Faker;
import com.siemens.webstore.models.Booking;
import com.siemens.webstore.models.GuestUser;
import com.siemens.webstore.services.BookingThread;
import com.siemens.webstore.services.NameAnimation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class ThreadApp {

    public static void main(String... args){
        //NameAnimation nameAnimation=new NameAnimation("Parameswari");
        //nameAnimation.start();
/*
        GuestUser guestUser=new GuestUser("Parameswari");
        Thread thread=new Thread(guestUser);
        thread.start();
*/

        //synchronization
        Faker faker=new Faker();
        Booking booking=new Booking(faker.random().nextInt(10000,1000000), LocalDate.now()
                .plus(faker.random().nextInt(2,5), ChronoUnit.DAYS),faker.random().nextInt(500,1000));
        BookingThread bookingThread1=new BookingThread(booking,"booking-1");
        BookingThread bookingThread2=new BookingThread(booking,"booking-2");
        BookingThread bookingThread3=new BookingThread(booking,"booking-3");
        BookingThread bookingThread4=new BookingThread(booking,"booking-4");



        //System.out.println(Thread.currentThread().getName());
    }
}
