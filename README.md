# json-schema-codegen

Model and Serialization source code generator from a defined Json-Schema.

Scala code generator supports the following of Json-schema spec:

 * Object types with properties

 * required and optional properties

 * Object types with additionProperties

 * Arrays of any type

 * Unique or non-unique arrays

 * Simple types

 * Type definitions

 * Enum of string and integer values

 * Formats - uri, date-time, email, hostname, ipv4, ipv6

Not supported:

 * anyOf, not, allOf, oneOf

 * multiple types

 * enum of objects or variable types

 * validation constructs that do not affect the structures

## SBT Plugin  

You can run the scala code generator as part of your build.

By default the schema definitions should be placed in src/main/json-schema.

In project/plugins.sbt add:

```scala
  addSbtPlugin("com.voxsupplychain" %% "json-schema-codegen-sbt" % "0.1.0")
```

In build.sbt :

```scala
  // json-schema to be watched for changes in ~compile
  watchSources <++= baseDirectory map { dir =>
    Seq(
      dir / "src/main/json-schema"
    )
  }
```

Code is generated during the compile phase. 
