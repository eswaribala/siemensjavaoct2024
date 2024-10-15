package com.siemens.webstore.services;

import com.siemens.webstore.models.GuestUser;

import java.util.Comparator;

public class GuestUserService implements Comparator<GuestUser> {
    @Override
    public int compare(GuestUser guestUser1, GuestUser guestUser2) {
        return guestUser1.email.compareTo(guestUser2.email);
    }
}
