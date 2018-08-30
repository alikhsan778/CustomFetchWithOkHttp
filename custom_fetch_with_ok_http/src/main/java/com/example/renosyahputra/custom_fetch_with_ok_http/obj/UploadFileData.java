package com.example.renosyahputra.custom_fetch_with_ok_http.obj;

import java.io.File;
import java.io.Serializable;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class UploadFileData implements Serializable {
    public String variabelName;
    public File file;

    public UploadFileData(String variabelName, File file) {
        this.variabelName = variabelName;
        this.file = file;
    }

    public String GetFilePathSubstring(){
        String path = this.file.getAbsolutePath();
        return path.substring(path.lastIndexOf("/") + 1);
    }

    public RequestBody GetFileBody(){
        return RequestBody.create(MediaType.parse("aplication/octect-stream"), this.file);
    }
}
