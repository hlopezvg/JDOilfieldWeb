//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.24 at 02:38:17 PM VET 
//


package com.iata.iatafuelcodedirectory.generated;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.iata.iatafuelcodedirectory.CurrencyCodeBase;
import com.iata.iatafuelcodedirectory.PaymentTermsDateBasis;


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
 *         &lt;element ref="{}CustomerEntityID"/>
 *         &lt;element ref="{}IssuingEntityID"/>
 *         &lt;element ref="{}IssuingEntityName" minOccurs="0"/>
 *         &lt;element ref="{}IssuingEntityAffiliateName" minOccurs="0"/>
 *         &lt;element ref="{}IssuingEntityAffiliateNotes" minOccurs="0"/>
 *         &lt;element ref="{}InvoiceNumber"/>
 *         &lt;element ref="{}InvoiceIssueDate"/>
 *         &lt;element ref="{}InvoiceType"/>
 *         &lt;element ref="{}InvoiceDeliveryLocation"/>
 *         &lt;element ref="{}InvoicePaymentTermsType" minOccurs="0"/>
 *         &lt;element ref="{}InvoicePaymentTermsDateBasis" minOccurs="0"/>
 *         &lt;element ref="{}InvoicePaymentTermsDiscountPercent" minOccurs="0"/>
 *         &lt;element ref="{}InvoicePaymentTermsDiscountDueDate" minOccurs="0"/>
 *         &lt;element ref="{}InvoicePaymentTermsNetDueDate" minOccurs="0"/>
 *         &lt;element ref="{}InvoicePaymentTermsNetDueDays" minOccurs="0"/>
 *         &lt;element ref="{}InvoicePaymentTermsDescription" minOccurs="0"/>
 *         &lt;element ref="{}InvoiceReferenceValue" maxOccurs="12" minOccurs="0"/>
 *         &lt;element ref="{}TaxInvoiceNumber"/>
 *         &lt;element ref="{}TaxPointDate" minOccurs="0"/>
 *         &lt;element ref="{}InvoiceTaxClause" maxOccurs="10" minOccurs="0"/>
 *         &lt;element ref="{}InvoiceCurrencyCode"/>
 *         &lt;element ref="{}InvoiceTotalAmount"/>
 *         &lt;element ref="{}InvoiceDiscountAmount" minOccurs="0"/>
 *         &lt;element ref="{}InvoiceNotes" maxOccurs="50" minOccurs="0"/>
 *         &lt;element ref="{}InvoiceIDDetails" maxOccurs="200" minOccurs="0"/>
 *         &lt;element ref="{}InvoiceTaxes" minOccurs="0"/>
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
    "customerEntityID",
    "issuingEntityID",
    "issuingEntityName",
    "issuingEntityAffiliateName",
    "issuingEntityAffiliateNotes",
    "invoiceNumber",
    "invoiceIssueDate",
    "invoiceType",
    "invoiceDeliveryLocation",
    "invoicePaymentTermsType",
    "invoicePaymentTermsDateBasis",
    "invoicePaymentTermsDiscountPercent",
    "invoicePaymentTermsDiscountDueDate",
    "invoicePaymentTermsNetDueDate",
    "invoicePaymentTermsNetDueDays",
    "invoicePaymentTermsDescription",
    "invoiceReferenceValue",
    "taxInvoiceNumber",
    "taxPointDate",
    "invoiceTaxClause",
    "invoiceCurrencyCode",
    "invoiceTotalAmount",
    "invoiceDiscountAmount",
    "invoiceNotes",
    "invoiceIDDetails",
    "invoiceTaxes"
})
@XmlRootElement(name = "InvoiceHeader")
public class InvoiceHeader {

