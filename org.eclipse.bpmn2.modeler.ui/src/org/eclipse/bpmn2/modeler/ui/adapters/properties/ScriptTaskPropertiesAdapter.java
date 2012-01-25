/*******************************************************************************
 * Copyright (c) 2011 Red Hat, Inc.
 *  All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 *
 * @author Bob Brodt
 ******************************************************************************/

package org.eclipse.bpmn2.modeler.ui.adapters.properties;

import org.eclipse.bpmn2.modeler.ui.Messages;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Bob Brodt
 *
 */
public class ScriptTaskPropertiesAdapter extends TaskPropertiesAdapter {

	/**
	 * @param adapterFactory
	 * @param object
	 */
	public ScriptTaskPropertiesAdapter(AdapterFactory adapterFactory, EObject object) {
		super(adapterFactory, object);
    	setProperty(Bpmn2ExtendedPropertiesAdapter.LONG_DESCRIPTION, Messages.UI_ScriptTask_long_description); //$NON-NLS-1$
	}

}