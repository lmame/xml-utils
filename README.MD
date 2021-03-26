**Author:**  
Laurent Matheo (BMC)  
  
**History:**  
0.1: 2021/04/25, First release.  
<br>
  
**What is this bundle?:**  
Usually web requests return text (JWT token for example) or Json. In some cases they can return xml (Qualys).  
In this case the web request activity activity does not return a text but returns an Attachment object, which is hard to parse and use in a process.  
This bundle contains an activity "Xml Attachment To Json" that takes as input an Attachment ("xml attachment") (web request output or an Attachment object) and returns the xml converted to Json.  
This is done using the library "org.json" as per those links:  
* https://mkyong.com/java/how-do-convert-byte-array-to-string-in-java/
* https://stackoverflow.com/questions/1823264/quickest-way-to-convert-xml-to-json-in-java
  
The library is declared in /bundle/pom.xml dependencies:  
```xml
        <!-- LMA:: Used to convert from Xml to Json -->
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20090211</version>
        </dependency>
```
  
The activity output can be "parsed" into a documented object using the "Compute value" activity for example.  
If an exception is detected in the activity, it will return an empty string.  
  
<br>
  
**Note:**  
The activity has an optional parameter "max indentation" which is the level depth you want to go in your xml. If not set the default will be set to 4.
  
<br>

**License / support:**  
This bundle is released by Laurent Matheo and "as is". There is no warranty, liability or support.   
If you wish to fork, modify, use the code for something else feel free to do so :)  