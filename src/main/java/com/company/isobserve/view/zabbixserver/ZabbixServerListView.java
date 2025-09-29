package com.company.isobserve.view.zabbixserver;

import com.company.isobserve.entity.ZabbixServer;
import com.company.isobserve.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "zabbixServers", layout = MainView.class)
@ViewController(id = "ZabbixServer.list")
@ViewDescriptor(path = "zabbix-server-list-view.xml")
@LookupComponent("zabbixServersDataGrid")
@DialogMode(width = "64em")
public class ZabbixServerListView extends StandardListView<ZabbixServer> {
}