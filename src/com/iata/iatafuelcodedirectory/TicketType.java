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
 * <p>Java class for TicketType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TicketType">
 *   &lt;restriction base="{http://www.IATA.com/IATABaseDataTypeDirectory}AN01Base">
 *     &lt;enumeration value="O"/>
 *     &lt;enumeration value="R"/>
 *     &lt;enumeration value="C"/>
 *     &lt;enumeration value="D"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TicketType", namespace = "http://www.IATA.com/IATAFuelCodeDirectory")
@XmlEnum
public enum TicketType {

    O,
    R,
    C,
    D;

    public String value() {
        return name();
    }

    public static TicketType fromValue(String v) {
        return valueOf(v);
    }

}
