package com.example.walmartstore

import android.os.Parcel
import android.os.Parcelable

data class User(var firstName: String? = "", var lastName: String? = "", var userName: UserName?) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(UserName::class.java.classLoader)
    ) {
    }

    data class UserName(var email:String?, var password: String?) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(email)
            parcel.writeString(password)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<UserName> {
            override fun createFromParcel(parcel: Parcel): UserName {
                return UserName(parcel)
            }

            override fun newArray(size: Int): Array<UserName?> {
                return arrayOfNulls(size)
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeParcelable(userName, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}
