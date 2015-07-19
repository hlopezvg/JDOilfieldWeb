//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.24 at 02:38:17 PM VET 
//


package com.iata.iatafuelcodedirectory.generated;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{}ItemNumber"/>
 *         &lt;element ref="{}ItemQuantity" maxOccurs="4"/>
 *         &lt;element ref="{}ItemDeliveryReferenceValue" maxOccurs="20" minOccurs="0"/>
 *         &lt;element ref="{}ItemTaxInvoiceNumber" minOccurs="0"/>
 *         &lt;element ref="{}ItemDeliveryLocation" minOccurs="0"/>
 *         &lt;element ref="{}ItemTransportation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}ItemReferenceLocalDate" maxOccurs="10"/>
 *         &lt;element ref="{}ItemReferenceGMTDate" maxOccurs="10" minOccurs="0"/>
 *         &lt;element ref="{}ItemDescription" minOccurs="0"/>
 *         &lt;element ref="{}ItemInvoiceAmount"/>
 *         &lt;element ref="{}SubItem" maxOccurs="500"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "itemNumber",
    "itemQuantity",
    "itemDeliveryReferenceValue",
    "itemTaxInvoiceNumber",
    "itemDeliveryLocation",
    "itemTransportation",
    "itemReferenceLocalDate",
    "itemReferenceGMTDate",
    "itemDescription",
    "itemInvoiceAmount",
    "subItem"
})
@XmlRootElement(name = "InvoiceLine")
public class InvoiceLine {

    @XmlElement(name = "ItemNumber")
    protected int itemNumber;
    @XmlElement(name = "ItemQuantity", required = true)
    protected List<ItemQuantity> itemQuantity;
    @XmlElement(name = "ItemDeliveryReferenceValue")
    protected List<ItemDeliveryReferenceValue> itemDeliveryReferenceValue;
    @XmlElement(name = "ItemTaxInvoiceNumber")
    protected String itemTaxInvoiceNumber;
    @XmlElement(name = "ItemDeliveryLocation")
    protected String itemDeliveryLocation;
    @XmlElement(name = "ItemTransportation")
    protected List<ItemTransportation> itemTransportation;
    @XmlElement(name = "ItemReferenceLocalDate", required = true)
    protected List<ItemReferenceLocalDate> itemReferenceLocalDate;
    @XmlElement(name = "ItemReferenceGMTDate")
    protected List<ItemReferenceGMTDate> itemReferenceGMTDate;
    @XmlElement(name = "ItemDescription")
    protected String itemDescription;
    @XmlElement(name = "ItemInvoiceAmount", required = true)
    protected BigDecimal itemInvoiceAmount;
    @XmlElement(name = "SubItem", required = true)
    protected List<SubItem> subItem;

    /**
     * Gets the value of the itemNumber property.
     * 
     */
    public int getItemNumber() {
        return itemNumber;
    }

    /**
     * Sets the value of the itemNumber property.
     * 
     */
    public void setItemNumber(int value) {
        this.itemNumber = value;
    }

    /**
     * Gets the value of the itemQuantity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemQuantity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemQuantity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemQuantity }
     * 
     * 
     */
    public List<ItemQuantity> getItemQuantity() {
        if (itemQuantity == null) {
            itemQuantity = new ArrayList<ItemQuantity>();
        }
        return this.itemQuantity;
    }

    /**
     * Gets the value of the itemDeliveryReferenceValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemDeliveryReferenceValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemDeliveryReferenceValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemDeliveryReferenceValue }
     * 
     * 
     */
    public List<ItemDeliveryReferenceValue> getItemDeliveryReferenceValue() {
        if (itemDeliveryReferenceValue == null) {
            itemDeliveryReferenceValue = new ArrayList<ItemDeliveryReferenceValue>();
        }
        return this.itemDeliveryReferenceValue;
    }

    /**
     * Gets the value of the itemTaxInvoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemTaxInvoiceNumber() {
        return itemTaxInvoiceNumber;
    }

    /**
     * Sets the value of the itemTaxInvoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemTaxInvoiceNumber(String value) {
        this.itemTaxInvoiceNumber = value;
    }

    /**
     * Gets the value of the itemDeliveryLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemDeliveryLocation() {
        return itemDeliveryLocation;
    }

    /**
     * Sets the value of the itemDeliveryLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemDeliveryLocation(String value) {
        this.itemDeliveryLocation = value;
    }

    /**
     * Gets the value of the itemTransportation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemTransportation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemTransportation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemTransportation }
     * 
     * 
     */
    public List<ItemTransportation> getItemTransportation() {
        if (itemTransportation == null) {
            itemTransportation = new ArrayList<ItemTransportation>();
        }
        return this.itemTransportation;
    }

    /**
     * Gets the value of the itemReferenceLocalDate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemReferenceLocalDate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemReferenceLocalDate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemReferenceLocalDate }
     * 
     * 
     */
    public List<ItemReferenceLocalDate> getItemReferenceLocalDate() {
        if (itemReferenceLocalDate == null) {
            itemReferenceLocalDate = new ArrayList<ItemReferenceLocalDate>();
        }
        return this.itemReferenceLocalDate;
    }

    /**
     * Gets the value of the itemReferenceGMTDate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemReferenceGMTDate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemReferenceGMTDate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemReferenceGMTDate }
     * 
     * 
     */
    public List<ItemReferenceGMTDate> getItemReferenceGMTDate() {
        if (itemReferenceGMTDate == null) {
            itemReferenceGMTDate = new ArrayList<ItemReferenceGMTDate>();
        }
        return this.itemReferenceGMTDate;
    }

    /**
     * Gets the value of the itemDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Sets the value of the itemDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemDescription(String value) {
        this.itemDescription = value;
    }

    /**
     * Gets the value of the itemInvoiceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getItemInvoiceAmount() {
        return itemInvoiceAmount;
    }

    /**
     * Sets the value of the itemInvoiceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setItemInvoiceAmount(BigDecimal value) {
        this.itemInvoiceAmount = value;
    }

    /**
     * Gets the value of the subItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubItem }
     * 
     * 
     */
    public List<SubItem> getSubItem() {
        if (subItem == null) {
            subItem = new ArrayList<SubItem>();
        }
        return this.subItem;
    }

}
