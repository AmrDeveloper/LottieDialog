package com.amrdeveloper.lottiedialoglibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import com.amrdeveloper.lottiedialog.LottieDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.launch_success_dialog).setOnClickListener(view -> launchSuccessLottieDialog());
        findViewById(R.id.launch_notification_dialog).setOnClickListener(view -> launchNotificationLottieDialog());
        findViewById(R.id.launch_location_dialog).setOnClickListener(view -> launchLocationLottieDialog());
        findViewById(R.id.launch_internet_dialog).setOnClickListener(view -> launchInternetLottieDialog());
    }

    private void launchSuccessLottieDialog() {
        Button button = new Button(this);
        button.setText("Ok");
        button.setTextColor(Color.WHITE);
        int greenColor = ContextCompat.getColor(this, R.color.green);
        button.setBackgroundTintList(ColorStateList.valueOf(greenColor));

        LottieDialog dialog = new LottieDialog(this)
                .setAnimation(R.raw.success_like)
                .setAnimationRepeatCount(LottieDialog.INFINITE)
                .setAutoPlayAnimation(true)
                .setDialogBackground(Color.WHITE)
                .setMessage("Task is Done :D")
                .setMessageColor(greenColor)
                .addActionButton(button);

        dialog.show();
    }

    private void launchNotificationLottieDialog() {
        Button button = new Button(this);
        button.setText("See it");
        button.setTextColor(Color.WHITE);
        button.setAllCaps(false);
        int purpleColor = ContextCompat.getColor(this, R.color.purple);
        button.setBackgroundTintList(ColorStateList.valueOf(purpleColor));

        LottieDialog dialog = new LottieDialog(this)
                .setAnimation(R.raw.purple_notification)
                .setAnimationRepeatCount(LottieDialog.INFINITE)
                .setAutoPlayAnimation(true)
                .setDialogBackground(Color.WHITE)
                .setMessage("You got a new notification!")
                .setMessageColor(purpleColor)
                .addActionButton(button);

        dialog.show();
    }

    private void launchLocationLottieDialog() {
        Button button = new Button(this);
        button.setText("Open GPS");
        button.setTextColor(Color.WHITE);
        button.setAllCaps(false);
        int purpleColor = ContextCompat.getColor(this, R.color.purple);
        button.setBackgroundTintList(ColorStateList.valueOf(purpleColor));

        LottieDialog dialog = new LottieDialog(this)
                .setAnimation(R.raw.location)
                .setAutoPlayAnimation(true)
                .setAnimationRepeatCount(LottieDialog.INFINITE)
                .setMessage("Can't get your location")
                .setMessageColor(purpleColor)
                .addActionButton(button);

        dialog.show();
    }

    private void launchInternetLottieDialog() {
        Button button = new Button(this);
        button.setText("Retry");
        button.setTextColor(Color.WHITE);
        button.setAllCaps(false);
        int purpleColor = ContextCompat.getColor(this, R.color.green);
        button.setBackgroundTintList(ColorStateList.valueOf(purpleColor));

        LottieDialog dialog = new LottieDialog(this)
                .setAnimation(R.raw.no_internet)
                .setAutoPlayAnimation(true)
                .setAnimationRepeatCount(LottieDialog.INFINITE)
                .setMessage("You have no internet connection")
                .addActionButton(button);

        dialog.show();
    }
}