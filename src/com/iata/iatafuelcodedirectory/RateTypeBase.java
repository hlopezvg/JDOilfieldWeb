//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.24 at 02:38:19 PM VET 
//


package com.iata.iatafuelcodedirectory;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RateTypeBase.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RateTypeBase">
 *   &lt;restriction base="{http://www.IATA.com/IATABaseDataTypeDirectory}AN03Base">
 *     &lt;enumeration value="FF"/>
 *     &lt;enumeration value="UR"/>
 *     &lt;enumeration value="P"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RateTypeBase", namespace = "http://www.IATA.com/IATAFuelCodeDirectory")
@XmlEnum
public enum RateTypeBase {

    FF,
    UR,
    P;

    public String value() {
        return name();
    }

    public static RateTypeBase fromValue(String v) {
        return valueOf(v);
    }

}
