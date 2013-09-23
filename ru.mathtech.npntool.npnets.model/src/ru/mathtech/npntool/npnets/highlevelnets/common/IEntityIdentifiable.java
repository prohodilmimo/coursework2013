/**
 */
package ru.mathtech.npntool.npnets.highlevelnets.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IEntity Identifiable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.common.IEntityIdentifiable#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see ru.mathtech.npntool.npnets.highlevelnets.common.CommonPackage#getIEntityIdentifiable()
 * @model abstract="true"
 * @generated
 */
public interface IEntityIdentifiable extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.CommonPackage#getIEntityIdentifiable_Id()
	 * @model default="" id="true" required="true" ordered="false"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link ru.mathtech.npntool.npnets.highlevelnets.common.IEntityIdentifiable#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // IEntityIdentifiable
