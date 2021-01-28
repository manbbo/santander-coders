package com.example.desafiofinal.viewmodels

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainViewModel> {
        override fun createFromParcel(parcel: Parcel): MainViewModel {
            return MainViewModel(parcel)
        }

        override fun newArray(size: Int): Array<MainViewModel?> {
            return arrayOfNulls(size)
        }
    }
}