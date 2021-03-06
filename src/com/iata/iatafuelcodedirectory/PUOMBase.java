//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.24 at 02:38:19 PM VET 
//


package com.iata.iatafuelcodedirectory;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PUOMBase.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PUOMBase">
 *   &lt;restriction base="{http://www.IATA.com/IATABaseDataTypeDirectory}AN03Base">
 *     &lt;enumeration value="BBL"/>
 *     &lt;enumeration value="CAN"/>
 *     &lt;enumeration value="M3"/>
 *     &lt;enumeration value="DR"/>
 *     &lt;enumeration value="EA"/>
 *     &lt;enumeration value="HL"/>
 *     &lt;enumeration value="HR"/>
 *     &lt;enumeration value="KG"/>
 *     &lt;enumeration value="KL"/>
 *     &lt;enumeration value="LT"/>
 *     &lt;enumeration value="MT"/>
 *     &lt;enumeration value="PCT"/>
 *     &lt;enumeration value="LB"/>
 *     &lt;enumeration value="USG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PUOMBase", namespace = "http://www.IATA.com/IATAFuelCodeDirectory")
@XmlEnum
public enum PUOMBase {

    BBL("BBL"),
    CAN("CAN"),
    @XmlEnumValue("M3")
    M_3("M3"),
    DR("DR"),
    EA("EA"),
    HL("HL"),
    HR("HR"),
    KG("KG"),
    KL("KL"),
    LT("LT"),
    MT("MT"),
    PCT("PCT"),
    LB("LB"),
    USG("USG");
    private final String value;

    PUOMBase(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PUOMBase fromValue(String v) {
        for (PUOMBase c: PUOMBase.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
