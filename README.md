# Custom Fetch With OkHttp

hanya sebuah modul simpel untuk melakukan upload dan mengirim data via rest full

## Instalasi


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
		implementation ''
	
	}

```

* untuk penggunaan untuk mengirim data berupa teks berikut adalah contohnya : 

```
CustomFetch fetch = new CustomFetch(this,"your server url");

        fetch.SetType(CustomFetch.TypeMessage);
        fetch.AddSendStringMessageData(new SendStringMessage("Data","Hello world"));

        fetch.SetOnSendMyDataListener(new OnSendTheFetch.OnSendMyDataListener() {
            @Override
            public void OnResponse(String response, Boolean isSuccesSend) {
                
                // letakan kode anda disini setelah fetch selesai
                
            }
        });

        fetch.SetIndonesian();
        fetch.SetColor(Color.BLUE);

fetch.execute();


```


* untuk penggunaan untuk mengirim data berupa file berikut adalah contohnya : 

```
CustomFetch fetch = new CustomFetch(this,"your server url");

        fetch.SetType(CustomFetch.TypeFile);
        fetch.AddUploadFileData(UploadFileData("foto",new file("path file anda")));

        fetch.SetOnSendMyDataListener(new OnSendTheFetch.OnSendMyDataListener() {
            @Override
            public void OnResponse(String response, Boolean isSuccesSend) {
                
                // letakan kode anda disini setelah fetch selesai
                
            }
        });

        fetch.SetIndonesian();
        fetch.SetColor(Color.BLUE);

fetch.execute();


```


* pengaturan untuk bahasa indonesia/inggris :

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

	fetch.SetTheme(CustomColor);
	// set kedalam dialog


	fetch.execute();
	// eksekusi

```