plugins {
    alias(libs.plugins.runique.android.library)
}

android {
    namespace = "com.running.core.data"
}

dependencies {
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}