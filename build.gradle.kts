import com.vanniktech.maven.publish.SonatypeHost
import java.util.Properties

// Load secrets.properties
val secretsProperties = Properties()
val secretsFile = rootProject.file("secrets.properties")
if (secretsFile.exists()) {
    secretsProperties.load(secretsFile.inputStream())
    // Apply secrets as project properties without using Java 8 `forEach`
    secretsProperties.stringPropertyNames().forEach { key ->
        project.extensions.extraProperties.set(key, secretsProperties.getProperty(key))
    }
}

plugins {
    `version-catalog`
    alias(libs.plugins.maven.publish)
}

group = "com.intsoftdev"
version = "1.0.0-ALPHA-31"

catalog {
    versionCatalog {
        from(files("./gradle/libs.versions.toml"))
    }
}

mavenPublishing {
    coordinates(
        groupId = group.toString(),
        artifactId = "isddependencies",
        version = version.toString()
    )

    pom {
        name.set("ISD Dependencies")
        description.set("Gradle version catalog dependencies")
        url.set("https://github.com/IntSoftDev/isddependencies")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }
        developers {
            developer {
                id.set("azaka01")
                name.set("A Zaka")
                email.set("az@intsoftdev.com")
            }
        }
        scm {
            url.set("https://github.com/IntSoftDev/isddependencies")
        }
    }

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
}