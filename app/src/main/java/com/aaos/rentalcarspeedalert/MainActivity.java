package com.aaos.rentalcarspeedalert;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.aaos.rentalcarspeedalert.model.Car;
import com.aaos.rentalcarspeedalert.model.RentalAgreement;
import com.aaos.rentalcarspeedalert.model.Renter;
import com.aaos.rentalcarspeedalert.notification.AWSNotifier;
import com.aaos.rentalcarspeedalert.notification.FirebaseNotifier;
import com.aaos.rentalcarspeedalert.notification.NotificationService;
import com.aaos.rentalcarspeedalert.speedmonitor.SpeedMonitorService;
import com.aaos.rentalcarspeedalert.speedmonitor.SpeedMonitorServiceImpl;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Firebase and AWS SNS clients

        NotificationService firebaseNotificationService = new FirebaseNotifier();
        NotificationService awsNotificationService = new AWSNotifier();
        SpeedMonitorService speedMonitorService = new SpeedMonitorServiceImpl(firebaseNotificationService);

        // TODO For Aws Notification using this  SpeedMonitorService speedMonitorService = new SpeedMonitorServiceImpl(awsNotificationService);

        // TODO  Set the temp static data
        // Create a Car instance with example data
        Car car = new Car("C001", "Honda", "AB123CD", 100.0);
        // Create a Renter instance with example data
        Renter renter = new Renter("R001", "ABC", "ABC@example.com");
        // Create a RentalAgreement instance with the Car and Renter
        RentalAgreement rentalAgreement = new RentalAgreement(renter, car, car.getMaxSpeedLimit(), new Date(), null);

        try {
            // Set speed limit (e.g., 100 km/h)
            int speedLimit = 100;
            // Monitor for an hour (3600 seconds)
            long monitoringDuration = 3600 * 1000L;
            long startTime = System.currentTimeMillis();

            while (System.currentTimeMillis() - startTime < monitoringDuration) {
                // TODO Example checkspeed of rentalcar by passing RentalAgreement object
                speedMonitorService.checkSpeed(rentalAgreement, speedLimit);
                // Check speed in every 5 seconds
                Thread.sleep(5000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


