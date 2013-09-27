/**
 */
package ru.mathtech.npntool.npnets.highlevelnets.common;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ru.mathtech.npntool.npnets.highlevelnets.common.CommonFactory
 * @model kind="package"
 * @generated
 */
public interface CommonPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "common"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:/mathtech.ru/npntool/common"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "common"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonPackage eINSTANCE = ru.mathtech.npntool.npnets.highlevelnets.common.impl.CommonPackageImpl.init();

	/**
	 * The meta object id for the '{@link ru.mathtech.npntool.npnets.highlevelnets.common.impl.IEntityIdentifiableImpl <em>IEntity Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.impl.IEntityIdentifiableImpl
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.impl.CommonPackageImpl#getIEntityIdentifiable()
	 * @generated
	 */
	int IENTITY_IDENTIFIABLE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENTITY_IDENTIFIABLE__ID = 0;

	/**
	 * The number of structural features of the '<em>IEntity Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENTITY_IDENTIFIABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link ru.mathtech.npntool.npnets.highlevelnets.common.impl.INetElementImpl <em>INet Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.impl.INetElementImpl
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.impl.CommonPackageImpl#getINetElement()
	 * @generated
	 */
	int INET_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ELEMENT__ID = IENTITY_IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ELEMENT__NAME = IENTITY_IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ELEMENT__COMMENT = IENTITY_IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>INet Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ELEMENT_FEATURE_COUNT = IENTITY_IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ru.mathtech.npntool.npnets.highlevelnets.common.IDiagramHolder <em>IDiagram Holder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.IDiagramHolder
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.impl.CommonPackageImpl#getIDiagramHolder()
	 * @generated
	 */
	int IDIAGRAM_HOLDER = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDIAGRAM_HOLDER__ID = INET_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDIAGRAM_HOLDER__NAME = INET_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDIAGRAM_HOLDER__COMMENT = INET_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDIAGRAM_HOLDER__DIAGRAM = INET_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IDiagram Holder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDIAGRAM_HOLDER_FEATURE_COUNT = INET_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>Rectangle</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.draw2d.geometry.Rectangle
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.impl.CommonPackageImpl#getRectangle()
	 * @generated
	 */
	int RECTANGLE = 3;

	/**
	 * The meta object id for the '<em>Point</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.draw2d.geometry.Point
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.impl.CommonPackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 4;


	/**
	 * Returns the meta object for class '{@link ru.mathtech.npntool.npnets.highlevelnets.common.INetElement <em>INet Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>INet Element</em>'.
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.INetElement
	 * @generated
	 */
	EClass getINetElement();

	/**
	 * Returns the meta object for the attribute '{@link ru.mathtech.npntool.npnets.highlevelnets.common.INetElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.INetElement#getName()
	 * @see #getINetElement()
	 * @generated
	 */
	EAttribute getINetElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link ru.mathtech.npntool.npnets.highlevelnets.common.INetElement#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.INetElement#getComment()
	 * @see #getINetElement()
	 * @generated
	 */
	EAttribute getINetElement_Comment();

	/**
	 * Returns the meta object for class '{@link ru.mathtech.npntool.npnets.highlevelnets.common.IEntityIdentifiable <em>IEntity Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IEntity Identifiable</em>'.
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.IEntityIdentifiable
	 * @generated
	 */
	EClass getIEntityIdentifiable();

	/**
	 * Returns the meta object for the attribute '{@link ru.mathtech.npntool.npnets.highlevelnets.common.IEntityIdentifiable#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.IEntityIdentifiable#getId()
	 * @see #getIEntityIdentifiable()
	 * @generated
	 */
	EAttribute getIEntityIdentifiable_Id();

	/**
	 * Returns the meta object for class '{@link ru.mathtech.npntool.npnets.highlevelnets.common.IDiagramHolder <em>IDiagram Holder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IDiagram Holder</em>'.
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.IDiagramHolder
	 * @generated
	 */
	EClass getIDiagramHolder();

	/**
	 * Returns the meta object for the containment reference '{@link ru.mathtech.npntool.npnets.highlevelnets.common.IDiagramHolder#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Diagram</em>'.
	 * @see ru.mathtech.npntool.npnets.highlevelnets.common.IDiagramHolder#getDiagram()
	 * @see #getIDiagramHolder()
	 * @generated
	 */
	EReference getIDiagramHolder_Diagram();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Rectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Rectangle</em>'.
	 * @see org.eclipse.draw2d.geometry.Rectangle
	 * @model instanceClass="org.eclipse.draw2d.geometry.Rectangle"
	 * @generated
	 */
	EDataType getRectangle();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Point</em>'.
	 * @see org.eclipse.draw2d.geometry.Point
	 * @model instanceClass="org.eclipse.draw2d.geometry.Point"
	 * @generated
	 */
	EDataType getPoint();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommonFactory getCommonFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ru.mathtech.npntool.npnets.highlevelnets.common.impl.INetElementImpl <em>INet Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ru.mathtech.npntool.npnets.highlevelnets.common.impl.INetElementImpl
		 * @see ru.mathtech.npntool.npnets.highlevelnets.common.impl.CommonPackageImpl#getINetElement()
		 * @generated
		 */
		EClass INET_ELEMENT = eINSTANCE.getINetElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ELEMENT__NAME = eINSTANCE.getINetElement_Name();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ELEMENT__COMMENT = eINSTANCE.getINetElement_Comment();

		/**
		 * The meta object literal for the '{@link ru.mathtech.npntool.npnets.highlevelnets.common.impl.IEntityIdentifiableImpl <em>IEntity Identifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ru.mathtech.npntool.npnets.highlevelnets.common.impl.IEntityIdentifiableImpl
		 * @see ru.mathtech.npntool.npnets.highlevelnets.common.impl.CommonPackageImpl#getIEntityIdentifiable()
		 * @generated
		 */
		EClass IENTITY_IDENTIFIABLE = eINSTANCE.getIEntityIdentifiable();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IENTITY_IDENTIFIABLE__ID = eINSTANCE.getIEntityIdentifiable_Id();

		/**
		 * The meta object literal for the '{@link ru.mathtech.npntool.npnets.highlevelnets.common.IDiagramHolder <em>IDiagram Holder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ru.mathtech.npntool.npnets.highlevelnets.common.IDiagramHolder
		 * @see ru.mathtech.npntool.npnets.highlevelnets.common.impl.CommonPackageImpl#getIDiagramHolder()
		 * @generated
		 */
		EClass IDIAGRAM_HOLDER = eINSTANCE.getIDiagramHolder();

		/**
		 * The meta object literal for the '<em><b>Diagram</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDIAGRAM_HOLDER__DIAGRAM = eINSTANCE.getIDiagramHolder_Diagram();

		/**
		 * The meta object literal for the '<em>Rectangle</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.draw2d.geometry.Rectangle
		 * @see ru.mathtech.npntool.npnets.highlevelnets.common.impl.CommonPackageImpl#getRectangle()
		 * @generated
		 */
		EDataType RECTANGLE = eINSTANCE.getRectangle();

		/**
		 * The meta object literal for the '<em>Point</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.draw2d.geometry.Point
		 * @see ru.mathtech.npntool.npnets.highlevelnets.common.impl.CommonPackageImpl#getPoint()
		 * @generated
		 */
		EDataType POINT = eINSTANCE.getPoint();

	}

} //CommonPackage
