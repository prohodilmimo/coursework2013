/**
 */
package ru.mathtech.npntool.npnets.highlevelnets.tokentypes.impl;

import java.util.UUID;
import org.eclipse.emf.ecore.EClass;

import ru.mathtech.npntool.npnets.highlevelnets.common.impl.INetElementImpl;

import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.TokenType;
import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.TokenTypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Token Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class TokenTypeImpl extends INetElementImpl implements TokenType {
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
	protected TokenTypeImpl() {
		super();
  
  
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TokenTypesPackage.Literals.TOKEN_TYPE;
	}

} //TokenTypeImpl
