package com.bhavesh.airbnbapp.service;

import com.bhavesh.airbnbapp.entity.Booking;

public interface CheckoutService {

    String getCheckoutSession(Booking booking, String successUrl, String failureUrl);


}
