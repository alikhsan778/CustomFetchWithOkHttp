# Custom Fetch With OkHttp

hanya sebuah modul simpel untuk melakukan upload dan mengirim data via rest full

## Instalasi

* jangan lupa tambahkan izin akses internet di AndroidManifest.xml

```
	...
    	<uses-permission android:name="android.permission.INTERNET"/>
	...

```


* tambahkan kedalam build.gradle : 

```

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```


* tambahkan kedalam app.gradle : 

```

	dependencies {
		...
		implementation 'com.github.renosyah:CustomFetchWithOkHttp:v0.4'
	
	}

```

* untuk penggunaan untuk mengirim data berupa teks berikut adalah contohnya : 

```

String FormName = "NAMA FORM";
String Message = "ISI PESAN";

CustomFetch fetch = new CustomFetch(this,"url server anda");

        fetch.SetType(CustomFetch.TypeMessage);
        fetch.AddSendStringMessageData(new SendStringMessage(FormName,Message));

        fetch.SetOnSendMyDataListener(new OnSendTheFetch.OnSendMyDataListener() {
            @Override
            public void OnResponse(String response, Boolean isSuccesSend) {
                
                // letakan kode anda disini setelah fetch selesai
                
            }
        });

	fetch.SetenableLoadingDialog(true);
        fetch.SetIndonesian();
        fetch.SetColor(Color.BLUE);

fetch.execute();


```


* untuk penggunaan untuk mengirim data berupa file berikut adalah contohnya : 

```

String FormName = "NAMA FORM";
File FileToUpload = new File("path file anda");

CustomFetch fetch = new CustomFetch(this,"url server anda");

        fetch.SetType(CustomFetch.TypeFile);
        fetch.AddUploadFileData(new UploadFileData(FormName,FileToUpload));

        fetch.SetOnSendMyDataListener(new OnSendTheFetch.OnSendMyDataListener() {
            @Override
            public void OnResponse(String response, Boolean isSuccesSend) {
                
                // letakan kode anda disini setelah fetch selesai
                
            }
        });

	fetch.SetenableLoadingDialog(true);
        fetch.SetIndonesian();
        fetch.SetColor(Color.BLUE);

fetch.execute();


```


* kedua-duanya dapat di sesuaikan, berapa banyak yang ingin di upload, tinggal add aja : 

```

	fetch.AddUploadFileData(new UploadFileData("NAMA FORM 1",new File("path file 1 anda")));
	fetch.AddUploadFileData(new UploadFileData("NAMA FORM 2",new File("path file 2 anda")));
	fetch.AddUploadFileData(new UploadFileData("NAMA FORM 3",new File("path file 3 anda")));
	// mengupload 3 gambar sekaligus
	
	// atau

        fetch.AddSendStringMessageData(new SendStringMessage("NAMA FORM 1","ISI PESAN 1"));
        fetch.AddSendStringMessageData(new SendStringMessage("NAMA FORM 2","ISI PESAN 2"));
        fetch.AddSendStringMessageData(new SendStringMessage("NAMA FORM 3","ISI PESAN 3"));
	// mengupload 3 pesan sekaligus
```

* jika ingin menghapus, tinggal memanggil perintah clear : 


```

	fetch.ClearSendStringMessageData(); // membersihkan list pesan

	//atau

	fetch.ClearUploadFileData(); // membersihkan list file yg ingin diupload

```


* pengaturan untuk bahasa indonesia/inggris pada dialog loading (jika diaktifkan) :

```


        fetch.SetIndonesian(); 
	//mengubah seluruh kalimat menjadi bahasa indonesia

 	fetch.SetEnglish(); 
	//mengubah seluruh kalimat menjadi bahasa inggris


```

* dialog loading dapat di sesuaikan warnanya :

```

	int CustomColor = ResourcesCompat.getColor(this.getResources(), R.color.colorPrimaryDark,null);
	// persiapkan warna yg ingin digunakan	

	fetch.SetColor(CustomColor);
	// set kedalam dialog


	fetch.execute();
	// eksekusi

```