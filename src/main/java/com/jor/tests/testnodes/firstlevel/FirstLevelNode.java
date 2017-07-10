/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jor.tests.testnodes.firstlevel;

import java.beans.IntrospectionException;
import org.openide.nodes.BeanNode;
import org.openide.nodes.Children;

/**
 *
 * @author jor
 */
class FirstLevelNode extends BeanNode<FirstLevelBean> {
	
	public FirstLevelNode(FirstLevelBean bean) throws IntrospectionException {
		super(bean, Children.LEAF);
		setDisplayName(bean.getName());
	}
	
}
