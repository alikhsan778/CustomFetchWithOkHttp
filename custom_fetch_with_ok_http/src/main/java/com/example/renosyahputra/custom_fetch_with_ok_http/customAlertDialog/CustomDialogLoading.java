package com.example.renosyahputra.custom_fetch_with_ok_http.customAlertDialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.renosyahputra.custom_fetch_with_ok_http.R;
import com.example.renosyahputra.custom_fetch_with_ok_http.lang.LangObj;

public class CustomDialogLoading {

    private AlertDialog dialog;

    public void Dismiss(){
        if (dialog != null){
            dialog.dismiss();
        }
    }

    public void ShowCustomDialogLoading(final Context context, String title, String message, final LangObj lang, int color) {
         dialog = new AlertDialog.Builder(context)
                .setNegativeButton(lang.Cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Toast.makeText(context,lang.UserCancelMessage,Toast.LENGTH_SHORT).show();
                    }
                }).create();

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View v = inflater.inflate(R.layout.loading_dialog,null);

        LinearLayout bar = v.findViewById(R.id.barDialogLoading);
        bar.setBackgroundColor(color);

        TextView titleBar = v.findViewById(R.id.titleDialogLoading);
        titleBar.setText(title);
        titleBar.setTextColor(Color.WHITE);

        TextView messageBar = v.findViewById(R.id.messageDialogLoading);
        messageBar.setText(message);
        messageBar.setTextColor(color);

        dialog.setView(v);
        dialog.show();
    }
}
