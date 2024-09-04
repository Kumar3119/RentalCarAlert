package com.aaos.rentalcarspeedalert.speedmonitor;

import com.aaos.rentalcarspeedalert.model.RentalAgreement;
import com.aaos.rentalcarspeedalert.notification.NotificationService;

public class SpeedMonitorServiceImpl implements SpeedMonitorService {
    private NotificationService notificationService;

    public SpeedMonitorServiceImpl(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void checkSpeed(RentalAgreement rentalAgreement, double currentSpeed) {

        if (currentSpeed > rentalAgreement.getMaxSpeedLimit()) {
            // Notify the rental company for exceeding the speed limit! via the selected notification service
            notificationService.notifyRentalCompany(rentalAgreement, currentSpeed);

            // TODO: If desired, you could also log this event to an external logging service
            // Example:
            // ExternalLoggingService.logEvent("Speed limit exceeded", ......);
            // Alert the user about exceeding the speed limit!
            notificationService.alertUser(rentalAgreement, currentSpeed);

            System.out.println("Warning: You are exceeding the speed limit!");
        }
    }


}