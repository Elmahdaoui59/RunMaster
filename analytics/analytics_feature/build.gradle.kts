plugins {
    //alias(libs.plugins.androidDynamicFeature)
    alias(libs.plugins.runique.android.dynamic.feature)
}
android {
    namespace = "com.running.analytics.analytics_feature"
}

dependencies {
    implementation(project(":app"))

    api(projects.analytics.presentation)
    implementation(projects.analytics.domain)
    implementation(projects.analytics.data)
    implementation(projects.core.database)
}