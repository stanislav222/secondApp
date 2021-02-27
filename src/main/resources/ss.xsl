<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                exclude-result-prefixes="#all"
                version="3.0">

    <xsl:template match="/">
        <xsl:for-each select="List/item">
            <xsl:value-of select="clientId"/>
            <xsl:value-of select="balance"/>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>