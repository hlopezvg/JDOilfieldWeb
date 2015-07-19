package com.jdoilfield.operationalsystem.iata;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.cxf.javascript.ItemInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iata.iatafuelcodedirectory.BaseBasis;
import com.iata.iatafuelcodedirectory.CurrencyCodeBase;
import com.iata.iatafuelcodedirectory.InvoiceIDType;
import com.iata.iatafuelcodedirectory.InvoiceReferenceType;
import com.iata.iatafuelcodedirectory.InvoiceTransactionType;
import com.iata.iatafuelcodedirectory.InvoiceTypeBase;
import com.iata.iatafuelcodedirectory.ItemReferenceCode;
import com.iata.iatafuelcodedirectory.ItemReferenceDateType;
import com.iata.iatafuelcodedirectory.PUOMBase;
import com.iata.iatafuelcodedirectory.ProductIDBase;
import com.iata.iatafuelcodedirectory.ProductIDQualifier;
import com.iata.iatafuelcodedirectory.QuantityType;
import com.iata.iatafuelcodedirectory.RateTypeBase;
import com.iata.iatafuelcodedirectory.TaxTypeBase;
import com.iata.iatafuelcodedirectory.generated.Invoice;
import com.iata.iatafuelcodedirectory.generated.InvoiceHeader;
import com.iata.iatafuelcodedirectory.generated.InvoiceIDCustomField;
import com.iata.iatafuelcodedirectory.generated.InvoiceIDDetails;
import com.iata.iatafuelcodedirectory.generated.InvoiceLine;
import com.iata.iatafuelcodedirectory.generated.InvoiceReferenceValue;
import com.iata.iatafuelcodedirectory.generated.InvoiceSummary;
import com.iata.iatafuelcodedirectory.generated.InvoiceTaxDetail;
import com.iata.iatafuelcodedirectory.generated.InvoiceTransmission;
import com.iata.iatafuelcodedirectory.generated.InvoiceTransmissionHeader;
import com.iata.iatafuelcodedirectory.generated.InvoiceTransmissionSummary;
import com.iata.iatafuelcodedirectory.generated.InvoiceType;
import com.iata.iatafuelcodedirectory.generated.ItemDeliveryReferenceValue;
import com.iata.iatafuelcodedirectory.generated.ItemQuantity;
import com.iata.iatafuelcodedirectory.generated.ItemReferenceGMTDate;
import com.iata.iatafuelcodedirectory.generated.ItemReferenceLocalDate;
import com.iata.iatafuelcodedirectory.generated.ObjectFactory;
import com.iata.iatafuelcodedirectory.generated.SubInvoiceHeader;
import com.iata.iatafuelcodedirectory.generated.SubInvoiceIDDetails;
import com.iata.iatafuelcodedirectory.generated.SubInvoiceTaxDetail;
import com.iata.iatafuelcodedirectory.generated.SubItem;
import com.iata.iatafuelcodedirectory.generated.SubItemProduct;
import com.iata.iatafuelcodedirectory.generated.SubItemProductID;
import com.iata.iatafuelcodedirectory.generated.SubItemQuantity;
import com.iata.iatafuelcodedirectory.generated.SubItemTax;
import com.iata.iatafuelcodedirectory.generated.SubTax;
import com.jdoilfield.operationalsystem.domain.remote.IataInvoice;
import com.jdoilfield.operationalsystem.util.Utilities;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * 
 * @author hernan
 *
 */

