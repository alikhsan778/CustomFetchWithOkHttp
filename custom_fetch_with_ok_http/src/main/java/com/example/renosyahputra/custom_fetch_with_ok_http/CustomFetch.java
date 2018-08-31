package com.example.renosyahputra.custom_fetch_with_ok_http;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;

import com.example.renosyahputra.custom_fetch_with_ok_http.obj.SendStringMessage;
import com.example.renosyahputra.custom_fetch_with_ok_http.obj.UploadFileData;
import com.example.renosyahputra.custom_fetch_with_ok_http.callBack.OnSendTheFetch;
import com.example.renosyahputra.custom_fetch_with_ok_http.customAlertDialog.CustomDialogLoading;
import com.example.renosyahputra.custom_fetch_with_ok_http.lang.LangObj;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import static com.example.renosyahputra.custom_fetch_with_ok_http.res.CustomFetchRes.SetRequestBodyForFile;
import static com.example.renosyahputra.custom_fetch_with_ok_http.res.CustomFetchRes.SetRequestBodyForMessage;

public class CustomFetch extends AsyncTask<Void,Void,String>{

    public static final String TypeMessage = "MESSAGE";
    public static final String TypeFile = "FILE";


    private Context context;
    private String Url;
    private OnSendTheFetch.OnSendMyDataListener onSendMyDataListener;
    private LangObj lang = new LangObj();
    private int color = 0;
    CustomDialogLoading customDialogLoading = new CustomDialogLoading();


    public CustomFetch(Context context, String url) {
        this.context = context;
        this.Url = url;
    }

    public void SetOnSendMyDataListener(OnSendTheFetch.OnSendMyDataListener onSendMyDataListener) {
        this.onSendMyDataListener = onSendMyDataListener;
    }

    private OkHttpClient client_upload = new OkHttpClient();
    private RequestBody requestBody;
    private String typeFetch = "";

    private ArrayList<SendStringMessage> sendStringMessagesArray = new ArrayList<>();
    private ArrayList<UploadFileData> uploadFileDataArray = new ArrayList<>();

    public void SetEnglish(){
        lang.SetEnglish();
    }

    public void SetColor(int color){
        this.color = color;
    }

    public void SetIndonesian(){
        lang.SetIndonesian();
    }

    public void SetType(String typeFetch){
        this.typeFetch = typeFetch;
    }

    public void AddSendStringMessageData(SendStringMessage sendStringMessage){
        sendStringMessagesArray.add(sendStringMessage);
    }

    public void AddUploadFileData(UploadFileData uploadFileData){
        uploadFileDataArray.add(uploadFileData);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        if (lang.TitleLoading.equals("")){
            this.SetEnglish();
        }

        if(color == 0){
            color = Color.BLUE;
        }


        customDialogLoading.ShowCustomDialogLoading(context,lang.TitleLoading,lang.MessageLoading,lang,color);

        if (typeFetch.equals(TypeFile)){

            requestBody = SetRequestBodyForFile(uploadFileDataArray);

        }else if (typeFetch.equals(TypeMessage)){

            requestBody = SetRequestBodyForMessage(sendStringMessagesArray);

        }

    }

    @Override
    protected String doInBackground(Void... voids) {
        String s = "";
        try {
            Request request = new Request.Builder().url(Url).post(requestBody).build();
            okhttp3.Response response = client_upload.newCall(request).execute();
            s += response.body().string();

        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }



    @Override
    protected void onPostExecute(String s) {
        
	if (onSendMyDataListener != null && customDialogLoading != null){
        	onSendMyDataListener.OnResponse(s,(!s.equals("")));
        	customDialogLoading.Dismiss();
	}

	super.onPostExecute(s);
    }

    @Override
    protected void onCancelled(String s) {
        
	if (onSendMyDataListener != null && customDialogLoading != null){
        	onSendMyDataListener.OnResponse(s,false);
        	customDialogLoading.Dismiss();
	}

	super.onCancelled(s);
    }

    @Override
    protected void onCancelled() {
       	if (onSendMyDataListener != null && customDialogLoading != null){
        	onSendMyDataListener.OnResponse("",false);
        	customDialogLoading.Dismiss();
	}

	super.onCancelled();
    }
}
