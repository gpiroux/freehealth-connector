//
//  Generated from FHIR Version 4.0.1-9346c8cc45
//
package org.taktik.icure.fhir.entities.r4.substanceprotein

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.taktik.icure.fhir.entities.r4.attachment.Attachment
import org.taktik.icure.fhir.entities.r4.backboneelement.BackboneElement
import org.taktik.icure.fhir.entities.r4.extension.Extension
import org.taktik.icure.fhir.entities.r4.identifier.Identifier

/**
 * This subclause refers to the description of each subunit constituting the SubstanceProtein. A
 * subunit is a linear sequence of amino acids linked through peptide bonds. The Subunit information
 * shall be provided when the finished SubstanceProtein is a complex of multiple sequences; subunits
 * are not used to delineate domains within a single sequence. Subunits are listed in order of
 * decreasing length; sequences of the same length will be ordered by decreasing molecular weight;
 * subunits that have identical sequences will be repeated multiple times
 *
 * This subclause refers to the description of each subunit constituting the SubstanceProtein. A
 * subunit is a linear sequence of amino acids linked through peptide bonds. The Subunit information
 * shall be provided when the finished SubstanceProtein is a complex of multiple sequences; subunits
 * are not used to delineate domains within a single sequence. Subunits are listed in order of
 * decreasing length; sequences of the same length will be ordered by decreasing molecular weight;
 * subunits that have identical sequences will be repeated multiple times.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class SubstanceProteinSubunit(
  /**
   * The modification at the C-terminal shall be specified
   */
  var cTerminalModification: String? = null,
  /**
   * Unique identifier for molecular fragment modification based on the ISO 11238 Substance ID
   */
  var cTerminalModificationId: Identifier? = null,
  override var extension: List<Extension> = listOf(),
  /**
   * Unique id for inter-element referencing
   */
  override var id: String? = null,
  /**
   * Length of linear sequences of amino acids contained in the subunit
   */
  var length: Int? = null,
  override var modifierExtension: List<Extension> = listOf(),
  /**
   * The name of the fragment modified at the N-terminal of the SubstanceProtein shall be specified
   */
  var nTerminalModification: String? = null,
  /**
   * Unique identifier for molecular fragment modification based on the ISO 11238 Substance ID
   */
  var nTerminalModificationId: Identifier? = null,
  /**
   * The sequence information shall be provided enumerating the amino acids from N- to C-terminal
   * end using standard single-letter amino acid codes. Uppercase shall be used for L-amino acids and
   * lowercase for D-amino acids. Transcribed SubstanceProteins will always be described using the
   * translated sequence; for synthetic peptide containing amino acids that are not represented with a
   * single letter code an X should be used within the sequence. The modified amino acids will be
   * distinguished by their position in the sequence
   */
  var sequence: String? = null,
  /**
   * The sequence information shall be provided enumerating the amino acids from N- to C-terminal
   * end using standard single-letter amino acid codes. Uppercase shall be used for L-amino acids and
   * lowercase for D-amino acids. Transcribed SubstanceProteins will always be described using the
   * translated sequence; for synthetic peptide containing amino acids that are not represented with a
   * single letter code an X should be used within the sequence. The modified amino acids will be
   * distinguished by their position in the sequence
   */
  var sequenceAttachment: Attachment? = null,
  /**
   * Index of primary sequences of amino acids linked through peptide bonds in order of decreasing
   * length. Sequences of the same length will be ordered by molecular weight. Subunits that have
   * identical sequences will be repeated and have sequential subscripts
   */
  var subunit: Int? = null
) : BackboneElement
