XSLT-PF (XSLT Processing Filter)
=================================

XSLT processor that behaves like Unix text filter.

License
-------

zlib License.

Target environments
-------------------

Cygwin, Linux, Mac OS X.

Probably it works on other Unix-like environment Java supported.

Set up
------

for Java implementation:

1. Install JDK and JRE.
2. Compile XSLTPFCore.java.
2. Put both xsltpf and XSLTPFCore.class in a directory registered in PATH.

for Groovy implementation:

1. Install Groovy 2.3.3 or later.
2. Put xsltpf in a directory registered in PATH.

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

# Transform some command result
some-command | xsltpf -t foo.xsl | less
```
