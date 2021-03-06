//
//  Generated from FHIR Version 4.0.1-9346c8cc45
//
package org.taktik.icure.fhir.entities.r4.nutritionorder

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import kotlin.String
import kotlin.collections.List
import org.taktik.icure.fhir.entities.r4.Quantity
import org.taktik.icure.fhir.entities.r4.backboneelement.BackboneElement
import org.taktik.icure.fhir.entities.r4.extension.Extension
import org.taktik.icure.fhir.entities.r4.ratio.Ratio
import org.taktik.icure.fhir.entities.r4.timing.Timing

/**
 * Formula feeding instruction as structured data
 *
 * Formula administration instructions as structured data.  This repeating structure allows for
 * changing the administration rate or volume over time for both bolus and continuous feeding.  An
 * example of this would be an instruction to increase the rate of continuous feeding every 2 hours.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class NutritionOrderEnteralFormulaAdministration(
  override var extension: List<Extension> = listOf(),
  /**
   * Unique id for inter-element referencing
   */
  override var id: String? = null,
  override var modifierExtension: List<Extension> = listOf(),
  /**
   * The volume of formula to provide
   */
  var quantity: Quantity? = null,
  /**
   * Speed with which the formula is provided per period of time
   */
  var rateQuantity: Quantity? = null,
  /**
   * Speed with which the formula is provided per period of time
   */
  var rateRatio: Ratio? = null,
  /**
   * Scheduled frequency of enteral feeding
   */
  var schedule: Timing? = null
) : BackboneElement
