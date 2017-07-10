/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jor.tests.testnodes.firstlevel;

import com.jor.tests.testnodes.PropertiesNotifier;
import java.io.IOException;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.NbBundle;
import org.openide.util.NbPreferences;
import org.openide.util.datatransfer.NewType;

/**
 *
 * @author jor
 */
@NbBundle.Messages({
        "LBL_Title=New node",
        "LBL_Text=Enter Name:"})
public class NewFirstLevelNodeAction extends NewType {

	@Override
	public String getName() {
		return Bundle.LBL_Title();
	}

	@Override
	public void create() throws IOException {
		NotifyDescriptor.InputLine msg = new NotifyDescriptor.InputLine(
				Bundle.LBL_Text(),
				Bundle.LBL_Title());
		Object result = DialogDisplayer.getDefault().notify(msg);
		if (result == NotifyDescriptor.OK_OPTION) {
			String name = msg.getInputText();
			NbPreferences.forModule(FirstLevelNode.class).
					put("name", name);
			PropertiesNotifier.changed();
		}
	}

}
