package com.mirzayogy.bengkelban.model

import android.os.Parcel
import android.os.Parcelable

class Bengkel() : Parcelable {
    var id: String? = null
    var name: String? = null
    var owner: String? = null
    var photo: String? = null
    var car: String? = null
    var bike: String? = null
    var lat: String? = null
    var lng: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        name = parcel.readString()
        owner = parcel.readString()
        photo = parcel.readString()
        car = parcel.readString()
        bike = parcel.readString()
        lat = parcel.readString()
        lng = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(owner)
        parcel.writeString(photo)
        parcel.writeString(car)
        parcel.writeString(bike)
        parcel.writeString(lat)
        parcel.writeString(lng)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Bengkel> {
        override fun createFromParcel(parcel: Parcel): Bengkel {
            return Bengkel(parcel)
        }

        override fun newArray(size: Int): Array<Bengkel?> {
            return arrayOfNulls(size)
        }
    }
}