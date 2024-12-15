plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.restaurantapp"
    compileSdk = 35

    packagingOptions {
        resources {
            excludes += "META-INF/native-image/org.mongodb/bson/native-image.properties"
        }
    }
    defaultConfig {
        applicationId = "com.example.restaurantapp"
        minSdk = 24
        targetSdk = 34
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
        isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}



dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("org.mongodb:mongodb-driver-kotlin-coroutine:4.10.2")
    implementation("org.mongodb:bson:4.10.2")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")
    implementation("org.mongodb:mongodb-driver-sync:4.10.2")
    implementation("io.realm:realm-gradle-plugin:10.16.0")



}

