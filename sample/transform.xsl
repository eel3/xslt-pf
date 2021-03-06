<?xml version="1.0" encoding="utf-16" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" encoding="utf-8" />
  <xsl:template match="/">
    <xsl:apply-templates select="//book" />
  </xsl:template>
  <xsl:template match="book">
    <xsl:for-each select="@*">
      <xsl:value-of select="name()" /><xsl:text>&#x09;</xsl:text><xsl:value-of select="." /><xsl:text>&#x0A;</xsl:text>
    </xsl:for-each>
    <xsl:if test="position() != last()">
      <xsl:text>&#x0A;</xsl:text>
    </xsl:if>
  </xsl:template>
</xsl:stylesheet>
