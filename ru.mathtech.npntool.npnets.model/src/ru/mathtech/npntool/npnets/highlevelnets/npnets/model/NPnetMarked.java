/**
 */
package ru.mathtech.npntool.npnets.highlevelnets.npnets.model;

import ru.mathtech.npntool.npnets.highlevelnets.common.INetElement;

import ru.mathtech.npntool.npnets.highlevelnets.marking.Marking;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NPnet Marked</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnetMarked#getNet <em>Net</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnetMarked#getMarking <em>Marking</em>}</li>
 * </ul>
 * </p>
 *
 * @see ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPNetsPackage#getNPnetMarked()
 * @model
 * @generated
 */
public interface NPnetMarked extends INetElement {
	/**
	 * Returns the value of the '<em><b>Net</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Net</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Net</em>' containment reference.
	 * @see #setNet(NPnet)
	 * @see ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPNetsPackage#getNPnetMarked_Net()
	 * @see ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet#getHost
	 * @model opposite="host" containment="true" required="true"
	 * @generated
	 */
	NPnet getNet();

	/**
	 * Sets the value of the '{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnetMarked#getNet <em>Net</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net</em>' containment reference.
	 * @see #getNet()
	 * @generated
	 */
	void setNet(NPnet value);

	/**
	 * Returns the value of the '<em><b>Marking</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Marking</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Marking</em>' containment reference.
	 * @see #setMarking(Marking)
	 * @see ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPNetsPackage#getNPnetMarked_Marking()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Marking getMarking();

	/**
	 * Sets the value of the '{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnetMarked#getMarking <em>Marking</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Marking</em>' containment reference.
	 * @see #getMarking()
	 * @generated
	 */
	void setMarking(Marking value);

} // NPnetMarked
