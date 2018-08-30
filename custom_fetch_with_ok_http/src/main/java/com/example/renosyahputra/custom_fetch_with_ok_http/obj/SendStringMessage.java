package com.example.renosyahputra.custom_fetch_with_ok_http.obj;

import java.io.Serializable;

public class SendStringMessage implements Serializable {
    public String variabelName;
    public String message;

    public SendStringMessage(String variabelName, String message) {
        this.variabelName = variabelName;
        this.message = message;
    }
}
