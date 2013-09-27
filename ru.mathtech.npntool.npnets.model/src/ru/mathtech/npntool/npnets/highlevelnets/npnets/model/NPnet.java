/**
 */
package ru.mathtech.npntool.npnets.highlevelnets.npnets.model;

import org.eclipse.emf.common.util.EList;

import ru.mathtech.npntool.npnets.highlevelnets.common.IDiagramHolder;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;

import ru.mathtech.npntool.npnets.highlevelnets.tokenexpressions.NetConstant;

import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.TokenTypeAtomic;
import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.TokenTypeElementNet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NPnet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet#getNetSystem <em>Net System</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet#getTypeElementNet <em>Type Element Net</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet#getTypeAtomic <em>Type Atomic</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet#getNetConstants <em>Net Constants</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet#getSynchronizations <em>Synchronizations</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet#getHost <em>Host</em>}</li>
 * </ul>
 * </p>
 *
 * @see ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPNetsPackage#getNPnet()
 * @model
 * @generated
 */
public interface NPnet extends IDiagramHolder {
	/**
	 * Returns the value of the '<em><b>Net System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Net System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Net System</em>' containment reference.
	 * @see #setNetSystem(HighLevelPetriNet)
	 * @see ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPNetsPackage#getNPnet_NetSystem()
	 * @model containment="true" required="true"
	 * @generated
	 */
	HighLevelPetriNet getNetSystem();

	/**
	 * Sets the value of the '{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet#getNetSystem <em>Net System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net System</em>' containment reference.
	 * @see #getNetSystem()
	 * @generated
	 */
	void setNetSystem(HighLevelPetriNet value);

	/**
	 * Returns the value of the '<em><b>Type Element Net</b></em>' containment reference list.
	 * The list contents are of type {@link ru.mathtech.npntool.npnets.highlevelnets.tokentypes.TokenTypeElementNet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Element Net</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Element Net</em>' containment reference list.
	 * @see ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPNetsPackage#getNPnet_TypeElementNet()
	 * @model containment="true"
	 * @generated
	 */
	EList<TokenTypeElementNet> getTypeElementNet();

	/**
	 * Returns the value of the '<em><b>Type Atomic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Atomic</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Atomic</em>' containment reference.
	 * @see #setTypeAtomic(TokenTypeAtomic)
	 * @see ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPNetsPackage#getNPnet_TypeAtomic()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TokenTypeAtomic getTypeAtomic();

	/**
	 * Sets the value of the '{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet#getTypeAtomic <em>Type Atomic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Atomic</em>' containment reference.
	 * @see #getTypeAtomic()
	 * @generated
	 */
	void setTypeAtomic(TokenTypeAtomic value);

	/**
	 * Returns the value of the '<em><b>Net Constants</b></em>' containment reference list.
	 * The list contents are of type {@link ru.mathtech.npntool.npnets.highlevelnets.tokenexpressions.NetConstant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Net Constants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Net Constants</em>' containment reference list.
	 * @see ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPNetsPackage#getNPnet_NetConstants()
	 * @model containment="true"
	 * @generated
	 */
	EList<NetConstant> getNetConstants();

	/**
	 * Returns the value of the '<em><b>Synchronizations</b></em>' containment reference list.
	 * The list contents are of type {@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.Synchronization}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synchronizations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synchronizations</em>' containment reference list.
	 * @see ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPNetsPackage#getNPnet_Synchronizations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Synchronization> getSynchronizations();

	/**
	 * Returns the value of the '<em><b>Host</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnetMarked#getNet <em>Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' container reference.
	 * @see #setHost(NPnetMarked)
	 * @see ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPNetsPackage#getNPnet_Host()
	 * @see ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnetMarked#getNet
	 * @model opposite="net" required="true" transient="false"
	 * @generated
	 */
	NPnetMarked getHost();

	/**
	 * Sets the value of the '{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet#getHost <em>Host</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host</em>' container reference.
	 * @see #getHost()
	 * @generated
	 */
	void setHost(NPnetMarked value);

} // NPnet
