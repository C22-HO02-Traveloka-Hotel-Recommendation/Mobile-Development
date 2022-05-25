package com.company.project.traveloka.data.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.company.project.traveloka.utils.constant.LOGIN_DATASTORE
import javax.inject.Inject

val Context.loginDataStore by preferencesDataStore(LOGIN_DATASTORE)

class DataStoreManager @Inject constructor(context: Context)
