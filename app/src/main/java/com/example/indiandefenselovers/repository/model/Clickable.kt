package com.example.indiandefenselovers.repository.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Clickable(
    @SerializedName("title") val title: String?,
    @SerializedName("subTitle1") val subTitleA: String?,
    @SerializedName("subTitle2") val subTitleB: String?,
    @SerializedName("link") val link: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("param1") val param1: String?,
    @SerializedName("param2") val param2: String?,
    @SerializedName("param3") val param3: String?,
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(subTitleA)
        parcel.writeString(subTitleB)
        parcel.writeString(link)
        parcel.writeString(image)
        parcel.writeString(param1)
        parcel.writeString(param2)
        parcel.writeString(param3)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Clickable> {
        override fun createFromParcel(parcel: Parcel): Clickable {
            return Clickable(parcel)
        }

        override fun newArray(size: Int): Array<Clickable?> {
            return arrayOfNulls(size)
        }
    }
}