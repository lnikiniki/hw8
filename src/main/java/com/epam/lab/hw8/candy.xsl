<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Candy</h2>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Energy</th>
                        <th>Sugar</th>
                        <th>Chocolate</th>
                        <th>Ingredient</th>
                        <th>Protein</th>
                        <th>Fat</th>
                        <th>Carbohydrates</th>
                        <th>Production</th>
                    </tr>
                    <xsl:for-each select="candies/candy">
                        <tr>
                            <td>
                                <xsl:value-of select="name" />
                            </td>
                            <td>
                                <xsl:value-of select="type" />
                            </td>
                            <td>
                                <xsl:value-of select="energy"/>
                            </td>
                            <td>
                                <xsl:value-of select="ingredients/sugar"/>
                            </td>
                            <td>
                                <xsl:value-of select="ingredients/chocolate"/>
                            </td>
                            <td>
                                <xsl:value-of select="ingredients/ingredient"/>
                            </td>
                            <td>
                                <xsl:value-of select="value/protein"/>
                            </td>
                            <td>
                                <xsl:value-of select="value/fat"/>
                            </td>
                            <td>
                                <xsl:value-of select="value/carbohydrates"/>
                            </td>
                            <td>
                                <xsl:value-of select="production"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>