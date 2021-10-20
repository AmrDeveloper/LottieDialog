package com.amrdeveloper.lottiedialoglibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.amrdeveloper.lottiedialog.LottieDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LottieDialog dialog = new LottieDialog(this)
                .setAnimation(R.raw.success_like)
                .setAnimationRepeatCount(LottieDialog.INFINITE)
                .setAutoPlayAnimation(true)
                .setTitle("LottieDialog Title")
                .setTitleColor(Color.WHITE)
                .setTitleTextSize(18)
                .setMessage("LottieDialog Message")
                .setMessageColor(Color.WHITE)
                .setDialogBackground(Color.BLACK)
                .setMessageTextSize(19)
                .setCancelable(false)
                .addActionButton(generateIdenticalButton("Ok1"))
                .addActionButton(generateIdenticalButton("Ok2"))
                .addActionButton(generateIdenticalButton("Ok3"))
                .addActionButton(generateIdenticalButton("Ok4"))
                .addActionButton(generateIdenticalButton("Ok5"))
                .setOnShowListener(dialogInterface -> {})
                .setOnDismissListener(dialogInterface -> {})
                .setOnCancelListener(dialogInterface -> {});
        dialog.show();
    }

    public Button generateIdenticalButton(String text) {
        Button button = new Button(this);
        button.setText(text);
        button.setAllCaps(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            button.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
        }
        button.setOnClickListener(view -> Log.d("LottieDialog", "Button click " + text));
        return button;
    }
}