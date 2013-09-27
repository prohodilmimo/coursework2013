/**
 */
package ru.mathtech.npntool.npnets.highlevelnets.npnets.model.impl;

import java.util.Collection;

import java.util.UUID;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import ru.mathtech.npntool.npnets.highlevelnets.common.impl.INetElementImpl;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;

import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPNetsPackage;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnetMarked;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.Synchronization;

import ru.mathtech.npntool.npnets.highlevelnets.tokenexpressions.NetConstant;

import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.TokenTypeAtomic;
import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.TokenTypeElementNet;
import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramNetSystem;
import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NPnet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.impl.NPnetImpl#getDiagram <em>Diagram</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.impl.NPnetImpl#getNetSystem <em>Net System</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.impl.NPnetImpl#getTypeElementNet <em>Type Element Net</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.impl.NPnetImpl#getTypeAtomic <em>Type Atomic</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.impl.NPnetImpl#getNetConstants <em>Net Constants</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.impl.NPnetImpl#getSynchronizations <em>Synchronizations</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.highlevelnets.npnets.model.impl.NPnetImpl#getHost <em>Host</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NPnetImpl extends INetElementImpl implements NPnet {
	/**
	 * The cached value of the '{@link #getDiagram() <em>Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagram()
	 * @generated
	 * @ordered
	 */
	protected NPNDiagramNetSystem diagram;

	/**
	 * The cached value of the '{@link #getNetSystem() <em>Net System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetSystem()
	 * @generated
	 * @ordered
	 */
	protected HighLevelPetriNet netSystem;

	/**
	 * The cached value of the '{@link #getTypeElementNet() <em>Type Element Net</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeElementNet()
	 * @generated
	 * @ordered
	 */
	protected EList<TokenTypeElementNet> typeElementNet;

	/**
	 * The cached value of the '{@link #getTypeAtomic() <em>Type Atomic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeAtomic()
	 * @generated
	 * @ordered
	 */
	protected TokenTypeAtomic typeAtomic;

	/**
	 * The cached value of the '{@link #getNetConstants() <em>Net Constants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetConstants()
	 * @generated
	 * @ordered
	 */
	protected EList<NetConstant> netConstants;

	/**
	 * The cached value of the '{@link #getSynchronizations() <em>Synchronizations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchronizations()
	 * @generated
	 * @ordered
	 */
	protected EList<Synchronization> synchronizations;

	/**
	 * ID's prefix  
	 * @generated
	 */
    protected static final String prefixID = "";

	/**
	 * ID's counter
	 * @generated
	 */
    protected static long counterID = 0;

	/**
    * Generate a unique ID based on the current time
    * @generated
    */

	protected synchronized String generateIDByTime() {
	  short cur = (short)System.currentTimeMillis();
	  if (cur<0) cur = (short)-cur;
	  return prefixID + cur + counterID++;
	}

	protected synchronized String generateID() {
	  String res = "npn" + UUID.randomUUID().toString();
	  return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NPnetImpl() {
		super();
  
  
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NPNetsPackage.Literals.NPNET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NPNDiagramNetSystem getDiagram() {
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDiagram(NPNDiagramNetSystem newDiagram, NotificationChain msgs) {
		NPNDiagramNetSystem oldDiagram = diagram;
		diagram = newDiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NPNetsPackage.NPNET__DIAGRAM, oldDiagram, newDiagram);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagram(NPNDiagramNetSystem newDiagram) {
		if (newDiagram != diagram) {
			NotificationChain msgs = null;
			if (diagram != null)
				msgs = ((InternalEObject)diagram).eInverseRemove(this, NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__HOST, NPNDiagramNetSystem.class, msgs);
			if (newDiagram != null)
				msgs = ((InternalEObject)newDiagram).eInverseAdd(this, NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__HOST, NPNDiagramNetSystem.class, msgs);
			msgs = basicSetDiagram(newDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NPNetsPackage.NPNET__DIAGRAM, newDiagram, newDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HighLevelPetriNet getNetSystem() {
		return netSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNetSystem(HighLevelPetriNet newNetSystem, NotificationChain msgs) {
		HighLevelPetriNet oldNetSystem = netSystem;
		netSystem = newNetSystem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NPNetsPackage.NPNET__NET_SYSTEM, oldNetSystem, newNetSystem);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetSystem(HighLevelPetriNet newNetSystem) {
		if (newNetSystem != netSystem) {
			NotificationChain msgs = null;
			if (netSystem != null)
				msgs = ((InternalEObject)netSystem).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NPNetsPackage.NPNET__NET_SYSTEM, null, msgs);
			if (newNetSystem != null)
				msgs = ((InternalEObject)newNetSystem).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NPNetsPackage.NPNET__NET_SYSTEM, null, msgs);
			msgs = basicSetNetSystem(newNetSystem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NPNetsPackage.NPNET__NET_SYSTEM, newNetSystem, newNetSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TokenTypeElementNet> getTypeElementNet() {
		if (typeElementNet == null) {
			typeElementNet = new EObjectContainmentEList<TokenTypeElementNet>(TokenTypeElementNet.class, this, NPNetsPackage.NPNET__TYPE_ELEMENT_NET);
		}
		return typeElementNet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TokenTypeAtomic getTypeAtomic() {
		return typeAtomic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeAtomic(TokenTypeAtomic newTypeAtomic, NotificationChain msgs) {
		TokenTypeAtomic oldTypeAtomic = typeAtomic;
		typeAtomic = newTypeAtomic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NPNetsPackage.NPNET__TYPE_ATOMIC, oldTypeAtomic, newTypeAtomic);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeAtomic(TokenTypeAtomic newTypeAtomic) {
		if (newTypeAtomic != typeAtomic) {
			NotificationChain msgs = null;
			if (typeAtomic != null)
				msgs = ((InternalEObject)typeAtomic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NPNetsPackage.NPNET__TYPE_ATOMIC, null, msgs);
			if (newTypeAtomic != null)
				msgs = ((InternalEObject)newTypeAtomic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NPNetsPackage.NPNET__TYPE_ATOMIC, null, msgs);
			msgs = basicSetTypeAtomic(newTypeAtomic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NPNetsPackage.NPNET__TYPE_ATOMIC, newTypeAtomic, newTypeAtomic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NetConstant> getNetConstants() {
		if (netConstants == null) {
			netConstants = new EObjectContainmentEList<NetConstant>(NetConstant.class, this, NPNetsPackage.NPNET__NET_CONSTANTS);
		}
		return netConstants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Synchronization> getSynchronizations() {
		if (synchronizations == null) {
			synchronizations = new EObjectContainmentEList<Synchronization>(Synchronization.class, this, NPNetsPackage.NPNET__SYNCHRONIZATIONS);
		}
		return synchronizations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NPnetMarked getHost() {
		if (eContainerFeatureID() != NPNetsPackage.NPNET__HOST) return null;
		return (NPnetMarked)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHost(NPnetMarked newHost, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newHost, NPNetsPackage.NPNET__HOST, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHost(NPnetMarked newHost) {
		if (newHost != eInternalContainer() || (eContainerFeatureID() != NPNetsPackage.NPNET__HOST && newHost != null)) {
			if (EcoreUtil.isAncestor(this, newHost))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newHost != null)
				msgs = ((InternalEObject)newHost).eInverseAdd(this, NPNetsPackage.NPNET_MARKED__NET, NPnetMarked.class, msgs);
			msgs = basicSetHost(newHost, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NPNetsPackage.NPNET__HOST, newHost, newHost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NPNetsPackage.NPNET__DIAGRAM:
				if (diagram != null)
					msgs = ((InternalEObject)diagram).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NPNetsPackage.NPNET__DIAGRAM, null, msgs);
				return basicSetDiagram((NPNDiagramNetSystem)otherEnd, msgs);
			case NPNetsPackage.NPNET__HOST:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetHost((NPnetMarked)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NPNetsPackage.NPNET__DIAGRAM:
				return basicSetDiagram(null, msgs);
			case NPNetsPackage.NPNET__NET_SYSTEM:
				return basicSetNetSystem(null, msgs);
			case NPNetsPackage.NPNET__TYPE_ELEMENT_NET:
				return ((InternalEList<?>)getTypeElementNet()).basicRemove(otherEnd, msgs);
			case NPNetsPackage.NPNET__TYPE_ATOMIC:
				return basicSetTypeAtomic(null, msgs);
			case NPNetsPackage.NPNET__NET_CONSTANTS:
				return ((InternalEList<?>)getNetConstants()).basicRemove(otherEnd, msgs);
			case NPNetsPackage.NPNET__SYNCHRONIZATIONS:
				return ((InternalEList<?>)getSynchronizations()).basicRemove(otherEnd, msgs);
			case NPNetsPackage.NPNET__HOST:
				return basicSetHost(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case NPNetsPackage.NPNET__HOST:
				return eInternalContainer().eInverseRemove(this, NPNetsPackage.NPNET_MARKED__NET, NPnetMarked.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NPNetsPackage.NPNET__DIAGRAM:
				return getDiagram();
			case NPNetsPackage.NPNET__NET_SYSTEM:
				return getNetSystem();
			case NPNetsPackage.NPNET__TYPE_ELEMENT_NET:
				return getTypeElementNet();
			case NPNetsPackage.NPNET__TYPE_ATOMIC:
				return getTypeAtomic();
			case NPNetsPackage.NPNET__NET_CONSTANTS:
				return getNetConstants();
			case NPNetsPackage.NPNET__SYNCHRONIZATIONS:
				return getSynchronizations();
			case NPNetsPackage.NPNET__HOST:
				return getHost();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NPNetsPackage.NPNET__DIAGRAM:
				setDiagram((NPNDiagramNetSystem)newValue);
				return;
			case NPNetsPackage.NPNET__NET_SYSTEM:
				setNetSystem((HighLevelPetriNet)newValue);
				return;
			case NPNetsPackage.NPNET__TYPE_ELEMENT_NET:
				getTypeElementNet().clear();
				getTypeElementNet().addAll((Collection<? extends TokenTypeElementNet>)newValue);
				return;
			case NPNetsPackage.NPNET__TYPE_ATOMIC:
				setTypeAtomic((TokenTypeAtomic)newValue);
				return;
			case NPNetsPackage.NPNET__NET_CONSTANTS:
				getNetConstants().clear();
				getNetConstants().addAll((Collection<? extends NetConstant>)newValue);
				return;
			case NPNetsPackage.NPNET__SYNCHRONIZATIONS:
				getSynchronizations().clear();
				getSynchronizations().addAll((Collection<? extends Synchronization>)newValue);
				return;
			case NPNetsPackage.NPNET__HOST:
				setHost((NPnetMarked)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case NPNetsPackage.NPNET__DIAGRAM:
				setDiagram((NPNDiagramNetSystem)null);
				return;
			case NPNetsPackage.NPNET__NET_SYSTEM:
				setNetSystem((HighLevelPetriNet)null);
				return;
			case NPNetsPackage.NPNET__TYPE_ELEMENT_NET:
				getTypeElementNet().clear();
				return;
			case NPNetsPackage.NPNET__TYPE_ATOMIC:
				setTypeAtomic((TokenTypeAtomic)null);
				return;
			case NPNetsPackage.NPNET__NET_CONSTANTS:
				getNetConstants().clear();
				return;
			case NPNetsPackage.NPNET__SYNCHRONIZATIONS:
				getSynchronizations().clear();
				return;
			case NPNetsPackage.NPNET__HOST:
				setHost((NPnetMarked)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case NPNetsPackage.NPNET__DIAGRAM:
				return diagram != null;
			case NPNetsPackage.NPNET__NET_SYSTEM:
				return netSystem != null;
			case NPNetsPackage.NPNET__TYPE_ELEMENT_NET:
				return typeElementNet != null && !typeElementNet.isEmpty();
			case NPNetsPackage.NPNET__TYPE_ATOMIC:
				return typeAtomic != null;
			case NPNetsPackage.NPNET__NET_CONSTANTS:
				return netConstants != null && !netConstants.isEmpty();
			case NPNetsPackage.NPNET__SYNCHRONIZATIONS:
				return synchronizations != null && !synchronizations.isEmpty();
			case NPNetsPackage.NPNET__HOST:
				return getHost() != null;
		}
		return super.eIsSet(featureID);
	}

} //NPnetImpl
