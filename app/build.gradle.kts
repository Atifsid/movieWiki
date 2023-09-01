plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.moviewiki"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.moviewiki"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":feature:movie:ui"))
    implementation(project(":feature:movie:domain"))
    implementation(project(":feature:movie:data"))

    implementation(project(":feature:movie_details:ui"))
    implementation(project(":feature:movie_details:domain"))
    implementation(project(":feature:movie_details:data"))

    implementation(project(":core:common"))
    implementation(project(":core:feature_api"))

    implementation(Deps.core)
    implementation(Deps.androidLifeCycle)
    implementation(Compose.activityCompose)
    implementation(platform(Compose.composeBom))
    implementation(Compose.composeUi)
    implementation(Compose.composeUiGraphics)
    implementation(Compose.uiToolingPreview)
    implementation(Compose.material3)
    testImplementation(TestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espressoCore)
    androidTestImplementation(platform(AndroidTestImplementation.androidTestComposeBom))
    androidTestImplementation(AndroidTestImplementation.composeUiTestjunit)
    debugImplementation(DebugImplementation.composeUiTooling)
    debugImplementation(DebugImplementation.composeUiTestManifest)

    implementation(DaggerHilt.hilt)
    kapt(DaggerHilt.hiltAndroidCompiler)

    implementation(Compose.navigation)
}

kapt {
    correctErrorTypes = true
}