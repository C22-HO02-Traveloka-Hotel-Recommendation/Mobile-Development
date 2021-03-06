package com.company.project.traveloka.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.company.project.traveloka.utils.Constant.LOGIN_DATASTORE
import javax.inject.Inject

val Context.loginDataStore by preferencesDataStore(LOGIN_DATASTORE)

class DataStoreManager @Inject constructor(context: Context)
