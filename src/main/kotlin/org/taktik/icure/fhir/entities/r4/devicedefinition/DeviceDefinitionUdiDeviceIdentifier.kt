//
//  Generated from FHIR Version 4.0.1-9346c8cc45
//
package org.taktik.icure.fhir.entities.r4.devicedefinition

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import kotlin.String
import kotlin.collections.List
import org.taktik.icure.fhir.entities.r4.backboneelement.BackboneElement
import org.taktik.icure.fhir.entities.r4.extension.Extension

/**
 * Unique Device Identifier (UDI) Barcode string
 *
 * Unique device identifier (UDI) assigned to device label or package.  Note that the Device may
 * include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction it is
 * sold, or for multiple jurisdictions it could have been sold.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class DeviceDefinitionUdiDeviceIdentifier(
  /**
   * The identifier that is to be associated with every Device that references this DeviceDefintiion
   * for the issuer and jurisdication porvided in the DeviceDefinition.udiDeviceIdentifier
   */
  var deviceIdentifier: String? = null,
  override var extension: List<Extension> = listOf(),
  /**
   * Unique id for inter-element referencing
   */
  override var id: String? = null,
  /**
   * The organization that assigns the identifier algorithm
   */
  var issuer: String? = null,
  /**
   * The jurisdiction to which the deviceIdentifier applies
   */
  var jurisdiction: String? = null,
  override var modifierExtension: List<Extension> = listOf()
) : BackboneElement
