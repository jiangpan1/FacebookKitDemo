package com.panshi.facebookkit;

import android.app.Fragment;
import android.os.Parcel;
import android.support.annotation.Nullable;

import com.facebook.accountkit.AccountKitError;
import com.facebook.accountkit.ui.BaseUIManager;
import com.facebook.accountkit.ui.ButtonType;
import com.facebook.accountkit.ui.LoginFlowState;
import com.facebook.accountkit.ui.LoginType;
import com.facebook.accountkit.ui.TextPosition;

public class MyAdvancedUIManager extends BaseUIManager {

    private final ButtonType confirmButton;
    private final ButtonType entryButton;
    private final TextPosition textPosition;
    private int type;

    public MyAdvancedUIManager(
            final ButtonType confirmButton,
            final ButtonType entryButton,
            final LoginType loginType,
            final TextPosition textPosition,
            final int themeResourceId

    ) {
        super(themeResourceId);
        this.confirmButton = confirmButton;
        this.entryButton = entryButton;
        this.textPosition = textPosition;

    }

    private MyAdvancedUIManager(final Parcel source) {
        super(source);
        String s = source.readString();
        final ButtonType confirmButton = s == null ? null : ButtonType.valueOf(s);
        s = source.readString();
        final ButtonType entryButton = s == null ? null : ButtonType.valueOf(s);
        s = source.readString();
        final TextPosition textPosition = s == null ? null : TextPosition.valueOf(s);
        this.confirmButton = confirmButton;
        this.entryButton = entryButton;
        this.textPosition = textPosition;
    }

    @Nullable
    @Override
    public Fragment getHeaderFragment(LoginFlowState state) {
        HeaderFragment headerFragment = null;
        switch (state) {
            case PHONE_NUMBER_INPUT:
            /*case EMAIL_INPUT:
            case EMAIL_VERIFY:
            case SENDING_CODE:
            case SENT_CODE:
            case CODE_INPUT:
            case VERIFYING_CODE:
            case VERIFIED:
            case ACCOUNT_VERIFIED:
            case CONFIRM_ACCOUNT_VERIFIED:
            case CONFIRM_INSTANT_VERIFICATION_LOGIN:
                // insert appropriate customizations for headerFragment
            case ERROR:
                // handle appropriate error for headerFragment
            default:*/
                headerFragment = new HeaderFragment();
                break;
        }
        return headerFragment;
    }

    @Nullable
    @Override
    public Fragment getFooterFragment(LoginFlowState state) {
        FooterFragment footerFragment = null;
       switch (state) {
          case PHONE_NUMBER_INPUT:
            /*case EMAIL_INPUT:
            case EMAIL_VERIFY:
            case SENDING_CODE:
            case SENT_CODE:
            case CODE_INPUT:
            case VERIFYING_CODE:
            case VERIFIED:
            case ACCOUNT_VERIFIED:
            case CONFIRM_ACCOUNT_VERIFIED:
            case CONFIRM_INSTANT_VERIFICATION_LOGIN:
                // insert appropriate customizations for headerFragment
            case ERROR:
                // handle appropriate error for headerFragment
            default:*/
                footerFragment = new FooterFragment();
              break;
      }
        return footerFragment;
    }

    public @Nullable
    ButtonType getButtonType(final LoginFlowState state) {
        switch (state) {
            case PHONE_NUMBER_INPUT:
                return entryButton;
            case EMAIL_INPUT:
                return entryButton;
            case CODE_INPUT:
                return confirmButton;
            default:
                return null;
        }
    }

    @Override
    public void onError(final AccountKitError error) {
        // handle error
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(confirmButton != null ? confirmButton.name() : null);
        dest.writeString(entryButton != null ? entryButton.name() : null);
        dest.writeString(textPosition != null ? textPosition.name() : null);
    }

    public static final Creator<MyAdvancedUIManager> CREATOR
            = new Creator<MyAdvancedUIManager>() {
        @Override
        public MyAdvancedUIManager createFromParcel(final Parcel source) {
            return new MyAdvancedUIManager(source);
        }

        @Override
        public MyAdvancedUIManager[] newArray(final int size) {
            return new MyAdvancedUIManager[size];
        }
    };

    @Override
    public void setUIManagerListener(UIManagerListener listener) {
        super.setUIManagerListener(listener);
    }
}