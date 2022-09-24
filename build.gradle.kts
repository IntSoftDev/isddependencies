group = "com.intsoftdev"
version = "0.01-SNAPSHOT"

plugins {
    `version-catalog`
    `maven-publish`
}

catalog {
    versionCatalog {
        from(files("./gradle/libs.versions.toml"))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "isdversioncatalog"
            from(components["versionCatalog"])
        }
    }
}
