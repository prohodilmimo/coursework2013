/**
* NPNtool: Nested Petri Nets toolset.
*
* Copyright (c) 2013 Leonid Dworzanski. All rights reserved.
*
*/

package ru.mathtech.npntool.npnets.highlevelnets.common;

import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramNetSystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IDiagram Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.common.IDiagramHolder#getDiagram <em>Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @see ru.mathtech.npntool.npnets.highlevelnets.common.CommonPackage#getIDiagramHolder()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IDiagramHolder extends INetElement {

/* eperzhand */

	/**
	 * Returns the value of the '<em><b>Diagram</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramNetSystem#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram</em>' containment reference.
	 * @see #setDiagram(NPNDiagramNetSystem)
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.CommonPackage#getIDiagramHolder_Diagram()
	 * @see ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramNetSystem#getHost
	 * @model opposite="host" containment="true" required="true"
	 * @generated
	 */
	NPNDiagramNetSystem getDiagram();

	/**
	 * Sets the value of the '{@link ru.mathtech.npntool.npnets.highlevelnets.common.IDiagramHolder#getDiagram <em>Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram</em>' containment reference.
	 * @see #getDiagram()
	 * @generated
	 */
	void setDiagram(NPNDiagramNetSystem value);

} // IDiagramHolder
