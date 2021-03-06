package be.ehealth.businessconnector.hub.security;

import be.ehealth.businessconnector.hub.exception.FolderDecryptionRuntimeException;
import be.ehealth.technicalconnector.exception.TechnicalConnectorException;
import be.ehealth.technicalconnector.exception.UnsealConnectorException;
import be.ehealth.technicalconnector.service.etee.Crypto;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HubDecryptionHandler implements SOAPHandler<SOAPMessageContext> {
   private static final Logger LOG = LoggerFactory.getLogger(HubDecryptionHandler.class.getName());
   private Crypto crypto;

   public HubDecryptionHandler(Crypto crypto2) {
      this.crypto = crypto2;
   }

   public boolean handleMessage(SOAPMessageContext cxt) {
      if (cxt == null) {
         throw new IllegalArgumentException("The message cannot be handled since the SOAPMessageContext doesn't have a valid value");
      } else {
         Boolean outboundProperty = (Boolean)cxt.get("javax.xml.ws.handler.message.outbound");
         if (!outboundProperty.booleanValue()) {
            this.handleDecryption(cxt);
         }

         return true;
      }
   }

   private void handleDecryption(SOAPMessageContext cxt) {
      try {
         SOAPMessage soapMessage = cxt.getMessage();
         SOAPBody soapBody = soapMessage.getSOAPBody();
         if (soapBody == null) {
            SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
            soapBody = soapEnvelope.getBody();
         }

         FolderDecryptor.decryptFolder(soapBody, this.crypto);
         soapMessage.saveChanges();
      } catch (SOAPException var5) {
         LOG.error("SOAPException when handling the SOAP Body", var5);
      } catch (UnsealConnectorException var6) {
         LOG.error("UnsealConnectorException when handling the SOAP Message: " + var6.getMessage());
         throw new FolderDecryptionRuntimeException(var6.getMessage(), var6);
      } catch (TechnicalConnectorException var7) {
         LOG.error("TechnicalConnectorException when handling the SOAP Message: " + var7.getMessage());
      }

   }

   public boolean handleFault(SOAPMessageContext context) {
      return false;
   }

   public void close(MessageContext context) {
   }

   public Set<QName> getHeaders() {
      return null;
   }
}
