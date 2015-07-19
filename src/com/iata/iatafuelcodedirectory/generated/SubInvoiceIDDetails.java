//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.24 at 02:38:17 PM VET 
//


package com.iata.iatafuelcodedirectory.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.iata.iatafuelcodedirectory.CountryCode;
import com.iata.iatafuelcodedirectory.InvoiceIDType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}SubInvoiceIDVATRegistrationNumber"/>
 *         &lt;element ref="{}SubInvoiceIDName1"/>
 *         &lt;element ref="{}SubInvoiceIDName2" minOccurs="0"/>
 *         &lt;element ref="{}SubInvoiceIDStreet1" minOccurs="0"/>
 *         &lt;element ref="{}SubInvoiceIDStreet2" minOccurs="0"/>
 *         &lt;element ref="{}SubInvoiceIDCity" minOccurs="0"/>
 *         &lt;element ref="{}SubInvoiceIDState" minOccurs="0"/>
 *         &lt;element ref="{}SubInvoiceIDCountryCode" minOccurs="0"/>
 *         &lt;element ref="{}SubInvoiceIDPostalCode" minOccurs="0"/>
 *         &lt;element ref="{}SubInvoiceIDCustomField" maxOccurs="99" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SubInvoiceIDType" use="required" type="{http://www.IATA.com/IATAFuelCodeDirectory}InvoiceIDType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "subInvoiceIDVATRegistrationNumber",
    "subInvoiceIDName1",
    "subInvoiceIDName2",
    "subInvoiceIDStreet1",
    "subInvoiceIDStreet2",
    "subInvoiceIDCity",
    "subInvoiceIDState",
    "subInvoiceIDCountryCode",
    "subInvoiceIDPostalCode",
    "subInvoiceIDCustomField"
})
@XmlRootElement(name = "SubInvoiceIDDetails")
public class SubInvoiceIDDetails {

    @XmlElement(name = "SubInvoiceIDVATRegistrationNumber", required = true)
    protected String subInvoiceIDVATRegistrationNumber;
    @XmlElement(name = "SubInvoiceIDName1", required = true)
    protected String subInvoiceIDName1;
    @XmlElement(name = "SubInvoiceIDName2")
    protected String subInvoiceIDName2;
    @XmlElement(name = "SubInvoiceIDStreet1")
    protected String subInvoiceIDStreet1;
    @XmlElement(name = "SubInvoiceIDStreet2")
    protected String subInvoiceIDStreet2;
    @XmlElement(name = "SubInvoiceIDCity")
    protected String subInvoiceIDCity;
    @XmlElement(name = "SubInvoiceIDState")
    protected String subInvoiceIDState;
    @XmlElement(name = "SubInvoiceIDCountryCode")
    protected CountryCode subInvoiceIDCountryCode;
    @XmlElement(name = "SubInvoiceIDPostalCode")
    protected String subInvoiceIDPostalCode;
    @XmlElement(name = "SubInvoiceIDCustomField")
    protected List<SubInvoiceIDCustomField> subInvoiceIDCustomField;
    @XmlAttribute(name = "SubInvoiceIDType", required = true)
    protected InvoiceIDType subInvoiceIDType;

    /**
     * Gets the value of the subInvoiceIDVATRegistrationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubInvoiceIDVATRegistrationNumber() {
        return subInvoiceIDVATRegistrationNumber;
    }

    /**
     * Sets the value of the subInvoiceIDVATRegistrationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubInvoiceIDVATRegistrationNumber(String value) {
        this.subInvoiceIDVATRegistrationNumber = value;
    }

    /**
     * Gets the value of the subInvoiceIDName1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubInvoiceIDName1() {
        return subInvoiceIDName1;
    }

    /**
     * Sets the value of the subInvoiceIDName1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubInvoiceIDName1(String value) {
        this.subInvoiceIDName1 = value;
    }

    /**
     * Gets the value of the subInvoiceIDName2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubInvoiceIDName2() {
        return subInvoiceIDName2;
    }

    /**
     * Sets the value of the subInvoiceIDName2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubInvoiceIDName2(String value) {
        this.subInvoiceIDName2 = value;
    }

    /**
     * Gets the value of the subInvoiceIDStreet1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubInvoiceIDStreet1() {
        return subInvoiceIDStreet1;
    }

    /**
     * Sets the value of the subInvoiceIDStreet1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubInvoiceIDStreet1(String value) {
        this.subInvoiceIDStreet1 = value;
    }

    /**
     * Gets the value of the subInvoiceIDStreet2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubInvoiceIDStreet2() {
        return subInvoiceIDStreet2;
    }

    /**
     * Sets the value of the subInvoiceIDStreet2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubInvoiceIDStreet2(String value) {
        this.subInvoiceIDStreet2 = value;
    }

    /**
     * Gets the value of the subInvoiceIDCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubInvoiceIDCity() {
        return subInvoiceIDCity;
    }

    /**
     * Sets the value of the subInvoiceIDCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubInvoiceIDCity(String value) {
        this.subInvoiceIDCity = value;
    }

    /**
     * Gets the value of the subInvoiceIDState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubInvoiceIDState() {
        return subInvoiceIDState;
    }

    /**
     * Sets the value of the subInvoiceIDState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubInvoiceIDState(String value) {
        this.subInvoiceIDState = value;
    }

    /**
     * Gets the value of the subInvoiceIDCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link CountryCode }
     *     
     */
    public CountryCode getSubInvoiceIDCountryCode() {
        return subInvoiceIDCountryCode;
    }

    /**
     * Sets the value of the subInvoiceIDCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryCode }
     *     
     */
    public void setSubInvoiceIDCountryCode(CountryCode value) {
        this.subInvoiceIDCountryCode = value;
    }

    /**
     * Gets the value of the subInvoiceIDPostalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubInvoiceIDPostalCode() {
        return subInvoiceIDPostalCode;
    }

    /**
     * Sets the value of the subInvoiceIDPostalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubInvoiceIDPostalCode(String value) {
        this.subInvoiceIDPostalCode = value;
    }

    /**
     * Gets the value of the subInvoiceIDCustomField property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subInvoiceIDCustomField property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubInvoiceIDCustomField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubInvoiceIDCustomField }
     * 
     * 
     */
    public List<SubInvoiceIDCustomField> getSubInvoiceIDCustomField() {
        if (subInvoiceIDCustomField == null) {
            subInvoiceIDCustomField = new ArrayList<SubInvoiceIDCustomField>();
        }
        return this.subInvoiceIDCustomField;
    }

    /**
     * Gets the value of the subInvoiceIDType property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceIDType }
     *     
     */
    public InvoiceIDType getSubInvoiceIDType() {
        return subInvoiceIDType;
    }

    /**
     * Sets the value of the subInvoiceIDType property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceIDType }
     *     
     */
    public void setSubInvoiceIDType(InvoiceIDType value) {
        this.subInvoiceIDType = value;
    }

}