import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.utils.configureKotlinCompileTasks
import com.running.convention.Extensiontype
import com.running.convention.configureAndroidCompose
import com.running.convention.configureBuildTypes
import com.running.convention.configureKotlinAndroid
import com.running.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.impldep.org.glassfish.jaxb.runtime.v2.schemagen.xmlschema.ExtensionType
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("runique.android.library")
            }
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }
}