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
 * <p>Java class for TaxTypeBase.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaxTypeBase">
 *   &lt;restriction base="{http://www.IATA.com/IATABaseDataTypeDirectory}AN03Base">
 *     &lt;enumeration value="APT"/>
 *     &lt;enumeration value="AUT"/>
 *     &lt;enumeration value="CNS"/>
 *     &lt;enumeration value="CO2"/>
 *     &lt;enumeration value="CRD"/>
 *     &lt;enumeration value="CUD"/>
 *     &lt;enumeration value="ENV"/>
 *     &lt;enumeration value="ERG"/>
 *     &lt;enumeration value="FEX"/>
 *     &lt;enumeration value="FUE"/>
 *     &lt;enumeration value="GRC"/>
 *     &lt;enumeration value="GRV"/>
 *     &lt;enumeration value="GST"/>
 *     &lt;enumeration value="IMP"/>
 *     &lt;enumeration value="LST"/>
 *     &lt;enumeration value="LUS"/>
 *     &lt;enumeration value="MOR"/>
 *     &lt;enumeration value="MOT"/>
 *     &lt;enumeration value="NDT"/>
 *     &lt;enumeration value="OTH"/>
 *     &lt;enumeration value="PTL"/>
 *     &lt;enumeration value="RRT"/>
 *     &lt;enumeration value="SLT"/>
 *     &lt;enumeration value="SPT"/>
 *     &lt;enumeration value="SEX"/>
 *     &lt;enumeration value="STM"/>
 *     &lt;enumeration value="STP"/>
 *     &lt;enumeration value="VAT"/>
 *     &lt;enumeration value="WHT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaxTypeBase", namespace = "http://www.IATA.com/IATAFuelCodeDirectory")
@XmlEnum
public enum TaxTypeBase {

    APT("APT"),
    AUT("AUT"),
    CNS("CNS"),
    @XmlEnumValue("CO2")
    CO_2("CO2"),
    CRD("CRD"),
    CUD("CUD"),
    ENV("ENV"),
    ERG("ERG"),
    FEX("FEX"),
    FUE("FUE"),
    GRC("GRC"),
    GRV("GRV"),
    GST("GST"),
    IMP("IMP"),
    LST("LST"),
    LUS("LUS"),
    MOR("MOR"),
    MOT("MOT"),
    NDT("NDT"),
    OTH("OTH"),
    PTL("PTL"),
    RRT("RRT"),
    SLT("SLT"),
    SPT("SPT"),
    SEX("SEX"),
    STM("STM"),
    STP("STP"),
    VAT("VAT"),
    WHT("WHT");
    private final String value;

    TaxTypeBase(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaxTypeBase fromValue(String v) {
        for (TaxTypeBase c: TaxTypeBase.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
