package com.vijay.trendingnow.model

import android.os.Parcel
import android.os.Parcelable

class News() : Parcelable {
    var title: String? = null
    var details: String? = null
    var link: String? = null
    var source: String? = null

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        details = parcel.readString()
        link = parcel.readString()
        source = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(details)
        parcel.writeString(link)
        parcel.writeString(source)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<News> {
        override fun createFromParcel(parcel: Parcel): News {
            return News(parcel)
        }

        override fun newArray(size: Int): Array<News?> {
            return arrayOfNulls(size)
        }
    }
}