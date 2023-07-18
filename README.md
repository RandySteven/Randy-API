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


### Messages Services
#### TBA

#### Message Entity
|Field|dataType|
|-----|-------|
|ID|int|
|MessageId|string|
|Message|string|
|CreatedAt|Timestamp|
|DeletedAt|Timestamp|

### {{url}}/randy-api/v1.0/messages/add-message
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

##### Parameter Check
|Field|dataType|M/O|detail|
|-----|--------|---|------|
|responseCode|int|M||
|responseMessage|string|M||
|message|string|M|get from request|

Sample Response of POST message

```
{
  "responseCode": 201,
  "responseMessage": "isi hati anda sudah tersampaikan",
  "message": "Hallo bebs."
}
```

### /randy-api/v1.0/messages
#### Parameter Check

|Field|dataType|M/O|details|
|-----|--------|---|-------|
|responseCode|int|M|response code|
|responseMessage|string|M|response message|
|messages|Array of object|M|list of messages|

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

#### /randy-steven/v1.0/karaoke/group/add-group

##### Parameter Check

###### Request
|Field|dataType|M/O|details|
|-----|--------|---|-------|
|groupName|string|M|the name of group min length 3 max length 32|
|groupPassword|string|O|you can add password if you want|

###### Response
|Field|dataType|M/O|details|
|-----|--------|---|-------|
|responseCode|int|M|response code|
|responseMessage|string|M|response message|
|success|boolean|M|success to create the group|
|groupAccessToken|string|M|group access token use SHA-512 using input groupName + groupPassword|


###### Sample Request
```
{
    "groupName":"",
    "groupPassword": ""
}
```

###### Sample Response
```
{
    "responseMessage": "Created",
    "responseCode": 201,
    "success": true,
    "groupAccessToken": "17d1111b91ba1691d01091d110017112816313d1e310b1991d11ea11e11a1fe1d81d11a71b01ad1a21f91131ad1a41431091f417e1cf1481cd1a619e1ff10c16816c1cd1421ab1071d412c1ff14110b11d1201ce11511a1ee12d14c16b1e11d4"
}
```

### {{url}}/randy-steven/v1.0/karaoke/groups
#### Parameter check
##### Response
|Field|dataType|M/O|details|
|-----|--------|---|-------|
|responseCode|int|M||
|responseMessage|string|M||
|success|boolean|M||
|totalGroup|int|M||
|groups|Array of Object|M||

##### Response Body
```
{
    "responseCode": 200,
    "responseMessage": "OK",
    "success": true,
    "totalGroup": 2,
    "groups": [
        {
            "groupName": "Elmore City",
            "groupUrl": "http://localhost:8080/randy-steven/v1.0/karaoke/groups/GRP4QC2DGSL120Z30GK"
        },
        {
            "groupName": "Cibai",
            "groupUrl": "http://localhost:8080/randy-steven/v1.0/karaoke/groups/GRPP81EAHEA756HYOGA"
        }
    ]
}
```

#### Song
|Method|URL|
|------|---|
|GET|{{url}}/randy-steven/v1.0/karaoke/songs/:groupId|
|POST|{{url}}/randy-steven/v1.0/karaoke/songs/insert-song|
|PATCH|{{url}}/randy-steven/v1.0/karaoke/songs/:id|
|PATCH|{{url}}/randy-steven/v1.0/karaoke/songs/add-lyric/:songId|
|GET|{{url}}/randy-steven/v1.0/karaoke/songs/song/:songId|
