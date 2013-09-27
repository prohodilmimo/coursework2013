/**
 */
package ru.mathtech.npntool.npnets.npndiagrams.impl;

import java.util.Collection;

import java.util.UUID;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import ru.mathtech.npntool.npnets.highlevelnets.common.CommonPackage;
import ru.mathtech.npntool.npnets.highlevelnets.common.IDiagramHolder;
import ru.mathtech.npntool.npnets.highlevelnets.common.impl.IEntityIdentifiableImpl;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;

import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramNetSystem;
import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramsPackage;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolNodeSN;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NPN Diagram Net System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ru.mathtech.npntool.npnets.npndiagrams.impl.NPNDiagramNetSystemImpl#getHost <em>Host</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.npndiagrams.impl.NPNDiagramNetSystemImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.npndiagrams.impl.NPNDiagramNetSystemImpl#getArcs <em>Arcs</em>}</li>
 *   <li>{@link ru.mathtech.npntool.npnets.npndiagrams.impl.NPNDiagramNetSystemImpl#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NPNDiagramNetSystemImpl extends IEntityIdentifiableImpl implements NPNDiagramNetSystem {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<NPNSymbolNodeSN> nodes;

	/**
	 * The cached value of the '{@link #getArcs() <em>Arcs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArcs()
	 * @generated
	 * @ordered
	 */
	protected EList<NPNSymbolArcSN> arcs;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected HighLevelPetriNet model;

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
	protected NPNDiagramNetSystemImpl() {
		super();
  
  
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NPNDiagramsPackage.Literals.NPN_DIAGRAM_NET_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDiagramHolder getHost() {
		if (eContainerFeatureID() != NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__HOST) return null;
		return (IDiagramHolder)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHost(IDiagramHolder newHost, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newHost, NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__HOST, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHost(IDiagramHolder newHost) {
		if (newHost != eInternalContainer() || (eContainerFeatureID() != NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__HOST && newHost != null)) {
			if (EcoreUtil.isAncestor(this, newHost))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newHost != null)
				msgs = ((InternalEObject)newHost).eInverseAdd(this, CommonPackage.IDIAGRAM_HOLDER__DIAGRAM, IDiagramHolder.class, msgs);
			msgs = basicSetHost(newHost, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__HOST, newHost, newHost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HighLevelPetriNet getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject)model;
			model = (HighLevelPetriNet)eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HighLevelPetriNet basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(HighLevelPetriNet newModel) {
		HighLevelPetriNet oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NPNSymbolNodeSN> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList<NPNSymbolNodeSN>(NPNSymbolNodeSN.class, this, NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__NODES, NPNDiagramsPackage.NPN_SYMBOL_NODE_SN__DIAGRAM);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NPNSymbolArcSN> getArcs() {
		if (arcs == null) {
			arcs = new EObjectContainmentWithInverseEList<NPNSymbolArcSN>(NPNSymbolArcSN.class, this, NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__ARCS, NPNDiagramsPackage.NPN_SYMBOL_ARC_SN__DIAGRAM);
		}
		return arcs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__HOST:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetHost((IDiagramHolder)otherEnd, msgs);
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__ARCS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArcs()).basicAdd(otherEnd, msgs);
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
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__HOST:
				return basicSetHost(null, msgs);
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__ARCS:
				return ((InternalEList<?>)getArcs()).basicRemove(otherEnd, msgs);
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
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__HOST:
				return eInternalContainer().eInverseRemove(this, CommonPackage.IDIAGRAM_HOLDER__DIAGRAM, IDiagramHolder.class, msgs);
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
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__HOST:
				return getHost();
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__NODES:
				return getNodes();
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__ARCS:
				return getArcs();
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
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
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__HOST:
				setHost((IDiagramHolder)newValue);
				return;
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends NPNSymbolNodeSN>)newValue);
				return;
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__ARCS:
				getArcs().clear();
				getArcs().addAll((Collection<? extends NPNSymbolArcSN>)newValue);
				return;
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__MODEL:
				setModel((HighLevelPetriNet)newValue);
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
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__HOST:
				setHost((IDiagramHolder)null);
				return;
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__NODES:
				getNodes().clear();
				return;
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__ARCS:
				getArcs().clear();
				return;
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__MODEL:
				setModel((HighLevelPetriNet)null);
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
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__HOST:
				return getHost() != null;
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__NODES:
				return nodes != null && !nodes.isEmpty();
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__ARCS:
				return arcs != null && !arcs.isEmpty();
			case NPNDiagramsPackage.NPN_DIAGRAM_NET_SYSTEM__MODEL:
				return model != null;
		}
		return super.eIsSet(featureID);
	}

} //NPNDiagramNetSystemImpl
