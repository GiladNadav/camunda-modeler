package org.camunda.bpm.modeler.ui.views.outline;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.modeler.ui.ImageConstants;
import org.camunda.bpm.modeler.ui.Images;
import org.eclipse.bpmn2.Choreography;
import org.eclipse.bpmn2.Collaboration;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.di.BPMNDiagram;
import org.eclipse.bpmn2.di.BPMNEdge;
import org.eclipse.bpmn2.di.BPMNShape;
import org.eclipse.swt.graphics.Image;

public class Bpmn2DiagramTreeEditPart extends AbstractGraphicsTreeEditPart {

	public Bpmn2DiagramTreeEditPart(DiagramTreeEditPart dep, BPMNDiagram bpmnDiagram) {
		super(dep, bpmnDiagram);
	}

	public BPMNDiagram getBPMNDiagram() {
		return (BPMNDiagram) getBpmnModel();
	}

	// ======================= overwriteable behaviour ========================

	/**
	 * Creates the EditPolicies of this EditPart. Subclasses often overwrite
	 * this method to change the behaviour of the editpart.
	 */
	@Override
	protected void createEditPolicies() {
	}
	
	@Override
	protected Image getImage() {
		BPMNDiagram d = getBPMNDiagram();
		Object m = d.getPlane().getBpmnElement();
		if (m instanceof Process || m instanceof Choreography || m instanceof Collaboration)
			return Images.getById(ImageConstants.ICON_BPMNDIAGRAM);
		return Images.getById(ImageConstants.ICON_BPMNSUBDIAGRAM);
	}
	
	@Override
	protected List<Object> getModelChildren() {
		List<Object> retList = new ArrayList<Object>();
		BPMNDiagram bpmnDiagram = getBPMNDiagram();
		for (Object o : bpmnDiagram.getPlane().getPlaneElement()) {
			if (o instanceof BPMNShape || o instanceof BPMNEdge)
				retList.add(o);
		}
		return retList;
	}
}