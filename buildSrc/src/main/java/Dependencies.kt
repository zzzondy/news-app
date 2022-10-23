object Dependencies {
    object Compose {
        const val composeVersion = "1.2.1"
        private const val materialVersion = "1.0.0-rc01"
        const val composeCompilerVersion = "1.3.0"

        // UI
        const val UI = "androidx.compose.ui:ui:$composeVersion"
        const val material3 = "androidx.compose.material3:material3:$materialVersion"

        // Tooling
        const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"
        const val previews = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
        const val testManifest = "androidx.compose.ui:ui-test-manifest:$composeVersion"

        // Coil
        const val coilCompose = "io.coil-kt:coil-compose:2.2.2"
    }

    object Lifecycle {
        private const val coreVersion = "1.9.0"
        private const val activityVersion = "1.6.0"
        private const val lifecycleRuntimeVersion = "2.5.1"

        const val core = "androidx.core:core-ktx:$coreVersion"
        const val activity = "androidx.activity:activity-compose:$activityVersion"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeVersion"
    }

    object Testing {
        const val junit = "junit:junit:4.13.2"
        const val androidJUnit = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        const val composeTests = "androidx.compose.ui:ui-test-junit4:1.2.1"
    }

    object Kotlin {
        private const val kotlinSerializationVersion = "1.0.1"

        const val kotlinSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${kotlinSerializationVersion}"
    }

    object Retrofit {
        private const val okHttpVersion = "4.9.3"
        private const val retrofitVersion = "2.9.0"

        const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"

        const val logging = "com.squareup.okhttp3:logging-interceptor:4.9.0"

        const val serialization = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
    }

    object Paging {
        const val pagingCompose = "androidx.paging:paging-compose:1.0.0-alpha16"
    }

    object Hilt {
        private const val hiltVersion = "2.44"

        const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
        const val hiltCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"
    }
}