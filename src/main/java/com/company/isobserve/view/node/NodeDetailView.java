package com.company.isobserve.view.node;

import com.company.isobserve.entity.Node;
import com.company.isobserve.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "nodes/:id", layout = MainView.class)
@ViewController(id = "Node.detail")
@ViewDescriptor(path = "node-detail-view.xml")
@EditedEntityContainer("nodeDc")
public class NodeDetailView extends StandardDetailView<Node> {
}