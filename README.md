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
|`{{url}}/randy-api/v1.0/`|`GET`|
|`{{url}}/randy-api/v1.0/messages/add-message`|`POST`|
|`{{url}}/randy-api/v1.0/messages/`|`GET`|
|`{{url}}/randy-api/v1.0/karaokes/`|`GET`|


### Messages Services
#### TBA

##### Parameter Check
|Field|dataType|M/O|Detail|
|-----|--------|-|------|
|message|string|M|minLength:3, maxLength : 32|

Sample Request of POST message
```
{
  "message":"Hallo bebs."
}
```

Sample Response of POST message
##### Parameter Check
|Field|dataType|M/O|detail|
|-----|--------|---|------|
|responseCode|int|M||
|responseMessage|string|M||
|message|string|M|get from request|

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

### Karaoke Services
<p>Karaoke services is where you can put your own songs that you want to sing</p>
There will 2 entities
- Group
- Song

##### Group
|Method|URL|
|------|---|
|GET|{{url}}/randy-steven/v1.0/karaoke/groups|
|GET|{{url}}/randy-steven/v1.0/karaoke/groups/:groupId|
|POST|{{url}}/randy-steven/v1.0/karaoke/groups/add-group|

#### Song
|Method|URL|
|------|---|
|GET|{{url}}/randy-steven/v1.0/karaoke/songs/:groupId|
|POST|{{url}}/randy-steven/v1.0/karaoke/songs/insert-song|
|PATCH|{{url}}/randy-steven/v1.0/karaoke/songs/:id|
|PATCH|{{url}}/randy-steven/v1.0/karaoke/songs/add-lyric/:songId|
|GET|{{url}}/randy-steven/v1.0/karaoke/songs/song/:songId|
