# R.A.N.D.Y-API
Randy API is an API that build for myself Randy. This features anonymous message, about me, etc (idk, if i've any ideas i will add it). 
|||
|---|---|
|R|Random|
|A|Access|
|N|Nerd|
|D|Database|
|Y|iYohohohoho|


It will includes `GET` & `POST` method
|URL|METHOD|
|---|----|
|`{{url}}/v1.0/randy-api/`|`GET`|
|`{{url}}/v1.0/randy-api/messages/add-message`|`POST`|
|`{{url}}/v1.0/randy-api/messages/`|`GET`|

Sample Request of POST message
```
{
  "message":"Hallo bebs."
}
```

Sample Response of POST message
```
{
  "responseCode": 201,
  "responseMessage": "isi hati anda sudah tersampaikan",
  "message": "Hallo bebs."
}
```

Sample Response of GET messages
```
{
  "responseCode": 200,
  "responseMessage": "Lihatlah semua isi hati orang-orang",
  "messages": [
    {
      "message":"Hallo bebs.",
      "created_at":"2023-11-02"
    },
    {
      "message":"I love you, you love me, we are happy family",
      "created_at":"2023-12-01"
    }
  ]

}
```
