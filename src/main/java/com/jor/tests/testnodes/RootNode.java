package com.jor.tests.testnodes;

import com.jor.tests.testnodes.firstlevel.NewFirstLevelNodeAction;
import com.jor.tests.testnodes.firstlevel.FirstLevelNodeFactory;
import javax.swing.Action;
import org.netbeans.api.core.ide.ServicesTabNodeRegistration;
import org.openide.actions.NewAction;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.actions.SystemAction;
import org.openide.util.datatransfer.NewType;

/**
 *
 * @author jor
 */
@ServicesTabNodeRegistration(displayName = "Root",name = "Name",
		iconResource = "com/jor/tests/testnodes/hpe.png")
public class RootNode extends AbstractNode {
	
	public RootNode() {
		super(Children.create(new FirstLevelNodeFactory(),true));
		setDisplayName("Root");
		setIconBaseWithExtension("com/jor/tests/testnodes/hpe.png");
		
	}
	
	@Override
	public Action[] getActions(boolean context) {
		return new Action[] { SystemAction.get(NewAction.class)};		
	}
	
	@Override
	public NewType[] getNewTypes() {
		return new NewType[]{ new NewFirstLevelNodeAction() };
	}
	
}
