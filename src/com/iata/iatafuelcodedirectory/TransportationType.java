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
 * <p>Java class for TransportationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransportationType">
 *   &lt;restriction base="{http://www.IATA.com/IATABaseDataTypeDirectory}AN02Base">
 *     &lt;enumeration value="BA"/>
 *     &lt;enumeration value="TR"/>
 *     &lt;enumeration value="PL"/>
 *     &lt;enumeration value="RL"/>
 *     &lt;enumeration value="VL"/>
 *     &lt;enumeration value="IT"/>
 *     &lt;enumeration value="IP"/>
 *     &lt;enumeration value="BK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransportationType", namespace = "http://www.IATA.com/IATAFuelCodeDirectory")
@XmlEnum
public enum TransportationType {

    BA,
    TR,
    PL,
    RL,
    VL,
    IT,
    IP,
    BK;

    public String value() {
        return name();
    }

    public static TransportationType fromValue(String v) {
        return valueOf(v);
    }

}
