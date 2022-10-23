plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "API_KEY", "\"aa7a7d3e94b0974d35256095ceb18f57\"")
            buildConfigField("String", "API_URL", "\"http://api.mediastack.com/v1/\"")
        }
        debug {
            isMinifyEnabled = false
            buildConfigField("String", "API_KEY", "\"aa7a7d3e94b0974d35256095ceb18f57\"")
            buildConfigField("String", "API_URL", "\"http://api.mediastack.com/v1/\"")
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
        kotlinCompilerExtensionVersion = Dependencies.Compose.composeCompilerVersion
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
    implementation(Dependencies.Compose.coilCompose)
    debugImplementation(Dependencies.Compose.tooling)
    debugImplementation(Dependencies.Compose.testManifest)

    implementation(Dependencies.Kotlin.kotlinSerialization)
    implementation(Dependencies.Retrofit.serialization)

    implementation(Dependencies.Retrofit.okHttp)
    implementation(Dependencies.Retrofit.retrofit)
    debugImplementation(Dependencies.Retrofit.logging)

    implementation(Dependencies.Paging.pagingCompose)

    implementation(Dependencies.Hilt.hilt)
    implementation(Dependencies.Hilt.hiltCompose)
    kapt(Dependencies.Hilt.hiltAndroidCompiler)
    kapt(Dependencies.Hilt.hiltCompiler)

    testImplementation(Dependencies.Testing.junit)
    androidTestImplementation(Dependencies.Testing.androidJUnit)
    androidTestImplementation(Dependencies.Testing.espresso)
    androidTestImplementation(Dependencies.Testing.composeTests)
}