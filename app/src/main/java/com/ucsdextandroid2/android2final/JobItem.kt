package com.ucsdextandroid2.android2final

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
class JobItem(
    @SerializedName("id") var id:String?,
    @SerializedName("company") var company:String?,
    @SerializedName("location") var location:String?,
    @SerializedName("title") var title:String?,
    @SerializedName("description") var description: String?

) : Parcelable {
    fun bind(item: JobItem) {

    }
}