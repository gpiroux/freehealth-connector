package be.fgov.ehealth.rn.baselegaldata.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
   name = "SpecialNotionType",
   propOrder = {"specialNotionCode", "specialNotionDescriptions"}
)
public class SpecialNotionType implements Serializable {
   private static final long serialVersionUID = 1L;
   @XmlElement(
      name = "SpecialNotionCode"
   )
   protected String specialNotionCode;
   @XmlElement(
      name = "SpecialNotionDescription"
   )
   protected List specialNotionDescriptions;

   public String getSpecialNotionCode() {
      return this.specialNotionCode;
   }

   public void setSpecialNotionCode(String value) {
      this.specialNotionCode = value;
   }

   public List getSpecialNotionDescriptions() {
      if (this.specialNotionDescriptions == null) {
         this.specialNotionDescriptions = new ArrayList();
      }

      return this.specialNotionDescriptions;
   }
}
