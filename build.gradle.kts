import com.vanniktech.maven.publish.SonatypeHost

// https://vanniktech.github.io/gradle-maven-publish-plugin/central/
plugins {
    `version-catalog`
    id("com.vanniktech.maven.publish") version "0.32.0"
}

group = "com.intsoftdev"
version = "1.0.0-ALPHA-24"

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