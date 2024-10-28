import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.utils.configureKotlinCompileTasks
import com.running.convention.Extensiontype
import com.running.convention.configureBuildTypes
import com.running.convention.configureKotlinAndroid
import com.running.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.impldep.org.glassfish.jaxb.runtime.v2.schemagen.xmlschema.ExtensionType
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)

                configureBuildTypes(
                    commonExtension = this,
                    extensiontype = Extensiontype.LIBRARY
                )

                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }
            }

            dependencies {
                "testImplementation"(kotlin("test"))
            }
        }
    }
}