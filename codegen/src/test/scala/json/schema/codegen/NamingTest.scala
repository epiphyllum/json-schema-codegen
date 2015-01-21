package json.schema.codegen

import java.net.URI

import org.scalatest.{FlatSpec, Matchers}

class NamingTest extends FlatSpec with Matchers with Naming {

  "Naming" should "name package" in {
    packageName(new URI("http://host/b/c#")) shouldBe "b"
    packageName(new URI("http://host/b/c#")) shouldBe  "b"
    packageName(new URI("http://host/b/c#/d")) shouldBe "b.c"
    packageName(new URI("#/d/e")) shouldBe "d"
    packageName(new URI("a#d/e")) shouldBe  "a.d"
    packageName(new URI("file:/a/b/c#d/e")) shouldBe "c.d"
    packageName(new URI("a-b-c#d/e")) shouldBe "a.b.c.d"
  }
  "Naming" should "name class" in {
    className(new URI("http://host/b/c#/d")) shouldBe "D"
    className(new URI("#/d/e")) shouldBe "E"
    className(new URI("a#/d/e")) shouldBe  "E"
    className(new URI("file:a#d/e")) shouldBe "E"
    className(new URI("file:a#class")) shouldBe "Class"
  }


}
