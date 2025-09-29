package com.company.isobserve.view.node;

import com.company.isobserve.entity.Node;
import com.company.isobserve.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "nodes", layout = MainView.class)
@ViewController(id = "Node.list")
@ViewDescriptor(path = "node-list-view.xml")
@LookupComponent("nodesDataGrid")
@DialogMode(width = "64em")
public class NodeListView extends StandardListView<Node> {
}