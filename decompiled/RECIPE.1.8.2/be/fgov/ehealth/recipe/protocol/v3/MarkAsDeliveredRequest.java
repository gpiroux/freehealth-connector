package be.fgov.ehealth.recipe.protocol.v3;

import be.fgov.ehealth.commons.protocol.v1.RequestType;
import be.fgov.ehealth.recipe.core.v3.ExecutorServiceAdministrativeInformationType;
import be.fgov.ehealth.recipe.core.v3.SecuredContentType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
   name = "MarkAsDeliveredRequestType",
   propOrder = {"securedMarkAsDeliveredRequest", "administrativeInformation"}
)
@XmlRootElement(
   name = "MarkAsDeliveredRequest"
)
public class MarkAsDeliveredRequest extends RequestType {
   @XmlElement(
      name = "SecuredMarkAsDeliveredRequest",
      required = true
   )
   protected SecuredContentType securedMarkAsDeliveredRequest;
   @XmlElement(
      name = "AdministrativeInformation",
      required = true
   )
   protected ExecutorServiceAdministrativeInformationType administrativeInformation;

   public SecuredContentType getSecuredMarkAsDeliveredRequest() {
      return this.securedMarkAsDeliveredRequest;
   }

   public void setSecuredMarkAsDeliveredRequest(SecuredContentType value) {
      this.securedMarkAsDeliveredRequest = value;
   }

   public ExecutorServiceAdministrativeInformationType getAdministrativeInformation() {
      return this.administrativeInformation;
   }

   public void setAdministrativeInformation(ExecutorServiceAdministrativeInformationType value) {
      this.administrativeInformation = value;
   }
}
