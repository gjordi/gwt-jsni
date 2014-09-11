gwt-jsni
========

JSNI utilities for GWT projects.

# Usage

Add the dependency to your Maven POM:

```xml
<dependency>
	<groupId>com.bytebybyte.gwt</groupId>
	<artifactId>jsni</artifactId>
	<version>1.0.0</version>
	<scope>provided</scope>
</dependency>
```

And to your .gwt.xml file:

```xml
<module>
	...
	<inherits name="com.bytebybyte.gwt.jsni.JSNI" />
	...
</module>
```
