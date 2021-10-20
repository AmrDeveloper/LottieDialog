package com.amrdeveloper.lottiedialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RawRes;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class LottieDialog {

    private final Dialog lottieDialog;
    private final TextView lottieDialogTitle;
    private final TextView lottieDialogMessage;
    private final RelativeLayout lottieDialogLayout;
    private final LinearLayout lottieDialogButtonsLayout;
    private final LinearLayout lottieDialogAnimationContainer;
    private final LottieAnimationView lottieDialogAnimationView;

    private boolean isAutoPlayedAnimation = false;
    public static final int INFINITE = LottieDrawable.INFINITE;
    private static final int LOTTIE_DIALOG_LAYOUT = R.layout.layout_lottie_dialog;

    private static final LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams (
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT, 1);

    public LottieDialog(Context context) {
        final View view = LayoutInflater.from(context).inflate(LOTTIE_DIALOG_LAYOUT, null);

        this.lottieDialog = new Dialog(context);
        this.lottieDialog.setContentView(view);

        this.lottieDialogTitle = view.findViewById(R.id.lottie_dialog_title);
        this.lottieDialogMessage = view.findViewById(R.id.lottie_dialog_message);
        this.lottieDialogAnimationView = view.findViewById(R.id.lottie_dialog_animation);
        this.lottieDialogLayout = view.findViewById(R.id.lottie_dialog_layout);
        this.lottieDialogButtonsLayout = view.findViewById(R.id.lottie_dialog_buttons_layout);
        this.lottieDialogAnimationContainer = view.findViewById(R.id.lottie_dialog_animation_container);
    }

    public LottieDialog setTitle(String title) {
        this.lottieDialogTitle.setText(title);
        return this;
    }

    public LottieDialog setTitleColor(int color) {
        this.lottieDialogTitle.setTextColor(color);
        return this;
    }

    public LottieDialog setTitleTextSize(float size) {
        this.lottieDialogTitle.setTextSize(size);
        return this;
    }

    public LottieDialog setTitleVisibility(int visibility) {
        this.lottieDialogTitle.setVisibility(visibility);
        return this;
    }

    public LottieDialog setMessage(String message) {
        this.lottieDialogMessage.setText(message);
        return this;
    }

    public LottieDialog setMessageColor(int color) {
        this.lottieDialogMessage.setTextColor(color);
        return this;
    }

    public LottieDialog setMessageTextSize(float size) {
        this.lottieDialogMessage.setTextSize(size);
        return this;
    }

    public LottieDialog setMessageVisibility(int visibility) {
        this.lottieDialogMessage.setVisibility(visibility);
        return this;
    }

    public LottieDialog setDialogBackground(int color) {
        this.lottieDialogLayout.setBackgroundColor(color);
        return this;
    }

    public LottieDialog setDialogBackgroundDrawable(Drawable drawable) {
        this.lottieDialogLayout.setBackground(drawable);
        return this;
    }

    public LottieDialog setCancelable(boolean cancelable) {
        this.lottieDialog.setCancelable(cancelable);
        return this;
    }

    public LottieDialog setCanceledOnTouchOutside(boolean cancel) {
        this.lottieDialog.setCanceledOnTouchOutside(cancel);
        return this;
    }

    public LottieDialog setDialogHeight(int height) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(lottieDialog.getWindow().getAttributes());
        layoutParams.height = height;
        lottieDialog.getWindow().setAttributes(layoutParams);
        return this;
    }

    public LottieDialog setDialogWidth(int width) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(lottieDialog.getWindow().getAttributes());
        layoutParams.width = width;
        lottieDialog.getWindow().setAttributes(layoutParams);
        return this;
    }

    public LottieDialog setDialogHeightPercentage(float percentage) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        int heightPixels = (int) (metrics.heightPixels * percentage);
        setDialogHeight(heightPixels);
        return this;
    }

    public LottieDialog setDialogWidthPercentage(float percentage) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        int widthPixels = (int) (metrics.widthPixels * percentage);
        setDialogWidth(widthPixels);
        return this;
    }

    public LottieDialog setAnimationViewHeight(int height) {
        ViewGroup.LayoutParams layoutParams = lottieDialogAnimationContainer.getLayoutParams();
        layoutParams.height = height;
        lottieDialogAnimationContainer.setLayoutParams(layoutParams);
        return this;
    }

    public LottieDialog setAnimationViewWidth(int width) {
        ViewGroup.LayoutParams layoutParams = lottieDialogAnimationContainer.getLayoutParams();
        layoutParams.width = width;
        lottieDialogAnimationContainer.setLayoutParams(layoutParams);
        return this;
    }

    public LottieDialog setAnimation(@RawRes int rawRes) {
        this.lottieDialogAnimationView.setAnimation(rawRes);
        return this;
    }

    public LottieDialog setAnimation(Animation animation) {
        this.lottieDialogAnimationView.setAnimation(animation);
        return this;
    }

    public LottieDialog setAnimation(String assetName) {
        this.lottieDialogAnimationView.setAnimation(assetName);
        return this;
    }

    public LottieDialog setAnimationFromUrl(String url) {
        this.lottieDialogAnimationView.setAnimationFromUrl(url);
        return this;
    }

    public LottieDialog setAnimationRepeatCount(int count) {
        this.lottieDialogAnimationView.setRepeatCount(count);
        return this;
    }

    public LottieDialog setAnimationSpeed(float speed) {
        this.lottieDialogAnimationView.setSpeed(speed);
        return this;
    }

    public LottieDialog addActionButton(Button button) {
        this.lottieDialogButtonsLayout.addView(button, linearLayoutParams);
        return this;
    }

    public LottieDialog addActionButton(Button button, int index) {
        this.lottieDialogButtonsLayout.addView(button, index, linearLayoutParams);
        return this;
    }

    public LottieDialog setAutoPlayAnimation(boolean autoplay) {
        isAutoPlayedAnimation = autoplay;
        return this;
    }

    public boolean isAutoPlayedAnimation() {
        return isAutoPlayedAnimation;
    }

    public void playAnimation() {
        this.lottieDialogAnimationView.playAnimation();
    }

    public void pauseAnimation() {
        this.lottieDialogAnimationView.pauseAnimation();
    }

    public void cancelAnimation() {
        this.lottieDialogAnimationView.cancelAnimation();
    }

    public void clearAnimation() {
        this.lottieDialogAnimationView.clearAnimation();
    }

    public void reverseAnimationSpeed() {
        this.lottieDialogAnimationView.reverseAnimationSpeed();
    }

    public boolean isAnimating() {
        return lottieDialogAnimationView.isAnimating();
    }

    public void show() {
        this.lottieDialog.show();
        if (isAutoPlayedAnimation) playAnimation();
    }

    public boolean isShowing() {
        return this.lottieDialog.isShowing();
    }

    public void dismiss() {
        this.lottieDialog.dismiss();
    }

    public void cancel() {
        this.lottieDialog.cancel();
    }

    public LottieDialog setOnShowListener(DialogInterface.OnShowListener listener) {
        this.lottieDialog.setOnShowListener(listener);
        return this;
    }

    public LottieDialog setOnCancelListener(DialogInterface.OnCancelListener listener) {
        this.lottieDialog.setOnCancelListener(listener);
        return this;
    }

    public LottieDialog setOnDismissListener(DialogInterface.OnDismissListener listener) {
        this.lottieDialog.setOnDismissListener(listener);
        return this;
    }
}