    @XmlElement(name = "CustomerEntityID", required = true)
    protected String customerEntityID;
    @XmlElement(name = "IssuingEntityID", required = true)
    protected String issuingEntityID;
    @XmlElement(name = "IssuingEntityName")
    protected String issuingEntityName;
    @XmlElement(name = "IssuingEntityAffiliateName")
    protected String issuingEntityAffiliateName;
    @XmlElement(name = "IssuingEntityAffiliateNotes")
    protected String issuingEntityAffiliateNotes;
    @XmlElement(name = "InvoiceNumber", required = true)
    protected String invoiceNumber;
    @XmlElement(name = "InvoiceIssueDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar invoiceIssueDate;
    @XmlElement(name = "InvoiceType", required = true)
    protected InvoiceType invoiceType;
    @XmlElement(name = "InvoiceDeliveryLocation", required = true)
    protected String invoiceDeliveryLocation;
    @XmlElement(name = "InvoicePaymentTermsType")
    protected String invoicePaymentTermsType;
    @XmlElement(name = "InvoicePaymentTermsDateBasis")
    protected PaymentTermsDateBasis invoicePaymentTermsDateBasis;
    @XmlElement(name = "InvoicePaymentTermsDiscountPercent")
    protected BigDecimal invoicePaymentTermsDiscountPercent;
    @XmlElement(name = "InvoicePaymentTermsDiscountDueDate")
    protected XMLGregorianCalendar invoicePaymentTermsDiscountDueDate;
    @XmlElement(name = "InvoicePaymentTermsNetDueDate")
    protected XMLGregorianCalendar invoicePaymentTermsNetDueDate;
    @XmlElement(name = "InvoicePaymentTermsNetDueDays")
    protected BigInteger invoicePaymentTermsNetDueDays;
    @XmlElement(name = "InvoicePaymentTermsDescription")
    protected String invoicePaymentTermsDescription;
    @XmlElement(name = "InvoiceReferenceValue")
    protected List<InvoiceReferenceValue> invoiceReferenceValue;
    @XmlElement(name = "TaxInvoiceNumber", required = true)
    protected String taxInvoiceNumber;
    @XmlElement(name = "TaxPointDate")
    protected XMLGregorianCalendar taxPointDate;
    @XmlElement(name = "InvoiceTaxClause")
    protected List<String> invoiceTaxClause;
    @XmlElement(name = "InvoiceCurrencyCode", required = true)
    protected CurrencyCodeBase invoiceCurrencyCode;
    @XmlElement(name = "InvoiceTotalAmount", required = true)
    protected BigDecimal invoiceTotalAmount;
    @XmlElement(name = "InvoiceDiscountAmount")
    protected BigDecimal invoiceDiscountAmount;
    @XmlElement(name = "InvoiceNotes")
    protected List<String> invoiceNotes;
    @XmlElement(name = "InvoiceIDDetails")
    protected List<InvoiceIDDetails> invoiceIDDetails;
    @XmlElement(name = "InvoiceTaxes")
    protected InvoiceTaxes invoiceTaxes;

    /**
     * Gets the value of the customerEntityID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerEntityID() {
        return customerEntityID;
    }

    /**
     * Sets the value of the customerEntityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerEntityID(String value) {
        this.customerEntityID = value;
    }

    /**
     * Gets the value of the issuingEntityID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuingEntityID() {
        return issuingEntityID;
    }

    /**
     * Sets the value of the issuingEntityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuingEntityID(String value) {
        this.issuingEntityID = value;
    }

    /**
     * Gets the value of the issuingEntityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuingEntityName() {
        return issuingEntityName;
    }

    /**
     * Sets the value of the issuingEntityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuingEntityName(String value) {
        this.issuingEntityName = value;
    }

    /**
     * Gets the value of the issuingEntityAffiliateName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuingEntityAffiliateName() {
        return issuingEntityAffiliateName;
    }

    /**
     * Sets the value of the issuingEntityAffiliateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuingEntityAffiliateName(String value) {
        this.issuingEntityAffiliateName = value;
    }

    /**
     * Gets the value of the issuingEntityAffiliateNotes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuingEntityAffiliateNotes() {
        return issuingEntityAffiliateNotes;
    }

    /**
     * Sets the value of the issuingEntityAffiliateNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuingEntityAffiliateNotes(String value) {
        this.issuingEntityAffiliateNotes = value;
    }

    /**
     * Gets the value of the invoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Sets the value of the invoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
    }

    /**
     * Gets the value of the invoiceIssueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInvoiceIssueDate() {
        return invoiceIssueDate;
    }

    /**
     * Sets the value of the invoiceIssueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInvoiceIssueDate(XMLGregorianCalendar value) {
        this.invoiceIssueDate = value;
    }

    /**
     * Gets the value of the invoiceType property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceType }
     *     
     */
    public InvoiceType getInvoiceType() {
        return invoiceType;
    }

    /**
     * Sets the value of the invoiceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceType }
     *     
     */
    public void setInvoiceType(InvoiceType value) {
        this.invoiceType = value;
    }

    /**
     * Gets the value of the invoiceDeliveryLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceDeliveryLocation() {
        return invoiceDeliveryLocation;
    }

    /**
     * Sets the value of the invoiceDeliveryLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceDeliveryLocation(String value) {
        this.invoiceDeliveryLocation = value;
    }

    /**
     * Gets the value of the invoicePaymentTermsType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoicePaymentTermsType() {
        return invoicePaymentTermsType;
    }

    /**
     * Sets the value of the invoicePaymentTermsType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoicePaymentTermsType(String value) {
        this.invoicePaymentTermsType = value;
    }

    /**
     * Gets the value of the invoicePaymentTermsDateBasis property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsDateBasis }
     *     
     */
    public PaymentTermsDateBasis getInvoicePaymentTermsDateBasis() {
        return invoicePaymentTermsDateBasis;
    }

    /**
     * Sets the value of the invoicePaymentTermsDateBasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsDateBasis }
     *     
     */
    public void setInvoicePaymentTermsDateBasis(PaymentTermsDateBasis value) {
        this.invoicePaymentTermsDateBasis = value;
    }

    /**
     * Gets the value of the invoicePaymentTermsDiscountPercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInvoicePaymentTermsDiscountPercent() {
        return invoicePaymentTermsDiscountPercent;
    }

    /**
     * Sets the value of the invoicePaymentTermsDiscountPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInvoicePaymentTermsDiscountPercent(BigDecimal value) {
        this.invoicePaymentTermsDiscountPercent = value;
    }

    /**
     * Gets the value of the invoicePaymentTermsDiscountDueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInvoicePaymentTermsDiscountDueDate() {
        return invoicePaymentTermsDiscountDueDate;
    }

    /**
     * Sets the value of the invoicePaymentTermsDiscountDueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInvoicePaymentTermsDiscountDueDate(XMLGregorianCalendar value) {
        this.invoicePaymentTermsDiscountDueDate = value;
    }

    /**
     * Gets the value of the invoicePaymentTermsNetDueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInvoicePaymentTermsNetDueDate() {
        return invoicePaymentTermsNetDueDate;
    }

    /**
     * Sets the value of the invoicePaymentTermsNetDueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInvoicePaymentTermsNetDueDate(XMLGregorianCalendar value) {
        this.invoicePaymentTermsNetDueDate = value;
    }

    /**
     * Gets the value of the invoicePaymentTermsNetDueDays property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInvoicePaymentTermsNetDueDays() {
        return invoicePaymentTermsNetDueDays;
    }

    /**
     * Sets the value of the invoicePaymentTermsNetDueDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInvoicePaymentTermsNetDueDays(BigInteger value) {
        this.invoicePaymentTermsNetDueDays = value;
    }

    /**
     * Gets the value of the invoicePaymentTermsDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoicePaymentTermsDescription() {
        return invoicePaymentTermsDescription;
    }

    /**
     * Sets the value of the invoicePaymentTermsDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoicePaymentTermsDescription(String value) {
        this.invoicePaymentTermsDescription = value;
    }

    /**
     * Gets the value of the invoiceReferenceValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceReferenceValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceReferenceValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceReferenceValue }
     * 
     * 
     */
    public List<InvoiceReferenceValue> getInvoiceReferenceValue() {
        if (invoiceReferenceValue == null) {
            invoiceReferenceValue = new ArrayList<InvoiceReferenceValue>();
        }
        return this.invoiceReferenceValue;
    }

    /**
     * Gets the value of the taxInvoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxInvoiceNumber() {
        return taxInvoiceNumber;
    }

    /**
     * Sets the value of the taxInvoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxInvoiceNumber(String value) {
        this.taxInvoiceNumber = value;
    }

    /**
     * Gets the value of the taxPointDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTaxPointDate() {
        return taxPointDate;
    }

    /**
     * Sets the value of the taxPointDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTaxPointDate(XMLGregorianCalendar value) {
        this.taxPointDate = value;
    }

    /**
     * Gets the value of the invoiceTaxClause property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceTaxClause property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceTaxClause().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getInvoiceTaxClause() {
        if (invoiceTaxClause == null) {
            invoiceTaxClause = new ArrayList<String>();
        }
        return this.invoiceTaxClause;
    }

    /**
     * Gets the value of the invoiceCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeBase }
     *     
     */
    public CurrencyCodeBase getInvoiceCurrencyCode() {
        return invoiceCurrencyCode;
    }

    /**
     * Sets the value of the invoiceCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeBase }
     *     
     */
    public void setInvoiceCurrencyCode(CurrencyCodeBase value) {
        this.invoiceCurrencyCode = value;
    }

    /**
     * Gets the value of the invoiceTotalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInvoiceTotalAmount() {
        return invoiceTotalAmount;
    }

    /**
     * Sets the value of the invoiceTotalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInvoiceTotalAmount(BigDecimal value) {
        this.invoiceTotalAmount = value;
    }

    /**
     * Gets the value of the invoiceDiscountAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInvoiceDiscountAmount() {
        return invoiceDiscountAmount;
    }

    /**
     * Sets the value of the invoiceDiscountAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInvoiceDiscountAmount(BigDecimal value) {
        this.invoiceDiscountAmount = value;
    }

    /**
     * Gets the value of the invoiceNotes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceNotes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceNotes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getInvoiceNotes() {
        if (invoiceNotes == null) {
            invoiceNotes = new ArrayList<String>();
        }
        return this.invoiceNotes;
    }

    /**
     * Gets the value of the invoiceIDDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceIDDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceIDDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceIDDetails }
     * 
     * 
     */
    public List<InvoiceIDDetails> getInvoiceIDDetails() {
        if (invoiceIDDetails == null) {
            invoiceIDDetails = new ArrayList<InvoiceIDDetails>();
        }
        return this.invoiceIDDetails;
    }

    /**
     * Gets the value of the invoiceTaxes property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceTaxes }
     *     
     */
    public InvoiceTaxes getInvoiceTaxes() {
        return invoiceTaxes;
    }

    /**
     * Sets the value of the invoiceTaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceTaxes }
     *     
     */
    public void setInvoiceTaxes(InvoiceTaxes value) {
        this.invoiceTaxes = value;
    }

}
