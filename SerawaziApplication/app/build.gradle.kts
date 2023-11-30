plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
//    id("com.google.devtools.ksp") version "1.8.10-1.0.9"
}

android {
    namespace = "com.greenrevive.serawaziapplication"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.greenrevive.serawaziapplication"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures{
        viewBinding = true
        dataBinding = true
    }


}


dependencies {

        implementation("androidx.core:core-ktx:1.12.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.10.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        implementation("com.google.firebase:firebase-inappmessaging:20.4.0")
        implementation("androidx.core:core-ktx:1.12.0")
        implementation("androidx.core:core-ktx:1.12.0")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
        implementation ("com.google.code.gson:gson:2.9.0")
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation ("androidx.room:room-runtime:2.6.0")
        implementation( "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
        implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

        implementation ("androidx.navigation:navigation-fragment-ktx:2.7.5")
        implementation ("androidx.navigation:navigation-ui-ktx:2.7.5")

         implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
         implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
         implementation ("com.squareup.okhttp3:okhttp:4.9.1")
         implementation ("com.squareup.retrofit2:retrofit:2.9.0")
         implementation ("com.squareup.retrofit2:converter-gson:2.9.0")


         implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
         implementation ("com.squareup.moshi:moshi:1.12.0")
         implementation ("com.squareup.moshi:moshi-kotlin:1.12.0")
         implementation ("androidx.activity:activity-ktx:1.8.0")
         implementation ("androidx.fragment:fragment-ktx:1.6.2")

//         implementation ("androidx.room:room-runtime:2.6.0")
//         ksp ("androidx.room:room-compiler:2.5.2")
//         ksp("androidx.room:room-compiler:2.5.2")

         implementation ("androidx.room:room-ktx:2.6.0")
         implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
         implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0-beta01")
         implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0-beta01")
         implementation ("androidx.activity:activity-ktx:1.8.0")
         implementation ("androidx.room:room-runtime:2.6.0")
         kapt("androidx.room:room-compiler:2.6.0")



//         implementation ("com.github.bumptech.glide:glide:latest_version")
//         kapt ("com.github.bumptech.glide:compiler:latest_version")




}

//fun ksp(s: String) {
//    TODO("Not yet implemented")
//}
