plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.running.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}