public class GenerateInvoiceIATAStandard2_2 {
	private Unmarshaller unmarshaller;
	private JAXBContext jaxbContext;
	private InvoiceTransmission invoiceTransmission;
	private InvoiceTransmissionHeader invoiceTransmissionHeader;
	private Invoice invoice;
	private InvoiceHeader invoiceHeader;
	private InvoiceType invoiceType;
	private InvoiceReferenceValue invoiceReferenceValue;
	private InvoiceIDDetails invoiceIDDetails;
	private InvoiceTaxDetail invoiceTaxDetail;
	private SubInvoiceHeader subInvoiceHeader; 
	private SubInvoiceIDDetails subInvoiceIDDetails;
	private SubInvoiceTaxDetail subInvoiceTaxDetail;
	private InvoiceLine invoiceLine;
	private ItemQuantity itemQuantity;
	private ItemReferenceGMTDate  itemReferenceGMTDate;
	private SubItem subItem;
	private SubItemProduct subItemProduct;
	private SubItemProductID subItemProductID;
	private SubItemQuantity subItemQuantity;
	private SubItemTax subItemTax;
	private SubTax subTax;
	private InvoiceSummary invoiceSummary;
	private InvoiceTransmissionSummary invoiceTransmissionSummary;
	private Marshaller marshaller;
	private String xmlResult;
	private Calendar cal_;
	private int invoiceMessageCount;
	private int invoiceLineItemNumber;
	protected final Logger logger;

	
	//Generate first the context for JAXB Binding
	public GenerateInvoiceIATAStandard2_2() {
		this.logger = LoggerFactory.getLogger(GenerateInvoiceIATAStandard2_2.class);
		try {
			jaxbContext = JAXBContext.newInstance("com.iata.iatafuelcodedirectory.generated");
			//Create the marshaller
			//unmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	
	}
	
	//This Method, actually does the Job
	
	/**
	 * @param 
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public String createXMLInvoice(List<IataInvoice>  iataInvoiceList){
		ObjectFactory factory = new ObjectFactory();
		//invoiceTransmission
		invoiceTransmission = factory.createInvoiceTransmission();
		//invoiceTransmissionSummary
		invoiceTransmissionSummary = factory.createInvoiceTransmissionSummary();
		//invoice 
		invoice = factory.createInvoice();
		//invoiceTransmissionHeader 
		invoiceTransmissionHeader = factory.createInvoiceTransmissionHeader();
		//invoice header
		invoiceHeader = factory.createInvoiceHeader(); 
		//invoice summary
		invoiceSummary = factory.createInvoiceSummary();
		//invoice Type
		invoiceType = factory.createInvoiceType();
		//invoice Reference Value
		invoiceReferenceValue = factory.createInvoiceReferenceValue();
		//invoiceIDDetails
		invoiceIDDetails = factory.createInvoiceIDDetails();
		//InvoiceIDCustomField
		InvoiceIDCustomField invoiceIDCustomField_1 = factory.createInvoiceIDCustomField();
		InvoiceIDCustomField invoiceIDCustomField_2 = factory.createInvoiceIDCustomField();
		//Invoice TransmissionSumary
		invoiceTransmissionSummary = factory.createInvoiceTransmissionSummary();
		//SubInvoiceHeader
		subInvoiceHeader = factory.createSubInvoiceHeader();
		//invoiceLine
		invoiceLine = factory.createInvoiceLine();
		//itemQuantity
		itemQuantity = factory.createItemQuantity();
		//itemDeliveryReferenceValue 
		ItemDeliveryReferenceValue itemDeliveryReferenceValue_ARN = factory.createItemDeliveryReferenceValue();
		ItemDeliveryReferenceValue itemDeliveryReferenceValue_FNO= factory.createItemDeliveryReferenceValue();
		ItemDeliveryReferenceValue itemDeliveryReferenceValue_NF = factory.createItemDeliveryReferenceValue();
		//itemReferenceLocalDate 
		ItemReferenceLocalDate itemReferenceLocalDate_DTA = factory.createItemReferenceLocalDate();
		ItemReferenceLocalDate itemReferenceLocalDate_RE = factory.createItemReferenceLocalDate();
		ItemReferenceLocalDate itemReferenceLocalDate_RS = factory.createItemReferenceLocalDate();
		//subItem 
		subItem = factory.createSubItem();
		//subItemProduct
		subItemProduct = factory.createSubItemProduct();
		//subItemProductID
		subItemProductID = factory.createSubItemProductID();
		//subItemQuantity
		subItemQuantity = factory.createSubItemQuantity();
		//subItemTax
		subItemTax = factory.createSubItemTax();
		
		//END OF INITALIZATION OF ELEMENTS
		
		//INIT FILL THE ELEMENTS
		try {
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = df.parse(iataInvoiceList.get(0).getInvoiceIssueSyncDate());
			cal_ = new GregorianCalendar();
			cal_.setTime(date);
			cal_.getTimeZone();
			invoiceTransmissionHeader.setInvoiceCreationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal_.get(Calendar.YEAR),
					cal_.get(Calendar.MONTH), cal_.get(Calendar.DAY_OF_MONTH), cal_.get(Calendar.HOUR), cal_.get(Calendar.MINUTE),
					cal_.get(Calendar.SECOND), cal_.get(Calendar.MILLISECOND), TimeZone.LONG));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		invoiceTransmissionHeader.setVersion("2.0.2");
		//
		//Recomended (D.U.N.S) del Cliente
		invoiceHeader.setCustomerEntityID(iataInvoiceList.get(0).getCardCode());
		invoiceHeader.setIssuingEntityID("JDOilfield International S.A (D.U.N.S)");
		invoiceHeader.setInvoiceNumber(iataInvoiceList.get(0).getInvoiceNumber());
		try {
			invoiceHeader.setInvoiceIssueDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal_.get(Calendar.YEAR),
					cal_.get(Calendar.MONTH), cal_.get(Calendar.DAY_OF_MONTH), cal_.get(Calendar.HOUR), cal_.get(Calendar.MINUTE),
					cal_.get(Calendar.SECOND), cal_.get(Calendar.MILLISECOND), TimeZone.LONG));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		//Si el numero de linea es mayor a 1.
		invoiceHeader.setInvoiceDeliveryLocation("MULTIPLE");		
//		//This value can be repeated up to 12 times, and can use to represent Ticket Code and Purchase orden number
		
		invoiceHeader.setTaxInvoiceNumber("T A X   G O E S   H E R E ! ! ! ");
		invoiceHeader.setInvoiceCurrencyCode(CurrencyCodeBase.USD);
		invoiceHeader.setInvoiceTotalAmount(BigDecimal.valueOf(Double.valueOf(iataInvoiceList.get(0).getInvoiceTotalAmount())));
		//invoiceHeader.setInvoicePaymentTermsNetDueDate(XMLGregorianCalendar)  EXPI
		
		//Para el campo INVOICE Type sacamos este valor
		invoiceType.setValue(InvoiceTypeBase.INV);
		invoiceType.setInvoiceTransactionType(InvoiceTransactionType.CA);
		//
		//Sales of Order
        invoiceReferenceValue.setInvoiceReferenceType(InvoiceReferenceType.SO);		
		
        //invoiceIDDetails
        //Bill TO
        invoiceIDDetails.setInvoiceIDType(InvoiceIDType.BT);
        
        //InvoiceIDCustomField
        invoiceIDCustomField_1.setID(1);
		invoiceIDCustomField_1.setInvoiceIDCustomFieldDescription("Start Period");
		invoiceIDCustomField_1.setInvoiceIDCustomFieldValue("T H E   D A T E   O F   T H E  P E R I O D   G O E S   H E R E ");
		
		invoiceIDCustomField_2.setID(2);
		invoiceIDCustomField_2.setInvoiceIDCustomFieldDescription("End  Period");
		invoiceIDCustomField_2.setInvoiceIDCustomFieldValue("T H E   D A T E   O F   T H E  P E R I O D   G O E S   H E R E ");
		
		//Total invoice Lines Count
		invoiceSummary.setInvoiceLineCount(BigInteger.valueOf(2L));
		invoiceSummary.setTotalInvoiceLineAmount(BigDecimal.valueOf(Double.valueOf(iataInvoiceList.get(0).getInvoiceTotalAmount())));
		invoiceSummary.setTotalInvoiceTaxAmount(BigDecimal.valueOf(Double.valueOf(0.0000000000)));	
	
		//------>    SUBINVOICE HEADER  ------>
		//	
		itemQuantity.setItemQuantityType(QuantityType.IN);
		itemQuantity.setItemQuantityFlag(BaseBasis.GR);
		itemQuantity.setItemQuantityQty(BigDecimal.valueOf(Double.valueOf(iataInvoiceList.get(0).getItemQuantityQty())));
		//TODO LIST   
		//-----------> Check here the way to get Lts or Gal
		itemQuantity.setItemQuantityUOM(PUOMBase.USG);
		
		invoiceLine.setItemNumber(invoiceLineItemNumber + 1);
		invoiceLine.getItemQuantity().add(itemQuantity);
		
		subInvoiceHeader.setSubInvoiceNumber(iataInvoiceList.get(0).getInvoiceNumber());		
		//TODO LIST --> we must check here that is allowed to used MULTIPLE, depending on the client, the example use CGH
		subInvoiceHeader.getInvoiceLine().add(invoiceLine);
		invoiceLine.setItemDeliveryLocation("MULTIPLE");
		//The ItemInvoiceAmount is the sum of all SubItemInvoiceAmount including taxes
		//TODO LIST  --> CHECK THE AMOUNT
		invoiceLine.setItemInvoiceAmount(BigDecimal.valueOf(Double.valueOf(iataInvoiceList.get(0).getInvoiceTotalAmount())));

		//Create a collection of itemReferenceLocalDate 		
		List<ItemReferenceLocalDate> itemReferenceLocalDate = new ArrayList<ItemReferenceLocalDate>();
		try {
			//CHECK THE DATE
			itemReferenceLocalDate_DTA.setItemReferenceDateTypes(ItemReferenceDateType.DTA.toString());
			itemReferenceLocalDate_DTA.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) Utilities.parseDateToCalendar(new Date())));  
			itemReferenceLocalDate.add(itemReferenceLocalDate_DTA);
			
			itemReferenceLocalDate_RE.setItemReferenceDateTypes(ItemReferenceDateType.RE.toString());
			itemReferenceLocalDate_RE.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) Utilities.parseDateToCalendar(new Date())));
			itemReferenceLocalDate.add(itemReferenceLocalDate_RE);
			
			itemReferenceLocalDate_RS.setItemReferenceDateTypes(ItemReferenceDateType.RS.toString());
			itemReferenceLocalDate_RS.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) Utilities.parseDateToCalendar(new Date())));
			itemReferenceLocalDate.add(itemReferenceLocalDate_RS);
			
		} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
		}
		
		//See Section Q Code Directory		
		//Create a collection of ItemDeliveryReferenceValue
		List<ItemDeliveryReferenceValue> itemDeliveryReferenceValue = new ArrayList<ItemDeliveryReferenceValue>(); 
		itemDeliveryReferenceValue_ARN.setItemDeliveryReferenceType(ItemReferenceCode.ARN);
		itemDeliveryReferenceValue_ARN.setValue(iataInvoiceList.get(0).getItemDeliveryReferenceValue_AircraftNumber());
		itemDeliveryReferenceValue.add(itemDeliveryReferenceValue_ARN);
		
		itemDeliveryReferenceValue_FNO.setItemDeliveryReferenceType(ItemReferenceCode.FNO);
		itemDeliveryReferenceValue_FNO.setValue(" A I R L I N E  C O D E");
		itemDeliveryReferenceValue.add(itemDeliveryReferenceValue_FNO);
		
		itemDeliveryReferenceValue_NF.setItemDeliveryReferenceType(ItemReferenceCode.NDT);
		itemDeliveryReferenceValue_NF.setValue("E R R O R   N F   N/A");
		itemDeliveryReferenceValue.add(itemDeliveryReferenceValue_NF);
		
		//Create a collection of SubItemProduct
		List<SubItemProduct> subItemProductList = new ArrayList<SubItemProduct>();
		
		//Validate what is the product that comes from SAP
		subItemProductID.setSubItemProductIDQualifier(ProductIDQualifier.PRDT);
		//if(iataInvoiceList.get(0).getProductIDBase().contains("JETA-1")){
		subItemProductID.setValue(ProductIDBase.JETA_1);	
		//}
		
		//
		subItemProduct.setSubItemProductID(subItemProductID);
		subItemProduct.setSubItemPricingUnitRateType(RateTypeBase.UR);
		//		Need to accommodate unit rate or flat fees governed by airport authority or fuel farm consotrium etc. (variable or unit rate based on criteria) need qualifier
		subItemProduct.setSubItemPricingUnitRate(BigDecimal.valueOf(Double.valueOf(iataInvoiceList.get(0).getRate())));
		subItemProduct.setSubItemPricingCurrencyCode(CurrencyCodeBase.USD);
		//This is the value of the PROVIDER WE MUST VALIDATE THAT
		subItemProduct.setSubItemPricingAmount(BigDecimal.valueOf(Double.valueOf(iataInvoiceList.get(0).getProviderPrice())));
		subItemProduct.setSubItemPricingUOM(PUOMBase.USG);
		//SubItemInvoiceAmount is the sum of the SubItem excluding taxes (quantity * unit rate) + SubItemTaxInvoiceAmount and SubTaxInvoiceAmount
		subItemProduct.setSubItemInvoiceAmount(BigDecimal.valueOf(0.00000000000000));
		//CHECK THIS VALUE
		subItemProduct.setSubItemInvoiceUnitRate(BigDecimal.valueOf(0.0000));
		//TODO LIST
		subItemQuantity.setSubItemInvoiceQuantity(BigDecimal.valueOf(0.00000));
		subItemQuantity.setSubItemQuantityType(QuantityType.IN);
		subItemQuantity.setSubItemQuantityFlag(BaseBasis.GR);
		//OJO ---->>
		subItem.getSubItemProduct().add(subItemProduct);
		subItemProduct.setSubItemQuantity(subItemQuantity);
		//invoiceLine.getSubItem().add(subItem);
		
		//SectionF
		//TOD LIST CHECH IF THIS TAX IS APPLICABLE
		subItemTax.setSubItemTaxType(TaxTypeBase.OTH);
		//TODO LIST CHECK IF THIS IS APPLICABLE
		
		subItemTax.setSubItemTaxRateType(RateTypeBase.P);
		subItemTax.setSubItemTaxPricingCurrencyCode(CurrencyCodeBase.USD);
		subItemTax.setSubItemTaxPricingAmount(BigDecimal.valueOf(0.0000000));
		//CHECK THIS VALUE
		subItemTax.setSubItemTaxInvoiceUOM(PUOMBase.PCT);
		subItemTax.setSubItemTaxPricingUOM(PUOMBase.PCT);
		//subItemTax.setSubItemTaxInvoiceUnitRate(null);
		//subItemTax.setSubItemTaxInvoiceAmount(null);
		
		
		
		subItemProduct.getSubItemTax().add(subItemTax);
//		
//		//
//		subTax = factory.createSubTax();
//		subTax.setSubTaxType(value);
//		subTax.setSubTaxRateType(value);
//		subTax.setSubTaxPricingCurrencyCode(value);
//		subTax.getSubTaxExchangeRate().setSubTaxConversionFactor(value);
//		subTax.setSubTaxPricingAmount(value);
//		subTax.setSubTaxInvoiceCurrencyCode(value);
//		subTax.setSubTaxInvoiceUnitRate(value);
//		subTax.setSubTaxInvoiceAmount(value);
//		
		
//		invoiceIDDetails = factory.createInvoiceIDDetails();
//		invoiceIDDetails.setInvoiceIDType(value);
//		invoiceIDDetails.setInvoiceIDVATRegistrationNumber(value);
//		invoiceIDDetails.setInvoiceIDName1(value);
//		
//		//
//		invoiceIDCustomField = factory.createInvoiceIDCustomField();
//		invoiceIDCustomField.setID(value);
//		
//		//
//		invoiceTaxDetail = factory.createInvoiceTaxDetail();
//		invoiceTaxDetail.setInvoiceTaxDetailType(value);
//		invoiceTaxDetail.setInvoiceTaxDetailRate(value);
//		invoiceTaxDetail.setInvoiceTaxDetailAmount(value);
//		
//		//
//		subInvoiceIDDetails = factory.createSubInvoiceIDDetails();
//		subInvoiceIDDetails.setSubInvoiceIDType(value);
//		subInvoiceIDDetails.setSubInvoiceIDVATRegistrationNumber(value);
//		subInvoiceIDDetails.setSubInvoiceIDName1(value);
//		subInvoiceIDDetails.getSubInvoiceIDCustomField().get(0).setID(value);
//		subInvoiceIDDetails.getSubInvoiceIDCustomField().get(0).setSubInvoiceIDCustomFieldValue(value);
//		
//		//
//		subInvoiceTaxDetail = factory.createSubInvoiceTaxDetail();
//		subInvoiceTaxDetail.setSubInvoiceTaxDetailType(value);
//		subInvoiceTaxDetail.setSubInvoiceTaxDetailRate(value);
//		subInvoiceTaxDetail.setSubInvoiceTaxDetailAmount(value);
//		

//
//		
//		//
//		itemReferenceGMTDate  = factory.createItemReferenceGMTDate(); 
//		itemReferenceGMTDate.setItemReferenceDateTypes(value);
//		
	
		//
		//BUILD BLOCK, ADD ALL THE ELEMENTS
		invoice.setInvoiceHeader(invoiceHeader);
		invoice.setInvoiceSummary(invoiceSummary);
		invoice.getSubInvoiceHeader().add(subInvoiceHeader);
		//

		
		//if we set only one node of invoice, the  invoiceMessageCount will be +1 each new node
		invoiceMessageCount=+1;
		//
		
		invoiceHeader.getInvoiceIDDetails().add(invoiceIDDetails);
		invoiceHeader.setInvoiceType(invoiceType);
		
		
		invoiceIDDetails.getInvoiceIDCustomField().add(invoiceIDCustomField_1);
		invoiceIDDetails.getInvoiceIDCustomField().add(invoiceIDCustomField_2);
		
		invoiceTransmission.getInvoice().add(invoice);
		invoiceTransmission.setInvoiceTransmissionHeader(invoiceTransmissionHeader);
		invoiceTransmission.setInvoiceTransmissionSummary(invoiceTransmissionSummary);
		
		//
		invoiceLine.getItemReferenceLocalDate().addAll(itemReferenceLocalDate);
		invoiceLine.getItemDeliveryReferenceValue().addAll(itemDeliveryReferenceValue);
		invoiceLine.getSubItem().add(subItem);
		//
		invoiceTransmissionSummary.setInvoiceMessageCount(invoiceMessageCount);
		
		//Marshal InvoiceTransmission to XML
		
		try {
			marshaller = jaxbContext.createMarshaller();
			StringWriter writer = new StringWriter();
			marshaller.marshal(invoiceTransmission, writer);
			//logger.info(writer.toString());
			xmlResult = writer.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xmlResult;
	}
}
