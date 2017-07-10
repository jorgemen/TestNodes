package com.jor.tests.testnodes;

import org.netbeans.api.core.ide.ServicesTabNodeRegistration;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

/**
 *
 * @author jor
 */
@ServicesTabNodeRegistration(displayName = "",name = "" )
public class RootNode extends AbstractNode {
	
	public RootNode(Children children) {
		super(children);
	}
	
}
