package com.example.indiandefenselovers

import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.analytics.FirebaseAnalytics


class GaEvents(context: Context) {
    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    init {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    fun sendEvent(bundle: Bundle) {
        mFirebaseAnalytics?.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }
}