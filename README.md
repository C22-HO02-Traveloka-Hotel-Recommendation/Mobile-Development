# Traveloka Singapore (C22-HO02) - Building engine for optimizing hotel ranking based on Business Cases -Bangkit Capstone Company Project - MobileDevelopment

## App Description
Having such a varied user base and inventory brings in new challenges. One of the biggest challenges that Traveloka faces is to decipher the appropriate order in which hotels should be displayed for a user when searching on our platform. Abdool et al., in their paper, Managing Diversity in Airbnb Search, state that the probability of the user clicking on a particular hotel and eventually booking it decays as the user goes down the list of hotels displayed to the user. As a result, having a relevant ordering of these hotels for our users directly impacts the business that Traveloka brings in for its partners. We take the challenge by making a new approach to enhance hotel recommendations using a wide and deep learning network model to strike the right balance between memorization and generalization. With such a vast and varied user base, we acknowledged the fact that a one-size-fits-all solution would not have worked to cater to the varying demand and supply. There was a need to provide our users with a more personalized experience on the hotel search page.

Download Apk : https://drive.google.com/file/d/1ZmVtORMM74AcmToTudOS3KUA2qR6Qi7o/view?usp=sharing

### Screenshots
![AppScreenshots](https://raw.githubusercontent.com/robertheo15/company-project/main/My_hotel.png)

## Development

#### Requirements
* A Mac or Windows computer.
* Android Studio
* Android Virtual Device (AVD) > API 30

#### Dependencies
```Gradle
dependencies {
    implementation 'androidx.core:core-ktx:1.8.0'
    implementation 'androidx.appcompat:appcompat:1.4.2'
    implementation 'com.google.android.material:material:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.4.2'
    implementation 'androidx.navigation:navigation-ui-ktx:2.4.2'
    implementation 'com.google.android.gms:play-services-auth:20.2.0'
    implementation 'com.google.firebase:firebase-common-ktx:20.1.1'
    implementation 'com.google.firebase:firebase-auth-ktx:21.0.5'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    implementation 'androidx.fragment:fragment-ktx:1.4.1'

    //GMS Auth
    implementation 'com.google.android.gms:play-services-auth:20.2.0'
    implementation platform('com.google.firebase:firebase-bom:30.1.0')
    implementation 'com.google.firebase:firebase-auth'

    // Activity
    implementation "androidx.activity:activity-ktx:1.4.0"

    // Glide
    implementation "com.github.bumptech.glide:glide:$glide_version"
    implementation 'com.google.android.gms:play-services-maps:18.0.2'
    kapt "com.github.bumptech.glide:compiler:$glide_version"

    // Lifecycle
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"

    // Retrofit
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-moshi:$retrofit_version"

    // Okhttp
    implementation "com.squareup.okhttp3:okhttp-bom:$okhttp_version"
    implementation "com.squareup.okhttp3:logging-interceptor:$okhttp_version"

    // Moshi
    implementation "com.squareup.moshi:moshi:$moshi_version"
    implementation "com.squareup.moshi:moshi-kotlin:$moshi_version"
    kapt "com.squareup.moshi:moshi-kotlin-codegen:$moshi_version"

    // Dagger Hilt
    implementation "com.google.dagger:hilt-android:$hilt_version"
    kapt "com.google.dagger:hilt-compiler:$hilt_version"
    kaptTest "com.google.dagger:hilt-android-compiler:$hilt_version"
    androidTestImplementation "com.google.dagger:hilt-android-testing:$hilt_version"
    kaptAndroidTest "com.google.dagger:hilt-android-compiler:$hilt_version"

    // Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
    testImplementation "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines_version"

    // Paging
    implementation "androidx.paging:paging-runtime-ktx:$paging_version"
    testImplementation "androidx.paging:paging-common-ktx:$paging_version"

    // Data Store
    implementation "androidx.datastore:datastore:$datastore_version"
    implementation "androidx.datastore:datastore-core:$datastore_version"
    implementation "androidx.datastore:datastore-preferences:$datastore_version"

    //rxjava
    implementation "io.reactivex.rxjava2:rxjava:2.2.19"
    implementation "com.jakewharton.rxbinding2:rxbinding:2.0.0"
}
```

#### Plugins
```Gradle
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'kotlin-kapt'
    id 'dagger.hilt.android.plugin'
    id 'kotlin-parcelize'
    id 'com.google.android.libraries.mapsplatform.secrets-gradle-plugin'
    id 'com.google.gms.google-services'
}
```
### Clone this App

**Clone**
```bash
$ git clone https://github.com/robertheo15/company-project.git
```

**Open in Android Studio**
* `File -> Open -> Navigate to folder that you clone this repo -> Open`

**Run this project on AVD**
* `Start AVD -> Run 'app'`

**Build this app**
* `Build -> Build Bundle(s)/APK(s) -> Build APK(s)`