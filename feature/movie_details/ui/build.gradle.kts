plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.feature.movie_details.ui"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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


    implementation(project(":core:feature_api"))
    implementation(project(":core:common"))
    implementation(project(":feature:movie_details:domain"))

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

    implementation(Compose.navigation)

    implementation(DaggerHilt.hilt)
    kapt(DaggerHilt.hiltAndroidCompiler)
    implementation(DaggerHilt.hiltComposeNavigation)

    implementation(Coil.coilCompose)
}

kapt {
    correctErrorTypes = true
}