XSLT-PF (XSLT Processing Filter)
=================================

XSLT processor that behaves like Unix text filter.

License
-------

zlib License.

Target environments
-------------------

Windows, Cygwin, Linux, macOS.

Probably it works on other Unix-like environment Java supported.

Set up
------

XSLT-PF is written in several programming languages. Choose one among them.

### For Java implementation:

1. Install JDK and JRE.
2. (Mac OS X only) Install realpath from [eel3-scripts](https://github.com/eel3/eel3-scripts "eel3-scripts repository").
3. Compile XSLTPFCore.java.
4. Put xsltpf, XSLTPFCore.class, and XSLTPFCore$XSLInputType.class in a directory registered in PATH.
5. (Cygwin only) Put xsltpf.bat in a directory registered in PATH (optional).

### For Groovy implementation:

1. Install Groovy 2.4.1 or later.
2. Put xsltpf in a directory registered in PATH.
3. (Windows only) Put xsltpf.bat in a directory registered in PATH.

Usage
-----

Please check help message xsltpf -h`

Example
-------

```sh
# Transform from foo.xml into foo.html, using foo.xsl.
xsltpf -t foo.xsl -o foo.html foo.xml

# Transform foo.xml, output to less(1).
xsltpf -t foo.xsl foo.xml | less

# Transform some command result.
some-command | xsltpf -t foo.xsl | less

# Use -e option.
echo '<?xml version="1.0" encoding="utf-8" ?>
<root>
  <leaf>1</leaf>
  <leaf>2</leaf>
  <leaf>3</leaf>
</root>
' | xsltpf -e '<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" encoding="utf-8" />
  <xsl:template match="/">
    <xsl:text>[</xsl:text>
    <xsl:apply-templates select="//leaf" />
    <xsl:text>]&#x0A;</xsl:text>
  </xsl:template>
  <xsl:template match="leaf">
    <xsl:value-of select="." />
    <xsl:if test="position() != last()">
      <xsl:text>, </xsl:text>
    </xsl:if>
  </xsl:template>
</xsl:stylesheet>'
#=> [1, 2, 3]
```
