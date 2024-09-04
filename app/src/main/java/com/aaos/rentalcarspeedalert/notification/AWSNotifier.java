package com.aaos.rentalcarspeedalert.notification;

import com.aaos.rentalcarspeedalert.model.RentalAgreement;

public class AWSNotifier implements NotificationService {

    @Override
    public void notifyRentalCompany(RentalAgreement rentalAgreement, double currentSpeed) {
        // TODO: Call AWS SNS or another AWS service to send a notification to the rental company

        String message = "Car " + rentalAgreement.getCar().getRegistrationNumber() + " exceeded the speed limit with " + currentSpeed + " km/h.";
        sendNotification("arn:aws:sns:your-region:your-account-id:RentalCompanyAlerts", "Speed Limit Exceeded", message);

        System.out.println("Notification sent to rental company via AWS: Car "
                + rentalAgreement.getCar().getRegistrationNumber()
                + " exceeded speed limit at " + currentSpeed + " km/h");
    }

    @Override
    public void alertUser(RentalAgreement rentalAgreement, double currentSpeed) {
        // TODO: Call AWS SNS or another AWS service to send a notification to the user

        String message = "Warning: Car " + rentalAgreement.getCar().getRegistrationNumber() +
                "You are driving at " + currentSpeed + " km/h, which is above your limit. Please slow down.";
        sendNotification("arn:aws:sns:your-region:your-account-id:UserAlerts", "Speed Alert", message);
    }

    private void sendNotification(String topicArn, String subject, String message) {
        // Example code might look like this:
       /*
        SNSMobileClient snsClient = new SNSMobileClient();
        PublishRequest request = new PublishRequest()
                .withTopicArn(topicArn)
                .withSubject(subject)
                .withMessage(message);

        PublishResult result = snsClient.publish(request);*/
        System.out.println("Notification sent via AWS SNS. Status");
    }

}