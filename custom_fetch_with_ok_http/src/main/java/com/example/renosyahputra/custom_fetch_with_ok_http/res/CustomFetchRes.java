package com.example.renosyahputra.custom_fetch_with_ok_http.res;

import com.example.renosyahputra.custom_fetch_with_ok_http.obj.SendStringMessage;
import com.example.renosyahputra.custom_fetch_with_ok_http.obj.UploadFileData;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class CustomFetchRes {
    public static RequestBody SetRequestBodyForFile(ArrayList<UploadFileData> UploadFileDataArray){

        MultipartBody.Builder multipartBody = new MultipartBody.Builder();
        multipartBody.setType(MultipartBody.FORM);

        for (UploadFileData uploadFileData : UploadFileDataArray){
            multipartBody.addFormDataPart(uploadFileData.variabelName,uploadFileData.GetFilePathSubstring(),uploadFileData.GetFileBody());
        }
        return multipartBody.build();
    }

    public static RequestBody SetRequestBodyForMessage(ArrayList<SendStringMessage> sendStringMessagesArray){

        MultipartBody.Builder multipartBody = new MultipartBody.Builder();
        multipartBody.setType(MultipartBody.FORM);

        for (SendStringMessage sendStringMessages : sendStringMessagesArray){
            multipartBody.addFormDataPart(sendStringMessages.variabelName,sendStringMessages.message);
        }
        return multipartBody.build();
    }
}
