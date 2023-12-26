@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("kapt")

    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.com.google.devtools.kts)
    alias(libs.plugins.com.google.dagger.hilt.android)
    alias(libs.plugins.navigation.safeargs)
}

android {
    namespace = "com.ezdream.password"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ezdream.password"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        getByName("debug") {
            keyAlias = "ezdream"
            keyPassword = "789123"
            storeFile = file("/Users/tunaunsal/Doc/private_key.pepk")
            storePassword = "789123"
        }
        create("release") {
            keyAlias = "ezdream"
            keyPassword = "789123"
            storeFile = file("/Users/tunaunsal/Doc/private_key.pepk")
            storePassword = "789123"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
            isDebuggable = false
        }
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
            isDebuggable = true
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
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.roomdb)
    implementation(libs.roomKtx)
    implementation(libs.hilt)
    implementation(libs.coroutines)
    implementation(libs.navigationFragment)
    implementation(libs.navigationUi)
    implementation(libs.viewmodel)
    implementation(libs.livedata)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.android.gif.drawable)
    implementation (libs.okhttp)
    implementation(libs.lifecycle)
    implementation(libs.savedsatateViewmodel)

    ksp(libs.roomdbCompiler)
    ksp(libs.hiltCompiler)

    kapt(libs.lifecycleCompiler)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

kapt {
    correctErrorTypes = true
}