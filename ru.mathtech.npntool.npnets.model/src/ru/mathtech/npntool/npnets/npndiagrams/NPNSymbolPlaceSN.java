/**
 */
package ru.mathtech.npntool.npnets.npndiagrams;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NPN Symbol Place SN</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolPlaceSN#getOutArcs <em>Out Arcs</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolPlaceSN#getInArcs <em>In Arcs</em>}</li>
 * </ul>
 * </p>
 *
 * @see ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramsPackage#getNPNSymbolPlaceSN()
 * @model
 * @generated
 */
public interface NPNSymbolPlaceSN extends NPNSymbolNodeSN {
	/**
	 * Returns the value of the '<em><b>Out Arcs</b></em>' reference list.
	 * The list contents are of type {@link ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcPTSN}.
	 * It is bidirectional and its opposite is '{@link ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcPTSN#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Arcs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Arcs</em>' reference list.
	 * @see ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramsPackage#getNPNSymbolPlaceSN_OutArcs()
	 * @see ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcPTSN#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<NPNSymbolArcPTSN> getOutArcs();

	/**
	 * Returns the value of the '<em><b>In Arcs</b></em>' reference list.
	 * The list contents are of type {@link ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcTPSN}.
	 * It is bidirectional and its opposite is '{@link ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcTPSN#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Arcs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Arcs</em>' reference list.
	 * @see ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramsPackage#getNPNSymbolPlaceSN_InArcs()
	 * @see ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcTPSN#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<NPNSymbolArcTPSN> getInArcs();

} // NPNSymbolPlaceSN
