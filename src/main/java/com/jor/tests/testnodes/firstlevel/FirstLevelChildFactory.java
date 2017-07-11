/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jor.tests.testnodes.firstlevel;

import com.jor.tests.testnodes.PropertiesNotifier;
import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.NbPreferences;

/**
 *
 * @author jor
 */
public class FirstLevelChildFactory extends ChildFactory.Detachable<FirstLevelBean> {

	private final List<FirstLevelBean> list;

	private ChangeListener listener;

	public FirstLevelChildFactory() {
		list = new ArrayList<>();
	}

	@Override
	protected boolean createKeys(List<FirstLevelBean> toPopulate) {
		toPopulate.addAll(list);
		return true;
	}

	@Override
	protected Node createNodeForKey(FirstLevelBean key) {
		FirstLevelNode node = null;
		try {
			node = new FirstLevelNode(key);
			node.setDisplayName(key.getName());
		} catch (IntrospectionException ex) {
			Exceptions.printStackTrace(ex);
		}
		return node;
	}

	@Override
	protected void addNotify() {
		PropertiesNotifier.addChangeListener(listener = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				String name = NbPreferences.forModule(FirstLevelNode.class).get("name", "error!");
				FirstLevelBean bean = new FirstLevelBean();
				bean.setName(name);
				bean.setId(UUID.randomUUID().toString());
				list.add(bean);
				refresh(true);
			}
		});
	}

	@Override
	protected void removeNotify() {
		if (listener != null) {
			PropertiesNotifier.removeChangeListener(listener);
			listener = null;
		}
	}

}
