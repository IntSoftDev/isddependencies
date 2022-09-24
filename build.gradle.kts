
plugins {
    `version-catalog`
    `maven-publish`
    id("convention.publication")
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
