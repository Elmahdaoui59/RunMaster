import com.android.build.api.dsl.DynamicFeatureExtension
import com.running.convention.Extensiontype
import com.running.convention.addUiLayerDependencies
import com.running.convention.configureAndroidCompose
import com.running.convention.configureBuildTypes
import com.running.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidDynamicFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.dynamic-feature")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<DynamicFeatureExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)

                configureBuildTypes(
                    this,
                    extensiontype = Extensiontype.DYNAMIC_FEATURE
                 )
            }
            dependencies {
                addUiLayerDependencies(target)
                "testImplementation"(kotlin("test"))
            }
        }
    }
}