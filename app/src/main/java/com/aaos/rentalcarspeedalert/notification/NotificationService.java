package com.aaos.rentalcarspeedalert.notification;

import com.aaos.rentalcarspeedalert.model.RentalAgreement;

public interface NotificationService {
    void notifyRentalCompany(RentalAgreement rentalAgreement, double currentSpeed);

    void alertUser(RentalAgreement rentalAgreement, double currentSpeed);


}
