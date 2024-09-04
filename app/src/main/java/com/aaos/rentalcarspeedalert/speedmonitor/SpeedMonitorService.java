package com.aaos.rentalcarspeedalert.speedmonitor;


import com.aaos.rentalcarspeedalert.model.RentalAgreement;

public interface SpeedMonitorService {
    void checkSpeed(RentalAgreement rentalAgreement, double currentSpeed);
}




