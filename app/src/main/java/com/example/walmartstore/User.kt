package com.example.walmartstore

data class User(var firstName:String = "" ,var lastName:String = "",var userName:UserName){
    data class UserName(var email:String ,var password:String)
}
