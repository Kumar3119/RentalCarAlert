package com.aaos.rentalcarspeedalert.notification;

import com.aaos.rentalcarspeedalert.model.RentalAgreement;

public class FirebaseNotifier implements NotificationService {

    @Override
    public void notifyRentalCompany(RentalAgreement rentalAgreement, double currentSpeed) {
        // Use Firebase API to send notification
        // Example:
        //  RemoteMessage notification = new RemoteMessage.Builder("rental_company_alerts")
        //                .setMessageId(Integer.toString(currentSpeed))
        //                .addData("title", "Speed Limit Exceeded")
        //                .addData("body", "Car " + rentalAgreement.getCar().getRegistrationNumber() + " is driving at " + currentSpeed + " km/h, which is above the limit.")
        //                .build();
        //
        //  FirebaseMessaging.getInstance().send(notification);
        System.out.println("Notification sent to rental company: Car "
                + rentalAgreement.getCar().getRegistrationNumber()
                + " exceeded speed limit at " + currentSpeed + " km/h");

    }

    @Override
    public void alertUser(RentalAgreement rentalAgreement, double currentSpeed) {
        // Use Firebase API to send notification
        // Example:
       /* RemoteMessage notification = new RemoteMessage.Builder("user_alert_" + carId)
                .setMessageId(Integer.toString(currentSpeed))
                .addData("title", "Warning: Speed Limit Exceeded")
                .addData("body", "You are driving at " + currentSpeed + " km/h, which is above your limit. Please slow down.")
                .build();

        FirebaseMessaging.getInstance().send(notification);*/
        System.out.println("Notification sent to user: Car "
                + rentalAgreement.getCar().getRegistrationNumber()
                + " You are driving at " + currentSpeed + " km/h, which is above your limit. Please slow down.");

    }

}