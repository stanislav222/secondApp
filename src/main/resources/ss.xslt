<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <List>
        <xsl:for-each select="List/item">
            <p><xsl:value-of select="clientId"/></p>
            <p><xsl:value-of select="balance"/></p>
        </xsl:for-each>
        </List>
    </xsl:template>
</xsl:stylesheet>