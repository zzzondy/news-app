plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.newsappcompose"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.newsappcompose"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

//    productFlavors {
//        create("debug") {
//            dimension = "serverType"
//            buildConfigField("String", "API_URL", "\"http://api.mediastack.com/v1/news?\"")
//        }
//        create("prod") {
//            dimension = "serverType"
//            buildConfigField("String", "API_URL", "\"http://api.mediastack.com/v1/news?\"")
//        }
//    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.Lifecycle.core)
    implementation(Dependencies.Lifecycle.lifecycleRuntime)
    implementation(Dependencies.Lifecycle.activity)

    implementation(Dependencies.Compose.UI)
    implementation(Dependencies.Compose.previews)
    implementation(Dependencies.Compose.material3)
    debugImplementation(Dependencies.Compose.tooling)
    debugImplementation(Dependencies.Compose.testManifest)

    testImplementation(Dependencies.Testing.junit)
    androidTestImplementation(Dependencies.Testing.androidJUnit)
    androidTestImplementation(Dependencies.Testing.espresso)
    androidTestImplementation(Dependencies.Testing.composeTests)
}