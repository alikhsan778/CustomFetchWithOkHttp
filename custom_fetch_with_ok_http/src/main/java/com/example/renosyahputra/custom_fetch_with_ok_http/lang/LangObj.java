package com.example.renosyahputra.custom_fetch_with_ok_http.lang;

import java.io.Serializable;

public class LangObj implements Serializable {


    public String Cancel;
    public String Ok;

    public String UserCancelMessage;

    public String TitleLoading;
    public String MessageLoading;

    public void SetEnglish(){
        this.Cancel = "Cancel";
        this.Ok = "Ok";
        this.UserCancelMessage = "Fetch Is Canceled!";
        this.TitleLoading = "Send";
        this.MessageLoading = "Sending data, please wait!";
    }

    public void SetIndonesian(){
        this.Cancel = "Batal";
        this.Ok = "Ok";
        this.UserCancelMessage = "Fetch Dibatalkan!";
        this.TitleLoading = "Mengirim";
        this.MessageLoading = "Mengirim data, harap menunggu!";
    }
}
